/*package com.dykj.GSM.utils;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="MyKaptchaServlet/Kaptcha",method=RequestMethod.GET)
public class MyKaptchaServlet extends HttpServlet
  implements Servlet
{
  private Properties props = new Properties();

  private Producer kaptchaProducer = null;

  private String sessionKeyValue = null;

  private String sessionKeyDateValue = null;
 
  public void init(ServletConfig conf)
    throws ServletException
  {
    super.init(conf);

    ImageIO.setUseCache(false);

    Enumeration initParams = conf.getInitParameterNames();
    while (initParams.hasMoreElements())
    {
      String key = (String)initParams.nextElement();
      String value = conf.getInitParameter(key);
      this.props.put(key, value);
    }

    Config config = new Config(this.props);
    System.out.println(this.props+"//////////************-------");
    this.kaptchaProducer = config.getProducerImpl();
    this.sessionKeyValue = config.getSessionKey();
    this.sessionKeyDateValue = config.getSessionDate();
  }

  public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
	  System.out.println(sessionKeyValue+"//////////************-------");
    resp.setDateHeader("Expires", 0L);

    resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

    resp.addHeader("Cache-Control", "post-check=0, pre-check=0");

    resp.setHeader("Pragma", "no-cache");

    resp.setContentType("image/jpeg");

    Random random = new Random(); 
    String capText = this.kaptchaProducer.createText();
    int str1=(int)(Math.random()*100);
    int str2=(int)(Math.random()*100);
    String str1 = capText.substring(0, 2);
    String str2 = capText.substring(2, 4);
    int result = str1 + str2;
    req.getSession().setAttribute(this.sessionKeyValue, result+"");

    req.getSession().setAttribute(this.sessionKeyDateValue, new Date());


    BufferedImage bi = this.kaptchaProducer.createImage(str1 + "+" + str2
      + "=?");

    ServletOutputStream out = resp.getOutputStream();

    ImageIO.write(bi, "jpg", out);
  }
}


*/
package com.dykj.GSM.utils;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
@RestController
@RequestMapping("/")  
public class MyKaptchaServlet {
 
 private Producer captchaProducer = null;  
   
     @Autowired  
     public void setCaptchaProducer(Producer captchaProducer) {  
         this.captchaProducer = captchaProducer;  
     }  
   
     @RequestMapping("/captcha-image")  
     
     public ModelAndView handleRequest
    (HttpServletRequest request, HttpServletResponse response) throws Exception {  
   
         response.setDateHeader("Expires", 0); 
 
         // Set standard HTTP/1.1 no-cache headers. 
 
         response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
         // Set IE extended HTTP/1.1 no-cache headers (use addHeader). 
 
         response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
         // Set standard HTTP/1.0 no-cache header. 
 
         response.setHeader("Pragma", "no-cache");  
         // return a jpeg 
 
         response.setContentType("image/jpeg");  
         // create the text for the image
  
         String capText = captchaProducer.createText();
         //取两个随机数
         int str1=(int)(Math.random()*10);
         int str2=(int)(Math.random()*10);
         int result1 = str1 + str2;
         String result =String.valueOf(result1);
         //把结果放到session
         request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, result);  

         BufferedImage bi = captchaProducer.createImage(str1 + "+" + str2);  
         ServletOutputStream out = response.getOutputStream();  
         // write the data out  

         ImageIO.write(bi, "jpg", out);  
         try {  
             out.flush();  
         } finally {  
             out.close();  
         }  
         return null;  
     }  
     //验证验证码
     @RequestMapping(value="/resultServlet/validateCode",method=RequestMethod.POST)
      public ActionMessage yanzheng( HttpServletRequest request,@Valid String validateCode) throws Exception {
  	      String code = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
              if(code.equals(validateCode)){       
              	return new ActionMessage(true);
              }else{        
              	return new ActionMessage(false);
              }        
      }       
   
 }