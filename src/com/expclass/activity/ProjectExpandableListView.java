package com.expclass.activity;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.expclass.R;
import com.expclass.adapter.ProjectAdapter;
import com.expclass.entity.Project;
import com.expclass.entity.ProjectType;

public class ProjectExpandableListView extends Activity{
	private ExpandableListView expandablelist = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_peopleproject);
		expandablelist = (ExpandableListView) findViewById(R.id.grouplist);
		LinkedList<ProjectType> types = new LinkedList<ProjectType>();
		types.add(new ProjectType(0, "移动应用项目", R.drawable.ic_launcher));
		types.add(new ProjectType(1, "网站项目", R.drawable.ic_launcher));
		types.add(new ProjectType(2, "游戏项目", R.drawable.ic_launcher));
		
		LinkedList<Project> projectlist1 = new LinkedList<Project>();
		int[] proimgs = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		/*projectlist1.add(new Project(0, "项目1", "段鹏飞，白林林", "这是项目1", proimgs));
		projectlist1.add(new Project(1, "项目2", "段鹏飞，白林林", "这是项目2", proimgs));
		projectlist1.add(new Project(2, "项目3", "段鹏飞，白林林", "这是项目3", proimgs));
		
		LinkedList<Project> projectlist2 = new LinkedList<Project>();
		projectlist2.add(new Project(0, "项目1", "钟云昶，白林林", "这是项目1", proimgs));
		projectlist2.add(new Project(1, "项目2", "钟云昶，白林林", "这是项目2", proimgs));
		projectlist2.add(new Project(2, "项目3", "钟云昶，白林林", "这是项目3", proimgs));
		
		LinkedList<Project> projectlist3 = new LinkedList<Project>();
		projectlist3.add(new Project(0, "项目1", "钟云昶，彭雅丽", "这是项目1", proimgs));
		projectlist3.add(new Project(1, "项目2", "钟云昶，彭雅丽", "这是项目2", proimgs));
		
		List<LinkedList<Project>> projects = new LinkedList<LinkedList<Project>>();
		projects.add(projectlist1);
		projects.add(projectlist2);
		projects.add(projectlist3);*/

		//ProjectAdapter adapter = new ProjectAdapter(ProjectExpandableListView.this, projects, types);
		//expandablelist.setAdapter(adapter);
		
		
		
	/*	View view = adapter.getChildView(0, 0, false, null, null);
		view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(ProjectActivity.this,ProjectItemActivity.class);
				startActivity(intent);
			}
		});*/
	}
}
