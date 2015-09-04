package weichun.campus.mycampus;


public class MycampusPlay
{
	public MycampusPlay(String mPlayName, String mPlayAddress,
		 String mPlayContent)
	{
		super();
		this.mPlayName = mPlayName;
		this.mPlayAddress = mPlayAddress;
		this.mPlayContent = mPlayContent;
	}

	private String mPlayName;
	private String mPlayAddress;
	private String mPlayContent;

	public String getmPlayName()
	{
		return mPlayName;
	}

	public void setmPlayName(String mPlayName)
	{
		this.mPlayName = mPlayName;
	}

	public String getmPlayAddress()
	{
		return mPlayAddress;
	}

	public void setmPlayAddress(String mPlayAddress)
	{
		this.mPlayAddress = mPlayAddress;
	}

	public String getmPlayContent()
	{
		return mPlayContent;
	}

	public void setmPlayContent(String mPlayContent)
	{
		this.mPlayContent = mPlayContent;
	}
}
