package com.expclass.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.expclass.R;
import com.expclass.adapter.PeopleAdapter;
import com.expclass.service.PeopleService;

public class PeopleActivity extends Activity {
	private ListView people = null;
	private Thread thread = null;
	private Handler handler = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_people);
		people = (ListView) findViewById(R.id.people);
		thread = new Thread(new Runnable() {
			Message msg = new Message();

			@Override
			public void run() {
				try {
					PeopleService.getJSONAllPeople_2();
				
					msg.what = 1;
					handler.sendMessage(msg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					msg.what = 0;
					handler.sendMessage(msg);
				}

			}
		});
		handler = new Handler(new Handler.Callback() {

			@Override
			public boolean handleMessage(Message msg) {
			     if(msg.what==1){
			    	 try {
			 			PeopleAdapter adapter = new PeopleAdapter(PeopleService.peoples, PeopleActivity.this);
			 			people.setAdapter(adapter);
			 			
			 		} catch (Exception e) {
			 			// TODO Auto-generated catch block
			 			Log.e("test", "crash");
			 			e.printStackTrace();
			 		} 
			     }else{
			    	 Toast.makeText(PeopleActivity.this, "read error", Toast.LENGTH_LONG).show();
			     }
				return true;
			}
		});
		thread.start();
		
		

	}

}
