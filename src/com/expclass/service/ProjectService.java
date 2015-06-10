package com.expclass.service;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.expclass.entity.Project;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ProjectService {
	
/**
 * 获取项目的信息
 */
	
	//使用第三方Gson类库解析 json字符串
			public static List<Project> getJSONAllProject() throws Exception {

				String path = "http://128.199.110.96/Innovate/public/api_projects?format=json&type=get";
				URL url = new URL(path);
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setReadTimeout(5 * 1000);
				conn.setRequestMethod("GET");
				InputStream inStream = conn.getInputStream();
				byte[] data = com.expclass.utils.StreamTool.readInputStream(inStream);
				String json = new String(data);
				Type typeList = new TypeToken<ArrayList<Project>>() {
				}.getType();
				Gson gson = new Gson();
				List<Project> projects = gson.fromJson(json, typeList);
				return projects;
			}
			//使用第三方Gson类库解析 json字符串
			public static Project getJSONProject(String project_id) throws Exception {

				String path = "http://128.199.110.96/Innovate/public/api_project/"+project_id+"?format=json&type=get";
				URL url = new URL(path);
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setReadTimeout(5 * 1000);
				conn.setRequestMethod("GET");
				InputStream inStream = conn.getInputStream();
				byte[] data = com.expclass.utils.StreamTool.readInputStream(inStream);
				String json = new String(data);
				Type typeList = new TypeToken<Project>() {
				}.getType();
				Gson gson = new Gson();
				 Project proitem = gson.fromJson(json, typeList);
				return proitem;
			}
}
