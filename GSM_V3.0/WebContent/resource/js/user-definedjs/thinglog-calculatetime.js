var originalOneTime = null; //对第一次巡查走访时间每次变更都会保留数据变化值的存根
var originalTowTime = null; //对第二次巡查走访时间每次变更都会保留数据变化值的存根
/**
 * 当自动计算第一次走访时间后，
 * 如需要改动第一次开始时间，则
 * 调用该方法
 * @param value
 */
function interviewOneTimeStarts(value){
	var interviewOneTimeend = $("#interview_one_timeend").val();
	if(interviewOneTimeend != "00:00"){
		if(value>interviewOneTimeend){
			bootbox.alert('开始时间不能大于结束时间！');
		}else{
			if(originalTowTime==null){
				originalOneTime = calculateTime(value,interviewOneTimeend);
			}else{
				var totalTime = originalTowTime;
				var reValueTime = calculateTime(value,interviewOneTimeend);
				calculateAddTime(totalTime,reValueTime);
			}
		}
	}
}
/**
 * 自动计算第一次走访查询时间
 * @param value
 */
function interviewOneTimeEnds(value){
	var interviewOneTimeStart = $("#interview_one_timestart").val();
	if(value<interviewOneTimeStart){
		bootbox.alert('结束时间不能小于开始时间！');
	}else{
		if(originalTowTime == null){
			originalOneTime = calculateTime(interviewOneTimeStart,value);
		}else{
			var totalTime = originalTowTime;
			var reValueTime = calculateTime(interviewOneTimeStart,value);
			calculateAddTime(totalTime,reValueTime);
		}
		
	}
}
function interviewTwoTimestart1s(value){
	var interviewTwoTimeend1 = $("#interview_two_timeend1").val();
	if(interviewTwoTimeend1 != "00:00"){
		if(value>interviewTwoTimeend1){
			bootbox.alert('开始时间不能大于结束时间！');
		}else{
			var totalTime = originalOneTime;
			var reValueTime = returnCalculateTime(value,interviewTwoTimeend1);
			originalTowTime = returnCalculateTime(value,interviewTwoTimeend1);
			calculateAddTime(totalTime,reValueTime);
		}
	}
}
function interviewTwoTimeend1s(value){
	var interviewTwoTimestart1 = $("#interview_two_timestart1").val();
	if(value<interviewTwoTimestart1){
		bootbox.alert('结束时间不能小于开始时间！');
	}else{
		var totalTime = originalOneTime;
		var reValueTime = returnCalculateTime(interviewTwoTimestart1,value);
		originalTowTime = returnCalculateTime(interviewTwoTimestart1,value);
		//alert(reValueTime)
		calculateAddTime(totalTime,reValueTime);
	}
}
/**
 * 计算第一次走访查询时间的调用函数
 * @param startTime
 * @param endTime
 * @returns {String}
 */
function calculateTime(startTime,endTime){
	var returnValue = null;
	var interviewOneTimeStartHour = startTime.substr(0,2);
	var interviewOneTimeStartMinute = startTime.substr(3,2);
	var valueHour = endTime.substr(0,2);
	var valueMinute = endTime.substr(3,2);
	var totalHour = valueHour - interviewOneTimeStartHour;
	var totalMinute = valueMinute - interviewOneTimeStartMinute;
	$("#totalHour").val(totalHour);
	$("#totalMinute").val(totalMinute);
	returnValue = totalHour+":"+totalMinute;
	//alert(valueHour+":"+valueMinute+"--"+interviewOneTimeStartHour+":"+interviewOneTimeStartMinute+"--"+totalHour+":"+totalMinute);
	if(totalMinute<0){
		var totalHourSeconds = totalHour*60*60;
		var totalSecond = totalMinute*60;
		totalHour = Math.floor(((totalHourSeconds+totalSecond)/60)/60);
		totalMinute = ((totalHourSeconds+totalSecond)/60)%60;
		$("#totalHour").val(totalHour);
		$("#totalMinute").val(totalMinute);
		returnValue = totalHour+":"+totalMinute;
	}
	
	return returnValue;
}
/**
 * 返回第二次巡查走访自动计算的时间
 * @param startTime 开始时间
 * @param endTime 结束时间
 */
function returnCalculateTime(startTime,endTime){
	var returnValue;
	var interviewOneTimeStartHour = startTime.substr(0,2);
	var interviewOneTimeStartMinute = startTime.substr(3,2);
	var valueHour = endTime.substr(0,2);
	var valueMinute = endTime.substr(3,2);
	var totalHour = valueHour - interviewOneTimeStartHour;
	var totalMinute = valueMinute - interviewOneTimeStartMinute;
	returnValue = totalHour+":"+totalMinute;
	//alert(valueHour+":"+valueMinute+"--"+interviewOneTimeStartHour+":"+interviewOneTimeStartMinute+"--"+totalHour+":"+totalMinute);
	if(totalMinute<0){
		var totalHourSeconds = totalHour*60*60;
		var totalSecond = totalMinute*60;
		totalHour = Math.floor(((totalHourSeconds+totalSecond)/60)/60);
		totalMinute = ((totalHourSeconds+totalSecond)/60)%60;	
		returnValue = totalHour+":"+totalMinute;
	}
	
	return returnValue;
}

function calculateAddTime(value1,value2){
	//第一次巡查走访自动计算的时长--小时
	var totalTimeHour = value1.substr(0,1);
	//第一次巡查走访自动计算的时长--分钟
	var totalTimeMinute = value1.substr(2,2);
	//第二次巡查走访自动计算的时长--小时
	var reValueTimeHour = value2.substr(0,1);
	//第二次巡查走访自动计算的时长--分钟
	var reValueTimeMinute = value2.substr(2,2);
	
	//alert(totalTimeHour+"--"+totalTimeMinute+"=="+reValueTimeHour+"--"+reValueTimeMinute)
	
	var totalTimeHourSeconds = totalTimeHour*60*60;
	var reValueTimeHourSeconds = reValueTimeHour*60*60;
	var totalTimeMinuteSeconds = totalTimeMinute*60;
	var reValueTimeMinuteSeconds = reValueTimeMinute*60
	
	//alert(totalTimeHourSeconds+"--"+reValueTimeHourSeconds+"=="+totalTimeMinuteSeconds+"--"+reValueTimeMinuteSeconds)
	
	var totalSeconds = totalTimeHourSeconds+reValueTimeHourSeconds+totalTimeMinuteSeconds+reValueTimeMinuteSeconds;
	
	//alert(totalSeconds);
	
	var newTotalHour = Math.floor((totalSeconds/60)/60);
	var newTotalMinute = (totalSeconds/60)%60;
	
	$("#totalHour").val(newTotalHour);
	$("#totalMinute").val(newTotalMinute);
	
}

function calculateAddQuestionCount(value){
	var questionConflict = parseInt($("#questionConflict").val());
	var questionAppeal =parseInt($("#questionAppeal").val());
	var questionIdea = parseInt($("#questionIdea").val());
	var questionOther = parseInt($("#questionOther").val());
	if(isNaN(questionConflict)){
		questionConflict = 0;
	}
	if(isNaN(questionAppeal)){
		questionAppeal = 0;
	}
	if(isNaN(questionIdea)){
		questionIdea = 0;
	}
	if(isNaN(questionOther)){
		questionOther = 0;
	}
	var questionCount = questionConflict+questionAppeal+questionIdea+questionOther;
	$("#questionCount").val(questionCount);
}

function calculateAddEnvCount(){
	var sanitationReaction = parseInt($("#sanitationReaction").val());
	var sanitationAd = parseInt($("#sanitationAd").val());
	var sanitationChaos = parseInt($("#sanitationChaos").val());
	var sanitationBuild = parseInt($("#sanitationBuild").val());
	var sanitationOther = parseInt($("#sanitationOther").val());
	
	if(isNaN(sanitationReaction)){
		sanitationReaction = 0;
	}
	if(isNaN(sanitationAd)){
		sanitationAd = 0;
	}
	if(isNaN(sanitationChaos)){
		sanitationChaos = 0;
	}
	if(isNaN(sanitationBuild)){
		sanitationBuild = 0;
	}
	if(isNaN(sanitationOther)){
		sanitationOther = 0;
	}
	
	var envCount = sanitationReaction+sanitationAd+sanitationChaos+sanitationBuild+sanitationOther;
	$("#envCount").val(envCount);
}