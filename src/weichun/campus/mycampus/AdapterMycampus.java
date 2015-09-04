package weichun.campus.mycampus;

import java.util.List;
import android.widget.BaseAdapter;

public abstract class AdapterMycampus extends BaseAdapter
{

	private List mList;
	public AdapterMycampus(List pList)
	{
		mList = pList;
	}
	
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return mList.size();
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
}
