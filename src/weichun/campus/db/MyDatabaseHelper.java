package weichun.campus.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper
{

	final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS phone_tb" 
							+ "(_id INTEGER PRIMARY KEY AUTOINCREMENT,name,phone,type,keyword)";
	
	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version)
	{
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(CREATE_TABLE_SQL);
		init(db);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS phone_tb");
		onCreate(db);
		System.out.println("------"+oldVersion+"----->"+newVersion);		
	}

	private void init(SQLiteDatabase db)
	{
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'教务处','88160001','学校号码','教务处88160001')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'保卫处','88160002','学校号码','保卫处88160002')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'医务处','88160003','学校号码','医务处88160003')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'后勤处','88160004','学校号码','后勤处88160004')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'通工学院','88160011','学院号码','通工学院88160011')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'电工学院','88160012','学院号码','电工学院88160012')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'经管学院','88160013','学院号码','经管学院88160013')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'自动化学院','88160014','学院号码','自动化学院88160014')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'计算机学院','88160015','学院号码','计算机学院88160015')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'赵斌老师','18710530401','老师电话','赵斌18392101771')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'张文老师','18710530401','老师电话','张文老师18710530401')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'李华老师','18710530402','老师电话','李华老师18710530402')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'王强老师','18710530403','老师电话','王强老师18710530403')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'小石头','18710840401','同学号码','小石头18710840401')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'小胖','18710840402','同学号码','小胖18710840402')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'夏天','18710840403','同学号码','未未18710840403')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'糖醋鲤脊','18710530031','订餐热线','糖醋鲤脊18710530031')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'红烧茄子','18710840032','订餐热线','红烧茄子18710840032')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'家常豆腐','18710840033','订餐热线','家常豆腐18710840033')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'手撕鸭','18710840034','订餐热线','手撕鸭18710840034')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'小王','18727469504','常用号码','小王18727469504')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'小张','18797504732','常用号码','小张18797504732')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'小明','12485264848','常用号码','小明12485264848')");
		
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'招商银行','95555','银行服务','招商银行95555')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'中国银行','95566','银行服务','中国银行95566')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'建设银行','95533','银行服务','建设银行95533')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'工商银行','95588','银行服务','工商银行95588')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'中信银行','95558','银行服务','中信银行95558')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'农业银行','95599','银行服务','农业银行95599')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'民生银行','95568','银行服务','民生银行95568')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'光大银行','95595','银行服务','光大银行95595')");
		
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'匪警','110','特种服务','匪警110')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'火警','119','特种服务','火警119')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'急救中心','120','特种服务','急救中心120')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'交通事故','122','特种服务','交通事故122')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'公安短信报警','12110','特种服务','公安短信报警12110')");
		db.execSQL("INSERT INTO phone_tb VALUES(NULL,'水上求救专用','12395','特种服务','水上求救专用12395')");
	}

}



















