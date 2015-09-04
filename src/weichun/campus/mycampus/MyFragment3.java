package weichun.campus.mycampus;

import java.util.ArrayList;
import java.util.List;

import weichun.campus.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class MyFragment3 extends Fragment
{
	private ListView mRouteList;
	
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
		View _parentView = inflater.inflate(R.layout.mycampus_fragment3, container, false);

		mRouteList = (ListView) _parentView.findViewById(R.id.lvMycampusRoute);
		//初始化数据
		final List<MycampusRoute> mRouteData = new ArrayList<MycampusRoute>();
		String[] _RouteName = getResources().getStringArray(R.array.InitRouteName);
		String[] _RouteStart = getResources().getStringArray(R.array.InitRouteStart);
		String[] _RouteEnd = getResources().getStringArray(R.array.InitRouteEnd);
		String[] _RouteContent = getResources().getStringArray(R.array.InitRouteContent);
		for (int i = 0; i < 7; i++)
		{
			MycampusRoute _mRoute = new MycampusRoute(_RouteName[i], _RouteStart[i],
					_RouteEnd[i], _RouteContent[i]);
			mRouteData.add(_mRoute);
		}
		//新建适配器
		AdapterMycampus mycampusRoute = new AdapterMycampus(mRouteData)
		{
			Holder _Holder;
			@Override
			public View getView(int position, View contentvView, ViewGroup arg2)
			{
				if (contentvView == null)
				{
					contentvView = LayoutInflater.from(getActivity()).inflate(R.layout.mycampus_route_item, null);
					_Holder = new Holder();
					_Holder.RouteName = (TextView) contentvView.findViewById(R.id.tvMycampusRouteName);
					_Holder.RouteStart = (TextView) contentvView.findViewById(R.id.tvMycampusRouteState);
					_Holder.RouteEnd = (TextView) contentvView.findViewById(R.id.tvMycampusRouteEnd);
					_Holder.RouteContent = (TextView) contentvView.findViewById(R.id.tvMycampusRouteContent);
					contentvView.setTag(_Holder);
				}
				else {
					_Holder = (Holder) contentvView.getTag();
				}
				_Holder.RouteName.setText(mRouteData.get(position).getmRouteName());
				_Holder.RouteStart.setText(mRouteData.get(position).getmRouteStart());
				_Holder.RouteEnd.setText(mRouteData.get(position).getmRouteEnd());
				_Holder.RouteContent.setText(mRouteData.get(position).getmRouteContent());
				return contentvView;
			}
		};

		mRouteList.setAdapter(mycampusRoute);
		return _parentView;
	}
	
	private class Holder
	{
		private TextView RouteName;  
        private TextView RouteStart; 
        private TextView RouteEnd;
        private TextView RouteContent;
	}
}
