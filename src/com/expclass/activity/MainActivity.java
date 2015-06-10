package com.expclass.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.expclass.R;

public class MainActivity extends Activity {
	private ViewFlipper main_picflipper = null;
	private LinearLayout dotlayout = null;
	private ImageView img = null;
	private GestureDetectorCompat detector = null;
	private int curindex = 0;
	private int curall = 2;
	private ImageView[] imgdots = new ImageView[3];
	private int [] imgicons = {R.drawable.sy4,R.drawable.sy2,R.drawable.sy3};
	
	private TextView sybtext = null;
	private TextView sybpeotext = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_picflipper = (ViewFlipper) findViewById(R.id.main_picflipper);
        dotlayout=(LinearLayout) findViewById(R.id.dotLayout);
        innit();
        detector = new GestureDetectorCompat(MainActivity.this, new GestureDetector.OnGestureListener() {
			
			@Override
			public boolean onSingleTapUp(MotionEvent arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onShowPress(MotionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
					float arg3) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onLongPress(MotionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float speedx,
					float speedy) {
				//e1表示初始的位置，e2表示最终的位置 从右向左滑
				if((e1.getX()-e2.getX())>50&&Math.abs(speedx)>200){
					if(curindex<curall){
						curindex++;
						main_picflipper.stopFlipping();
						main_picflipper.showNext();
						dotchange();
					}
					return true;
				}
							// 从左向右滑
				if((e2.getX()-e1.getX())>50&&Math.abs(speedx)>200){
					if(curindex>0){
						curindex--;
						main_picflipper.stopFlipping();
						main_picflipper.showNext();
						dotchange();
					}
					return true;
				}
				
				return false;
			}
			
			@Override
			public boolean onDown(MotionEvent arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		});

        main_picflipper.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				return detector.onTouchEvent(event);
			}
		});
        main_picflipper.setLongClickable(true);
        dotchange();
        
        sybtext = (TextView) findViewById(R.id.sybtext);
        sybtext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, PeopleActivity.class);
				startActivity(intent);
			}
		});
        
        sybpeotext = (TextView) findViewById(R.id.sybpeotext);
        sybpeotext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, ProjectListActivity.class);
				startActivity(intent);
			}
		});
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /**
     * dotchange()方法 -- 圆点的改变
     */
    public void dotchange(){
    	for (int i = 0; i < imgdots.length; i++) {
			if(i == curindex){
				imgdots[i].setBackgroundResource(R.drawable.selected_dot);
			}else{
				imgdots[i].setBackgroundResource(R.drawable.round);
			}
		}
    }
    
    /**
     * innit()准备图片资源
     */
    public void innit(){
    	for (int i = 0; i < 3; i++) {
    		//将xml转成view对象操作
			View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_mainpic, null);
			img = (ImageView) view.findViewById(R.id.main_pic);
			img.setImageResource(imgicons[i]);  //设置图片资源
			
			main_picflipper.addView(view);
			ImageView imgdot = new ImageView(MainActivity.this);
			imgdot.setBackgroundResource(R.drawable.round);
			dotlayout.addView(imgdot);
			imgdots[i] = imgdot;
		}
    }
    
   
    
}
