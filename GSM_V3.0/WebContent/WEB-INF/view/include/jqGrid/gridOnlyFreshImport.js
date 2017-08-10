
	$(function(){
		if(typeof(window.freshFun)=='undefined'){
			window.freshFun=function(){
				$("#grid-table").trigger("reloadGrid");
			};
		}
		//navButtons
		jQuery("#grid-table").navGrid('#grid-pager',{edit:false,add:false,del:false,search:false,refresh:false})
		 .navButtonAdd('#grid-pager',{  
			 caption:"",
			 buttonicon:"ui-icon icon-refresh",
			 onClickButton: freshFun,
			 position:"last"  ,
			 title:"刷新"
			 })  ;
	});