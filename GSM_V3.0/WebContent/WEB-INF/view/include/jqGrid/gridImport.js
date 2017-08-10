
	$(function(){
		if(typeof(window.freshFun)=='undefined'){
			window.freshFun=function(){
				$("#grid-table").trigger("reloadGrid");
			};
		}if(typeof(window.deleteFun)=='undefined'){
			window.deleteFun=function(){
				alert("页面未定义deleteFun js方法");
			};
		}
		if(typeof(window.addFun)=='undefined'){
			window.addFun=function(){
				alert("页面未定义addFun js方法");
			};
		}
		//navButtons
		jQuery("#grid-table").navGrid('#grid-pager',{edit:false,add:false,del:false,search:false,refresh:false})
		.navButtonAdd('#grid-pager',{  
		 caption:"",
		 buttonicon:"icon-plus-sign purple",
		 onClickButton:addFun,
		 position:"last"  ,
		 title:"新增"
		 })
		 .navButtonAdd('#grid-pager',{  
			 caption:"",
			 buttonicon:" icon-trash red",
			 onClickButton:deleteFun,
			 position:"last"  ,
			 title:"删除"
			 })
		 .navButtonAdd('#grid-pager',{  
			 caption:"",
			 buttonicon:"ui-icon icon-refresh",
			 onClickButton: freshFun,
			 position:"last"  ,
			 title:"刷新"
			 })  ;
	});