<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

	<head>
	<style>
.pdfobject-container { height: 550px;width:930px}
.pdfobject { border: 0px solid #666; }
</style>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<link rel="stylesheet"  href="${base}/resource/css/timeline.css" />
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
<script type="text/javascript" src="${base }/resource/js/pdfobject.js"></script>
<script type="text/javascript">
      window.onload = function (){
    	  PDFObject.embed("${base}/sys/sysupload/infosee?code=${vdata.code}", "#pdf");
    	  count();
      };
</script>
</head>
<body id = "pdf">
 <form id="form" name="form">  
  <table border="0" width="100%" height="100%">  
    <tr>   
    <td align=center id="pdfSee"  style="display:none;">   
        <p><span class="red"  style="font-size:50px;">插件丢失，请重新加载</span></p>  
        <p>  
            <!-- <input type="text" name="chart" size="46" style="font-family:Arial; font-weight:bolder; color:gray;background-color:white; padding:0px; border-style:none;"> -->  
            <br>  
            <!-- <input type="text" name="percent" size=46 style="font-family:Arial; color:gray; text-align:center; border-width:medium; border-style:none;">   -->
            <script>var bar = 0;   
            var line = "||" ;  
            var amount ="||" ;  
            count() ;  
            function count(){   
                bar= bar+2 ;  
                amount =amount + line;   
                /* document.form.chart.value=amount ;  
                document.form.percent.value=bar+"%"; */      
                if (bar<99)   
                    {setTimeout("count()",100);}   
                else   
                    {$("#pdfSee").show();}   
            }  
  
            </script>  
        </p>  
    </td>  
</tr>  
</table>  
</form>  

</body>
</html>


