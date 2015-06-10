package com.expclass.activity;

import java.util.ArrayList;
import java.util.List;

import com.expclass.R;
import com.expclass.adapter.ProjectListAdapter;
import com.expclass.entity.Project;
import com.expclass.service.ProjectService;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.Toast;

public class ProjectListActivity extends Activity{
  private ListView allprojects = null;
  private Thread thread = null;
  private Handler handler = null;
  public  List<Project> projects = new ArrayList<Project>();
  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_projectlist);
		allprojects = (ListView) findViewById(R.id.allprojects);
		
		thread = new Thread(new Runnable() {
			Message msg = new Message();
			@Override
			public void run() {
				try {
					projects =ProjectService.getJSONAllProject();
					msg.what=1;
					handler.sendMessage(msg);
				} catch (Exception e) {
					e.printStackTrace();
					msg.what=0;
					handler.sendMessage(msg);
				}
			}
		});
		handler = new Handler(new Handler.Callback() {
			
			@Override
			public boolean handleMessage(Message msg) {
				if(msg.what==1){
					ProjectListAdapter projectListAdapter = new ProjectListAdapter(projects, ProjectListActivity.this);
					allprojects.setAdapter(projectListAdapter);
				}else{
					Toast.makeText(ProjectListActivity.this, "it has error", Toast.LENGTH_LONG).show();
				}
				return true;
			}
		});
		thread.start();
	}
}
