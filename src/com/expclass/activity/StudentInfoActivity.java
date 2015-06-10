package com.expclass.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.expclass.R;
import com.expclass.adapter.StuProjectAdapter;
import com.expclass.entity.People;
import com.expclass.entity.Project;
import com.expclass.service.PeopleService;
import com.expclass.service.ProjectService;

public class StudentInfoActivity extends Activity {
	private TextView stuname;
	private TextView stuid;
	private TextView stuphone;
	private TextView stuemail;

	private ListView stu_pro_list;
	public People peo;
	public List<Project> projects = new ArrayList<Project>(); // 获取学生参与的项目
	public String stu_id = null;
	private Thread thread = null;
	private Handler handler = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_peopleinfo);
		stuname = (TextView) findViewById(R.id.stuname);
		stuid = (TextView) findViewById(R.id.stuid);
		stuphone = (TextView) findViewById(R.id.stuphone);
		stuemail = (TextView) findViewById(R.id.stuemail);

		stu_pro_list = (ListView) findViewById(R.id.stu_pro_list);

		Intent intent = this.getIntent();
		peo = (People) intent.getSerializableExtra("studentitem");
		stu_id = peo.getId();

		stuname.setText("姓名：" + peo.getName());
		stuid.setText("学号：" + peo.getId());
		stuphone.setText("联系方式:" + peo.getTel());
		stuemail.setText("邮箱:" + peo.getEmail());

		thread = new Thread(new Runnable() {
			Message msg = new Message();

			@Override
			public void run() {
				try {
					People student = PeopleService.getJSONPeopleItem(stu_id);
					String[] stuProjects = student.getProjects();
					if (stuProjects.length == 0) {
						msg.what = 0;
					}else{
					for (int i = 0; i < stuProjects.length; i++) {
						Project pro = ProjectService
								.getJSONProject(stuProjects[i]);
						projects.add(pro);

					}
					msg.what = 1;
					handler.sendMessage(msg);
					}
				} catch (Exception e) {
					msg.what = 0;
					handler.sendMessage(msg);
					e.printStackTrace();
				}
			}
		});

		handler = new Handler(new Handler.Callback() {

			@Override
			public boolean handleMessage(Message msg) {
				if (msg.what == 1) {
					StuProjectAdapter stuProjectAdapter = new StuProjectAdapter(
							projects, StudentInfoActivity.this);
					stu_pro_list.setAdapter(stuProjectAdapter);
				} else {
					Toast.makeText(StudentInfoActivity.this, "该用户暂未参与项目",
							Toast.LENGTH_LONG).show();
				}
				return true;
			}

		});
		thread.start();
		// peopleitem = new People(R.drawable.ic_launcher, "白林林", "12100001",
		// "bll@163.com", "15958040001");
		// stuname.setText("姓名："+peopleitem.getName());
		// stuid.setText("学号："+peopleitem.getStuID());
		// stuphone.setText("联系方式:"+peopleitem.getPhone());
		// stuemail.setText("邮箱:"+peopleitem.getEmail());

		// LinkedList<Project> stuprojectlist = new LinkedList<Project>();
		// stuprojectlist.add(new Project(0, "项目1", "钟云昶，白林林", "这是项目1",
		// proimgs));
		// stuprojectlist.add(new Project(1, "项目2", "钟云昶，白林林", "这是项目2",
		// proimgs));
		// stuprojectlist.add(new Project(2, "项目3", "钟云昶，白林林", "这是项目3",
		// proimgs));

	}
}
