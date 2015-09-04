package weichun.campus.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import weichun.campus.R;
import weichun.campus.SysApplication;
import weichun.campus.controls.SlideMenuItem;
import weichun.campus.controls.SlideMenuView.OnSlideMenuListener;
import weichun.campus.db.DBHandler;
import weichun.campus.db.MyDatabaseHelper;

public class ActivityPhone extends ActivityFrame implements OnSlideMenuListener
{
	
	private ExpandableListView elvPhoneList;
	public static MyDatabaseHelper myHelper;
	DBHandler dbHandler;
	SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);	
		appendMainBody(R.layout.phone);		
		SysApplication.getInstance().addActivity(this);
		
		InitVariable();
		InitView();
		BindData();
		createSlideMenu(R.array.SlideMenuActivityPhone);
		
		
	}
	
	/**
	 * 初始化变量
	 */
	public void InitVariable()
	{		
		dbHandler = new DBHandler();
	}
	
	/**
	 * 初始化控件
	 */
	public void InitView()
	{
		elvPhoneList = (ExpandableListView) findViewById(R.id.ExpandableListViewPhone);
	}
	
	/**
	 * 初始化绑定数据
	 */
	public void BindData()
	{
		myHelper = new MyDatabaseHelper(this, "phone.db", null, 1);
		db = myHelper.getReadableDatabase();
		String sql = "select distinct type from phone_tb";//distinct具有相同类型，只取一个
		ArrayList<String> type = dbHandler.getType(db, sql);
		ArrayList<Map<String, String>> groups = new ArrayList<Map<String,String>>();
		ArrayList<List<Map<String, String>>> children = new ArrayList<List<Map<String,String>>>();
		for (String str : type)
		{
			Map<String, String> item = new HashMap<String, String>();
			item.put("group", str);
			groups.add(item);
			ArrayList<Map<String, String>> child = dbHandler.getData(db, 
					"select name,phone from phone_tb where type=?", new String[]{str});
			System.out.println(child);
			children.add(child);
		}
		
		SimpleExpandableListAdapter simpleExpandableListAdapter = new SimpleExpandableListAdapter(
				this, groups, R.layout.phone_group_item, new String[]{"group"},
				new int[]{R.id.tvPhoneGroup}, children, R.layout.phone_child_item,
				new String[]{"name", "phone"}, new int[]{R.id.tvPhoneName,
						R.id.tvPhonePhones});
				
		elvPhoneList.setAdapter(simpleExpandableListAdapter);
		SetTitle();
	}
	
	@Override
	public void onSlideMenuItemClick(View pView, SlideMenuItem pSlideMenuItem)
	{
		slideMenuToggle();
		// TODO Auto-generated method stub
		if (pSlideMenuItem.getmItemID() == 0)
		{
			openActivity(ActivityPhoneAdd.class);
		}else {
			openActivity(ActivityPhoneQuery.class);
		}
		
	}

	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if(keyCode == KeyEvent.KEYCODE_BACK)
		{
			//退出时，关闭数据库
			db.close();
			this.finish();
			return true; 
		}
		return super.onKeyDown(keyCode, event);
	}
	
	/**
	 * 设置显示的标题bar
	 */
	private void SetTitle() {
		String _Titel = getString(R.string.ActivityTitlePhone);
		setTopBarTitle(_Titel);
	}

}
