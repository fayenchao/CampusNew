package weichun.campus.mycampus;

import java.util.ArrayList;
import java.util.List;
import weichun.campus.R;
import weichun.campus.news.ActivityNewsInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class MyFragment1 extends Fragment
{
	private ListView mActiveList;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		View _parentView = inflater.inflate(R.layout.mycampus_fragment1, container, false);

		mActiveList = (ListView) _parentView.findViewById(R.id.lvMycampusActive);
		//初始化数据
				final List<MycampusActive> mActiveData = new ArrayList<MycampusActive>();
				String[] _ActiveName = getResources().getStringArray(R.array.InitActiveName);
				String[] _ActiveAutor = getResources().getStringArray(R.array.InitActiveAuthor);
				String[] _ActiveTime = getResources().getStringArray(R.array.InitActiveTime);
				final String[] _ActiveContent = getResources().getStringArray(R.array.InitActiveContent);
				for (int i = 0; i < 7; i++)
				{
					MycampusActive _mActive = new MycampusActive(_ActiveName[i], _ActiveAutor[i],
							_ActiveTime[i], _ActiveContent[i]);
					mActiveData.add(_mActive);
				}
	    //新建适配器
			AdapterMycampus mycampusActive = new AdapterMycampus(mActiveData)
			{
				Holder _Holder;
				@Override
				public View getView(int position, View contentvView, ViewGroup arg2)
				{
					if (contentvView == null)
					{
						contentvView = LayoutInflater.from(getActivity()).inflate(R.layout.mycampus_active_item, null);
						_Holder = new Holder();
						_Holder.ActiveName = (TextView) contentvView.findViewById(R.id.tvMycampusName);
						_Holder.ActiveAutor = (TextView) contentvView.findViewById(R.id.tvMycampusMan);
						_Holder.ActiveTime = (TextView) contentvView.findViewById(R.id.tvMycampusTime);
						//_Holder.ActiveContent = (TextView) contentvView.findViewById(R.id.tvMycampusActiveContent);
						contentvView.setTag(_Holder);
					}
					else {
						_Holder = (Holder) contentvView.getTag();
					}
					_Holder.ActiveName.setText(mActiveData.get(position).getmActiveName());
					_Holder.ActiveAutor.setText(mActiveData.get(position).getmActiveMan());
					_Holder.ActiveTime.setText(mActiveData.get(position).getmActiveTime());
					//_Holder.ActiveContent.setText(mActiveData.get(position).getmActiveContent());
					return contentvView;
				}
			};

			mActiveList.setAdapter(mycampusActive);
			mActiveList.setOnItemClickListener(new OnItemClickListener()
			{

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3)
				{
					// TODO Auto-generated method stub
					ListView _listView = (ListView) arg0;
					MycampusActive _Data = (MycampusActive) _listView
							.getItemAtPosition(arg2);

					Intent _Intent = new Intent();
					_Intent.putExtra("title", _Data.getmActiveName());
					_Intent.putExtra("time", _Data.getmActiveTime());
					_Intent.putExtra("text", _ActiveContent[arg2]);
					_Intent.setClass(getActivity(), ActivityNewsInfo.class);
					startActivity(_Intent);
				}
			});
		return _parentView;
	}
	
	private class Holder
	{
		private TextView ActiveName;  
        private TextView ActiveAutor; 
        private TextView ActiveTime;

	}
	
}
