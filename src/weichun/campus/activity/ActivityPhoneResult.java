package weichun.campus.activity;

import java.util.ArrayList;
import java.util.Map;

import weichun.campus.R;
import weichun.campus.SysApplication;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ActivityPhoneResult extends ActivityFrame
{

	private ListView resultList;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone_result);
		
		SysApplication.getInstance().addActivity(this);
		
		resultList = (ListView) findViewById(R.id.lvPhoneResult);
		Bundle bundle = getIntent().getExtras();
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, String>> phoneList = (ArrayList<Map<String,String>>) bundle
				.getSerializable("result");
		SimpleAdapter adapter = new SimpleAdapter(this, phoneList, 
				R.layout.phone_child_item, new String[]{"name", "phone"}, new int[]
						{R.id.tvPhoneName, R.id.tvPhonePhones});
		resultList.setAdapter(adapter);
	}
	
}
