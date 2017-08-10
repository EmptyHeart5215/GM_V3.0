(function($){ 
    $.fn.serializeJson=function(){ 
      var serializeObj={}; 
      var array=this.serializeArray(); 
      var str=this.serialize(); 
      $(array).each(function(){ 
        if(serializeObj[this.name]){ 
          if($.isArray(serializeObj[this.name])){ 
            serializeObj[this.name].push(this.value); 
          }else{ 
            serializeObj[this.name]=[serializeObj[this.name],this.value]; 
          } 
        }else{ 
          serializeObj[this.name]=this.value;  
        } 
      }); 
      return serializeObj; 
    }; 
  })(jQuery); 

jQuery.extend(jQuery.validator.messages, {
    required: "请填入正确值！",
	remote: "请修正该字段",
	email: "请输入正确格式的电子邮件",
	url: "请输入合法的网址",
	date: "请输入合法的日期",
	dateISO: "请输入合法的日期 (ISO).",
	number: "请输入合法的数字",
	digits: "只能输入整数",
	creditcard: "请输入合法的信用卡号",
	equalTo: "请再次输入相同的值",
	accept: "请输入拥有合法后缀名的字符串",
	maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
	minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
	rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
	range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
	max: jQuery.validator.format("请输入一个最大为{0} 的值"),
	min: jQuery.validator.format("请输入一个最小为{0} 的值")
});
jQuery.validator.addMethod("regex", //addMethod第1个参数:方法名称
		function(value, element, params) { //addMethod第2个参数:验证方法，参数（被验证元素的值，被验证元素，参数）
			var exp = new RegExp(params); //实例化正则对象，参数为传入的正则表达式
			return exp.test(value); //测试是否匹配
		},"格式错误");
 
jQuery.validator.addMethod("allPhone",function(value, element) {
	if($.trim(value)!=""){
		if((/^\d*-*\d* *(\d*-*\d*)*\d{7}$/).test(value)){
			var phones=value.split(" ");
			var re = /^0\d{2,3}-?\d{7,8}$|^1\d{10}$|^\d{7,8}$/;
			for(var i=0;i<phones.length;i++){
				if(!re.test(phones[i])){
					return false;
				}
			}
			return true;
		}
		return false;
		}
	return true;
	},"请输入正确格式的电话号码！");




var idCardNoUtil = {
		  /*省,直辖市代码表*/
		  provinceAndCitys: {11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",
		  31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",
		  45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",
		  65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"},

		  /*每位加权因子*/
		  powers: ["7","9","10","5","8","4","2","1","6","3","7","9","10","5","8","4","2"],
		  
		  /*第18位校检码*/
		  parityBit: ["1","0","X","9","8","7","6","5","4","3","2"],

		  /*性别*/
		  genders: {male:"男",female:"女"},

		  /*校验地址码*/
		  checkAddressCode: function(addressCode){
		     var check = /^[1-9]\d{5}$/.test(addressCode);
		     if(!check) return false;
		     if(idCardNoUtil.provinceAndCitys[parseInt(addressCode.substring(0,2))]){
		       return true;
		     }else{
		       return false;
		     }
		  },

		  /*校验日期码*/
		  checkBirthDayCode: function(birDayCode){
		      var check = /^[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))$/.test(birDayCode);
		      if(!check) return false;    
		      var yyyy = parseInt(birDayCode.substring(0,4),10);
		      var mm = parseInt(birDayCode.substring(4,6),10);
		      var dd = parseInt(birDayCode.substring(6),10);
		   var xdata = new Date(yyyy,mm-1,dd);
		   if(xdata > new Date()){
		      return false;//生日不能大于当前日期
		   }else if ( ( xdata.getFullYear() == yyyy ) && ( xdata.getMonth () == mm - 1 ) && ( xdata.getDate() == dd ) ){
		      return true;
		   }else{
		      return false;
		   }
		  },
		  
		  /*计算校检码*/
		  getParityBit: function(idCardNo){
		    var id17 = idCardNo.substring(0,17);    
		     /*加权 */
		     var power = 0;
		     for(var i=0;i<17;i++){
		       power += parseInt(id17.charAt(i),10) * parseInt(idCardNoUtil.powers[i]);
		     }              
		     /*取模*/ 
		     var mod = power % 11;
		     return idCardNoUtil.parityBit[mod];
		  },
		  
		  /*验证校检码*/
		  checkParityBit: function(idCardNo){
		     var parityBit = idCardNo.charAt(17).toUpperCase();
		     if(idCardNoUtil.getParityBit(idCardNo) == parityBit){
		         return true;
		     }else{
		         return false;
		     }
		  },

		  /*校验15位或18位的身份证号码*/
		  checkIdCardNo: function(idCardNo){
		    //15位和18位身份证号码的基本校验
		    var check = /^\d{15}|(\d{17}(\d|x|X))$/.test(idCardNo);
		    if(!check) return false;
		    //判断长度为15位或18位  
		    if(idCardNo.length==15){
		        return idCardNoUtil.check15IdCardNo(idCardNo);
		    }else if(idCardNo.length==18){
		        return idCardNoUtil.check18IdCardNo(idCardNo);
		    }else{
		        return false;
		    }
		  },

		  //校验15位的身份证号码
		  check15IdCardNo: function(idCardNo){
		     //15位身份证号码的基本校验
		     var check = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}$/.test(idCardNo);   
		     if(!check) return false;
		     //校验地址码
		     var addressCode = idCardNo.substring(0,6);
		     check = idCardNoUtil.checkAddressCode(addressCode);
		     if(!check) return false;
		     var birDayCode = '19' + idCardNo.substring(6,12);
		     //校验日期码
		     return idCardNoUtil.checkBirthDayCode(birDayCode);
		  },

		  //校验18位的身份证号码
		  check18IdCardNo: function(idCardNo){
		     //18位身份证号码的基本格式校验
		     var check = /^[1-9]\d{5}[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}(\d|x|X)$/.test(idCardNo);
		     if(!check) return false;
		     //校验地址码
		     var addressCode = idCardNo.substring(0,6);
		     check = idCardNoUtil.checkAddressCode(addressCode);
		     if(!check) return false;
		     //校验日期码
		     var birDayCode = idCardNo.substring(6,14);
		     check = idCardNoUtil.checkBirthDayCode(birDayCode);
		     if(!check) return false;
		     //验证校检码   
		     return idCardNoUtil.checkParityBit(idCardNo);   
		  },

		  formateDateCN: function(day){
		       var yyyy =day.substring(0,4);
		       var mm = day.substring(4,6);
		       var dd = day.substring(6);
		       return yyyy + '-' + mm +'-' + dd;
		  },

		  //获取信息
		  getIdCardInfo: function(idCardNo){
		     var idCardInfo = {
		       gender:"",   //性别
		       birthday:"" // 出生日期(yyyy-mm-dd)
		     };
		    if(idCardNo.length==15){
		        var aday = '19' + idCardNo.substring(6,12);
		        idCardInfo.birthday=idCardNoUtil.formateDateCN(aday);
		        if(parseInt(idCardNo.charAt(14))%2==0){
		            idCardInfo.gender=idCardNoUtil.genders.female;
		        }else{
		            idCardInfo.gender=idCardNoUtil.genders.male;
		        }     
		    }else if(idCardNo.length==18){
		        var aday = idCardNo.substring(6,14);
		        idCardInfo.birthday=idCardNoUtil.formateDateCN(aday);
		         if(parseInt(idCardNo.charAt(16))%2==0){
		            idCardInfo.gender=idCardNoUtil.genders.female;
		        }else{
		            idCardInfo.gender=idCardNoUtil.genders.male;
		        } 
		        
		    }
		    return idCardInfo;
		  },
		  
		  /*18位转15位*/
		  getId15: function(idCardNo){
		   if(idCardNo.length==15){
		       return idCardNo;
		   }else if(idCardNo.length==18){
		       return idCardNo.substring(0,6) + idCardNo.substring(8,17); 
		   }else{
		    return null;
		   }
		  },
		  
		  /*15位转18位*/
		  getId18: function(idCardNo){
		   if(idCardNo.length==15){
		       var id17 = idCardNo.substring(0,6) + '19' + idCardNo.substring(6);
		       var parityBit = idCardNoUtil.getParityBit(id17);
		       return id17 + parityBit;
		   }else if(idCardNo.length==18){
		       return idCardNo;
		   }else{
		    return null;
		   }
		  }
		};

		//身份证号码验证   
		jQuery.validator.addMethod("personcid", function(value, element) { 
		    return this.optional(element) || idCardNoUtil.checkIdCardNo(value); 
		},"请输入正确身份证号"); 
		
jQuery.validator.addMethod("clock",function(value, element) {
	if($.trim(value)!=""){
		if(value=="00:00"){
			return false;
		}
		return true;
		}
	return true;
	},"请输时间值！");

$.validator.setDefaults({
	errorClass: "error",
    success: 'valid',
    unhighlight: function (element, errorClass, validClass) { //验证通过
        $(element).tooltip('destroy');
    },
   highlight: function (element, errorClass, validClass) { //未通过验证
	   
    },
   errorPlacement: function (label, element) {
	   $(element).addClass('tooltip-error');
        $(element).attr('title', $(label).text()).tooltip('show'); 
    }
});