package com.me.common.util;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public class MathUtil {
	
	private static Random random = new Random(System.currentTimeMillis());
	
	/**
	 * 随机数计算 闭区间
	 * @param start
	 * @param end
	 * @return
	 */
	public static int random(int start,int end){
		if(end-start<0){
			int smaller = end;
			end = start;
			start = smaller;
		}else if(end-start==0){
			return start;
		}
		return start+random.nextInt(end-start)+random.nextInt(2);
	}
	/**
	 * 随机数计算 闭区间
	 * @param start
	 * @param end
	 * @return
	 */
	public static double random(double start,double end){
		if(end-start<0){
			double smaller = end;
			end = start;
			start = smaller;
		}else if(end-start==0){
			return start;
		}
		return start+(end-start)*random.nextDouble();
	}
	/**
	 * 随机数计算 闭区间
	 * @param start
	 * @param end
	 * @return
	 */
	public static float random(float start,float end){
		if(end-start<0){
			float smaller = end;
			end = start;
			start = smaller;
		}else if(end-start==0){
			return start;
		}
		return start+(end-start)*random.nextFloat();
	}
	/**
	 * 返回一个[0,i)之间的整数
	 * @param i
	 * @return
	 */
	public static int random(int i){
		return random.nextInt(i);
	}
	/***
	 * 返回一个[0,d)之间的双精度整型
	 * @param d
	 * @return
	 */
	public static double random(double d){
		return random.nextDouble()*d;
	}
	/**
     * [1,100]随机数是否命中指定数值范围
     * @param per 指定数值(百分比)
     * @return
     */
	public static boolean isHitRandom(int per){
		if (per >= 100) {
            return true;
        }
        int r = random(1, 100);
		return r <= per;
	}
	/***
	 * 除法,给jsp使用
	 * @param a
	 * @param b
	 * @return
	 */
	public static int division(int a , int b){
		return a/b;
	}
	/***
	 * 对象 转 int类型
	 * @param obj
	 * @return
	 */
	public static int objToInt(Object obj){
		int result = 0;
		if (obj == null || obj.equals("")) {
			result = 0;
		} else {
			if ((obj.toString()).matches("[0-9]+")
					&& obj.toString().length() < 10) {
				result = Integer.valueOf(obj.toString());
			} else {
				result = 0;
			}
		}
		return result;
	}
	
	/**
	 * 按权重随机抽取一个
	 * @param listRate
	 * @param rateMaxNum
	 * @return
	 */
	public static int getRadomIndex(List<Integer> listRate,int rateMaxNum) {
		int left = 0;
		int right = 0;
		int index = -1;
		int random = MathUtil.random(rateMaxNum);
		for(int i=0; i < listRate.size(); i++){
			right = left + listRate.get(i);
			if(random >= left && random < right){
				index = i;
				break;
			}
			left = right;
		}
		return index;
	}
	/*
	 * 取三个数最小的一个
	 */
	public static int getMin(int x,int y,int z){
		return x>y?(y>z?z:y):(x>z?z:x);
	}
	
	/**
	 * 数字格式化
	 * */
	public static double numberFormat(double number,String format){
		 DecimalFormat df = new DecimalFormat(format); 
		 String num = df.format(number);
		return Double.parseDouble(num);
	}
	
	/**
	 * 数据库维持2条记录
	 * 
	 * @param list
	 * @param state
	 * @return
	 */
	public static int getId2(List<String[]> list, String state) {
		int id = 0;
		int len = 0;
		if (list != null && !list.isEmpty()) {
			len = list.size();
		}
		if (len == 0) {
			return id;
		} else if (len == 1) {
			if (state.equals(list.get(0)[1])) {
				id = ConvertUtil.ToInt(list.get(0)[0]);
			}
		} else {
			if (state.equals(list.get(0)[1])) {
				id = ConvertUtil.ToInt(list.get(0)[0]);
			} else {
				id = ConvertUtil.ToInt(list.get(1)[0]);
			}
		}
		return id;
	}

    /**
     *
     * @param f
     * @param n
     * @return
     */
    public static int getResult(Float f, int n){
        if(f==null){
            return 0;
        }
        return (int)(f*n);
    }
	public static void test(StringBuffer sb){
		sb.append("ss");
	}
//	public static void main(String[] args){
//		StringBuffer sb = new StringBuffer();
////		for (int i = 0; i < 5; i++) {
////			test(sb);
////		}
//		List<String[]> list = new ArrayList<String[]>();
//		System.out.println(list.size());
//	}
}
