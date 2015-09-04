package weichun.campus.xiyou;

import weichun.campus.R;
import weichun.campus.activity.ActivityFrame;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;

public class ActivityXiyou extends ActivityFrame implements
		OnPageChangeListener
{
	private ViewPager mViewPager;
	//装点点的ImageView数组 
    private ImageView[] tips;        
    //  装ImageView数组 
    private ImageView[] mImageViews;  
    //图片资源id  
    private int[] imgIdArray ;
    
    private TextView mXiyouTitle;
    private View mBarLayout;
    
    private TabHost mTabHost;
    
    private TextView mXiyouTextView01,mXiyouTextView02,mXiyouTextView03;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.xiyou_main);
		appendMainBody(R.layout.xiyou_main);
		
		String[] _XiyouText = getResources().getStringArray(R.array.InitXiyouText);
		 
		mXiyouTextView01 = (TextView) findViewById(R.id.textView1);
		mXiyouTextView01.setText(_XiyouText[0]);
		mXiyouTextView02 = (TextView) findViewById(R.id.textView2);
		mXiyouTextView02.setText(_XiyouText[1]);
		mXiyouTextView03 = (TextView) findViewById(R.id.textView3);
		mXiyouTextView03.setText(_XiyouText[2]);
		
		ViewGroup group = (ViewGroup)findViewById(R.id.viewGroup);  
	    mViewPager = (ViewPager) findViewById(R.id.xiyouViewPager);  
	    
	    mXiyouTitle = (TextView) findViewById(R.id.tvTitleBar);
	    mXiyouTitle.setText("西安邮电大学欢迎您！");
	    mXiyouTitle.setGravity(Gravity.CENTER_HORIZONTAL);
	    mXiyouTitle.setTextSize(20);
	    
	    mBarLayout = findViewById(R.id.IncludeBottom);
	    mBarLayout.setVisibility(View.GONE);
	    
	    mTabHost = (TabHost) findViewById(R.id.tabhost);
	    mTabHost.setup();
	    //TabWidget tabWidget = mTabHost.getTabWidget(); 
	    addTab();// 添加标签
	    updateTabStyle(mTabHost);
	    // 设置TabHost背景颜色
	   // mTabHost.setBackgroundColor(Color.argb(150, 20, 80, 150));
	    mTabHost.setCurrentTab(0);
	    mTabHost.setOnTabChangedListener(new OnTabChangeListener()
		{
			
			@Override
			public void onTabChanged(String tabId)
			{
				// TODO Auto-generated method stub
				
			}
		});
	    	    
	    //载入图片资源
	    imgIdArray = new int[]{
	    	R.drawable.xiyou2,
	    	R.drawable.xiyou3,
	    	R.drawable.xiyou4,
	    	R.drawable.xiyou5,
	    	R.drawable.xiyou6,
	    	R.drawable.xiyou7,
	    	R.drawable.xiyou8,
	    	R.drawable.xiyou9,
	    	R.drawable.xiyou10,
	    	R.drawable.xiyou11	    	
	    };
	    
	    //将点点加入到ViewGroup中  
        tips = new ImageView[imgIdArray.length];  
        for(int i=0; i<tips.length; i++){  
            ImageView imageView = new ImageView(this);  
            imageView.setLayoutParams(new LayoutParams(10,10));  
            tips[i] = imageView;  
            if(i == 0){  
                tips[i].setBackgroundResource(R.drawable.page_indicator_focused);  
            }else{  
                tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);  
            }  
              
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,    
                    LayoutParams.WRAP_CONTENT));  
            layoutParams.leftMargin = 5;  
            layoutParams.rightMargin = 5;  
            group.addView(imageView, layoutParams);  
        }  
        
        //将图片装载在数组
        mImageViews = new ImageView[imgIdArray.length];  
        for(int i=0; i<mImageViews.length; i++){  
            ImageView imageView = new ImageView(this);  
            mImageViews[i] = imageView;  
            imageView.setBackgroundResource(imgIdArray[i]);  
        } 
        
        //设置Adapter  
        mViewPager.setAdapter(new MyAdapter());  
        //设置监听，主要是设置点点的背景  
        mViewPager.setOnPageChangeListener(this);  
        //设置ViewPager的默认项, 设置为长度的100倍，这样子开始就能往左滑动  
        mViewPager.setCurrentItem((mImageViews.length) * 100);  
	}

	private void updateTabStyle(final TabHost pTabHost) {  
        TabWidget tabWidget = pTabHost.getTabWidget(); 
        tabWidget.setStripEnabled(true);
        tabWidget.setRightStripDrawable(R.drawable.xiyou_bottom_bar);  
        tabWidget.setLeftStripDrawable(R.drawable.xiyou_bottom_bar); 
 
        for (int i = 0; i < tabWidget.getChildCount(); i++) {  
            RelativeLayout tabView = (RelativeLayout) pTabHost.getTabWidget()  
                    .getChildAt(i);  
            TextView text = (TextView) tabWidget.getChildAt(i).findViewById(  
                    android.R.id.title);  
            text.setTextSize(17);  
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) text  
                    .getLayoutParams();  
            params.width = RelativeLayout.LayoutParams.MATCH_PARENT;  
            params.height = RelativeLayout.LayoutParams.MATCH_PARENT;  
            text.setLayoutParams(params);   
            text.setGravity(Gravity.CENTER);  
 
             tabView.setBackgroundColor(Color.parseColor("#8DB6CD"));  
                text.setTextColor(this.getResources().getColorStateList(  
                        android.R.color.white));             
        }  
    }  
	
	
	 //为TabHost添加标签 新建一个newTabSped(new TabSpec) 设置其标签和图标（setIndicator）、设置内容(setContent)
	 // TabSpec是TabHost的内部类 TabHost对象的 newTabSpec()方法返回一个TabSpec对象
	 // 源码里边是这么写的 public TabSpec newTabSpec(String tag)
	 // { return new TabSpec(tag); }
	 private void addTab() {
	 mTabHost.addTab(mTabHost
	  .newTabSpec("tab1")
	  .setIndicator("西邮简介")// setIndicator()此方法用来设置标签和图表
	  .setContent(R.id.textView1));
	 // 指定内容为一个TextView --->public TabHost.TabSpec setContent(int viewId) 此方法需要一个 viewId 作为参数
	 mTabHost.addTab(mTabHost
	  .newTabSpec("tab2")
	  .setIndicator("到达方式")
	  .setContent(R.id.textView2));

	 mTabHost.addTab(mTabHost
	  .newTabSpec("tab3")
	  .setIndicator("联系方式")
	  .setContent(R.id.textView3));
	 }
	 
	protected void appendMainBody(int pResID)
	{
		LinearLayout _MainBody = (LinearLayout)findViewById(R.id.layMainBody);
		
		View _View = LayoutInflater.from(this).inflate(pResID, null); 
		LinearLayout.LayoutParams _LayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		_MainBody.addView(_View, _LayoutParams);
	}
	
	public class MyAdapter extends PagerAdapter
	{

		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			// TODO Auto-generated method stub
			// super.destroyItem(container, position, object);
		}

		@Override
		public int getCount()
		{
			// TODO Auto-generated method stub
			return Integer.MAX_VALUE;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1)
		{
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		
		/** 
         * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键 
         */  
        @Override  
        public Object instantiateItem(View container, int position) {  
        	 try {    
                 ((ViewPager)container).addView(mImageViews[position % mImageViews.length], 0);  
             }catch(Exception e){  
                 //handler something  
             }  
             return mImageViews[position % mImageViews.length];   
        }  
	}
	
	@Override
	public void onPageScrollStateChanged(int arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0)
	{
		// TODO Auto-generated method stub
		setImageBackground(arg0 % mImageViews.length);  
	}

	
	/** 
     * 设置选中的tip的背景 
     * @param selectItems 
     */  
    private void setImageBackground(int selectItems){  
        for(int i=0; i<tips.length; i++){  
            if(i == selectItems){  
                tips[i].setBackgroundResource(R.drawable.page_indicator_focused);  
            }else{  
                tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);  
            }  
        }  
    }  
}
