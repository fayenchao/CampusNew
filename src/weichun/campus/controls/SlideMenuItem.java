package weichun.campus.controls;

/**
 * @author weichun
 * @version AccountBook 2014年4月5日
 * @time： 下午5:29:38   
 * @infor：封装一个实体类，用来简化代码  
 */
public class SlideMenuItem
{
	
	private int mItemID;
	private String mTitle;
	
	public SlideMenuItem(int pItemID, String pTitle)
	{
		mItemID = pItemID;
		mTitle = pTitle;
	}
	
	public int getmItemID()
	{
		return mItemID;
	}
	public void setmItemID(int mItemID)
	{
		this.mItemID = mItemID;
	}
	public String getmTitle()
	{
		return mTitle;
	}
	public void setmTitle(String mTitle)
	{
		this.mTitle = mTitle;
	}
}
