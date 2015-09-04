package weichun.campus.library;

import weichun.campus.R;
import weichun.campus.SysApplication;
import weichun.campus.activity.ActivityLibraryBottom;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLibrary extends Activity
{
	private Button exitButton
	   , loginButton;
	private EditText nameText
		,passwordtText;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.library);
		
		SysApplication.getInstance().addActivity(this);
		
		nameText = (EditText) findViewById(R.id.etLibraryName);
		passwordtText = (EditText) findViewById(R.id.etLibraryPassword);
		
		MyOnClickListener myOnClickListener = new MyOnClickListener();
		exitButton = (Button) findViewById(R.id.btnExit);
		loginButton = (Button) findViewById(R.id.btnLogin);
		
		exitButton.setOnClickListener(myOnClickListener);
		loginButton.setOnClickListener(myOnClickListener);
		
		String name = nameText.getText().toString();
		String password = passwordtText.getText().toString();
		
	}
	
	public class MyOnClickListener implements OnClickListener
	{
		@Override
		public void onClick(View v)
		{
		switch (v.getId())
		{
		case R.id.btnExit:
			nameText.setText("");
			passwordtText.setText("");
			break;
			
		case R.id.btnLogin:
			Intent intent = new Intent(ActivityLibrary.this, ActivityLibraryBottom.class);
			startActivity(intent);
			break;
			
		default:
			break;
		}
		}		
	}	
}
