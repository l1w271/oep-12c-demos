package com.oracle.oep.demo.launch;

public class SalesData {

    protected String productID;
    protected String retailerID;
    protected String storeID;
    protected long numUnitsSold;


    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductID() {
        return productID;
    }

    public void setRetailerID(String retailerID) {
        this.retailerID = retailerID;
    }

    public String getRetailerID() {
        return retailerID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setNumUnitsSold(long numUnitsSold) {
        this.numUnitsSold = numUnitsSold;
    }

    public long getNumUnitsSold() {
        return numUnitsSold;
    }


    @Override
    public String toString() {

        String result;
        result =
            "productID: " + productID 
            + " retailerID: " + retailerID 
            + " storeID: " + storeID 
            + " numUnitsSold: " + numUnitsSold;

        return result;


    }


}
