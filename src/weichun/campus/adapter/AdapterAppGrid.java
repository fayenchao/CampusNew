package weichun.campus.adapter;

import weichun.campus.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author weichun
 * @version CampusNew 2014年4月23日
 * @time： 下午8:03:31   
 * @infor：  自定义主界面GridView适配器
 */
public class AdapterAppGrid extends BaseAdapter
{
	private Context mContext;
	private class Holder
	{
		ImageView ivIcon;
		TextView tvName;
	}
	
	//主界面的数据
	private Integer[] mImageInteger = 
		{
			R.drawable.main_campus,
			R.drawable.main_news,
			R.drawable.main_maps,
			R.drawable.main_library,
			R.drawable.main_life,			
			R.drawable.main_phone
		};
	
	// 主界面对应数据的文字
	private String[] mImageString = new String[6];
	
	public AdapterAppGrid(Context pContext)
	{
		mContext = pContext;
		mImageString[0] = pContext.getString(R.string.appGridTextaCampus);
		mImageString[1] = pContext.getString(R.string.appGridTextNews);
		mImageString[2] = pContext.getString(R.string.appGridTextMaps);
		mImageString[3] = pContext.getString(R.string.appGridTextLibrary);
		mImageString[4] = pContext.getString(R.string.appGridTextLife);		
		mImageString[5] = pContext.getString(R.string.appGridTextPhone);
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return mImageString.length;
	}

	@Override
	public Object getItem(int arg0)
	{
		// TODO Auto-generated method stub
		return mImageString[arg0];
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
		// TODO Auto-generated method stub
		Holder _Holder;
		if (convertView == null)
		{
			LayoutInflater _LayoutInflater = LayoutInflater.from(mContext);
			convertView = _LayoutInflater.inflate(R.layout.main_body_item, null);
			
			_Holder = new Holder();
			_Holder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
			_Holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
			
			convertView.setTag(_Holder);
		}else {
			_Holder = (Holder) convertView.getTag();
		}
		_Holder.ivIcon.setImageResource(mImageInteger[position]);
		_Holder.tvName.setText(mImageString[position]);
		return convertView;
	}

}
