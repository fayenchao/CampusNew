package weichun.campus.news;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import weichun.campus.R;
import weichun.campus.activity.ActivityFrame;
import weichun.campus.controls.SlideMenuItem;
import weichun.campus.controls.SlideMenuView.OnSlideMenuListener;

public class ActivityNews extends ActivityFrame implements OnSlideMenuListener
{

	private ListView mListView;
	private List<NewsData> mList;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		appendMainBody(R.layout.layout_news);
		setTopBarTitle("西邮新闻");

		createSlideMenu(R.array.SlideMenuActivityNews);

		mListView = (ListView) findViewById(R.id.lvNewsList);
		mList = new ArrayList<NewsData>();
		initData();
		// 对象排序
		Collections.sort(mList, new Comparator<NewsData>()
		{
			@Override
			public int compare(NewsData lhs, NewsData rhs)
			{
				Date date1 = DataUtil.stringToDate(lhs.getNewsTime());
				Date date2 = DataUtil.stringToDate(rhs.getNewsTime());
				// 对日期字段进行升序，如果欲降序可采用after方法
				if (date1.before(date2))
				{
					return 1;
				}
				return -1;
			}
		});
		mListView.setAdapter(new AdapterNews(this, mList));

		mListView.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{

				ListView _listView = (ListView) parent;
				NewsData _Data = (NewsData) _listView
						.getItemAtPosition(position);

				Intent _Intent = new Intent();
				_Intent.putExtra("title", _Data.getnewsTitle());
				_Intent.putExtra("time", _Data.getNewsTime());
				_Intent.putExtra("text", _Data.getnewsText());
				_Intent.setClass(ActivityNews.this, ActivityNewsInfo.class);
				startActivity(_Intent);
			}
		});
	}

	@Override
	public void onSlideMenuItemClick(View pView, SlideMenuItem pSlideMenuItem)
	{
		slideMenuToggle();
		// TODO Auto-generated method stub
		if (pSlideMenuItem.getmItemID() == 0)
		{
			mListView.setAdapter(new AdapterNews(this, mList));
		}
	}

	private void initData()
	{
		String[] _NewsTime = getResources()
				.getStringArray(R.array.InitNewsTime);
		String[] _NewsName = getResources()
				.getStringArray(R.array.InitNewsName);
		String[] _NewsTitle = getResources().getStringArray(
				R.array.InitNewsTitel);
		String[] _NewsText = getResources().getStringArray(R.array.InitNewsTxt);
		for (int i = 0; i < 7; i++)
		{
			mList.add(new NewsData(_NewsTime[i], _NewsName[i], _NewsTitle[i],
					_NewsText[i]));
		}
	}

}
