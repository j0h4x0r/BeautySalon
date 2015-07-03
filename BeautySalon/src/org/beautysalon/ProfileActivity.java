package org.beautysalon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends Activity {
	private Connector con;	//传递数据
	private SendMessage sendMessage;
	private UserInfo userInfo;	//数据源
//	private String email;				//发型id
	
	private TextView userNameTextView;
	private TextView birthdayTextView;
	private TextView registTimeTextView;
	private TextView phoneNumTextView;
	private TextView addressTextView;
	private TextView staffTextView;		//会员对应的员工
	private Button recordButton;		//消费记录
	private Button editButton;			//修改资料
	
	private DatePicker birthdayDatePicker;	//修改生日
	private EditText phoneNumEditText;
	private EditText addressEditText;
	private Button saveButton;
	private Button cancelButton;

	private View profileLayout;
	private View editLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		initialization();
		setListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_profile, menu);
		return true;
	}
	
	
	private void initialization() {
		sendMessage = new SendMessage(SendMessageConstant.GET_PROFILE);
		sendMessage.setEmail(getIntent().getStringExtra("email"));
		con = new Connector();
		userInfo = (UserInfo)con.sendMessage(sendMessage);	
		
		this.userNameTextView = (TextView)findViewById(R.id.username);
		this.birthdayTextView = (TextView)findViewById(R.id.birthday);
		this.registTimeTextView = (TextView)findViewById(R.id.regist_time);
		this.phoneNumTextView = (TextView)findViewById(R.id.phonenum);
		this.addressTextView = (TextView)findViewById(R.id.address);
		this.staffTextView = (TextView)findViewById(R.id.staff);
		this.recordButton = (Button)findViewById(R.id.record_button);
		this.editButton = (Button)findViewById(R.id.edit_button);
		
		this.birthdayDatePicker = (DatePicker)findViewById(R.id.datePicker);
		this.phoneNumEditText = (EditText)findViewById(R.id.phone_edit);
		this.addressEditText = (EditText)findViewById(R.id.editText1);
		this.saveButton = (Button)findViewById(R.id.save_button);
		this.cancelButton = (Button)findViewById(R.id.cancel_button);
		
		/*
		 * 初始化用户信息列表
		 */
		this.userNameTextView.setText(userInfo.getUserName());
		this.birthdayTextView.setText(userInfo.getBirthday());
		this.registTimeTextView.setText(userInfo.getRegistTime());
		this.phoneNumTextView.setText(userInfo.getPhoneNum());
		this.addressTextView.setText(userInfo.getAddress());
		this.staffTextView.setText(userInfo.getStaff());
		
		this.profileLayout = (View)findViewById(R.id.profile_layout);
		this.editLayout = (View)findViewById(R.id.edit_layout);
		
	}
	
	/*
	 * 事件监听
	 */
	private void setListener() {
		
		/*
		 * 查询消费记录按钮
		 */
		this.recordButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ProfileActivity.this, ConsumeRecordActivity.class);
				intent.putExtra("id", userInfo.getUserId());
				startActivity(intent);
			}
		});
		
		
		/*
		 * 修改用户信息按钮
		 */
		this.editButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				profileLayout.setVisibility(View.GONE);
				editLayout.setVisibility(View.VISIBLE);
				String[] s = userInfo.getRegistTime().split("-", 3);
				birthdayDatePicker.init(Integer.parseInt(s[0]), Integer.parseInt(s[1]), 
						Integer.parseInt(s[2]), new DatePicker.OnDateChangedListener() {
					
					@Override
					public void onDateChanged(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						birthdayDatePicker.updateDate(year,  monthOfYear, dayOfMonth);						
					}
				});					
						
				phoneNumEditText.setText(userInfo.getPhoneNum());
				addressEditText.setText(userInfo.getAddress());			
			}
		});
		
		/*
		 * 保存修改用户信息按钮
		 */
		this.saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				userInfo.setAddress(ProfileActivity.this.addressEditText.getText().toString());
				addressTextView.setText(userInfo.getAddress());
				userInfo.setBirthday(birthdayDatePicker.getYear() + "-" + birthdayDatePicker.getMonth()
						+ "-" + birthdayDatePicker.getDayOfMonth());
				birthdayTextView.setText(userInfo.getBirthday());
				userInfo.setPhoneNum(phoneNumEditText.getText().toString());
				phoneNumTextView.setText(userInfo.getPhoneNum());
				
				sendMessage.setUserInfo(userInfo);
				sendMessage.setType(SendMessageConstant.UPDATE_USER_INFO);
				con.sendMessage(sendMessage);
				Toast toast = Toast.makeText(getApplicationContext(),
					     "修改已保存", Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
				editLayout.setVisibility(View.GONE);
				profileLayout.setVisibility(View.VISIBLE);
			}
		});
		
		this.cancelButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				profileLayout.setVisibility(View.VISIBLE);
				editLayout.setVisibility(View.GONE);
			}
		});
	}
}
