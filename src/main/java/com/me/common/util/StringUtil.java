package com.me.common.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	private static Pattern pattern = Pattern.compile("[\u0001-\u001F]");
	/**
	 * 默认的日期格式
	 */
	private static final String DEFAULT_DATE_FAMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期转字符串 默认格式
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateToString(date, DEFAULT_DATE_FAMAT);
	}

	/**
	 * 日期转字符串 指定格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	/**
	 * 二进制转十进制
	 * @param s
	 * @return
	 */
	public static int convertAlgorism(String s){
		if(isEmptyStr(s)){
			return 0;
		}
		return convertAlgorism(s.toCharArray());
	}
	/**
	 * 二进制转十进制
	 * @param cars
	 * @return
	 */
	public static int convertAlgorism(char[] cars) {
		if(cars==null){
			return 0;
		}
		return Integer.parseInt(String.valueOf(cars),2);
	}
	/**
	 * 判断字符串是否为null
	 * 
	 * @param string
	 * @return
	 */
	public static boolean checkNull(String string) {
		return string == null || "".equals(string.trim())
				|| "null".equalsIgnoreCase(string.trim());
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmptyStr(String string) {
		return string == null || "".equals(string.trim());
	}

	/**
	 * 返回一个指定长度的随机字符串(只包括数字大小写英文字母)
	 * 
	 * @param len
	 * @return
	 */
	public static String randomStr(int len) {
		String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		for (int i = 0, strL = str.length(); i < len; i++) {
			int index = MathUtil.random(strL);
			sb.append(str.charAt(index));
		}
		return sb.toString();
	}
	/***
	 * 判断字符串是不是数字
	 * @param s
	 * @return
	 */
	public static boolean isNum(String s){
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 对字符串进行简单html编码,以便页面显示不会乱码
	 * 
	 * @param str
	 * @return
	 */
	public static String htmlEncode(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll(" ", "&#160;");
		str = str.replaceAll("\n", "&#160;");
		str = str.replaceAll("\"", "&quot;");
		Matcher m = pattern.matcher(str);
		str = m.replaceAll("");
		return str;
	}

	public static String htmlEncodeNick(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("#", "&#35;");
		str = str.replaceAll(",", "&#44;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll(" ", "&#160;");
		str = str.replaceAll("\n", "&#160;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("[|]", "&#124;");
		str = str.replaceAll("[$]", "");
		Matcher m = pattern.matcher(str);
		str = m.replaceAll("");
		return str;
	}

	/**
	 * 去除uc的token中+,/等url需编码的字符
	 * @param str
	 * @return
	 */
	public static String removeUrlChar(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		str = str.replaceAll("[+]", "");
		str = str.replaceAll("[/]", "");
		return str;
	}

	/**
	 * 过滤sid中的攻击性字符
	 * @param str
	 * @return
	 */
	public static String filterBadChar(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		str = str.replaceAll("[|]", "");
		str = str.replaceAll("[&]", "");
		str = str.replaceAll("[;]", "");
		str = str.replaceAll("[$]", "");
		str = str.replaceAll("[%]", "");
		str = str.replaceAll("[@]", "");
		str = str.replaceAll("[']", "");
		str = str.replaceAll("[\"]", "");
		str = str.replaceAll("[\\\\]", "");
		str = str.replaceAll("[<]", "");
		str = str.replaceAll("[>]", "");
		str = str.replaceAll("[(]", "");
		str = str.replaceAll("[)]", "");
		str = str.replaceAll("[+]", "");
		str = str.replaceAll("[\r]", "");
		str = str.replaceAll("[\n]", "");
		str = str.replaceAll("[,]", "");
		str = str.replaceAll("[ ]", "");
		return str;
	}

	/**
	 * 记录日志
	 * */
	public static void writeLog(String path, String content) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(path, true);
			BufferedWriter bfW = new BufferedWriter(fw);
			bfW.write(content);
			bfW.newLine();
			bfW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * 分割字符串
	 * 
	 * @param original
	 * @param regex
	 * @return
	 */
	public static String[] splitString(String original, String regex) {
		// 取子串的起始位置
		int startIndex = 0;
		// 将结果数据先放入Vector中
		Vector<String> v = new Vector<String>();
		// 返回的结果字符串数组
		String[] str = null;

		// 存储取子串时起始位置
		int index = 0;
		if (original == null) {
			return null;
		}
		// 获得匹配子串的位置
		startIndex = original.indexOf(regex);
		// 如果起始字符串的位置小于字符串的长度，则证明没有取到字符串末尾。
		// -1代表取到了末尾
		while (startIndex < original.length() && startIndex != -1) {
			String temp = original.substring(index, startIndex);
			// 取子串
			v.addElement(temp);
			// 设置取子串的起始位置
			index = startIndex + regex.length();
			// 获得匹配子串的位置
			startIndex = original.indexOf(regex, index);
		}
		// 取结束的子串
		v.addElement(original.substring(index));
		// 将Vector对象转换成数组
		str = new String[v.size()];
		for (int i = 0; i < v.size(); i++) {
			str[i] = v.elementAt(i);
		}
		// 返回生成的数组
		return str;
	}
	
	/**
	 * 去除字符串中的逗号
	 * @param s
	 * @return
	 */
	public static  String getStringp(String s){
		String ss = "";
		String sss[] = StringUtil.splitString(s, ",");
		for(int i=0;i<sss.length;i++){
			ss = ss.concat(sss[i]);
		}
		return ss;
	} 
	
	/**
	 * 去掉空格、回车、换行符、制表符,html空格(&nbsp;)
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String a= "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			a= m.replaceAll("").replaceAll("&nbsp;","");
		}
		return a;
	}
	

	/**
	 * 生成uuid字符串，不带-
	 * @return
	 */
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

	/**
	 * 生成uuid字符串，带-
	 * @return
	 */
	public static String getUUIDWithMinus(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	/**
     * 输入字符串是否为null或空字符串
     * @param s - 输入字符串 
     * @return
     */
    public static boolean IsNullOrEmpty(String s) 
    {
    	if(s == null){
    		return true;
    	}
		return s.trim().isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(getUUIDWithMinus());
	}
	
	/**
	 * 验证密码是否过于简单 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static boolean passwordVerification(String password){
		//必须包含字母大小写、数字、字符 至少3种
		int count=0;
		if(password.matches("^.*[a-z]+.*$")){
			count=count+1;
		}
		if(password.matches("^.*[A-Z]+.*$")){
			count=count+1;
		}
		if(password.matches("^.*[0-9]+.*$")){
			count=count+1;
		}
		if(password.matches("^.*[^a-zA-Z0-9]+.*$")){
			count=count+1;
		}
		if(count<2){
			return false;
		}
		//新密码过于简单
		return !("123456".equals(password) || "aly123456".equals(password));
	}
	/**
	 * 生成 随机密码
	 */
	public static String passwordCreate(){
		String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String num = "0123456789";
		String ch = "~()-_=+[];,.";
		int length = MathUtil.random(6,12);
		StringBuffer psw = new StringBuffer();
		String s = "";
		for(int i = 0; i< length ; i++){
			int size = MathUtil.random(1,4);
			if(size == 1){
				int l = MathUtil.random(capital.length());
				s = String.valueOf(capital.charAt(l));
			}else if(size == 2){
				int l = MathUtil.random(lowercase.length());
				s = String.valueOf(lowercase.charAt(l));
			}else if(size == 3){
				int l = MathUtil.random(num.length());
				s = String.valueOf(num.charAt(l));
			}else if(size == 4){
				int l = MathUtil.random(ch.length());
				s = String.valueOf(ch.charAt(l));
			}
			psw.append(s);
		}
		if(!passwordVerification(psw.toString())){
			return passwordCreate();
		}
		return psw.toString();
	}
    
    /**
     * 按格式化串格式化输出字符串
     * @param s
     * @param p
     * @return
     */
    public static String Format(String s, Object... p) {
    	if(p==null || p.length==0){
    		return s;
    	}
    	for (int i = 0; i < p.length; i++) {
    		String t = new StringBuilder().append("{").append(i).append("}").toString();
    		s = s.replace(t, p[i].toString());
		}
    	return s;
    }
    /**
     * 按分隔符格式化输出字符串
     * @param separator
     * @param p
     * @return
     */
    public static String FormatBySeparator(String separator, String... s) {
    	if(s==null || s.length==0){
    		return "";
    	}
    	StringBuffer sb = new StringBuffer();
    	sb.append(DateUtil.dateToString(new Date())).append(separator);
    	for (int i = 0; i < s.length; i++) {
			if(i==s.length-1){
				sb.append(s[i]).append(separator);
			}else {
				sb.append(s[i]).append(separator);
			}
		}
    	return sb.toString();
    }
    /** 
     * 计算采用utf-8编码方式时字符串所占字节数 
     *  
     * @param content 
     * @return 
     */  
    public static int getByteSize(String content) {  
        int size = 0;  
        if (!IsNullOrEmpty(content)) {  
            try {  
                // 汉字采用utf-8编码时占3个字节  
                size = content.getBytes("utf-8").length;  
            } catch (UnsupportedEncodingException e) {  
                e.printStackTrace();  
            }  
        }  
        return size;  
    }

    /**
     * 把数组转化为逗号分隔的字符串
     * @param sArr
     * @return
     */
    public static String ArrToStr(String[] sArr){
        if(sArr!=null && sArr.length>0){
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < sArr.length; i++) {
                sb.append(sArr[i]).append(",");
            }
            return sb.toString().substring(0,sb.length()-1);
        }
        return "";
    }
}
