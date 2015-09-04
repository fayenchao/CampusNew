package weichun.campus.mycampus;

import java.util.ArrayList;
import java.util.List;
import weichun.campus.R;
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

public class MyFragment2 extends Fragment
{
	private ListView mPlayList;
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
		View _parentView = inflater.inflate(R.layout.mycampus_fragment2, container, false);
		final int[] imgData = {R.drawable.play01,
				R.drawable.play02,
				R.drawable.play03,
				R.drawable.play04,
				R.drawable.play05,
				R.drawable.play06,
				R.drawable.play07};
		mPlayList = (ListView) _parentView.findViewById(R.id.lvMycampusPlay);
		//初始化数据
				final List<MycampusPlay> mPlayData = new ArrayList<MycampusPlay>();
				String[] _PlayName = getResources().getStringArray(R.array.InitPlayName);
				String[] _PlayAddress = getResources().getStringArray(R.array.InitPlayAddress);
				final String[] _PlayContent = getResources().getStringArray(R.array.InitPlayContent);
				for (int i = 0; i < 7; i++)
				{
					MycampusPlay _mPlay = new MycampusPlay(_PlayName[i], _PlayAddress[i],
							 _PlayContent[i]);
					mPlayData.add(_mPlay);
				}
	    //新建适配器
				AdapterMycampus mycampusPlay = new AdapterMycampus(mPlayData)
				{				
					Holder _Holder;
					@Override
					public View getView(int position, View contentvView, ViewGroup arg2)
					{
						if (contentvView == null)
						{
							contentvView = LayoutInflater.from(getActivity()).inflate(R.layout.mycampus_play_item, null);
							_Holder = new Holder();
							_Holder.PlayName = (TextView) contentvView.findViewById(R.id.tvMycampusPlayTitle);
							_Holder.PlayAddress = (TextView) contentvView.findViewById(R.id.tvMycampusPlayTime);
							contentvView.setTag(_Holder);
						}
						else {
							_Holder = (Holder) contentvView.getTag();
						}
						_Holder.PlayName.setText(mPlayData.get(position).getmPlayName());
						_Holder.PlayAddress.setText(mPlayData.get(position).getmPlayAddress());
						return contentvView;
					}
				};
				mPlayList.setAdapter(mycampusPlay);
				mPlayList.setOnItemClickListener(new OnItemClickListener()
				{

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3)
					{
						// TODO Auto-generated method stub
						ListView _listView = (ListView) arg0;
						MycampusPlay _Data = (MycampusPlay) _listView
								.getItemAtPosition(arg2);

						Intent _Intent = new Intent();
						_Intent.putExtra("title", _Data.getmPlayName());
						_Intent.putExtra("txt", _Data.getmPlayContent());
						_Intent.putExtra("address", _Data.getmPlayAddress());
						_Intent.putExtra("image", imgData[arg2]);
						_Intent.setClass(getActivity(), ActivityPlayInfo.class);
						startActivity(_Intent);
					}
				});
		return _parentView;
	}
	private class Holder
	{
		private TextView PlayName;  
        private TextView PlayAddress; 

	}
}
