/*
 *    Copyright 2011-2012 19lou.com
 */
package com.boot1.chovy.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * JSON与JAVA BEAN转换工具类
 * Created by wangchaohui on 2018/5/10.
 * */
public class JSONUtil {
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();
	private static Gson gson_fieldNaming = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();
	private static Gson gson_default = new GsonBuilder().disableHtmlEscaping().create();
	private static Type listType = new TypeToken<ArrayList<HashMap<String, String>>>() {}.getType();
	private static Type objType = new TypeToken<HashMap<String, String>>() {}.getType();

	/**
	 * 把简单的JAVA对象转换成JSON格式的字符串
	 * @param obj
	 * @return JSONString
	 */
	public static String beanToStr(Object obj) {
		if (obj == null)
			return "";
		return gson.toJson(obj);
	}

	/**
	 * 格式化对象为JSONString
	 * @param T obj
	 * @return JSONString
	 */
	public static <T> String objToStr(T obj) {
		return gson.toJson(obj, new TypeToken<T>() {
		}.getType());
	}

	/**
	 * 把JSONString转成JsonObject，格式如：{"values":["先生","女士"],"raddef":"先生"}
	 */
	public static JsonObject getJsonObject(String json) {
		return new JsonParser().parse(json).getAsJsonObject();
	}

	/**
	 * 格式化JSONString为简单JAVA对象
	 * @param str JSONString
	 * @param classType
	 * @return Object
	 */
	public static Object strToObject(String str, Type classType) {
		try {
			return gson.fromJson(str, classType);
		} catch (Exception e) {
			return gson_default.fromJson(str, classType);
		}
	}

	/**
	 * 格式化JSONString为JAVA对象(单个对象)
	 * @param str JSONString
	 * @param cls 要转换的JAVA类
	 * @return 转换后的JAVA对象
	 */
	public static <T> Object strToBean(String str, Class<T> cls) {
		if (str == null)
			return null;
		try {
			return gson.fromJson(str, cls);
		} catch (Exception e) {
			return gson_default.fromJson(str, cls);
		}
	}

	/**
	 * 把非空JSONString转为HashMap对象集合
	 */
	public static List<HashMap<String, String>> strToMapList(String str) {
		if (str.startsWith("[") && str.endsWith("]"))
			return gson.fromJson(str, listType);
		else {
			List<HashMap<String, String>> maplist = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> fromJson = gson.fromJson(str, objType);
			maplist.add(fromJson);
			return maplist;
		}
	}

	/**
	 * 把数组转化成JSONString，数组内容为 BEAN
	 */
	public static String arraysToStr(Object[] srcs) {
		return gson.toJsonTree(srcs).toString();
	}

	
	public static class JsonFieldNamingPolicy {
		private final Gson gson;
		private JsonFieldNamingPolicy(Gson gson) {
			super();
			this.gson = gson;
		}
		
	}

	public static final JsonFieldNamingPolicy camelCasePolicy = new JsonFieldNamingPolicy(gson);
	public static final JsonFieldNamingPolicy underlineCasePolicy = new JsonFieldNamingPolicy(gson_fieldNaming);
}
