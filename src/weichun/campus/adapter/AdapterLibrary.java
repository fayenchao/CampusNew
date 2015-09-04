package weichun.campus.adapter;

import java.util.HashMap;
import java.util.List;
import weichun.campus.R;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AdapterLibrary extends BaseAdapter
{

	private Context mContext;
	private LayoutInflater mInflater;
	private List<HashMap<String, String>> mList;
	private class Holder
	{
		//ImageButton btnBookMoreInfo;
		TextView tvBookName;
		TextView tvPublish;
		TextView tvName;
		TextView tvTime;
	}
	
	public AdapterLibrary(Context pContext, List<HashMap<String, String>> pList)
	{
		mContext = pContext;
		mInflater = LayoutInflater.from(pContext);
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Holder _Holder;
		
		if (convertView == null)
		{
			convertView = mInflater.inflate(R.layout.library_list_item, null);
			_Holder = new Holder();
			//_Holder.btnBookMoreInfo = (ImageButton) convertView.findViewById(R.id.ibBookMore);
			_Holder.tvBookName = (TextView) convertView.findViewById(R.id.tvBookName);
			_Holder.tvPublish = (TextView) convertView.findViewById(R.id.tvPublish);
			_Holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
			_Holder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
			convertView.setTag(_Holder);
		}else {
			_Holder = (Holder) convertView.getTag();
		}
		//_Holder.btnBookMoreInfo.setBackgroundResource(R.drawable.btn_library_book);
		RelativeLayout.LayoutParams layoutParams=
	            new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
	           // _Holder.btnBookMoreInfo.setLayoutParams(layoutParams);
		_Holder.tvBookName.setText(mList.get(position).get("tvBookName"));
		_Holder.tvPublish.setText(mList.get(position).get("tvPublish"));
		_Holder.tvName.setText(mList.get(position).get("tvName"));
		_Holder.tvTime.setText(mList.get(position).get("tvTime"));
		
		/*_Holder.btnBookMoreInfo.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View arg0)
			{
			new AlertDialog.Builder(mContext)  	
			.setIcon(R.drawable.ic_launcher)
			.setTitle("图书借阅情况")			  
			.setMessage("已借出3本还剩5本")			  
			.setPositiveButton("确定", null)			  
			.show();
			}
		});*/
		return convertView;
	}

	

}
