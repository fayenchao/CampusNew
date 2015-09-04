package weichun.campus.adapter;

import java.util.List;
import weichun.campus.R;
import weichun.campus.controls.SlideMenuItem;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdapterSlideMenu extends AdapterBase
{

	private class Holder
	{
		TextView tvMenuName;
	}
	
	public AdapterSlideMenu(Context pContext, List pList)
	{
		super(pContext, pList);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Holder _Holder;
		if (convertView == null)
		{
			convertView = getLayoutInflater().inflate(R.layout.slidemnu_list_item, null);
			
			_Holder = new Holder();
			_Holder.tvMenuName = (TextView) convertView.findViewById(R.id.tvMenuName);
		
			convertView.setTag(_Holder);
		}else {
			_Holder = (Holder) convertView.getTag();
		}
		SlideMenuItem _Item = (SlideMenuItem) getList().get(position);
		_Holder.tvMenuName.setText(_Item.getmTitle());
		return convertView;
	}
}
