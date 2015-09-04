package weichun.campus.news;

public class NewsData
{
	public NewsData(String newsTime, String newsName, String newsTitle, String newsText)
	{
		this.newsTime = newsTime;
		this.newsName = newsName;
		this.newsTitle = newsTitle;
		this.newsText = newsText;
	}
	private String newsTime;
	private String newsName;
	private String newsTitle;
	private String newsText;
	
	public String getNewsTime()
	{
		return newsTime;
	}
	public void setNewsTime(String newsTime)
	{
		this.newsTime = newsTime;
	}
	public String getNewsName()
	{
		return newsName;
	}
	public void setNewsName(String newsName)
	{
		this.newsName = newsName;
	}
	
	public String getnewsTitle()
	{
		return newsTitle;
	}
	public void setnewsTitle(String newsTitle)
	{
		this.newsTitle = newsTitle;
	}
	
	public String getnewsText()
	{
		return newsText;
	}
	public void setnewsText(String newsText)
	{
		this.newsText = newsText;
	}
	
	
}
