package com.oracle.oep.event ;

public class SalesEvent
{
  private String item;
  private Double price;
  private String userId;
  
  public String getItem()
  {
    return item;
  }
  
  public void setItem(String item)
  {
    this.item = item;
  }
  
  public Double getPrice()
  {
    return price;
  }
  
  public void setPrice(Double price)
  {
    this.price = price;
  }
  
  public String getUserId()
  {
    return userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }

  @Override
  public String toString() {
	return "SalesEvent [item=" + item + ", price=" + price + ", userId="
			+ userId + "]";
}
  
  
  
}
