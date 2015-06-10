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

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.expclass.R;
import com.expclass.activity.StudentInfoActivity;
import com.expclass.entity.People;

public class PeopleAdapter extends BaseAdapter{
	private List<People> people = null;
	private Activity context = null;
	public PeopleAdapter(List<People> people,Activity context){
		this.context = context;
		this.people = people;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return people.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return people.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView( int position, View view, ViewGroup group) {

		ViewHolder holder = null;
		if(view==null){
			holder = new ViewHolder();
		view=LayoutInflater.from(context).inflate(R.layout.activity_peopleitem, null);
		holder.peopleImg=(NetworkImageView) view.findViewById(R.id.peopleImg);
		holder.peopleName =  (TextView) view.findViewById(R.id.peopleName);
		holder.peopleEmail =  (TextView) view.findViewById(R.id.peopleEmail);
		holder.peopleId =  (TextView) view.findViewById(R.id.peopleId);
		holder.peoplePhone =  (TextView) view.findViewById(R.id.peoplePhone);
		view.setTag(holder);
		}else{
			holder = (ViewHolder) view.getTag();
		}
		context.registerForContextMenu(view);
		 final People peo = people.get(position);
		//采用volley库来加载网络图片
		RequestQueue mQueu = Volley.newRequestQueue(context);
		ImageLoader imageLoader = new ImageLoader(mQueu, new BitmapCache());
		/*ImageListener listener = ImageLoader.getImageListener(holder.peopleImg, R.drawable.ic_launcher, R.drawable.ic_launcher);
		imageLoader.get(peo.getIcon(), listener);*/
		if(peo.getIcon()==null){
			holder.peopleImg.setImageResource(R.drawable.ic_launcher);
		}else{
		holder.peopleImg.setImageUrl(peo.getIcon(), imageLoader);
		}
		//holder.peopleImg.setImageResource(R.drawable.ic_launcher);
		 
		holder.peopleEmail.setText(peo.getEmail());
		holder.peopleId.setText(peo.getId());
		holder.peopleName.setText(peo.getName());
		holder.peoplePhone.setText(peo.getTel());
		view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				Intent intent = new Intent(context,StudentInfoActivity.class);
				intent.putExtra("studentitem", peo);
				//intent.putExtra("stu_id", peo.getId());
				context.startActivity(intent);
				
			}
		});
		return view;
	}
	
	public class ViewHolder{
		NetworkImageView peopleImg;
		TextView peopleName;
		TextView peopleId;
		TextView peopleEmail;
		TextView peoplePhone;
	}

}

