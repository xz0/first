package com.me.common.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class ConvertUtil {
	/**
	 * 将int型转为byte[]
	 * 
	 * @param i
	 * @return
	 */
	public static byte[] intToByteArray(int i) {
		if (i <= 0) {
			return null;
		}
		byte[] result = new byte[4];
		result[0] = (byte) ((i >> 24) & 0xFF);
		result[1] = (byte) ((i >> 16) & 0xFF);
		result[2] = (byte) ((i >> 8) & 0xFF);
		result[3] = (byte) (i & 0xFF);
		if(ByteUtil.isNullOrEmpty(result)){
			return null;
		}
		return result;
	}

	/**
	 * 将byte[]型转为int
	 * 
	 * @param b
	 * @return
	 */
	public static int byteToInt(byte[] b) {

		if (b == null || b.length != 4) {
			return 0;
		}
		int mask = 0xff;
		int temp = 0;
		int n = 0;
		for (int i = 0; i < 4; i++) {
			n <<= 8;
			temp = b[i] & mask;
			n |= temp;
		}
		return n;
	}
	/**
	 * 将字符串转换为整数
	 * 
	 * @param val
	 * @return
	 */
	public static int ToInt(String val) {
		return ToInt(val, -1);
	}
	
	/**
	 * 将字符串转换为整数
	 * 
	 * @param val
	 * @return
	 */
	public static int ToInt(String val, int defaultValue) {
		if (StringUtil.IsNullOrEmpty(val)) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(val);
		} catch (Exception ex) {
			return defaultValue;
		}
	}

    /**
     * 将字符串转换为布尔类型
     * @param val
     * @param defaultValue
     * @return
     */
    public static boolean ToBoolean(String val, boolean defaultValue){
        if(StringUtil.IsNullOrEmpty(val)){
            return defaultValue;
        }
        if(val.equalsIgnoreCase("true")||val.equalsIgnoreCase(1+"")){
            return true;
        }else if(val.equalsIgnoreCase("false") || val.equalsIgnoreCase(0+"")){
            return false;
        }
        return defaultValue;
    }
	
	/**
	 * 将字符串转换为正整数
	 * 
	 * @param val
	 * @return
	 */
	public static int ToUInt(String val) {
		return Math.abs(ToInt(val));
	}

	/**
	 * 将字符串转换为长整数
	 * 
	 * @param val
	 * @return
	 */
	public static long ToLong(String val) {
		if (StringUtil.IsNullOrEmpty(val)) {
			return 0;
		}

		try {
			return Long.parseLong(val);
		} catch (Exception ex) {
			return 0;
		}
	}

	/**
	 * 将字符串转换为正长整数
	 * 
	 * @param val
	 * @return
	 */
	public static long ToULong(String val) {
		return Math.abs(ToLong(val));
	}

	/**
	 * 将字符串转换为日期
	 * 
	 * @param val
	 * @return
	 */
	public static Date ToDate(String val) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(val);
		} catch (Exception ex) {
			return new Date();
		}
	}

	/**
	 * 将字符串转换为日期
	 * 
	 * @param val
	 * @return
	 */
	public static Date ToDateTime(String val) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(val);
		} catch (Exception ex) {
			return new Date();
		}
	}

	/**
	 * 1,0|2,1|3,0
	 * 
	 * @param str
	 * @return
	 */
	public static Map<Integer, Integer> decodeStringToMap(String str) {
		Map<Integer, Integer> unlockIdMapTmp = new HashMap<Integer, Integer>();
		if (str != null && !str.equals("")) {
			String[] s = str.split("\\|");
			if (s.length > 0) {
				for (String string : s) {
					String[] s2 = string.split(",");
					if (s2.length > 1) {
						unlockIdMapTmp.put(Integer.parseInt(s2[0]),
								Integer.parseInt(s2[1]));
					}
				}
			}
		}

		return unlockIdMapTmp;
	}

	public static String encodeMapToString(Map<Integer, Integer> map) {
		if (map != null && !map.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			int index = 0;
			for (Integer key : map.keySet()) {
				if (index > 0) {
					sb.append("|");
				}
				sb.append(key);
				sb.append(",");
				sb.append(map.get(key));
				index++;
			}
			return sb.toString();
		}

		return "";
	}

	/**
	 * 存储 Map<Integer,Set<Integer>> 转换为String 分隔符不需要使用者自定义
	 * 
	 * @param map
	 * @return
	 */
	public static String encodeMapSetToString(Map<Integer, Set<Integer>> map) {
		if (map != null && !map.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			int index1 = 0;
			for (Integer key : map.keySet()) {

				Set<Integer> valueSet = map.get(key);
				if (index1 > 0) {
					sb.append("|");
				}
				sb.append(key);
				sb.append("@");
				if (valueSet != null && !valueSet.isEmpty()) {
					int index = 0;
					for (Integer integer : valueSet) {
						if (index > 0) {
							sb.append(",");
						}
						sb.append(integer);
						index++;
					}
				}
				index1++;
			}
			return sb.toString();
		}

		return "";
	}

	/**
	 * 1,0|2,1|3,0
	 * 
	 * @param str
	 * @return
	 */
	public static Map<Integer, Set<Integer>> decodeStringToMapSet(String str) {
		Map<Integer, Set<Integer>> mapSet = new HashMap<Integer, Set<Integer>>();
		if (str != null && !str.equals("")) {
			String[] s = str.split("\\|");
			if (s.length > 0) {
				for (String string : s) {
					String[] s2 = string.split("@");
					if (s2.length > 1) {

						int key = Integer.parseInt(s2[0]);
						Set<Integer> value = new HashSet<Integer>();
						String[] s3 = s2[1].split(",");
						if (s3.length >= 1) {
							for (String s4 : s3) {
								value.add(Integer.parseInt(s4));
							}
						}
						mapSet.put(key, value);
					}
				}
			}
		}

		return mapSet;
	}

	/**
	 * 解码 字符串 为 Integer[]
	 * 
	 * @param str
	 * @param split
	 * @return
	 */
	public static int[] decodeStringToArray(String str, String split) {
		int[] ints = new int[4];
		if (str != null && !str.equals("")) {
			String[] s = str.split(split);
			ints = new int[s.length];
			if (s.length > 0) {
				for (int i = 0; i < s.length; i++) {
					ints[i] = Integer.parseInt(s[i]);

				}
			}
		}

		return ints;
	}

	/**
	 * 解码 字符串 为 Set<Integer>列表
	 * 
	 * @param str
	 * @param split
	 * @return
	 */
	public static Set<Integer> decodeStringToSet(String str, String split) {
		Set<Integer> set = new HashSet<Integer>();
		if (str != null && !str.equals("")) {
			String[] s = str.split(split);
			if (s.length > 0) {
				for (String string : s) {
					set.add(Integer.parseInt(string));
				}
			}
		}

		return set;
	}

	/**
	 * 解码 字符串 为 List<Integer>列表
	 * 
	 * @param str
	 * @param split
	 * @return
	 */
	public static List<Integer> decodeStringToList(String str, String split) {
		List<Integer> list = new ArrayList<Integer>();
		if (str != null && !str.equals("")) {
			String[] s = str.split(split);
			if (s.length > 0) {
				for (String string : s) {
					list.add(Integer.parseInt(string));
				}
			}
		}

		return list;
	}

	/**
	 * 把set<Integer>转换 为 String
	 * 
	 * @param set
	 * @param split
	 * @return
	 */
	public static String encodeSetToString(Set<Integer> set, String split) {
		if (set != null && !set.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			int index = 0;
			for (Integer id : set) {
				if (index > 0) {
					sb.append(split);
				}
				sb.append(id);
				index++;
			}
			return sb.toString();
		}

		return "";
	}

	/**
	 * 把set<Integer>转换 为 String | ,
	 * 
	 * @param array
	 * @param split
	 * @param split1
	 * @return
	 */
	public static String encodeArrayToString(int[][] array, String split,
			String split1) {
		if (array != null && array.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int[] ids : array) {
				String temp = "";
				if (ids != null) {
					for (int i : ids) {
						temp += i + split1;
					}
					sb.append(temp.substring(0, temp.length() - 1));
					sb.append(split);
				}
			}
			String result = sb.toString();
			return result.substring(0, result.length() - 1);
		}

		return "";
	}

	/**
	 * 把set<Integer>转换 为 String
	 * 
	 * @param list
	 * @param split
	 * @return
	 */
	public static String encodeListToString(List<Integer> list, String split) {
		if (list != null && !list.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			int index = 0;
			for (Integer id : list) {
				if (index > 0) {
					sb.append(split);
				}
				sb.append(id);
				index++;
			}
			return sb.toString();
		}

		return "";
	}

//	public static void main(String[] args) {
//		String str = "1.2.3.4";
//		String[] s = str.split("\\.");
//		Set<Integer> set = decodeStringToSet("12.12.56", ".");
//		for (String string : s) {
//
//		}
//		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
//		Set<Integer> set1 = new HashSet<Integer>();
//		set1.add(10);
//		map.put(1, set1);
//		System.out.println(encodeMapSetToString(map));
//	}

	public static List<int[]> converMapToArray(Map<Integer, Integer> mapOfInt) {
		List<int[]> list = new ArrayList<int[]>();

		if (mapOfInt != null && !mapOfInt.isEmpty()) {
			for (Integer key : mapOfInt.keySet()) {
				int[] is = new int[2];
				is[0] = key;
				is[1] = mapOfInt.get(key);

				list.add(is);
			}
		}
		return list;
	}

}
