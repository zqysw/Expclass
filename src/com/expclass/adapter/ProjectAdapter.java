package com.expclass.adapter;

import java.util.LinkedList;
import java.util.List;

import com.expclass.R;
import com.expclass.activity.ProjectItemActivity;
import com.expclass.entity.Project;
import com.expclass.entity.ProjectType;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProjectAdapter implements ExpandableListAdapter{
	private Context context = null;
	private LinkedList<ProjectType> types = null;  //采用有序列表，要插入一组数据时效率更高
	private List<LinkedList<Project>> projects = null;
	public ProjectAdapter(Context context ,List<LinkedList<Project>>  projects , LinkedList<ProjectType> types){
		this.context = context;
		this.projects = projects;
		this.types = types;
	}
	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getChild(int typeops, int projectpos) {
		// TODO Auto-generated method stub
		return projects.get(typeops).get(projectpos);
	}

	@Override
	public long getChildId(int typeops, int projectpos) {
		// TODO Auto-generated method stub
		return projectpos;
	}

	@Override
	public View getChildView(int typeops, int projectpos, boolean islastchild, View view,
			ViewGroup parents) {
		ProjectHolder projectHolder = null;
		if(view ==null){
			projectHolder = new ProjectHolder();
			view = LayoutInflater.from(context).inflate(R.layout.activity_projectitem, null);
			projectHolder.pronamecontent= (TextView) view.findViewById(R.id.pronamecontent);
			projectHolder.proworkerscontent = (TextView) view.findViewById(R.id.proworkerscontent);
			view.setTag(projectHolder);
		}else{
			projectHolder = (ProjectHolder) view.getTag();
		}
          view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context,ProjectItemActivity.class);
				context.startActivity(intent);
				
			}
		});
			projectHolder.pronamecontent.setText(projects.get(typeops).get(projectpos).getName());
			projectHolder.proworkerscontent.setText(projects.get(typeops).get(projectpos).getMembers().toString());
		
		return view;
	}
	public class ProjectHolder{
		TextView pronamecontent;
		TextView proworkerscontent;
	}
	@Override
	public int getChildrenCount(int typeops) {
		// TODO Auto-generated method stub
		return projects.get(typeops).size();
	}

	@Override
	public long getCombinedChildId(long arg0, long arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCombinedGroupId(long arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getGroup(int typeops) {
		// TODO Auto-generated method stub
		return types.get(typeops);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return types.size();
	}

	@Override
	public long getGroupId(int typeops) {
		// TODO Auto-generated method stub
		return typeops;
	}

	@Override
	public View getGroupView(int typeops, boolean islastgroup, View view, ViewGroup parrent) {
		TypeHolder holder = null;
		if(view ==null){
			holder = new TypeHolder();
			view = LayoutInflater.from(context).inflate(R.layout.activity_projecttype, null);
			holder.typeimg =  (ImageView) view.findViewById(R.id.typeimg);
			holder.typetext = (TextView) view.findViewById(R.id.typetext);
			view.setTag(holder);
		}else{
			holder =(TypeHolder) view.getTag();
		}
		
			holder.typeimg.setBackgroundResource(types.get(typeops).getTypeimg());
			holder.typetext.setText(types.get(typeops).getProjecttypename());
	
		return view;
	}
	public class TypeHolder{
		ImageView typeimg;
		TextView  typetext;
	}
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onGroupCollapsed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGroupExpanded(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}

}
