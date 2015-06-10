package com.expclass.service;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.expclass.entity.People;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PeopleService {
	public static List<People> peoples=null;
	
/**
 * 获取学生的各项信息
 */
	
	//使用第三方Gson类库解析 json字符串
		public static void getJSONAllPeople_2() throws Exception {
			
			String path = "http://128.199.110.96/Innovate/public/api_students?format=json&type=get";
			URL url = new URL(path);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(5 * 1000);
			conn.setRequestMethod("GET");
			InputStream inStream = conn.getInputStream();
			byte[] data = com.expclass.utils.StreamTool.readInputStream(inStream);
			String json = new String(data);
			Type typeList = new TypeToken<ArrayList<People>>() {
			}.getType();
			Gson gson = new Gson();
			 peoples = gson.fromJson(json, typeList);
		}
		
		/**
		 * 获取单个学生的信息
		 */
		public static People getJSONPeopleItem(String stu_id) throws Exception {
			People peopleitem = null;
			String path = "http://128.199.110.96/Innovate/public/api_student/"+stu_id+"?format=json&type=get";
			URL url = new URL(path);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(5 * 1000);
			conn.setRequestMethod("GET");
			InputStream inStream = conn.getInputStream();
			byte[] data = com.expclass.utils.StreamTool.readInputStream(inStream);
			String json = new String(data);
			Type typeList = new TypeToken<People>() {
			}.getType();
			Gson gson = new Gson();
			 peopleitem = gson.fromJson(json, typeList);
			 return peopleitem;
		}
}
