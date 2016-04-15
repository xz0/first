package com.me.common.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	private static Logger logger = Logger.getLogger(DateUtil.class);
	/**
	 * 默认的日期格式
	 */
	public static final String DEFAULT_DATE_FAMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 常用于自动文件名
	 */
	public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	/**
	 * 年月日日期格式
	 */
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * 年月日日期格式
	 */
	public static final String DAY_FORMAT_START = "yyyy-MM-dd 00:00:00";
	/**
	 * 年月日日期格式
	 */
	public static final String DAY_FORMAT_END = "yyyy-MM-dd 23:59:59";
	/**
	 * 时分秒的
	 */
	public static final String TIME_FORMAT = "HH:mm:ss";
	/**
	 * 时分
	 */
	public static final String TIME_HHmm = "HH:mm";
	/**
	 * 表时间戳
	 */
	public static final String TABLE_DATE_FORMAT = "yyyyMMdd";
	/**
	 * 年月日期格式
	 */
	public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";

	public static final String DATE_FORMAT_YYYYMM= "yyyyMM";
	
	private static String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	
	/**
	* 判断当前日期是星期几<br>
	* <br>
	* @param dt 要判断的时间<br>
	* @return weekDays 判断结果<br>
	*/
	public static String getWeekOfDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0){
			w = 0;
		}
		return weekDays[w];
	}
	public static String getWeekOfDate(String dt) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(dt));
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0){
			w = 0;
		}
		return weekDays[w];
	}

	/**
	 * 根据一个日期的星期数字得到星期的汉字
	 * 如0：星期日，1：星期一
	 * @param w
	 * @return
	 */
	public static String getWeekStr(int w){
		if (w < 0 || w > 6){
			w = 0;
		}
		return weekDays[w];
	}
	/**
	 * 字符串转日期 按默认格式
	 * @param stringValue
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String stringValue) throws ParseException{
		return stringToDate(stringValue,DEFAULT_DATE_FAMAT);
	}
	/**
	 * 字符串转日期 按指定格式
	 * @param stringValue
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String stringValue,String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(stringValue);
	}
	
	/**
	 * 日期转换为字符串yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateToString(date, DEFAULT_DATE_FAMAT);
	}
	/**
	 * 格式化输出日期
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date,String format){
		SimpleDateFormat time = new SimpleDateFormat(format);
		return time.format(date);
	}
	
	/**
	 * 日期转换为字符串MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String dateToStringNoYear(Date date) {
		SimpleDateFormat time = new SimpleDateFormat("MM-dd HH:mm");
		return time.format(date);
	}
	
	/**
	 * 年和月拼成一个日期
	 * @param year
	 * @param month
	 * @return
	 * @throws ParseException 
	 */
	public static Date yearMonthToDate(int year,int month) throws ParseException{
		String dtStr = "" + year;
		if (month < 10) {
			dtStr += "-0" + month;
		} else {
			dtStr += "-" + month;
		}
		Date dt = stringToDate(dtStr, DATE_FORMAT_YYYY_MM);
		return dt;
	}
	/**
	 * 两日期相差的天数
	 */
	public static int delayCeilDay(Date date1,Date date2){
		long t1 = date1.getTime();
		long t2 = date2.getTime();
		long delay = 0;
		if(t1<t2){
			delay = t2-t1;
		}else{
			delay = t1-t2;
		}
		return (int) Math.ceil((delay/(3600000*24d)));
	}
	/***
	 * 判断是否是同一天
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean   isSameDay(Date   date1,Date   date2)   {
		if(date1 == null || date2 == null) return false;
		SimpleDateFormat   sdf   =   new   SimpleDateFormat(DATE_FORMAT);
		String date1Str   =   sdf.format(date1);
		String date2Str   =   sdf.format(date2);
		return   date1Str.equals(date2Str);
	} 
	/**
	 * 计算两个日期相差的分钟数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int delaySecond(Date date1,Date date2){
		long t1 = date1.getTime();
		long t2 = date2.getTime();
		long delay = 0;
		if(t1<t2){
			delay = t2-t1;
		}else{
			delay = t1-t2;
		}
		return (int) (delay%60000)/1000;
	}
	/**
	 * 计算两个日期相差的分钟数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int delayMinute(Date date1,Date date2){
		long t1 = date1.getTime();
		long t2 = date2.getTime();
		long delay = 0;
		if(t1<t2){
			delay = t2-t1;
		}else{
			delay = t1-t2;
		}
		return (int) delay/60000;
	}
	/**
	 * 相差的小时数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int delayHour(Date date1,Date date2){
		long t1 = date1.getTime();
		long t2 = date2.getTime();
		long delay = 0;
		if(t1<t2){
			delay = t2-t1;
		}else{
			delay = t1-t2;
		}
		return (int) ((delay%(3600000*24))/3600000);
	}
	
	/**
	 * 两日期相差的天数
	 */
	public static int delayDay(Date date1,Date date2){
		long t1 = date1.getTime();
		long t2 = date2.getTime();
		long delay = 0;
		if(t1<t2){
			delay = t2-t1;
		}else{
			delay = t1-t2;
		}
		return (int) (delay/(3600000*24));
	}
	
	/**
	 * 计算两个日期相差的总秒数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int delayTotleSecond(Date date1,Date date2){
		long t1 = date1.getTime();
		long t2 = date2.getTime();
		long delay = 0;
		if(t1<t2){
			delay = t2-t1;
		}else{
			delay = t1-t2;
		}
		return (int) delay/1000;
	}
	
	/**
	 * 计算两个日期相差的总分钟数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int delayTotleMinute(Date date1,Date date2){
		long t1 = date1.getTime();
		long t2 = date2.getTime();
		long delay = 0;
		if(t1<t2){
			delay = t2-t1;
		}else{
			delay = t1-t2;
		}
		return (int) (delay/60000);
	}
	
	/**
	 * 计算传过来的日期与当前日期相差的总分钟数
	 * @param date
	 * @return int
	 */
	public static int delayTotleMinute(Date date){
		Date now = new Date();
		long t1 = date.getTime();
		long t2 = now.getTime();
		long delay = 0;
		if(t1<t2){
			delay = t2-t1;
		}else{
			delay = t1-t2;
		}
		return (int) (delay/60000);
	}

	/**
	 * 相差的总小时数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int delayTotleHour(Date date1,Date date2){
		long t1 = date1.getTime();
		long t2 = date2.getTime();
		long delay = 0;
		if(t1<t2){
			delay = t2-t1;
		}else{
			delay = t1-t2;
		}
		return (int) (delay/3600000);
	}

	/***
	 * 查看当前是否在两时间之中
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isBetween(String start,String end,String format){
		boolean ret = false;
		if(StringUtil.isEmptyStr(start) || StringUtil.isEmptyStr(end)) return ret;
		try {
			Date startDt = stringToDate(start,format);
			Date endDt = stringToDate(end,format);
			Date now = stringToDate(StringUtil.dateToString(new Date(),format),format);
			ret = now.after(startDt) && now.before(endDt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ret;
	}
	/***
	 * 查看给定时间是否在两时间之中
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isBetween(Date dt,String start,String end,String format){
		boolean ret = false;
		if(StringUtil.isEmptyStr(start) || StringUtil.isEmptyStr(end)) return ret;
		try {
			Date startDt = stringToDate(start,format);
			Date endDt = stringToDate(end,format);
			Date now = stringToDate(StringUtil.dateToString(dt,format),format);
			ret = now.after(startDt) && now.before(endDt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * 得到某天的后几月日期
	 * @param d
	 * @param month
	 * @return
	 */
	public static Date getMonthAfter(Date d,int month){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.MONTH, now.get(Calendar.MONTH) + month);
		return now.getTime();
	}
	/**
	 * 得到某天的后几天日期
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateAfter(Date d,int day){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}

	/**
	 * 得到某天多少小时后的日期
	 * @param d
	 * @param hour
	 * @return
	 */
	public static Date getDateBeforeAnyHour(Date d,int hour){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY) + hour);
		return now.getTime();
	}

	/**
	 * 得到某天多少分钟后的日期
	 * @param d
	 * @param minute
	 * @return
	 */
	
	public static Date getMinuteAfter(Date d,int minute){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + minute);
		return now.getTime();
	}
	
	/**
	 * 得到某天的后几秒Date
	 * @param d
	 * @param second
	 * @return
	 */
	public static Date getSecondAfter(Date d,int second){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.SECOND, now.get(Calendar.SECOND) + second);
		return now.getTime();
	}
	

	/**
	 * 得到某天的前几月日期
	 * @param d
	 * @param month
	 * @return
	 */
	public static Date getMonthBefore(Date d,int month){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.MONTH, now.get(Calendar.MONTH) - month);
		return now.getTime();
	}
	
	public static Date getDateBefore(Date d,int day){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}
	
	public static Date getHourBefore(Date d,int hour){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY) - hour);
		return now.getTime();
	}

	public static Date getMinuteBefore(Date d,int minute){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) - minute);
		return now.getTime();
	}
	/**
	 * 得到某天的前几秒Date
	 * @param d
	 * @param second
	 * @return
	 */
	public static Date getSecondBefore(Date d,int second){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.SECOND, now.get(Calendar.SECOND) - second);
		return now.getTime();
	}
	public static List<String> getDateStrBetweenDates(String start,String end) throws Exception{
		return getDateStrBetweenDates(start, end, null);
	}
	public static List<String> getDateStrBetweenDates(String start,String end,String format) throws Exception{
		List<String> list = new ArrayList<String>();
		if(format==null || "".equals(format)){
			format = DateUtil.DATE_FORMAT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Long startM = sdf.parse(start).getTime();
		Long endM = sdf.parse(end).getTime();
		long result = (endM - startM) / (24 * 60 * 60 * 1000);
		logger.info("差:" + result + "天");

		Date startDate = sdf.parse(start);
		Calendar startTime = Calendar.getInstance();
		startTime.clear();
		startTime.setTime(startDate);
		for (int i = 0; i <=(int)result;i++) {
			String str = startTime.get(Calendar.YEAR) + "-"
			+ (startTime.get(Calendar.MONTH)+1<10?"0"+(startTime.get(Calendar.MONTH)+1):(startTime.get(Calendar.MONTH)+1))+ "-"
			+ (startTime.get(Calendar.DAY_OF_MONTH)<10?"0"+startTime.get(Calendar.DAY_OF_MONTH):startTime.get(Calendar.DAY_OF_MONTH));
			list.add(str);
			startTime.add(Calendar.DAY_OF_YEAR, 1); 
		}
		return list;
	}
	public static List<Map<String,String>> getDateBetweenMap(String startStr,String endStr){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Date end;
		Date start;
		try {
			start = DateUtil.stringToDate(startStr, DateUtil.DEFAULT_DATE_FAMAT);
			end = DateUtil.stringToDate(endStr,DateUtil.DEFAULT_DATE_FAMAT);
			if(start.before(end)){
				Calendar st = new GregorianCalendar();
				 Calendar en = new GregorianCalendar();
				 st.setTime(start);
				 en.setTime(end);
				 int count = (en.get(Calendar.YEAR)-st.get(Calendar.YEAR))*12+(en.get(Calendar.MONTH)-st.get(Calendar.MONTH));
				 for(int i=0;i<=count;i++){
					 Map<String,String> map = new HashMap<String,String>();
					 if(count==0){
						 map.put("start", startStr);
						 map.put("end", endStr);
					 }else{
						 if(i==0){
							 map.put("start", startStr);
							 st.set(Calendar.DATE, st.getMaximum(Calendar.DATE));
							 map.put("end", DateUtil.dateToString(st.getTime(), DateUtil.DATE_FORMAT)+" 23:59:59");
						 }else if(i==count){
							 en.set(Calendar.DATE, st.getMinimum(Calendar.DATE));
							 map.put("start", DateUtil.dateToString(en.getTime(), DateUtil.DATE_FORMAT)+" 00:00:00");
							 st.set(Calendar.DATE, st.getMaximum(Calendar.DATE));
							 map.put("end", endStr);
						 }else {
							 st.set(Calendar.DATE, st.getMinimum(Calendar.DATE));
							 st.set(Calendar.MONTH, st.get(Calendar.MONTH) + 1);
							 map.put("start", DateUtil.dateToString(en.getTime(), DateUtil.DATE_FORMAT)+" 00:00:00");
							 st.set(Calendar.DATE, st.getMaximum(Calendar.DATE));
							 st.set(Calendar.MONTH, st.get(Calendar.MONTH) + 1);
							 map.put("end", DateUtil.dateToString(en.getTime(), DateUtil.DATE_FORMAT)+" 23:59:59");
						 }
					 }
					 list.add(map);
				 }
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return list;
		
	}
	/**
	 * 获取小时值
	 * @param date
	 * @return
	 */
	public static int getHourBYDate(Date date){
		String dateStr = dateToString(date);
		return ConvertUtil.ToInt(dateStr.split(" ")[1].split(":")[0]);
	}
}
