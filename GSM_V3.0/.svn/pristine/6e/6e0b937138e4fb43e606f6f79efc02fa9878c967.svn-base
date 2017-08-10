package com.dykj.GSM.action.sys;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.sys.SysUpload;
import com.dykj.GSM.service.sys.SysUploadService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.ConvertToPdf;
import com.dykj.GSM.utils.ImgErToFileUtil;
import com.dykj.GSM.utils.MySession;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/sys/sysupload")
public class SysUploadAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysUploadAction.class);
	@Autowired
	private SysUploadService sysUploadService;

	/**
	 * 新增页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad() {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "sys/sysupload/add");
		return new ModelAndView("/sys/sysupload/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param sysupload
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(SysUpload sysupload) {
		SessionModel session = MySession.getInfo();
		sysupload.setCreateBy(session.getCode());
		try {
			if (sysUploadService.insert(sysupload) > 0) {
				return new ActionMessage(true);
			} else {
				return new ActionMessage(false);
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/sys/sysupload/manage");
	}

	/**
	 * 文件上传
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public String upload(HttpServletRequest request, HttpServletResponse response, String cookieValue) throws Exception {
		List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
		SessionModel session = MySession.getInfo();
		SysUpload sysUpload = new SysUpload();
		// uploadify 插件可能造成cookie丢失，所以在formdata中传值
		/*
		 * if (session == null) { if (MySession.setInfo(cookieValue)) { session
		 * = MySession.getInfo(); } }
		 */
		sysUpload.setCreateBy(session.getCode());
		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			Iterator itr = items.iterator();
			while (itr.hasNext()) {
				Map<String, Object> fileMap = new HashMap<String, Object>();
				FileItem item = (FileItem) itr.next();
				if (item.isFormField()) {
					System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
				} else {
					if (item.getName() != null && !item.getName().equals("")) {
						double filesize = item.getSize();
						DecimalFormat df = new DecimalFormat("######0.00");
						filesize = ((filesize / 1024) / 1024);
						String files = df.format(filesize);

						System.out.println("上传文件的大小:" + files + "MB");
						System.out.println("上传文件的类型:" + item.getContentType());
						// item.getName()返回上传文件在客户端的完整路径名称
						System.out.println("上传文件的名称:" + item.getName());
						File tempFile = new File(item.getName());
						// 上传文件的保存路径
						String path = request.getServletContext().getRealPath("upload");
						System.out.println(path);
						fileMap.put("size", files);
						String fileNames = item.getName();
						String fileNamess[] = fileNames.split("\\.");
						fileMap.put("name", fileNamess[0]);
						Calendar date = Calendar.getInstance();
						int year = date.get(Calendar.YEAR);
						int month = date.get(Calendar.MONTH) + 1;
						int day = date.get(Calendar.DAY_OF_MONTH);
						path = path + File.separator + year + File.separator + month;
						String fileExt = tempFile.getName()
								.substring(tempFile.getName().lastIndexOf("."), tempFile.getName().length())
								.toLowerCase();
						UUID uuidString = java.util.UUID.randomUUID();
						String fileName = uuidString.toString() + "_" + day + fileExt;
						File pathFile = new File(path);
						if (pathFile.exists() == false) {
							pathFile.mkdirs();
						}
						File file = new File(path, fileName);
						sysUpload.setPath(year + "/" + month + "/" + fileName);
						sysUpload.setName(tempFile.getName());
						if (fileExt.equals(".jpg") || fileExt.equals(".jpeg") || fileExt.equals(".gif")
								|| fileExt.equals(".png")) {
							InputStream is = item.getInputStream();
							// 如果文件大于1G，则开始压缩
							if (item.getSize() > 1024.0 * 1024.0) {
								this.compressImg(is, file);
							} else {
								item.write(file);
							}
						} else {
							item.write(file);
						}
						int i = sysUploadService.insert(sysUpload);
						fileMap.put("path", sysUpload.getPath());
						fileMap.put("code", sysUpload.getCode());
						request.setAttribute("upload.message", "上传文件成功！");
					} else {
						request.setAttribute("upload.message", "没有选择上传文件！");
					}
				}
				if (item.getName() != null) {
					fileMap.put("oldFileName", item.getName());
					fileList.add(fileMap);
				}
			}
		} catch (FileUploadException e) {
			logger.error("error", e);
			throw e;
		} catch (Exception e) {
			logger.error("error", e);
			throw e;
		}
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(fileList);
	}

	@RequestMapping(value = "/uploadFile")
	public String uploadFile(HttpServletRequest request, HttpServletResponse response, String cookieValue)
			throws Exception {
		List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
		SessionModel session = MySession.getInfo();
		SysUpload sysUpload = new SysUpload();
		// uploadify 插件可能造成cookie丢失，所以在formdata中传值
		if (session == null) {
			if (MySession.setInfo(cookieValue)) {
				session = MySession.getInfo();
			}
		}
		sysUpload.setCreateBy(session.getCode());
		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			Iterator itr = items.iterator();
			while (itr.hasNext()) {
				Map<String, Object> fileMap = new HashMap<String, Object>();
				FileItem item = (FileItem) itr.next();
				if (item.isFormField()) {
					System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
				} else {
					if (item.getName() != null && !item.getName().equals("")) {
						double filesize = item.getSize();
						DecimalFormat df = new DecimalFormat("######0.00");
						filesize = ((filesize / 1024) / 1024);
						String files = df.format(filesize);
						System.out.println("上传文件的大小:" + files + "MB");
						System.out.println("上传文件的类型:" + item.getContentType());
						// item.getName()返回上传文件在客户端的完整路径名称
						System.out.println("上传文件的名称:" + item.getName());
						File tempFile = new File(item.getName());
						// 上传文件的保存路径
						String path = request.getServletContext().getRealPath("upload\\uploadfile");
						System.out.println(path);
						fileMap.put("size", files);
						fileMap.put("name", item.getName());
						path = path + File.separator;
						String fileExt = tempFile.getName()
								.substring(tempFile.getName().lastIndexOf("."), tempFile.getName().length())
								.toLowerCase();
						UUID uuidString = UUID.randomUUID();

						// 组成上传到服务器的文件名称例如：525770e7-427f-4f37-8600-b6e374209cd3.doc
						String fileName = uuidString.toString() + fileExt;

						// 创建uploadFile文件夹
						File pathFile = new File(path);
						if (pathFile.exists() == false) {
							pathFile.mkdirs();
						}

						File file = new File(path, fileName);

						sysUpload.setPath("uploadfile" + "/" + fileName);
						sysUpload.setName(tempFile.getName());

						if (fileExt.equals(".txt") || fileExt.equals(".doc") || fileExt.equals(".docx")) {
							InputStream is = item.getInputStream();
							// 如果文件大于1G，则开始压缩
							item.write(file);
						} else {
							item.write(file);
						}

						if (sysUploadService.insert(sysUpload) > 0) {
							fileMap.put("path", sysUpload.getPath());
							fileMap.put("code", sysUpload.getCode());
							request.setAttribute("upload.message", "上传文件成功！");
						} else {
							request.setAttribute("upload.message", "上传至服务器失败！");
						}
						request.setAttribute("upload.message", "上传文件成功！");
					} else {
						request.setAttribute("upload.message", "没有选择上传文件！");
					}
				}
				if (item.getName() != null) {
					fileMap.put("oldFileName", item.getName());
					fileList.add(fileMap);
				}
			}
		} catch (FileUploadException e) {
			logger.error("error", e);
			throw e;
		} catch (Exception e) {
			logger.error("error", e);
			throw e;
		}
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(fileList);
	}

	// 根据code字符串查找图片，字符串以;隔开
	@RequestMapping(value = "/queryByCodes")
	public List<SysUpload> queryByCodes(String codes) {
		try {
			List codeList = Arrays.asList(codes.split(";"));
			return sysUploadService.queryByCodes(codeList);
		} catch (Exception e) {
			logger.error("error", e);
			return null;
		}
	}

	/**
	 * 文件上传
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadApp")
	public String upload(String picString, HttpServletRequest request) {
		String code = "";
		String[] picList = picString.split(",");
		for (String stringImg : picList) {
			try {
				Calendar date = Calendar.getInstance();
				int year = date.get(Calendar.YEAR);
				int month = date.get(Calendar.MONTH) + 1;
				int day = date.get(Calendar.DAY_OF_MONTH);
				UUID uuidString = java.util.UUID.randomUUID();
				String fileName = "androidImg_" + year + "_" + month + "_" + uuidString.toString() + "_" + day + ".jpg";
				String path = request.getServletContext().getRealPath("upload") + File.separator + year
						+ File.separator + month;
				System.out.println(path);
				SysUpload sysUpload = new SysUpload();
				SessionModel session = MySession.getInfo();
				sysUpload.setCreateBy(session.getCode());
				sysUpload.setPath(year + "/" + month + "/" + fileName);
				sysUpload.setName(fileName);
				ImgErToFileUtil.saveToImgByStr(stringImg, path, fileName);
				int i = sysUploadService.insert(sysUpload);
				if (i > 0) {
					code += sysUpload.getCode() + ";";
				} else {
					throw new Exception("上传图片出错！");
				}
			} catch (Exception e) {
				logger.error("error", e);
			}
		}
		return "{\"code\":\"" + code + "\"}";
	}

	@RequestMapping(value = "/downLoad")
	public void downLoad(HttpServletRequest request, HttpServletResponse response, String code) throws Exception {
		code = request.getParameter("code");
		SysUpload upload = sysUploadService.queryByKey(code);
		if (upload != null) {
			String path = request.getServletContext().getRealPath("upload");
			String fileNameString = upload.getPath();
			String oldFileName = upload.getName();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-download;charset=UTF-8");
			if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
				oldFileName = new String(oldFileName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器
			} else {
				if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
					oldFileName = URLEncoder.encode(oldFileName, "UTF-8");// IE浏览器
				}
			}
			response.setHeader("Content-Disposition", "attachment;fileName=" + oldFileName);
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				File file = new File(path + File.separator + fileNameString);
				Long fileLength = file.length();
				System.out.println(file.getAbsolutePath());
				// 设置输出长度
				response.setHeader("Content-Length", String.valueOf(fileLength));
				// 获取输入流
				bis = new BufferedInputStream(new FileInputStream(file));
				// 输出流
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buff = new byte[2048];
				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
				// 关闭流
				bis.close();
				bos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 在线预览word
	 * 
	 * @param is
	 * @param outputFile
	 * @throws IOException
	 */
	@RequestMapping(value = "/infosee")
	public void doGet(HttpServletRequest request, HttpServletResponse response, String code) throws Exception{
		    code = request.getParameter("code");
		    SysUpload upload = sysUploadService.queryByKey(code);
		    if (upload != null) {
		    String path = request.getServletContext().getRealPath("upload");
		    String fileNameString = upload.getPath();
		    File file = new File(path + File.separator + fileNameString);
		    ConvertToPdf office = new ConvertToPdf();
		    office.convert2PDF(file.getAbsolutePath(), path+ File.separator +"uploadfile"+ File.separator +code+".pdf");
			response.setContentType("application/pdf");

			FileInputStream in = new FileInputStream(new File(path+ File.separator +"uploadfile"+ File.separator +code+".pdf"));
			OutputStream out = response.getOutputStream();
			byte[] b = new byte[512];

			while ((in.read(b)) != -1) {
			out.write(b);
			}

			out.flush();
			in.close();
			out.close();
			}
	}
	
	

	/**
	 * 图片压缩功能
	 * 
	 * @param is
	 * @param outputFile
	 * @throws IOException
	 */
	public void compressImg(InputStream is, File outputFile) throws IOException {
		BufferedImage prevImage = ImageIO.read(is);
		OutputStream os = new BufferedOutputStream(new FileOutputStream(outputFile));
		double width = prevImage.getWidth();
		double height = prevImage.getHeight();
		double percent = 1.0;
		if (width > 1024) {
			percent = 1024 / width;
		}
		Image i = prevImage.getScaledInstance((int) (width * percent), (int) (height * percent), Image.SCALE_DEFAULT);
		// 缩放图像
		BufferedImage bImage = new BufferedImage((int) (width * percent), (int) (height * percent),
				BufferedImage.TYPE_BYTE_INDEXED);
		Graphics g = bImage.createGraphics();
		g.drawImage(i, 0, 0, null); // 绘制缩小后的图
		g.dispose();
		ImageIO.write(bImage, "jpg", os);// 输出
		os.close();
	}

	@RequestMapping(value = "/tempDownLoad")
	public void tempDownLoad(HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		String path = request.getServletContext().getRealPath("upload");
		String fileNameString = "temp" + File.separator + "test.docx";
		String oldFileName = name;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-download;charset=UTF-8");
		if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
			oldFileName = new String(oldFileName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器
		} else {
			if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
				oldFileName = URLEncoder.encode(oldFileName, "UTF-8");// IE浏览器
			}
		}
		response.setHeader("Content-Disposition", "attachment;fileName=" + oldFileName);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File file = new File(path + File.separator + fileNameString);
			if (file.exists()) {
				file.createNewFile();
			}
			Long fileLength = file.length();
			// 设置输出长度
			response.setHeader("Content-Length", String.valueOf(fileLength));
			// 获取输入流
			bis = new BufferedInputStream(new FileInputStream(file));
			// 输出流
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			// 关闭流
			bis.close();
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 * 
	 * @param codes
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public Object delete(String[] codes) {
		try {
			int i = sysUploadService.deleteBatch(Arrays.asList(codes));
			if (i > 0) {
				return new ActionMessage(true);
			}
			return new ActionMessage(false);
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}
}
