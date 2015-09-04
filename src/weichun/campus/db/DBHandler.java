package weichun.campus.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBHandler
{
	public ArrayList<String> getType(SQLiteDatabase db, String sql)
	{
		ArrayList<String> type = new ArrayList<String>();
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor != null)
			if(cursor.moveToFirst())
			{
				do {
					type.add(cursor.getString(0));
				} while(cursor.moveToNext());
			}
		cursor.close();
		return type;
	}
	
	public ArrayList<Map<String, String>> getData(SQLiteDatabase db,String sql, String[] str)
	{
		ArrayList<Map<String, String>> children = new ArrayList<Map<String,String>>();
		Cursor cursor = db.rawQuery(sql, str);
		if (cursor != null)
			if(cursor.moveToFirst())
			{
				do {
					Map<String, String> item = new HashMap<String, String>();
					item.put("name", cursor.getString(0));
					item.put("phone", cursor.getString(1));
					children.add(item);
				} while(cursor.moveToNext());
			}
		cursor.close();
		return children;
	}
	
	public void insert(SQLiteDatabase db, String sql, String[] str)
	{
		db.execSQL(sql, str);
	}
}






















