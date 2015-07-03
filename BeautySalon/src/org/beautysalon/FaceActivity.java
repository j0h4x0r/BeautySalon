package org.beautysalon;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class FaceActivity extends Activity {
	private ListView faceListView;		//���������б�
	private Connector con;	//����ͨ����
	private GetServiceInfo getServiceInfo;	//��������
	private ArrayList<HashMap<String, Object>> listItem;	//list����Դ

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_face);
		initialization();
		setListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_face, menu);
		return true;
	}
	
	
	
	private void initialization() {
		this.faceListView = (ListView)findViewById(R.id.face_listView);
		listItem = new ArrayList<HashMap<String,Object>>();
		con = new Connector();
		SendMessage sendMessage = new SendMessage(SendMessageConstant.GET_FACE_LIST);		//��÷����б�
		getServiceInfo = (GetServiceInfo)con.sendMessage(sendMessage);
		if (getServiceInfo.getServiceList() != null) {
			for (int i = 0; i < getServiceInfo.getServiceList().size(); i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();  
	            map.put("hair_title", getServiceInfo.getServiceIdList().get(i).toString());  
	            map.put("ItemText", getServiceInfo.getServiceList().get(i));  
	            listItem.add(map);  
			}
		}
		 //������������Item�Ͷ�̬�����Ӧ��Ԫ��  
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//����Դ   
            R.layout.listview,//ListItem��XMLʵ��  
            //��̬������ImageItem��Ӧ������          
            new String[] {"ItemTitle", "ItemText"},   
            //ImageItem��XML�ļ������һ��ImageView,����TextView ID  
            new int[] {R.id.hair_title, R.id.ItemText}  
        );  
         
        //��Ӳ�����ʾ  
        faceListView.setAdapter(listItemAdapter);  
	}
	
	/*
	 * ��ӿؼ��ļ���
	 */
	private void setListener() {
		faceListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();				//�������Ϳ�
				intent.setClass(FaceActivity.this,FaceDetailActivity.class);
				intent.putExtra("id", getServiceInfo.getServiceIdList().get(arg2).toString());
				startActivity(intent);
			}
			
		});
	}

}
