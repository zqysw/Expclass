package com.expclass.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.expclass.R;
import com.expclass.activity.ProjectItemActivity;
import com.expclass.entity.Project;

public class StuProjectAdapter extends BaseAdapter {
	private List<Project> projects = null;
	private Activity context = null;
	// private People peopleitem = null;
	public String allmembers = "";

	public StuProjectAdapter(List<Project> projects, Activity context) {
		this.context = context;
		this.projects = projects;

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



	public View getView(final int position, View view, ViewGroup parent) {
		StuProHolder proHolder = null;
		if (view == null) {
			proHolder = new StuProHolder();
			view = LayoutInflater.from(context).inflate(
					R.layout.activity_projectitem, null);
			proHolder.pronamecontent = (TextView) view
					.findViewById(R.id.pronamecontent);
			proHolder.proworkerscontent = (TextView) view
					.findViewById(R.id.proworkerscontent);
			view.setTag(proHolder);
		} else {
			proHolder = (StuProHolder) view.getTag();
		}
		context.registerForContextMenu(view);
		for (int i = 0; i < projects.size(); i++) {
			allmembers = "";
			
			for (int k = 0; k < projects.get(i).getMembers().length; k++) {
				allmembers += projects.get(i).getMembers()[k] + " ";
				
			}
		}
		proHolder.proworkerscontent.setText("成员:" + allmembers);
		proHolder.pronamecontent.setText("项目名:" + projects.get(position).getName());
		
	
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent intent = new Intent(context, ProjectItemActivity.class);
				intent.putExtra("one_project", projects.get(position));
			//	intent.putExtra("project_id", projects.get(position).getId());
				context.startActivity(intent);
			}
		});
		return view;
	}

	public class StuProHolder {
		TextView pronamecontent;
		TextView proworkerscontent;
	}

}
