package weichun.campus.adapter;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

public abstract class AdapterBase extends BaseAdapter
{
	private List mList;
	private Context mContext;
	private LayoutInflater mLayoutInflater;

	public AdapterBase(Context pContext, List pList)
	{
		mContext = pContext;
		mList = pList;
		mLayoutInflater = LayoutInflater.from(mContext);
	}
	
	/**
	 * @return 封装用于返回LayoutInflater对象
	 */
	public LayoutInflater getLayoutInflater()
	{
		return mLayoutInflater;
	}
	
	/**
	 * @return 封装用于返回context对象
	 */
	public Context getContext()
	{
		return mContext;
	}
	
	/**
	 * @return 封装用于返回List对象
	 */
	public List getList()
	{
		return mList;
	}
	
	public void setList(List pList)
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
