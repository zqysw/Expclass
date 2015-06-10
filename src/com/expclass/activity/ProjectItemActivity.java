package com.expclass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.expclass.R;
import com.expclass.entity.Project;

public class ProjectItemActivity extends FilpperImgActivity{
	private TextView projectname;
	private TextView projectworkers;
	private TextView projectdescription;

	public static String project_id = null;
	public String itemmembers = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_projectinfo);
		super.onCreate(savedInstanceState);
	
		projectname = (TextView) findViewById(R.id.projectname);
		projectworkers =(TextView) findViewById(R.id.projectworkers);
		projectdescription = (TextView) findViewById(R.id.projectdescription);
		
		int[] proimgs = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		Intent intent = this.getIntent();
		 Project one_project= (Project) intent.getSerializableExtra("one_project");
					projectname.setText(one_project.getName());
					projectdescription.setText("œÓƒøΩÈ…‹:"+one_project.getDetail());
					for (int  i = 0; i < one_project.getMembers().length; i++) {
						itemmembers+= one_project.getMembers()[i]+" ";
					}
					projectworkers.setText(itemmembers);
	}
}
