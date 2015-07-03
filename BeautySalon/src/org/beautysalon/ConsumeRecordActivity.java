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
	private RecordInfo recordInfo;	//接受数据
	private ArrayList<HashMap<String, Object>> listItem;	//list数据源

	private int id;		//用户id
	
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
		 //生成适配器的Item和动态数组对应的元素  
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//数据源   
            R.layout.record_listview,//ListItem的XML实现  
            //动态数组与ImageItem对应的子项          
            new String[] {"record_time", "record_service_staff", "record_price", "record_sevice_info"},   
            //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
            new int[] {R.id.record_time, R.id.record_service_staff, R.id.record_price, R.id.record_sevice_info}  
        );  
         
        //添加并且显示  
        recordListView.setAdapter(listItemAdapter);  
	}
	
}
