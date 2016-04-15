package com.me.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonUtil {

    private static SerializeConfig mapping = new SerializeConfig();
    private static String dateFormat;

    static {
        dateFormat = "yyyy-MM-dd HH:mm:ss";
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
    }

    /**
     * 将JAVA对象转换为JSON对象
     * @param javaObj
     * @return
     */
    public static JSONObject getJsonObject4JavaPOJO(Object javaObj){
        return getJsonObject4String(getJsonString4JavaPOJO(javaObj));
    }
    /**
	 * 将java对象转换成json字符串
	 * 
	 * @param javaObj
	 * @return
	 */
	public static String getJsonString4JavaPOJO(Object javaObj) {
		return JSON.toJSONString(javaObj, mapping);
	}
	/**
	 * 字符串转换为JAVA对象
	 * @param str
	 * @return
	 */
	public static JSONObject getJsonObject4String(String str) {
		return JSON.parseObject(str);
	}
	
	@SuppressWarnings("rawtypes")
	public static String getJsonString4List(List list) {
		if(list==null || list.isEmpty()){
			return "";
		}
		String str = JSON.toJSONString(list, mapping, SerializerFeature.DisableCircularReferenceDetect);
		return str;
	}
	
	/**
	 * 将JSON转换成POJO,其中beanClz为POJO的Class
	 * @param jsonStr
	 * @param beanClass
	 * @return
	 */
	public static <T> T jsonStr2Object(String jsonStr,Class<T> beanClass){
		return JSON.parseObject(jsonStr, beanClass);
	}
	public static <T> List<T> jsonStr2ObjectList(String jsonStr,Class<T> beanClass){
		return JSON.parseArray(jsonStr, beanClass);
	}

	public static Map<String, Object> jsonStr2Map(String jsonStr){
		return JSON.parseObject(jsonStr, new TypeReference<Map<String,Object>>(){});
	}

	public static void main(String args[]){
//		List<PersonPo> list = new ArrayList<PersonPo>();
//		list.add(new PersonPo(4,100,"[00ff00] 内测当天 [-]",new Date()));
//		list.add(new PersonPo(2,99,"99"));
////		list.add(new PersonPo(3,101,"101"));
////		list.add(new PersonPo(1,100,"100 1"));
////		list.add(new PersonPo(5,102,"102"));
//		net.sf.json.JSONArray jsonArr = net.sf.json.JSONArray.fromObject(list, getJsonConfig());
//		System.out.println(jsonArr.toString());
//		net.sf.json.JSONArray jsonArr2 = net.sf.json.JSONArray.fromObject(jsonArr.toString(), getJsonConfig());
//		System.out.println(jsonArr2.toString().replaceAll("【", "["));
//		
//		
//		String strList = JsonUtil.getJsonString4List(list);
//		System.out.println(strList);
//		List<PersonPo> list2 = JsonUtil.jsonStr2ObjectList(strList, PersonPo.class);
//		if (list2 != null) {
//			for (PersonPo personPo : list2) {
//				System.out.println(personPo.getId()+",id2:"+personPo.getId2()+",name:"+personPo.getName()+",dt:"+personPo.getDt());
//			}
//		}
//		String strList2 = JsonUtil.getJsonString4List(list2);
//		System.out.println(strList2);
		
		
//		for (int i = 0; i < jsonArr.size(); i++) {
//			JSONObject jsonObj = (JSONObject)jsonArr.get(i); 
//			System.out.println(jsonObj);
//		}
//		JSONObject jsonFromBean = JSONObject.fromObject(new PersonPo(4,100,"100 4", new Date()),jsonConfig);  
//		System.out.println(jsonFromBean);  
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("name2", "ttt");
		map.put("dt", new Date());
//
		String jsonObjStr = JsonUtil.getJsonString4JavaPOJO(map);
        System.out.println(jsonObjStr);
//        PersonPo po = jsonStr2Object(jsonObjStr, PersonPo.class);
//        System.out.println(po);
//
//		String f = getJsonString4JavaPOJO(map);
////		String f = getJsonString4JavaPOJO("{\"access_token\":\"8ALN7LKJigfGJLqVLytUYtGQa3-7qQ5kOBZYroVSEr7lCNdEnga38OhyujhimsspZTCxt7zN3-hap2WP_dd-Bt-joXZ5vPQYhgOJ9yR39QQ\",\"expires_in\":7200}");
//		System.out.println(f);
//		JSONObject json =  getJsonObject4String(f);
//		System.out.println(json);
//
//		Map<String, Object> map2 = JsonUtil.jsonStr2Map(jsonObjStr);
//		System.out.println(map2.get("id"));
//		System.out.println(map2.get("name"));
//		System.out.println(map2.get("dt"));
		
	}
}


 

