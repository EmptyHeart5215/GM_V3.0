package com.dykj.GSM.service.workflow;

/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.FactoryException;
import com.opensymphony.workflow.loader.AbstractWorkflowFactory;
import com.opensymphony.workflow.loader.WorkflowDescriptor;
import com.opensymphony.workflow.loader.WorkflowLoader;

/**
 * Workflow Factory that stores workflows in a database. The database requires a
 * property called 'datasource' which is the JNDI name of the datasource for
 * this factory.
 * <p>
 * Also required is a database table called OS_WORKFLOWDEFS with two columns,
 * WF_NAME which contains the workflow name, and WF_DEFINITION which will
 * contain the xml workflow descriptor, the latter can be either a TEXT or
 * BINARY type.
 * <p>
 * Note that this class is provided as an example, and users are encouraged to
 * use their own implementations that are more suited to their particular needs.
 * 
 * @author Hubert Felber, Philipp Hug Date: May 01, 2003 Time: 11:17:06 AM
 */
public class OracleWorkflowFactory extends AbstractWorkflowFactory {
	// ~ Static fields/initializers
	// /////////////////////////////////////////////

	private static final Log log = LogFactory.getLog(OracleWorkflowFactory.class);
	final static String wfTable = "OS_FLOW_FILE";
	final static String wfName = "WFNAME";
	final static String wfFlowFile = "FLOWFILE";
	//final static String wfPointXml = "POINTXML";
	//final static String wfSign = "SIGN";

	// ~ Instance fields
	// ////////////////////////////////////////////////////////

	protected DataSource ds;
	protected Map workflows;
	protected boolean reload;
	protected Map points;

	public void setdataSource(DataSource _ds) {
		this.ds = _ds;
	}

	// ~ Methods
	// ////////////////////////////////////////////////////////////////
	@Cacheable(value = "serviceCache")
	public WorkflowDescriptor getWorkflow(String name, boolean validate) throws FactoryException {
		WfConfig c = (WfConfig) workflows.get(name);

		if (c == null) {
			throw new RuntimeException("Unknown workflow name \"" + name + "\"");
		}

		if (log.isDebugEnabled()) {
			log.debug("getWorkflow " + name + " descriptor=" + c.descriptor);
		}

		if (c.descriptor != null) {
			if (reload) {
				// @todo check timestamp
				try {
					c.descriptor = load(c.wfName, validate);
				} catch (FactoryException e) {
					throw e;
				} catch (Exception e) {
					throw new FactoryException("Error reloading workflow", e);
				}
			}
		} else {
			try {
				c.descriptor = load(c.wfName, validate);
			} catch (FactoryException e) {
				throw e;
			} catch (Exception e) {
				throw new FactoryException("Error loading workflow", e);
			}
		}

		return c.descriptor;
	}

	public String[] getWorkflowNames() {
		int i = 0;
		String[] res = new String[workflows.keySet().size()];
		Iterator it = workflows.keySet().iterator();

		while (it.hasNext()) {
			res[i++] = (String) it.next();
		}

		return res;
	}

	public void execute(Map transientVars, Map args, PropertySet ps) {
		String name = (String) args.get("name");
		WorkflowDescriptor wfds = (WorkflowDescriptor) transientVars.get("descriptor");

		try {
			saveWorkflow(name, wfds, false);
		} catch (Exception e) {
		}
	}

	public void initDone() throws FactoryException {
		Connection conn = null;

		try {
			workflows = new HashMap();
			// String jndi = (String)
			// getProperties().getProperty("datasource","jdbc/iprmis");
			// //jndi="jdbc/iprmis";
			// if (jndi != null) {
			// try {
			// ds = (DataSource) lookup(jndi);
			//
			// if (ds == null) {
			// ds = (DataSource) new javax.naming.InitialContext().lookup(jndi);
			// }
			// } catch (Exception e) {
			// throw e;
			// }
			// }

			reload = getProperties().getProperty("reload", "false").equalsIgnoreCase("true");

			conn = ds.getConnection();
			String sql = "SELECT " + wfName + "," + wfFlowFile +  " FROM " + wfTable;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString(1);
				WfConfig wfconfig = new WfConfig(name);
				workflows.put(name, wfconfig);
				// points.put(name,rs.getString(3));
			}

			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new FactoryException("Could not read workflow names from datasource", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
	}

	public List<Map> queryFlowfiles() throws FactoryException {
		List<Map> rsall = new ArrayList();
		Map rsTree;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT ID," + wfName + "," + wfFlowFile + " FROM " + wfTable;
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			while (rs.next()) {
				Object value = "";
				rsTree = new HashMap(numberOfColumns);// 注意要new
				for (int i = 1; i < numberOfColumns + 1; i++) {
					String field = rsmd.getColumnName(i);
					String type = rsmd.getColumnTypeName(i);
					if ("DATE".equals(type)) {
						value = rs.getTimestamp(i) == null ? "" : rs.getTimestamp(i);
					} else if ("CLOB".equals(type)) {
						value = rs.getString(i);
					} else {
						value = rs.getObject(i) == null ? "" : rs.getObject(i);
					}
					rsTree.put(field, value);
				}

				rsall.add(rsTree);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new FactoryException("Could not read workflow names from datasource", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
		return rsall;
	}

	public String read(String workflowname) throws SQLException {
		String wf = "";
		Connection conn = null;

		try {
			conn = ds.getConnection();
			String sql = "SELECT " + wfFlowFile + " FROM " + wfTable + " WHERE " + wfName + " = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, workflowname);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				wf = rs.getString(1);
				// wf = rs.getBytes(1);
			}

			rs.close();
			ps.close();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
				}
			}
		}

		return wf;
	}

	public boolean removeWorkflow(String name) throws FactoryException {
		boolean removed = false;

		try {
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM " + wfTable + " WHERE " + wfName + " = ?");
			ps.setString(1, name);

			int rows = ps.executeUpdate();

			if (rows == 1) {
				removed = true;
				workflows.remove(name);
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new FactoryException("Unable to remove workflow: " + e.toString(), e);
		}

		return removed;
	}

	public boolean saveWorkflow(String name, WorkflowDescriptor descriptor, boolean replace) throws FactoryException {
		WfConfig c = (WfConfig) workflows.get(name);

		if ((c != null) && !replace) {
			return false;
		}

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		Writer out = new OutputStreamWriter(bout);

		PrintWriter writer = new PrintWriter(out);
		writer.println(WorkflowDescriptor.XML_HEADER);
		writer.println(WorkflowDescriptor.DOCTYPE_DECL);
		descriptor.writeXML(writer, 0);
		writer.flush();
		writer.close();

		// @todo is a backup necessary?
		try {
			return write(name, bout.toByteArray());
		} catch (SQLException e) {
			throw new FactoryException("Unable to save workflow: " + e.toString(), e);
		} finally {
			WfConfig config = new WfConfig(name);
			workflows.put(name, config);
		}
	}

	public boolean write(String workflowname, byte[] wf) throws SQLException {
		boolean written = false;
		Connection conn = null;

		try {
			conn = ds.getConnection();

			PreparedStatement ps;

			if (exists(workflowname, conn)) {
				ps = conn.prepareStatement("UPDATE " + wfTable + " SET " + wfFlowFile + " = ?" + "WHERE " + wfName
						+ "= ?");

				try {
					ps.setBytes(1, wf);
				} catch (Exception e) {
				}

				ps.setString(2, workflowname);
			} else {
				ps = conn.prepareStatement("INSERT INTO " + wfTable + " (" + wfName + ", " + wfFlowFile
						+ ") VALUES (?, ?)");
				ps.setString(1, workflowname);

				try {
					ps.setBytes(2, wf);
				} catch (Exception e) {
				}
			}

			ps.executeUpdate();
			ps.close();
			conn.close();
			written = true;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}

		return written;
	}

	private boolean exists(String workflowname, Connection conn) {
		boolean exists = false;

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT " + wfName + " FROM " + wfTable + " WHERE " + wfName
					+ " = ?");
			ps.setString(1, workflowname);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				exists = true;
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.fatal("Could not check if [" + workflowname + "] exists", e);
		}

		return exists;
	}

	private Object lookup(String location) throws NamingException {
		try {
			InitialContext context = new InitialContext();

			try {
				return context.lookup(location);
			} catch (NamingException e) {
				// ok, couldn't find it, look in env
				return context.lookup("java:comp/env/" + location);
			}
		} catch (NamingException e) {
			throw e;
		}
	}

	private WorkflowDescriptor load(final String wfName, boolean validate) throws IOException, SAXException,
			FactoryException {
		String wf;

		try {
			wf = read(wfName);
		} catch (SQLException e) {
			throw new FactoryException("Error loading workflow:" + e, e);
		}

		ByteArrayInputStream is = new ByteArrayInputStream(wf.getBytes("UTF-8"));

		return WorkflowLoader.load(is, false);
	}

	public String saveOrUpdateXml(String id, String wfname, String xml, String pointxml, String sign) throws Exception {
		Connection conn = null;
		String result = "";
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from " + wfTable + " where " + wfName + " like'" + wfname + "%' " + " order by ID desc";
			if (id == "") {
				sql = "select * from " + wfTable + " where " + wfName + "='" + wfname + "' And Id !='" + id + "'";
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs != null && rs.getRow() > 0) {
				result = "wfname已经存在，请您核对一下";
			} else {
				if (id == "") {
					try {
						ps = conn.prepareStatement("INSERT INTO " + wfTable + " (" + wfName + ", " + wfFlowFile+ ") VALUES (?, ?,?,?)");
						ps.setString(1, wfname);
						ps.setString(2, xml);
						ps.executeUpdate();
						result = "添加成功";
					} catch (Exception e) {
						result = "添加失败";
					}
				} else {
					try {
						String name = wfname;
						if (name.indexOf("_") == -1) {
							name = name + "_1";
						} else {
							int number = Integer.parseInt(name.substring(name.indexOf("_") + 1));
							number++;
							name = name.substring(0, name.indexOf('_')) + "_" + number;
						}
						int r = 0;
						if (sign.equals("update")) {
							ps = conn.prepareStatement("UPDATE " + wfTable + " SET " + wfName + " = ?," + wfFlowFile
									+ "=? WHERE ID=?");
							ps.setString(1, wfname);
							ps.setString(2, xml);
						
							ps.executeUpdate();
							result = "修改成功";
						} else if (sign.equals("insert")) {
							DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
							dbf.setNamespaceAware(true);
							ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
							DocumentBuilder db = dbf.newDocumentBuilder();
							org.w3c.dom.Document doc = db.parse(is);
							Element root = (Element) doc.getElementsByTagName("workflow").item(0);
							NodeList children = root.getChildNodes();

							for (int i = 0; i < children.getLength(); i++) {
								Node child = children.item(i);

								if (child.getNodeName().equals("meta")) {
									Element meta = (Element) child;
									if (meta.getAttribute("name").equals("wfName")) {
										// meta.setAttribute("name", value);
										meta.setTextContent(name);
									}
									// String value = XMLUtil.getText(meta);
								}
							}
							ps = conn.prepareStatement("INSERT INTO " + wfTable + " (" + wfName + ", " + wfFlowFile
									+ ") VALUES (?, ?,?,?)");
							ps.setString(1, name);
							DOMSource source = new DOMSource(doc);
							StringWriter writer = new StringWriter();
							Result flowfileresult = new StreamResult(writer);
							Transformer transformer = TransformerFactory.newInstance().newTransformer();
							transformer.transform(source, flowfileresult);
							ps.setString(2, writer.getBuffer().toString());
						
							ps.executeUpdate();
							//ps = conn.prepareStatement("UPDATE " + wfTable + " SET " + wfSign + " = 0 WHERE ID=?");
							ps.setString(1, id);
							ps.executeUpdate();
							result = "添加成功";
						}
					} catch (Exception e) {
						result = "修改失败";
					}

				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
		return result;
	}

	// ~ Inner Classes
	// //////////////////////////////////////////////////////////

	class WfConfig {
		String wfName;
		WorkflowDescriptor descriptor;
		long lastModified;

		public WfConfig(String name) {
			wfName = name;
		}
	}

	@Override
	public void setLayout(String workflowName, Object layout) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getLayout(String workflowName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isModifiable(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createWorkflow(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void renameWorkflow(String oldName, String newName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	public String getWorkFlowNameByEntryID(String entryID) throws Exception {
		Connection conn = null;
		String result = "";
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();
			String sql = "select name from os_wfentry where id='" + entryID + "'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			result = rs.getString(0);

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
		return result;
	}
}
