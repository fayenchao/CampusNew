package weichun.campus.mycampus;

public class MycampusActive
{
	public MycampusActive(String mActiveName, String mActiveTime,
			String mActiveMan, String mActiveContent)
	{
		super();
		this.mActiveName = mActiveName;
		this.mActiveTime = mActiveTime;
		this.mActiveMan = mActiveMan;
		this.mActiveContent = mActiveContent;
	}

	private String mActiveName;
	private String mActiveTime;
	private String mActiveMan;
	private String mActiveContent;

	public String getmActiveName()
	{
		return mActiveName;
	}

	public void setmActiveName(String mActiveName)
	{
		this.mActiveName = mActiveName;
	}

	public String getmActiveTime()
	{
		return mActiveTime;
	}

	public void setmActiveTime(String mActiveTime)
	{
		this.mActiveTime = mActiveTime;
	}

	public String getmActiveMan()
	{
		return mActiveMan;
	}

	public void setmActiveMan(String mActiveMan)
	{
		this.mActiveMan = mActiveMan;
	}

	public String getmActiveContent()
	{
		return mActiveContent;
	}

	public void setmActiveContent(String mActiveContent)
	{
		this.mActiveContent = mActiveContent;
	}
}
