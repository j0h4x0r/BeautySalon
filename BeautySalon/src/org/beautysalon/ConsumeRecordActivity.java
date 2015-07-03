package org.beautysalon;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ConsumeRecordActivity extends Activity {
	private Connector con;
	private SendMessage sendMessage;
	private RecordInfo recordInfo;	//��������
	private ArrayList<HashMap<String, Object>> listItem;	//list����Դ

	private int id;		//�û�id
	
	private ListView recordListView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consume_record);
		initialization();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_face, menu);
		return true;
	}
	
	private void initialization() {
		listItem = new ArrayList<HashMap<String,Object>>();
		this.recordListView = (ListView)findViewById(R.id.record_listView);
		this.id = getIntent().getIntExtra("id", 0);
		sendMessage = new SendMessage(SendMessageConstant.GET_RECORD, this.id);
		con = new Connector();
		recordInfo = (RecordInfo)con.sendMessage(sendMessage);
		
		if (recordInfo.getRecordPriceAlList() != null) {
			for (int i = 0; i < recordInfo.getRecordPriceAlList().size(); i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();  
				 map.put("record_time", recordInfo.getRecordTimeAList().get(i));  
				 map.put("record_service_staff", recordInfo.getRecordStaffAList().get(i));  
				 map.put("record_price", recordInfo.getRecordPriceAlList().get(i).toString());  
				 map.put("record_sevice_info", recordInfo.getRecordServiceAlList().get(i));  
		         listItem.add(map);  
			}
		}
		 //������������Item�Ͷ�̬�����Ӧ��Ԫ��  
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//����Դ   
            R.layout.record_listview,//ListItem��XMLʵ��  
            //��̬������ImageItem��Ӧ������          
            new String[] {"record_time", "record_service_staff", "record_price", "record_sevice_info"},   
            //ImageItem��XML�ļ������һ��ImageView,����TextView ID  
            new int[] {R.id.record_time, R.id.record_service_staff, R.id.record_price, R.id.record_sevice_info}  
        );  
         
        //��Ӳ�����ʾ  
        recordListView.setAdapter(listItemAdapter);  
	}
	
}
