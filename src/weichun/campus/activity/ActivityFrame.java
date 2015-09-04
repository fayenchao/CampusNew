package weichun.campus.activity;

import weichun.campus.R;
import weichun.campus.controls.SlideMenuItem;
import weichun.campus.controls.SlideMenuView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityFrame extends ActivityBase
{
	private SlideMenuView mSlideMenuView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//取消标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		View _View = findViewById(R.id.btAppBack);
		OnBackListener _OnBackListener = new OnBackListener();
		_View.setOnClickListener(_OnBackListener);
	}
	
	private class OnBackListener implements android.view.View.OnClickListener
	{
		public void onClick(View view)
		{
			finish();
		}
	}
	
	/**
	 * 封装通过控件ID，将控件添加到主界面的中间位置
	 * @param pResID
	 */
	protected void appendMainBody(int pResID)
	{
		LinearLayout _MainBody = (LinearLayout)findViewById(R.id.layMainBody);
		
		View _View = LayoutInflater.from(this).inflate(pResID, null); 
		LinearLayout.LayoutParams _LayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		_MainBody.addView(_View, _LayoutParams);
	}
	
	/**
	 * 封装通过View，将控件添加到主界面的中间位置
	 * @param pResID
	 */
	protected void appendMainBody(View pView)
	{
		LinearLayout _MainBody = (LinearLayout) findViewById(getMainBodyLayoutID());
		LinearLayout.LayoutParams _LayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		_MainBody.addView(pView, _LayoutParams);
	}	
	private int getMainBodyLayoutID()
	{
		return R.id.layMainBody;
	}
	
	/**
	 * @param pTitle
	 * 设置TopBar标题
	 */
	protected void setTopBarTitle(String pTitle)
	{
		TextView _TextView = (TextView) findViewById(R.id.tvTitleBar);
		_TextView.setText(pTitle);
	}
	
	/**
	 * 隐藏返回按钮
	 */
	protected void hideTitleBackButton()
	{
		findViewById(R.id.btAppBack).setVisibility(View.GONE);
	}
	
	/**
	 * 封装实现SlideMenu菜单的出现
	 */
	protected void createSlideMenu(int pResID)
	{
		mSlideMenuView = new SlideMenuView(this);
		String[] _MenuItemArray = getResources().getStringArray(pResID);
		
		for (int i = 0; i < _MenuItemArray.length; i++)
		{
			SlideMenuItem _Item = new SlideMenuItem(i, _MenuItemArray[i]);
			mSlideMenuView.add(_Item);
			
			mSlideMenuView.bindList();
		}
	}
	
	/**
	 * 用于打开合并菜单
	 */
	protected void slideMenuToggle() {
		mSlideMenuView.toggle();
	}
}
