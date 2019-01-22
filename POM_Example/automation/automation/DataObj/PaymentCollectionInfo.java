package eupchaar.ui.automation.DataObj;

public class PaymentCollectionInfo {
	
	private Boolean isWaiveOffRequired = false;
	private Boolean isNewCardRequired = false;
	private String waiveOffReason;
	private String authCode;
	
	
	public PaymentCollectionInfo(Boolean isWaiveOffRequired, String waiveOffReason, String authCode, Boolean isNewCardRequired)
	{
		this.isWaiveOffRequired = isWaiveOffRequired;
		this.waiveOffReason = waiveOffReason;
		this.isNewCardRequired = isNewCardRequired;
		this.authCode = authCode;
	}
	
	public Boolean getIsWaiveOffRequired()
	{
		return this.isWaiveOffRequired;
	}
	
	public Boolean getIsNewCardRequired()
	{
		return this.isNewCardRequired;
	}
	
	public String getWaiveOffReason()
	{
		return this.waiveOffReason;
	}
	
	public String getAuthCode()
	{
		return this.authCode;
	}
	
	
}
