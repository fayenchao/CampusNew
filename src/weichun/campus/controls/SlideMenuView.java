package weichun.campus.controls;

import java.util.ArrayList;
import java.util.List;
import weichun.campus.R;
import weichun.campus.adapter.AdapterSlideMenu;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class SlideMenuView
{
	private Activity mActivity;
	private List mList;
	private boolean mIsClosed;
	private RelativeLayout layBottomBar;
	private OnSlideMenuListener mOnSlideMenuListener;
		
	public interface OnSlideMenuListener
	{
		public abstract void onSlideMenuItemClick(View pView, SlideMenuItem pSlideMenuItem);
	}
	
	public SlideMenuView(Activity pActivity)
	{
		mActivity = pActivity;
		
		initView();
		if (pActivity instanceof OnSlideMenuListener)
		{
			mOnSlideMenuListener = (OnSlideMenuListener) pActivity;
		}
		
		initVariable();
		initListeners();
	}
	
	public void initView()
	{
		mList = new ArrayList();
		mIsClosed = true;
	}
	
	public void initVariable()
	{
		layBottomBar = (RelativeLayout) mActivity.findViewById(R.id.IncludeBottom);
	}
	
	public void initListeners()
	{
		layBottomBar.setOnClickListener(new OnSlideMenuClick());
		
		layBottomBar.setFocusableInTouchMode(true);
		layBottomBar.setOnKeyListener(new OnKeyListener()
		{			
			@Override
			public boolean onKey(View arg0, int arg1, KeyEvent arg2)
			{
				if (arg1 == KeyEvent.KEYCODE_MENU && arg2.getAction() == KeyEvent.ACTION_UP)
				{
					toggle();
				}
				return false;
			}
		});
	}
	
	/**
	 * 打开底部菜单向上
	 */
	private void open()
	{
		RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		_LayoutParams.addRule(RelativeLayout.BELOW, R.id.IncludeTitle);
		
		layBottomBar.setLayoutParams(_LayoutParams);
		mIsClosed = false;
	}
	
	private void close()
	{
		RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				60);
		_LayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		
		layBottomBar.setLayoutParams(_LayoutParams);
		mIsClosed = true;
	}
	
	/**
	 * 控制底部上下的开关方法
	 */
	public void toggle()
	{
		if (mIsClosed)
		{
			open();
		}else {
			close();
		}
	}
	
	//菜单点击事件
	private class OnSlideMenuClick implements OnClickListener
	{
		@Override
		public void onClick(View arg0)
		{
			toggle();
		}		
	}
	
	/**
	 * 给listview添加数据
	 */
	public void add(SlideMenuItem pSlideMenuItem)
	{
		mList.add(pSlideMenuItem);
	}
	
	public void bindList()
	{
		AdapterSlideMenu _AdapterSlideMenu = new AdapterSlideMenu(mActivity, mList);
		
		ListView _ListView = (ListView) mActivity.findViewById(R.id.lvSlidList);
		_ListView.setAdapter(_AdapterSlideMenu);
		
		_ListView.setOnItemClickListener(new OnSlideMenuItemClick());
	}
	
	//listview中项目点击事件
	private class OnSlideMenuItemClick implements OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView<?> pAdapterView, View pView, int position,
				long arg3)
		{
			SlideMenuItem _SlideMenuItem = (SlideMenuItem) pAdapterView.getItemAtPosition(position);
			mOnSlideMenuListener.onSlideMenuItemClick(pAdapterView, _SlideMenuItem);
		}		
	}
	
	public void removeBottomBox()
	{
		RelativeLayout _MainLayout = (RelativeLayout)mActivity.findViewById(R.id.layMainActivity);
		_MainLayout.removeView(layBottomBar);
		layBottomBar = null;
	}
}
