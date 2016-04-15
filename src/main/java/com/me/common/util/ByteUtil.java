package com.me.common.util;

public class ByteUtil {

	private ByteUtil(){}
	/**
	 * 判断一个字节数组的内容是否为空
	 * 
	 * @param b
	 * @return
	 */
	public static boolean isNullOrEmpty(byte[] b) {
		if (b == null) {
			return true;
		}
		int len = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 0) {
				len++;
			}
		}
		return len == b.length;
	}

	/**
	 * java 合并两个byte数组
	 * 
	 * @param byte_1
	 * @param byte_2
	 * @return
	 */
	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		if(isNullOrEmpty(byte_1)||isNullOrEmpty(byte_2)){
			return null;
		}
		byte[] byte_3 = new byte[byte_1.length + byte_2.length];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
		return byte_3;
	}
}
