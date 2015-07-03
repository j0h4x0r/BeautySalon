package org.beautysalon;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class FaceDetailActivity extends Activity {
	private Connector con;	//传递数据
	private FaceInfo faceInfo;	//数据源
	private int id;				//发型id

	
	private TextView nameTextView;
	private TextView profileTextView;
	private TextView priceTextView;
	private TextView scoreTextView;				//平均分数
	private RatingBar selfScoreRatingBar;		//自己评分控件
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_face_detail);
		initialization();
		setListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_face_detail, menu);
		return true;
	}
	
	private void initialization() {
		this.nameTextView = (TextView)findViewById(R.id.face_name);	//发型名称
		this.priceTextView = (TextView)findViewById(R.id.price);	//价格
		this.profileTextView = (TextView)findViewById(R.id.profile_textView);	//简介
		this.scoreTextView = (TextView)findViewById(R.id.rate);					//平均得分
		this.selfScoreRatingBar = (RatingBar)findViewById(R.id.ratingBar);		//自我评分
		
				
		Intent intent = getIntent();
		this.id = Integer.parseInt(intent.getStringExtra("id"));
		con = new Connector();
		SendMessage sendMessage = new SendMessage(SendMessageConstant.GET_FACE_DETAIL, id);
		this.faceInfo = (FaceInfo)con.sendMessage(sendMessage);		//得到数据
		
		this.nameTextView.setText(this.faceInfo.getName());
		this.priceTextView.setText(String.valueOf(this.faceInfo.getPrice()));
		this.profileTextView.setText(this.faceInfo.getFaceProfile());
		float score = this.faceInfo.getScore();
		String strSc = new DecimalFormat("#.00").format(score);
		this.scoreTextView.setText(strSc);	
		
	}

	
	private void setListener() {
		this.selfScoreRatingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
		
			@Override
			public void onRatingChanged(RatingBar arg0, float arg1, boolean arg2) {
				// TODO Auto-generated method stub
				SendMessage sendMessage1 = new SendMessage(SendMessageConstant.SEND_FACE_SELF_SCORE);
				sendMessage1.setId(FaceDetailActivity.this.id);
				sendMessage1.setScore(selfScoreRatingBar.getRating());
				con.sendMessage(sendMessage1);
				
				Toast toast = Toast.makeText(getApplicationContext(),
					     "评分提交成功", Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();

//				AlertDialog.Builder builder = new Builder(FaceDetailActivity.this);
//				builder.setMessage("评分提交成功");
//				builder.setTitle("提示");
//				builder.create().show();
			}
		});
	}
}

