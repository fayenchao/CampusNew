package weichun.campus.mycampus;

public class MycampusRoute
{
	public MycampusRoute(String mRouteName, String mRouteStart,
			String mRouteEnd, String mRouteContent)
	{
		super();
		this.mRouteName = mRouteName;
		this.mRouteStart = mRouteStart;
		this.mRouteEnd = mRouteEnd;
		this.mRouteContent = mRouteContent;
	}

	private String mRouteName;
	private String mRouteStart;
	private String mRouteEnd;
	private String mRouteContent;

	public String getmRouteName()
	{
		return mRouteName;
	}

	public void setmRouteName(String mRouteName)
	{
		this.mRouteName = mRouteName;
	}

	public String getmRouteStart()
	{
		return mRouteStart;
	}

	public void setmRouteStart(String mRouteStart)
	{
		this.mRouteStart = mRouteStart;
	}

	public String getmRouteEnd()
	{
		return mRouteEnd;
	}

	public void setmRouteEnd(String mRouteEnd)
	{
		this.mRouteEnd = mRouteEnd;
	}

	public String getmRouteContent()
	{
		return mRouteContent;
	}

	public void setmRouteContent(String mRouteContent)
	{
		this.mRouteContent = mRouteContent;
	}
}
