package com.oracle.oep.demo.admin;

public class TestQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		OfferQuery q = new OfferQuery();
		q.setImgSource("200.jpg");
		q.setLoyaltyStatus(1);
		q.setOfferID("O200");
		q.setPrice(3.99f);
		q.setProductID("P200");
		q.setProductName("Cookies");
		q.setCompare("=");
		
		String result = q.getQuery();
		
		System.out.println("RESULT:" + result);
		
		
	}

}
