package weichun.campus.activity;

import weichun.campus.R;
import weichun.campus.SysApplication;
import weichun.campus.db.DBHandler;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityPhoneAdd extends ActivityFrame
{
	private Button submit, reset;
	private EditText name, phone, type, keyword;
	private SQLiteDatabase db = ActivityPhone.myHelper.getReadableDatabase();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone_add_or_edit);
	    SysApplication.getInstance().addActivity(this);
	    
	    submit = (Button) findViewById(R.id.add_btn_ok);
	    reset = (Button) findViewById(R.id.add_btn_exit);
	    name = (EditText) findViewById(R.id.add_name);
	    phone = (EditText) findViewById(R.id.add_phones);
	    type = (EditText) findViewById(R.id.add_type);
	    keyword = (EditText) findViewById(R.id.add_keyword);
	    MyOnClickListener myOnClickListener = new MyOnClickListener();
	    submit.setOnClickListener(myOnClickListener);
	    reset.setOnClickListener(myOnClickListener);
	}

	private class MyOnClickListener implements OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			switch (v.getId())
			{
			case R.id.add_btn_ok:
				DBHandler dbHandler = new DBHandler();
				String sql = "insert into phone_tb values(null,?,?,?,?)";
				String keywordStr = keyword.getText().toString();
				if(keywordStr == null || "".equals(keywordStr))
				{
					keywordStr = name.getText().toString() + 
							phone.getText().toString();
				}
				dbHandler.insert(db,sql,new String[]{
						name.getText().toString(), phone.getText().toString(),
						type.getText().toString(), keywordStr});
				Toast.makeText(ActivityPhoneAdd.this, "号码添加成功", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(ActivityPhoneAdd.this, ActivityPhone.class);
				startActivity(intent);
				break;
			case R.id.add_btn_exit:
				name.setText("");
				phone.setText("");
				type.setText("");
				keyword.setText("");
				break;
			default:
				break;
			}
			
		}
		
	}
}











