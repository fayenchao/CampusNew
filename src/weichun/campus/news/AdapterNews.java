package weichun.campus.news;

import java.util.List;

import weichun.campus.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterNews extends BaseAdapter
{

	public AdapterNews(Context pContext, List<NewsData> pList)
	{
		mContext = pContext;
		mList = pList;
	}

	private Context mContext;
	private List<NewsData> mList;
	
	
	
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return mList != null ? mList.size() : 0;  
	}

	@Override
	public Object getItem(int arg0)
	{
		// TODO Auto-generated method stub
		return mList.get(arg0);
	}

	@Override
	public long getItemId(int arg0)
	{
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Holder _Holder;
		if (convertView == null)
		{
			convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_newslistitem, null);
			_Holder = new Holder();
			_Holder.newsName = (TextView) convertView.findViewById(R.id.tvNewsListItemName);
			_Holder.newsTime = (TextView) convertView.findViewById(R.id.tvNewsListItemTime);
			_Holder.newsTitle = (TextView) convertView.findViewById(R.id.tvNewsTitle);
			convertView.setTag(_Holder);
		}else {
			_Holder = (Holder) convertView.getTag();
		}
		_Holder.newsName.setText(mList.get(position).getNewsName());
		_Holder.newsTime.setText(mList.get(position).getNewsTime());
		_Holder.newsTitle.setText(mList.get(position).getnewsTitle());
		return convertView;
	}

	private class Holder {  
        private TextView newsTime;  
        private TextView newsName; 
        private TextView newsTitle;
    }
}
