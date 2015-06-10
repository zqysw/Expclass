package com.expclass.adapter;

import java.util.List;

import com.expclass.R;
import com.expclass.activity.ProjectItemActivity;
import com.expclass.entity.Project;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class ProjectListAdapter extends BaseAdapter{
	private List<Project> projects = null;
	private Activity context = null;
	public String allmembers = "";
	public ProjectListAdapter(List<Project> projects,Activity context){
		this.projects = projects;
		this.context = context;
	}
	@Override
	public int getCount() {
		return projects.size();
	}

	@Override
	public Object getItem(int position) {
		return projects.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		ViewHolder holder = null;
		if(view ==null){
			holder = new ViewHolder();
			view = LayoutInflater.from(context).inflate(R.layout.activity_projectitem, null);
			holder.pronamecontent =  (TextView) view.findViewById(R.id.pronamecontent);
			holder.proworkerscontent =  (TextView) view.findViewById(R.id.proworkerscontent);
			view.setTag(holder);
		}else{
			holder =  (ViewHolder) view.getTag();
		}
		context.registerForContextMenu(view);
		final Project project = projects.get(position);
		holder.pronamecontent.setText("项目名:"+project.getName());
	
		allmembers="";
		for (int  i = 0; i < project.getMembers().length; i++) {
			allmembers+= project.getMembers()[i]+" ";
		}
		
		holder.proworkerscontent.setText("项目成员:"+allmembers);
		view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(context,ProjectItemActivity.class);
				intent.putExtra("one_project", project);
				context.startActivity(intent);
				
			}
		});
		return view;
	}
	
	public class ViewHolder{
		TextView pronamecontent;
		TextView proworkerscontent;
		
	}
}
