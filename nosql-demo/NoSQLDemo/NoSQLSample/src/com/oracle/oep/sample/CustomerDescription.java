package com.oracle.oep.sample ;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomerDescription implements Serializable
{

    @SuppressWarnings("compatibility:-3308362959634562829")
    private static final long serialVersionUID = 69273881851764339L;
  
  private String userId;
  private int creditScore;
  private String customerName;
  private String address;
  
  public String getUserId()
  {
    return userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
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
  
  public String getAddress()
  {
    return address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }

  public byte[] serialize() throws IOException
  {
    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
    ObjectOutputStream objectOut = 
      new ObjectOutputStream(byteStream);

    objectOut.writeObject(this);

    return byteStream.toByteArray();
  }
}
