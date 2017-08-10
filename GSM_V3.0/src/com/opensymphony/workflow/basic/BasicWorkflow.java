/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
/*
 * Created by IntelliJ IDEA.
 * User: plightbo
 * Date: Apr 29, 2002
 * Time: 11:12:05 PM
 */
package com.opensymphony.workflow.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.opensymphony.workflow.AbstractWorkflow;
import com.opensymphony.workflow.JoinNodes;
import com.opensymphony.workflow.loader.ActionDescriptor;
import com.opensymphony.workflow.loader.ConditionalResultDescriptor;
import com.opensymphony.workflow.loader.JoinDescriptor;
import com.opensymphony.workflow.loader.ResultDescriptor;
import com.opensymphony.workflow.loader.SplitDescriptor;
import com.opensymphony.workflow.loader.StepDescriptor;
import com.opensymphony.workflow.loader.WorkflowDescriptor;
import com.opensymphony.workflow.spi.Step;
import com.opensymphony.workflow.spi.WorkflowStore;


/**
 * A basic workflow implementation which does not read in
 * the current user from any context, but allows one to be
 * specified via the constructor. Also does not support rollbacks.
 */
public class BasicWorkflow extends AbstractWorkflow {
    //~ Constructors ///////////////////////////////////////////////////////////

    public BasicWorkflow(String caller) {
        super.context = new BasicWorkflowContext(caller);
    }
   /**
    * 
    * @param wf
    * @param id
    * @param actionId
    * @param stepID
    * @param transientVars
    * @return
    */
    public ResultDescriptor getResultDescriptor(WorkflowDescriptor wf,long id,int  actionId,String stepID,Map<String, Object> transientVars) throws Exception
    {
    	WorkflowStore store = getPersistence();
        List<Map<String, Object>> currentSteps = store.findCurrentSteps(id);
        ResultDescriptor ss = null;
        ActionDescriptor action = null;
        for (int i = 0; i < wf.getInitialActions().size(); i++)
        {
            ActionDescriptor actionDesc = (ActionDescriptor)wf.getInitialActions().get(i);
            if (actionDesc.getId() == actionId)
            {
                action = actionDesc;
            }
        }

        //check global actions

        for (int i = 0; i < wf.getGlobalActions().size() ; i++)
        {
            ActionDescriptor actionDesc = (ActionDescriptor)wf.getGlobalActions().get(i);

            if (actionDesc.getId() == actionId)
            {
                action = actionDesc;

            }
        }
        StepDescriptor sd = wf.getStep(Integer.parseInt(stepID));
        List<Map<String, Object>> list = sd.getActions();
        for (int i = 0; i < list.size(); i++)
        {
            action=(ActionDescriptor)list.get(i);
            if (action.getId() == actionId)
            {
                break;
            }
        }
        Step step = getCurrentStep(wf, actionId, currentSteps, transientVars, null);
        
        // check each conditional result
        List<Map<String, Object>> conditionalResults = action.getConditionalResults();

        ResultDescriptor[] theResults = new ResultDescriptor[1];

        for (int i=0;i<conditionalResults.size();i++)
        {
        	ConditionalResultDescriptor conditionalResultDescriptor=(ConditionalResultDescriptor) conditionalResults.get(i);
            if (passesConditions(null, conditionalResultDescriptor.getConditions(), Collections.unmodifiableMap(transientVars), null, (step != null) ? step.getStepId() : (-1)))
            {
                theResults[0] = conditionalResultDescriptor;
                break;
            }
        }

        // use unconditional-result if a condition hasn't been met
        if (theResults[0] == null)
        {
            theResults[0] = action.getUnconditionalResult();
        }

        // go to next step
        if (theResults[0].getSplit() != 0)
        {
            // the result is a split request, handle it correctly
            SplitDescriptor splitDesc = wf.getSplit(theResults[0].getSplit());
            List results = splitDesc.getResults();

            if (!action.isFinish())
            {
                // now make these steps...
                boolean moveFirst = true;

                theResults = new ResultDescriptor[results.size()];
                for(int j=0;j<results.size();j++)
                {
                	theResults[j]=(ResultDescriptor) results.get(j);
                }
                for (int i=0;i<results.size();i++)
                {
                    Step moveToHistoryStep = null;

                    if (moveFirst)
                    {
                        moveToHistoryStep = step;
                    }

                    long[] previousIds = null;

                    if (step != null)
                    {
                        previousIds = new long[] { step.getId() };
                    }
                    ss = (ResultDescriptor) results.get(i);
                }
            }
        }
        else if (theResults[0].getJoin() != 0)
        {
            // this is a join, finish this step...
            JoinDescriptor joinDesc = wf.getJoin(theResults[0].getJoin());

            // (get only current steps that have a result to this join)
            List joinSteps = new ArrayList();
            joinSteps.add(step);

            JoinNodes jn = new JoinNodes(joinSteps);
            transientVars.put("jn", jn);

            //todo verify that 0 is the right value for currentstep here
            if (passesConditions(null, joinDesc.getConditions(), Collections.unmodifiableMap(transientVars), null, 0))
            {
                // move the rest without creating a new step ...
                ResultDescriptor joinresult = joinDesc.getResult();

                if (!action.isFinish())
                {
                    theResults[0] = joinDesc.getResult();
                    ss = joinDesc.getResult();
                }
            }
        }
        else
        {
            ss=theResults[0];
        }

        return ss;
    }

}

