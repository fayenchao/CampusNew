package weichun.campus.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import weichun.campus.R;
import weichun.campus.adapter.AdapterLibrary;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Fragment1 extends Fragment
{

	private ListView mBookList;
	private EditText mBookQuery;
	private Button mBookBtn;
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
		View _parentView = inflater.inflate(R.layout.library_fragment1, container, false);
		
		mBookList = (ListView) _parentView.findViewById(R.id.lvBookList);
		mBookQuery = (EditText) _parentView.findViewById(R.id.edBookQuery);
		mBookBtn = (Button) _parentView.findViewById(R.id.btnBookQuery);
		mBookBtn.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				mBookQuery.setText("");
				//添加数据
				List<HashMap<String, String>> _BookList = new ArrayList<HashMap<String,String>>();
				
				String[] _LibraryName = getResources().getStringArray(R.array.InitLibraryName);
				String[] _LibraryPublish = getResources().getStringArray(R.array.InitLibraryPublic);
				String[] _LibraryAuthor = getResources().getStringArray(R.array.InitLibraryAutor);
				String[] _LibraryTime = getResources().getStringArray(R.array.InitLibraryTime);
				
				for (int i = 0; i < 7; i++)
				{		
					HashMap<String, String> _Data = new HashMap<String, String>();
					_Data.put("tvBookName", _LibraryName[i]);
					_Data.put("tvPublish", _LibraryPublish[i]);
					_Data.put("tvName", _LibraryAuthor[i]);
					_Data.put("tvTime", _LibraryTime[i]);
					_BookList.add(_Data);
				}
				/*//绑定数据
				adapter = new SimpleAdapter(getActivity(), _BookList, R.layout.library_list_item,
						new String[]{"tvBookName","tvPublish","tvName","tvTime"}
				       ,new int[]{R.id.tvBookName,R.id.tvPublish,R.id.tvName,R.id.tvTime,});
				
				mBookList.setAdapter(adapter);*/
				
				AdapterLibrary adapterLibrary = new AdapterLibrary(getActivity(), _BookList);
				mBookList.setAdapter(adapterLibrary);
				mBookList.setOnItemClickListener(new OnItemClickListener()
				{

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3)
					{
						new AlertDialog.Builder(getActivity())  	
						.setIcon(R.drawable.ic_launcher)
						.setTitle("图书借阅情况")			  
						.setMessage("已借出3本还剩5本")			  
						.setPositiveButton("确定", null)			  
						.show();					
					}
				});
			}
		});	
		
		return _parentView;
	}
	
}
