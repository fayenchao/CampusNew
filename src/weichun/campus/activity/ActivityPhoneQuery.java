package weichun.campus.activity;

import java.util.ArrayList;
import java.util.Map;

import weichun.campus.R;
import weichun.campus.db.DBHandler;
import weichun.campus.db.MyDatabaseHelper;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityPhoneQuery extends Activity
{

	private EditText keyword;
	private Button btn_query;
	DBHandler dbHandler = new DBHandler();
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone_query);
		init();
	}

	private void init()
	{
				
		db = new MyDatabaseHelper(this, "phone.db", null, 1).getReadableDatabase();
		
		keyword = (EditText) findViewById(R.id.edKeyWord);
		btn_query = (Button) findViewById(R.id.btnQuery);
		btn_query.setOnClickListener(new OnClickListener()
		{
			String sql = "select name,phone from phone_tb where keyword like ?";
			@Override
			public void onClick(View v)
			{
				ArrayList<Map<String, String>> phoneList = dbHandler.getData(db, sql,
						new String[]{"%" + keyword.getText().toString() + "%"});
				Intent intent = new Intent(ActivityPhoneQuery.this, ActivityPhoneResult.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("result", phoneList);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
}
