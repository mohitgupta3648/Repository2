package eupchaar.ui.automation.utils;

import eupchaar.ui.automation.Enums.LocatorType;

public class Locator {
	
	private String value;
	private String type;
	private String desc;
	
	public Locator(String value, LocatorType lType, String description)
	{
		this.value = value;
		this.type = lType.toString();
		this.desc = description;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String getDescription()
	{
		return this.desc;
	}

}
