package weichun.campus.mycampus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import weichun.campus.R;
import weichun.campus.activity.ActivityFrame;

public class ActivityPlayInfo extends ActivityFrame
{
	
	private TextView mPlayTitle,mPlayAddress,mPlayTxt;
	private ImageView  mImageView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		appendMainBody(R.layout.mycampus_play_info);
		setTopBarTitle("游玩西安");
		
		mImageView = (ImageView) findViewById(R.id.ivPlayInfo);
		
		mPlayAddress = (TextView) findViewById(R.id.tvPlayAddressInfo);
		mPlayTitle = (TextView) findViewById(R.id.tvPlayTitleInfo);
		mPlayTxt = (TextView) findViewById(R.id.tvPlayTxtInfo);
		
		Intent _Intent = getIntent();
		mImageView.setImageResource(_Intent.getIntExtra("image", -1));
		mPlayTitle.setText(_Intent.getStringExtra("title"));
		mPlayAddress.setText(_Intent.getStringExtra("address"));
		mPlayTxt.setText(_Intent.getStringExtra("txt"));
	}

}
