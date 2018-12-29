package com.thinkgem.jeesite.test.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.thinkgem.jeesite.test.entity.TestValue;


/**
 * 
 * <p>Title: JsonTest</p>
 * <p>Description: json交互测试</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-14下午3:54:32
 * @version 1.0
 */
@Controller // 必须是Controller @Component 或者其他的 注解不会映射url（404）
public class JsonTest extends org.mybatis.spring.TestValue {
	/*@Value("${jdbc.driver}") // 需要被spring管理的类才能注入值
	private String test;*/
	@Resource
	private TestValue testvalue;
	//请求json串(商品信息)，输出json(商品信息)
	//@RequestBody将请求的商品信息的json串转成itemsCustom对象
	//@ResponseBody将itemsCustom转成json输出
	@RequestMapping("/requestJson")
	public void requestJson(/*ItemsCustom itemsCustom,*/ HttpServletRequest request) {// 也能封装到map对象中但请求的必须是json格式数据
		
		//@ResponseBody将itemsCustom转成json输出
		StringBuffer sb = new StringBuffer();
		BufferedReader br;
		try {
			br = request.getReader();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
		} catch (IOException e) {
		}
		String msgstr = sb.toString();
		String header = request.getHeader("User-Agent");
		HttpSession session = request.getSession();

	}
	
	//请求key/value，输出json
	@RequestMapping("/responseJson")
	public /* @ResponseBody */ /* ItemsCustom */ void responseJson(String name, Map<String, Object> map,
			/*ItemsCustom itemsCustom,*/ HttpServletResponse response) throws IOException {
		RandomAccessFile fileInputStream = null;
		File file = new File(
				"C:\\Users\\hasee\\Pictures\\timg.jpg");
		//FileInputStream fileInputStream = new FileInputStream(
		//		"D:\\BaiduNetdiskDownload\\javaScript高级面向对象教程视频-video\\javaScript高级面向对象高级day01-video\\视频\\01-基础填空题测评与课程介绍-01.mp4");
		byte[] b = new byte[10240];
		int read = 0;
		// response.setContentType("text/html;charset=UTF-8");
		;
		//	response.setContentType("multipart/form-data");
		response.setContentType("application/octet-stream");
		;
		// PrintWriter outputStream = response.getWriter();
		response.setHeader("content-disposition", "attachment;filename=123.mp4");// 设置下载文件的名称
		//response.setHeader("Content-Length", String.valueOf(file.length()));//下载的大小
		fileInputStream = new RandomAccessFile(file, "r");
		ServletOutputStream outputStream = response.getOutputStream();// 字节流也能响应
		/*String temp = "";
		// FileOutputStream fileOutputStream = new
		// FileOutputStream("C:\\test3/haha2.html");
		while ((read = fileInputStream.read(b)) != -1) {
			// outputStream.flush(); //及时刷新
			// temp += (read++)
			// +
			// "nihaonihaonihaodusadbhhsadbhjsdbhjsadbvsjadvsgdjsvadgsadvshjadbsdhjsbadhsadbsadkjsandbkjsadnkjsdbskjdsnakdjsakdnasjk";
			// 将字符转换成字节缓存到底层的bytebuffer中去，如果满了(或者调用flush，close方法)，才会输出到目的地
			outputStream.write(b, 0, read);
		}
		fileInputStream.close();
		outputStream.close();// 输出流关闭时，客户端就不在等待
		*/ FileCopyUtils.copy(new FileInputStream(file), outputStream);
	}

	@RequestMapping("/reqFormData")
	public void formData(HttpServletRequest request) throws IllegalStateException, IOException {
		/*
		 * CommonsMultipartResolver commonsMultipartResolver = new
		 * CommonsMultipartResolver( request.getSession().getServletContext());
		 * commonsMultipartResolver.resolveMultipart(request); 如果在xml中配置了
		 * 这段代码可以不用写，会自动解析 在XMl中配置了 只有上传文件是才会生效，否则 还是原始的请求
		 */
		System.out.println(getTest());
		System.out.println(request.getParameter("name"));
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		System.out.println(multipartRequest.getParameter("name"));
		System.out.println(multipartRequest.getParameter("age"));
		System.out.println(multipartRequest.getParameter("qwer"));// 如果没有选择文件
																	// 手动拼接的
																	// 该值为undefined
		MultipartFile qwer = multipartRequest.getFile("qwer"); //
		System.out.println(multipartRequest.getParameter("moreFile"));// 文件类型的参数为null
																		// getParameter只能获取非文件类型的参数
																		// 需要通过multipartRequest.getFile("moreFile")
																		// 获取
		MultipartFile file2 = multipartRequest.getFile("moreFile"); // 非手动拼接的通过表单对象传递的该值不会为空
																	// 但是size为0
		// 适用于<input
		// type="file"
		// name="moreFile"
		// multiple="multiple">一个标签多文件上传
		List<MultipartFile> file3 = multipartRequest.getFiles("moreFile");
		/*for (Entry<String, MultipartFile> entry : fileMap.entrySet()) {
			MultipartFile file = entry.getValue();
			System.out.println(file);
		
		}
		String originalFilename = file2.getOriginalFilename();
		// 新的图片名称
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		// 新图片
		File newFile = new File("C:/test3/" + newFileName);
		
		// 将内存中的数据写入磁盘
		file2.transferTo(newFile);*/
	}

	@RequestMapping("/responseJson2")
	//@ResponseBody
	public /*Map<String, Object>*/ void jsonTest2(HttpServletResponse response,
			String name/*,@RequestBody Map<String, Object> map*/) throws IOException {

		/*HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		return map;*/

		response.setContentType("application/json");// 也能输出json
		//response.setCharacterEncoding("GBK");
		//字节不设置ContentType 浏览器不会自动解析为 text/html

		//ServletOutputStream outputStream = response.getOutputStream();//输出字节流

		//outputStream.write("{\"a\":12,\"b\":\"dsa\"}".getBytes("utf-8"));//
		// * 只要符合json格式就会输出json(需要设置application/json,不然的话就不会解析，为纯字符串),如果设置了 application/json，返回的不是json类型的数据，
		//ajax的success回调没有数据 error回调的第二个参数的值为parsererror
		//outputStream.flush(); //
		/*outputStream.write("nihai2".getBytes("utf-8"));
		outputStream.flush();
		outputStream.close();*/

		// response.setContentType("text/html;charset=gbk");//字符流设不设置ContentType
		// 浏览器都会自动解析为 text/html

		PrintWriter writer = response.getWriter();// 输出字符流实际上也是转换成字节流
		//writer.append("<div>战三<div/>");
		writer.append("{\"a\":12,\"b\":\"年\"}");
		//writer.append("{\"a2\":12,\"b2\":\"年\"}");
		//response.setContentLength(120);
		writer.flush();
		writer.close();

	}

	@RequestMapping("/responseJson3")
	@ResponseBody
	public void jsonTest3(HttpServletResponse response, HttpServletRequest request) throws IOException {
		System.out.println(request.getServletPath());
		/*
		 * response.setContentType("application/json");// 也能输出json
		 * 字节不设置ContentType 浏览器不会自动解析为 text/html
		 */
		response.setContentType("text/plain");
		response.setHeader("aas", "12");
		response.setCharacterEncoding("UTF-8");
		testvalue.test();
		ServletOutputStream outputStream = response.getOutputStream();// 输出字节流

		outputStream.write("{\"a\":12,\"b\":'dsa啊'}".getBytes("utf-8"));//
		outputStream.write(request.getServletPath().getBytes("utf-8"));//
		outputStream.write(request.getRequestURI().getBytes("utf-8"));//
		// 只要符合json格式就会输出json outputStream.flush(); //
		// outputStream.write("<div>nihai2吗<div/>".getBytes("utf-8"));
		outputStream.flush();
		outputStream.close();

		/*
		 * response.setContentType("text/html;charset=UTF-8");//
		 * 字符流设不设置ContentType // 浏览器都会自动解析为 text/html
		 * 
		 * PrintWriter writer = response.getWriter();// 输出字符流实际上也是转换成字节流
		 * writer.append("<div>战三<div/>");//
		 * 设置setContentType不为text/html的时候html标签不会解析 writer.flush();
		 * writer.write("{\"a\":2,\"p\":'你好'}");// 当只输出为json格式的时候， 输出为json //
		 * 与setContentType设置什么无关 writer.close();
		 */

	}
}
