package weichun.campus;

import weichun.campus.R;
import weichun.campus.activity.ActivityFrame;
import weichun.campus.activity.ActivityPhone;
import weichun.campus.adapter.AdapterAppGrid;
import weichun.campus.controls.SlideMenuItem;
import weichun.campus.controls.SlideMenuView.OnSlideMenuListener;
import weichun.campus.library.ActivityLibrary;
import weichun.campus.map.ActivityMap;
import weichun.campus.mycampus.ActivityMycampus;
import weichun.campus.news.ActivityNews;
import weichun.campus.xiyou.ActivityXiyou;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class ActivityMain extends ActivityFrame 
						implements OnSlideMenuListener
{

	private GridView gvAppGrid;
	private AdapterAppGrid mAdapterAppGrid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		hideTitleBackButton();
		appendMainBody(R.layout.main_body);
		
		title();
		initVariable();
		initView();
		initListeners();
		bindData();
		createSlideMenu(R.array.SlideMenuActivityMain);
	}
	
	//菜单项的点击事件
	@Override
	public void onSlideMenuItemClick(View pView, SlideMenuItem pSlideMenuItem)
	{
		if (pSlideMenuItem.getmItemID() < 4)
		{
			String msg = pSlideMenuItem.getmTitle();
			showMsg(msg);
		}
		
		if (pSlideMenuItem.getmItemID() == 4)
		{
			Dialog dialog = new AlertDialog.Builder(ActivityMain.this)
			.setTitle("退出西邮校园通")
			.setIcon(R.drawable.ic_launcher)
			.setMessage("您确定要退出？")
			.setPositiveButton("确定", 
					new DialogInterface.OnClickListener()
					{						
						@Override
						public void onClick(DialogInterface dialog, int whichButton)
						{
							SysApplication.getInstance().exit();							
						}
					})
					.setNeutralButton("取消",
							new DialogInterface.OnClickListener()
							{								
								@Override
								public void onClick(DialogInterface arg0, int arg1)
								{
																		
								}
							} ).create();
		
		dialog.show();
		}		
	}

	/**
	 * 初始化变量
	 */
	public void initVariable()
	{
		mAdapterAppGrid = new AdapterAppGrid(this);
	}
	
	/**
	 * 初始化控件
	 */
	public void initView()
	{
		gvAppGrid = (GridView)findViewById(R.id.gvAppGrid);
	}
	
	private void title()
	{
		Time mTime = new Time();
		mTime.setToNow();
		int year = mTime.year;  
		int month = mTime.month + 1;  
		int date = mTime.monthDay;  
		int hour = mTime.hour; // 0-23  
		
		if (hour >= 8 && hour < 10)
		{
			setTopBarTitle(year +"-"+ month +"-"+ date +"  第12周"+" 第一节");
		}else if (hour >= 10 && hour < 12) {
			setTopBarTitle(year +"-"+ month +"-"+ date +"  第12周"+" 第二节");
		}else if (hour >= 14 && hour < 16) {
			setTopBarTitle(year +"-"+ month +"-"+ date +"  第12周"+" 第三节");
		}else if (hour >= 16 && hour < 18) {
			setTopBarTitle(year +"-"+ month +"-"+ date +"  第12周"+" 第四节");
		}else {
			setTopBarTitle(year +"-"+ month +"-"+ date +"  第12周");
		}
		
	}
	/**
	 * 初始化监听
	 */
	public void initListeners()
	{
		gvAppGrid.setOnItemClickListener(new OnAppGridItemClickListener());
	}
	
	private class OnAppGridItemClickListener implements OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView<?> pAdapterView, View pView, int position,
				long arg3)
		{
			// TODO Auto-generated method stub
			String _MenuName = (String)pAdapterView.getAdapter().getItem(position);
			Log.i("weichun", _MenuName);
			if (_MenuName.equals(getString(R.string.appGridTextaCampus)))
			{
				openActivity(ActivityXiyou.class);
				return;
			}
			if (_MenuName.equals(getString(R.string.appGridTextMaps)))
			{
				openActivity(ActivityMap.class);
				return;
			}
			if (_MenuName.equals(getString(R.string.appGridTextNews)))
			{
				openActivity(ActivityNews.class);
				return;
			}
			if (_MenuName.equals(getString(R.string.appGridTextLibrary)))
			{
				openActivity(ActivityLibrary.class);
				return;
			}
			if (_MenuName.equals(getString(R.string.appGridTextLife)))
			{
				openActivity(ActivityMycampus.class);
				return;
			}			
			if (_MenuName.equals(getString(R.string.appGridTextPhone)))
			{
				openActivity(ActivityPhone.class);
				return;
			}
		}		
	}
	
	/**
	 * 初始化绑定数据
	 */
	public void bindData()
	{
		gvAppGrid.setAdapter(mAdapterAppGrid);
	}
	

}
