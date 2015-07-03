package org.beautysalon;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class HairActivity extends Activity {
	private Connector con;	//数据通信类
	private GetServiceInfo getServiceInfo;	//接受数据
	private ListView hairListView;
	private ArrayList<HashMap<String, Object>> listItem;	//list数据源
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hair);
		hairListView = (ListView)findViewById(R.id.hair_listView);
		listViewInitialization();
		setListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_hair, menu);
		return true;
	}
	
	private void listViewInitialization() {
		listItem = new ArrayList<HashMap<String,Object>>();
		con = new Connector();
		SendMessage sendMessage = new SendMessage(SendMessageConstant.GET_HAIR_LIST);		//获得发型列表
		getServiceInfo = (GetServiceInfo)con.sendMessage(sendMessage);
		if (getServiceInfo.getServiceList() != null) {
			for (int i = 0; i < getServiceInfo.getServiceList().size(); i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();  
	            map.put("hair_title", getServiceInfo.getServiceIdList().get(i).toString());  
	            map.put("ItemText", getServiceInfo.getServiceList().get(i));  
	            listItem.add(map);  
			}
		}
		
		 //生成适配器的Item和动态数组对应的元素  
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//数据源   
            R.layout.listview,//ListItem的XML实现  
            //动态数组与ImageItem对应的子项          
            new String[] {"ItemTitle", "ItemText"},   
            //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
            new int[] {R.id.hair_title, R.id.ItemText}  
        );  
         
        //添加并且显示  
        hairListView.setAdapter(listItemAdapter);  
        
	}
	
	private void setListener() {
		hairListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();				//弹出发型框
				intent.setClass(HairActivity.this,HairDetailActivity.class);
				intent.putExtra("id", getServiceInfo.getServiceIdList().get(arg2).toString());
				startActivity(intent);
			}
			
		});
	}

}
