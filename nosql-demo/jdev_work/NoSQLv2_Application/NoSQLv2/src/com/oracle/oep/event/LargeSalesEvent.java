package com.oracle.oep.event ;

public class LargeSalesEvent
{
  private int creditScore;
  private String customerName;
  private Double price;
  private String item;
  private String address ;
  
  public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public Double getPrice()
  {
    return price;
  }

  public void setPrice(Double price)
  {
    this.price = price;
  }

  public String getItem()
  {
    return item;
  }

  public void setItem(String item)
  {
    this.item = item;
  }

  public int getCreditScore()
  {
    return creditScore;
  }
  
  public void setCreditScore(int creditScore)
  {
    this.creditScore = creditScore;
  }
  
  public String getCustomerName()
  {
    return customerName;
  }
  
  public void setCustomerName(String customerName)
  {
    this.customerName = customerName;
  }

@Override
public String toString() {
	return "LargeSalesEvent [creditScore=" + creditScore + ", customerName="
			+ customerName + ", price=" + price + ", item=" + item
			+ ", address=" + address + "]";
}
  
  
  
}
