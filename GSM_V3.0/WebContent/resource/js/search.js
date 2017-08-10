    $.fn.searchPara = function (p) {
        p = $.extend({
        }, p);
         
        var para="";
        
        $(".text", this).each(function (a, b) {
        	if(!b.value) return;
        	if(para){
        		para+=",";
        	}
        	
        	if($(b).attr("searchType")){
        		para+=b.name+$(b).attr("searchType")+b.value;
        	}else{
        		para+=b.name+"="+b.value;
        	}
        		
        	
        });
        
        
        return para;
                
    };