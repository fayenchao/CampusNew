package weichun.campus.activity;

import java.lang.reflect.Field;
import weichun.campus.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.Toast;

/**
 * @author weichun
 * @version CampusNew 2014年4月15日
 * @time： 上午10:09:15   
 * @infor： 业务逻辑无关的封装
 */
public class ActivityBase extends Activity
{
	/**
	 * @param pMsg
	 * 封装用于显示Toast
	 */
	protected void showMsg(String pMsg)
	{
		Toast.makeText(this, pMsg, Toast.LENGTH_LONG).show();
	}
	
	protected void showMsg(int pResID)
	{
		Toast.makeText(this, pResID, Toast.LENGTH_LONG).show();
	}
	
	/**
	 * @param pClass
	 * 封装用于打开Activity
	 */
	protected void openActivity(Class<?> pClass)
	{
		Intent _Intent = new Intent();
		_Intent.setClass(this, pClass);
		startActivity(_Intent);
	}
	
	/**
	 * @return
	 * 封装用于得到LayoutInflater对象
	 */
	protected LayoutInflater getLayouttInflater()
	{
		LayoutInflater _LayoutInflater = LayoutInflater.from(this);
		return _LayoutInflater;
	}
	
	/**
	 * @param pDialog
	 * @param pIsClose
	 * 通过反射，修改私有变量mShowing的值，使得只有点击“确定”
	 * 按钮后，dialog对话框才能关闭
	 */
	protected void setAlertDialogIsClose(DialogInterface pDialog, boolean pIsClose)
	{
		try
		{
			Field _Field = pDialog.getClass().getSuperclass().getDeclaredField("mShowing");
			_Field.setAccessible(true);
			_Field.set(pDialog, pIsClose);
		} catch (Exception e)
		{			
			e.printStackTrace();
		}		
	}
	
	/**
	 * @param pResID
	 * @param pMessage
	 * @param pClickListener
	 * @return 用于封装显示警示对话框
	 */
	protected AlertDialog showAlertDialog(int pResID, String pMessage, DialogInterface.OnClickListener pClickListener)
	{
		String _Title = getResources().getString(pResID);
		return showAlertDialog(_Title, pMessage, pClickListener);
	}
	protected AlertDialog showAlertDialog(String pTitle, String pMessage, DialogInterface.OnClickListener pClickListener)
	{
		 return	new AlertDialog.Builder(this)
		 .setTitle(pTitle)
		 .setMessage(pMessage)
		 .setPositiveButton(R.string.ButtonTextYes, pClickListener)
		 .setNegativeButton(R.string.ButtonTextNo, null)
		 .show();
	}	
}
