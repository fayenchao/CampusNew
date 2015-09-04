package weichun.campus.news;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import weichun.campus.R;
import weichun.campus.activity.ActivityFrame;

public class ActivityNewsInfo extends ActivityFrame
{
	
	private TextView mNewsTitle,mNewsTime,mNewsTxt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		appendMainBody(R.layout.layout_new_info);
		setTopBarTitle("西邮新闻");
		
		mNewsTime = (TextView) findViewById(R.id.tvNewsTimeInfo);
		mNewsTitle = (TextView) findViewById(R.id.tvNewsTitleInfo);
		mNewsTxt = (TextView) findViewById(R.id.tvNewsTxtInfo);
		
		Intent _Intent = getIntent();
		
		mNewsTime.setText(_Intent.getStringExtra("time"));
		mNewsTitle.setText(_Intent.getStringExtra("title"));
		mNewsTxt.setText(_Intent.getStringExtra("text"));
	}

}
