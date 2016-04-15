package com.me.common.util;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;


public class HttpUtil {
	private static Logger logger = Logger.getLogger(HttpUtil.class);
	public static String getParameter(HttpServletRequest request,
			String paramName) {
		if (paramName == null || "".equals(paramName.trim()))
			return null;
		String paramValue = request.getParameter(paramName);
		if (paramValue == null || "".equals(paramValue.trim()))
			return null;
		return paramValue.trim();
	}

	public static String getAttribute(HttpServletRequest request,
			String paramName) {
		if (paramName == null || "".equals(paramName.trim()))
			return null;
		String paramValue = (String) request.getAttribute(paramName);
		if (paramValue == null || "".equals(paramValue.trim()))
			return null;
		return paramValue;
	}

	/**
	 * 从request的attribute里获取对象
	 * 
	 * @param <T>
	 * @param request
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObjectFromAttribute(HttpServletRequest request,
			String key) {
		return (T) request.getAttribute(key);
	}

	public static void setSessionValue(HttpServletRequest request, String key,
			Object object) {
		if (key == null || "".equals(key.trim()))
			return;
		request.getSession().setAttribute(key, object);
	}

	public static Object getSessionValue(HttpServletRequest request, String key) {
		if (key == null || "".equals(key.trim()))
			return null;
		return request.getSession().getAttribute(key);
	}

	/**
	 * 获取浮点型的参数值
	 * 
	 * @param request
	 * @param paramname
	 * @param defaultVal
	 * @return
	 */
	public static Double getDoubleParam(HttpServletRequest request,
			String paramname, Double defaultVal) {
		Double rt = defaultVal;
		String tmp = getStrParam(request, paramname, defaultVal + "", "");
		try {
			rt = Double.parseDouble(tmp);
		} catch (NumberFormatException e) {
			System.out.println(new Date() + "getDoubleParam error:"
					+ e.getMessage());
		}
		return rt;
	}

	/**
	 * 获取浮点型的参数值
	 * 
	 * @param request
	 * @param paramname
	 * @param defaultVal
	 * @return
	 */
	public static Float getFloatParam(HttpServletRequest request,
			String paramname, Float defaultVal) {
		Float rt = defaultVal;
		String tmp = getStrParam(request, paramname, defaultVal + "", "");
		try {
			rt = Float.parseFloat(tmp);
		} catch (NumberFormatException e) {
			logger.info(new Date() + "getFloatParam error:"
					+ e.getMessage());
		}
		return rt;
	}

	/**
	 * 获取长整型的参数值
	 * 
	 * @param request
	 * @param paramname
	 * @param defaultVal
	 * @return
	 */
	public static Long getLongParam(HttpServletRequest request,
			String paramname, Long defaultVal) {
		Long rt = defaultVal;
		String tmp = getStrParam(request, paramname, defaultVal + "", "");
		try {
			rt = Long.parseLong(tmp);
		} catch (NumberFormatException e) {
			System.out.println(new Date() + "getLongParam error:"
					+ e.getMessage());
		}
		return rt;
	}

	/**
	 * 获取布尔值的参数值
	 * 
	 * @param request
	 * @param paramname
	 * @return
	 */
	public static Boolean getBooleanParam(HttpServletRequest request,
			String paramname) {
		Boolean rt = false;
		Integer tmp = getIntegerParam(request, paramname);
		if (tmp == 1) {
			rt = true;
		}
		return rt;
	}

	/**
	 * 获取int型的参数值
	 * 
	 * @param request
	 * @param paramname
	 * @return
	 */
	public static Integer getIntegerParam(HttpServletRequest request,
			String paramname) {
		return getIntegerParam(request, paramname, -1);
	}

	/**
	 * 获取int型的带默认值参数值
	 * 
	 * @param request
	 * @param paramname
	 * @param defaultVal
	 * @return
	 */
	public static Integer getIntegerParam(HttpServletRequest request,
			String paramname, Integer defaultVal) {
		Integer rt = defaultVal;
		String tmp = getStrParam(request, paramname, defaultVal + "", "");
		try {
			rt = Integer.parseInt(tmp);
		} catch (NumberFormatException e) {
			System.out.println(new Date() + "getIntegerParam error:"
					+ e.getMessage());
			e.printStackTrace();
		}
		return rt;
	}

	/**
	 * 获取int型的带默认值参数值
	 * 
	 * @param request
	 * @param paramname
	 * @return
	 */
	public static int[] getIntegerParams(HttpServletRequest request,
			String paramname) {
		String[] tmp ;
		int[] rt = null;
		if(request.getParameterValues(paramname) != null){
			tmp =  request.getParameterValues(paramname);
			rt = new int[tmp.length];
			try {
				for(int i = 0;i< tmp.length;i++){
					rt[i] = Integer.parseInt(tmp[i]);
				}
				
			} catch (NumberFormatException e) {
				System.out.println(new Date() + "getIntegerParams error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return rt;
	}

	/**
	 * 取字符串参数
	 * 
	 * @param request
	 * @param paramname
	 * @return
	 */
	public static String getStrParam(HttpServletRequest request,
			String paramname) {
		return getStrParam(request, paramname, "");
	}

	/**
	 * 取带默认的值的字符串参数
	 * 
	 * @param request
	 * @param paramname
	 * @param defaultVal
	 * @return
	 */
	public static String getStrParam(HttpServletRequest request,
			String paramname, String defaultVal) {
		return getStrParam(request, paramname, defaultVal, "");
	}
	
	/**
	 * 带默认值的且需按指定编码转码的字符串参数
	 * 
	 * @param request
	 * @param paramname
	 * @param defaultVal
	 * @param encoding
	 * @return
	 */
	public static String getStrParam(HttpServletRequest request,
			String paramname, String defaultVal, String encoding) {
		String rt = defaultVal;
		String tmp = request.getParameter(paramname);
		// String tmp = (String) request.getAttribute(paramname);
		if (!StringUtil.checkNull(tmp)) {
			/**
			 * 转码
			 */
			if (!StringUtil.checkNull(encoding)) {

			}

			rt = tmp.trim();
		}
		return rt;
	}
	
	/**
	 * session 中取对象
	 * 
	 * @param request
	 * @param key
	 * @param defaultVal
	 * @return
	 */
	public static Object getSessionObj(HttpServletRequest request, String key,
			Object defaultVal) {
		Object rt = defaultVal;
		Object o = request.getSession().getAttribute(key);
		if (o != null) {
			rt = o;
		}
		return rt;
	}

	/**
	 * session中取字符串
	 * 
	 * @param request
	 * @param key
	 * @param defaultVal
	 * @return
	 */
	public static String getSessionStr(HttpServletRequest request, String key,
			String defaultVal) {
		String rt = defaultVal;
		Object o = getSessionObj(request, key, null);
		if (o != null) {
			rt = (String) o;
		}
		return rt;
	}

	/**
	 * session中取int
	 * 
	 * @param request
	 * @param key
	 * @param defaultVal
	 * @return
	 */
	public static int getSessionInt(HttpServletRequest request, String key,
			int defaultVal) {
		int rt = defaultVal;
		Object o = getSessionObj(request, key, null);
		if (o != null) {
			try {
				rt = (Integer) o;
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return rt;
	}

	/**
	 * HTML转义
	 * 
	 * @param htmlStr
	 * @return
	 */
	public static String htmlEncode(String htmlStr) {
		return StringUtil.htmlEncode(htmlStr);
	}

	/** wap格式 */
	public static final String OUTPUT_WAP1_CONTENT_TYPE = "text/vnd.wap.wml";
	/** json格式 */
	public static final String OUTPUT_JSON_CONTENT_TYPE = "application/json";
	/** html格式 */
	public static final String OUTPUT_HTML_CONTENT_TYPE = "text/html";
	/** image格式 */
	public static final String OUTPUT_IMAGE_CONTENT_TYPE = "image/png";

	/** 编码格式 utf-8 */
	public static final String ENCODING_UTF8 = "UTF-8";

	/**
	 * 向前端输出内容
	 * 
	 * @param response
	 * @param str
	 */
	public static void rspString(HttpServletResponse response, String str) {
		rspString(response, str, OUTPUT_HTML_CONTENT_TYPE, ENCODING_UTF8);
	}

	/**
	 * 向前端输出内容
	 * 
	 * @param response
	 * @param str
	 */
	public static void rspJsonString(HttpServletResponse response, String str) {
		rspString(response, str, OUTPUT_JSON_CONTENT_TYPE, ENCODING_UTF8);
	}
	
	/**
	 * 向前端输出内容
	 * 
	 * @param response
	 * @param str
	 */
	public static void rspString(HttpServletResponse response, String str,
			String contentType, String characterEncoding) {
		response.setContentType(contentType);
		response.setCharacterEncoding(characterEncoding);
		java.io.PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(str);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
				writer = null;
			}
		}
	}
	
	/**
	 * 向前端显示图片
	 * 
	 * @param response
	 * @param bts
	 */
	public static void rspJPEG(HttpServletResponse response, byte[] bts) {
		response.setContentType(OUTPUT_IMAGE_CONTENT_TYPE);
		response.setCharacterEncoding(ENCODING_UTF8);
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			int len = bts.length;
			out.write(bts, 0, len);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * 生成下载文件
	 * @param response
	 * @param str
	 * @param contentType
	 * @param characterEncoding
	 * @param fileName
	 * @throws Exception 
	 */
	public static void rspString(HttpServletResponse response, String str,
			String contentType, String characterEncoding, String fileName) throws Exception {
		fileName = new String(fileName.getBytes("GB2312"), "ISO_8859_1");
		response.addHeader("Content-Disposition",  
                "attachment;filename="+fileName);// filename指定默认的名字
		rspString(response, str, contentType, characterEncoding);
	}
	public static String readJSONString(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return json.toString();
	}

	/**
	 * 得到一个link
	 * 
	 * @param href
	 * @param title
	 * @return
	 */
	public static String getLink(String href, String title) {
		StringBuilder sb = new StringBuilder();
		sb.append("<a href=\"").append(href).append("\">").append(title)
				.append("</a>");
		return sb.toString();
	}

	public static String getUrl(HttpServletRequest request) {
		String uri = request.getRequestURL().toString();
		String query = request.getQueryString();
		StringBuffer sb = new StringBuffer();
		sb.append(uri);
		if (!StringUtil.isEmptyStr(query)) {
			sb.append("?").append(query);
		}
		return sb.toString();
	}

	

	/**
	 * 从request中获得参数Map，并返回可读的Map
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Map<String, String> getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map properties = request.getParameterMap();
		// 返回值Map
		Map<String, String> returnMap = new HashMap<String, String>();
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}

	/**
	 * 根据年月两个字段，拼成日期类型
	 * 
	 * @param request
	 * @param yearName
	 *            年的字段名称
	 * @param monthName
	 *            月的字段名称
	 * @return
	 * @throws ParseException
	 */
	public static Date getYearMonthDt(HttpServletRequest request,
			String yearName, String monthName, Date defaultVal)
			throws ParseException {
		int year = getIntegerParam(request, yearName, -1);
		int month = getIntegerParam(request, monthName, -1);
		Date dt = defaultVal;
		if (year == 0 && month == 0) {
			dt = null;
		} else if (year < 2000 || year > 2100 || month < 1 || month > 12) {
			if (defaultVal != null) {
				year = Integer.parseInt(DateUtil.dateToString(defaultVal,
						"yyyy"));
				month = Integer.parseInt(DateUtil
						.dateToString(defaultVal, "MM"));
			} else {
				year = 0;
				month = 0;
			}
		} else {
			dt = DateUtil.yearMonthToDate(year, month);
		}
		request.setAttribute(yearName, year);
		request.setAttribute(monthName, month);
		return dt;
	}

	/**
	 * 根据年月两个字段，拼成日期类型
	 * 
	 * @param request
	 * @param yearName
	 *            年的字段名称
	 * @param monthName
	 *            月的字段名称
	 * @return
	 * @throws ParseException
	 */
	public static String getYearMonthDtStr(HttpServletRequest request,
			String yearName, String monthName, Date defaultVal)
			throws ParseException {
		Date dt = getYearMonthDt(request, yearName, monthName, defaultVal);
		if (dt == null) {
			return null;
		} else {
			String dtStr = DateUtil.dateToString(dt, DateUtil.DATE_FORMAT);
			return dtStr;
		}
	}

	/**
	 * 根据年月两个字段，拼成日期类型
	 * 
	 * @param request
	 * @param yearName
	 *            年的字段名称
	 * @param monthName
	 *            月的字段名称
	 * @return
	 * @throws ParseException
	 */
	public static String getYearMonthDtStrYyyyMm(HttpServletRequest request,
			String yearName, String monthName, Date defaultVal)
			throws ParseException {
		Date dt = getYearMonthDt(request, yearName, monthName, defaultVal);
		if (dt == null) {
			return null;
		} else {
			String dtStr = DateUtil.dateToString(dt,
					DateUtil.DATE_FORMAT_YYYY_MM);
			return dtStr;
		}
	}

	/**
	 * 获得真实的IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtil.isEmptyStr(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtil.isEmptyStr(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtil.isEmptyStr(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (StringUtil.isEmptyStr(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (StringUtil.isEmptyStr(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for-pound");
		}
		if (StringUtil.isEmptyStr(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 如果是多级代理，那么取第一个非unknown的ip为客户ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		}
		
//		System.out.println("x-forwarded-for:"+request.getHeader("x-forwarded-for")+",Proxy-Client-IP:"+request.getHeader("Proxy-Client-IP")
//				+",WL-Proxy-Client-IP:"+request.getHeader("WL-Proxy-Client-IP")+",getRemoteAddr():"+request.getRemoteAddr()
//				+",http_client_ip:"+request.getHeader("HTTP_CLIENT_IP")+",HTTP_X_FORWARDED_FOR:"+request.getHeader("HTTP_X_FORWARDED_FOR")
//				+",x-forwarded-for-pound:"+request.getHeader("x-forwarded-for-pound"));
		return ip;
	}

	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j)
					|| Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16) {
					tmp.append("0");
				}
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}
	
	/**
	 * 根据语言环境取得从配置文件中取得对应的提示信息
	 * @param request
	 * @param message
	 * @return
	 */
	public static String setLangPro(HttpServletRequest request, String message){
		RequestContext requestContext = new RequestContext(request);
		 return requestContext.getMessage(message);
	}
	/**
	 * 填写错误提示信息
	 * @param request
	 * @param msg
	 */
	public static void setReqMsg(HttpServletRequest request, String msg){
//		request.setAttribute(GipFixedNameEnum.msg.getName(), msg);
		request.setAttribute("msg", msg);
	}
	
	/**
	 * 把request里所有参数放入map
	 * @param request
	 */
	public static Map<String,String>  setAttributeForAllParams(HttpServletRequest request){
		Enumeration<String> enu=request.getParameterNames();  
		String paraName = "";
		Map<String,String> paramMap = new HashMap<String,String>();
		while(enu.hasMoreElements()){  
			paraName= enu.nextElement();
			paramMap.put(paraName, getStrParam(request, paraName));
		} 
		request.setAttribute("paramMap", paramMap);
		return paramMap;
	}
	
}
