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
	private Connector con;	//��������
	private FaceInfo faceInfo;	//����Դ
	private int id;				//����id

	
	private TextView nameTextView;
	private TextView profileTextView;
	private TextView priceTextView;
	private TextView scoreTextView;				//ƽ������
	private RatingBar selfScoreRatingBar;		//�Լ����ֿؼ�
	
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
		this.nameTextView = (TextView)findViewById(R.id.face_name);	//��������
		this.priceTextView = (TextView)findViewById(R.id.price);	//�۸�
		this.profileTextView = (TextView)findViewById(R.id.profile_textView);	//���
		this.scoreTextView = (TextView)findViewById(R.id.rate);					//ƽ���÷�
		this.selfScoreRatingBar = (RatingBar)findViewById(R.id.ratingBar);		//��������
		
				
		Intent intent = getIntent();
		this.id = Integer.parseInt(intent.getStringExtra("id"));
		con = new Connector();
		SendMessage sendMessage = new SendMessage(SendMessageConstant.GET_FACE_DETAIL, id);
		this.faceInfo = (FaceInfo)con.sendMessage(sendMessage);		//�õ�����
		
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
					     "�����ύ�ɹ�", Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();

//				AlertDialog.Builder builder = new Builder(FaceDetailActivity.this);
//				builder.setMessage("�����ύ�ɹ�");
//				builder.setTitle("��ʾ");
//				builder.create().show();
			}
		});
	}
}

