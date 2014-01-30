package com.oracle.oep.adapter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import com.bea.wlevs.ede.api.Adapter;
import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.InitializingBean;
import com.bea.wlevs.ede.api.SuspendableBean;
import com.bea.wlevs.ede.api.ResumableBean;
import com.bea.wlevs.util.Service;
import com.oracle.oep.demo.admin.OEPQueryInterface;
import com.oracle.oep.demo.admin.OfferQuery;
import com.oracle.oep.demo.admin.OEPAdminService;

public class QueryAdminHTTPService extends HttpServlet implements Adapter, InitializingBean, RunnableBean, ResumableBean, SuspendableBean {

    @SuppressWarnings("compatibility:-271341236059055462")
    private static final long serialVersionUID = -2319006919163970964L;
    
	private boolean suspended = true ;

	private String hostname = "localhost" ;
	private String port = "9002" ;
	private String appName = "com.oracle.oep.shopping.analytics" ;
	
	private OEPAdminService adminService ;

	public void setHostname(String host) {
		hostname = host;
	}

	public void setPort(String p) {
		port = p;
	}

	public void setAppName(String app) {
		appName = app;
	}
    

	private String contextString;

	public void setContextString(String contextString) {
		this.contextString = contextString;
	}
    
    
    public QueryAdminHTTPService() {
        super();
    }

    public void run() {
    	
        while (!isSuspended()) { 
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				//e.printStackTrace();
			}

        }
        
    }
 
    public synchronized void suspend() {
        suspended = true;
    }
    
    private synchronized boolean isSuspended() {
        return suspended;
    }


	@Override
	public void beforeResume() throws Exception {
		
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	
	@Service(serviceType = HttpService.class)
	public void setHttpService(HttpService httpService) {
		try {
			httpService.registerServlet(contextString, this, null, null);
		} catch (ServletException e) {
			System.out.println("ERROR: Could not register servlet: "
					+ e.getMessage());
			e.printStackTrace();
		} catch (NamespaceException e) {
			System.out.println("ERROR: Could not register servlet: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		doAny(request, response);
		//System.out.println("**** END GET  *****");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		doAny(request, response);
		//System.out.println("**** END POST  *****");
		
	}
	
	public void doAny(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		
		String offerQ = request.getParameter("OfferQuery");
		String queryID = "";
		String responseString = ""; 
		
		if (offerQ != null){
			System.out.println("Received a offer request.");
			String editedQueryID = "" ;
			
			boolean isOK = true ;
		
			try {
				queryID = request.getParameter("queryId");
				String offerID = request.getParameter("offerID");
				String imgSource  = request.getParameter("imgSource");
				String productID = request.getParameter("productID");
				String productName = request.getParameter("productName");
				String compare = request.getParameter("compare");
				
				float price = 0.00f ;
				try {
					price = Float.valueOf(request.getParameter("price")).floatValue();
					isOK = true ;
					System.out.println("Price is OK");
				} catch (NumberFormatException nfex) {
					isOK = false ;
					responseString += "<b> Price is : '" + request.getParameter("price") + "' is not valid! </b>";
					System.out.println("Number Format Exception");
				}
				
				int loyaltyStatus = 0;
				try {
					loyaltyStatus = Integer.valueOf(request.getParameter("loyaltyStatus")).intValue();
					System.out.println("Loyalty status is OK");
				} catch (NumberFormatException nfex) {
					isOK = false ;
					responseString += "<b> Loyalty status is : '" + request.getParameter("loyaltyStatus") + "' is not valid! </b>";
					System.out.println("Number Format Exception");
				}

				//int industryID = Integer.valueOf(request.getParameter("industryId")).intValue();
				
				//remove spaces from the query ID
				editedQueryID = queryID.replaceAll("\\s","");
					
				if (isOK){ 
					if (testQueryName(editedQueryID)){
					
						OfferQuery oq = new OfferQuery();
						oq.setQueryID(editedQueryID);
						oq.setOfferID(offerID);
						oq.setImgSource(imgSource);
						oq.setProductID(productID);
						oq.setProductName(productName);
						oq.setLoyaltyStatus(loyaltyStatus);
						oq.setPrice(price);
						oq.setCompare(compare);
						
						
						if (addRules(oq)){
							responseString = "<b> Query ID: '" + queryID + "' added! </b>";
							//addSelector(oq);
						} else {
							responseString = "<b> Attempt to add '" + queryID + "' failed! </b>";
						} 
					} else {
						responseString = "<b> Invalid Query ID: '" + queryID + "' ! </b>";
						responseString += "<br>Query ID must start with a letter!";	
					}
				} else {
					
					responseString += "<br><b> Attempt to add '" + queryID + "' failed! </b>";
				}
			
				
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Error accepting an Industry Query request!");
				
			}
			
		}
		//response.flushBuffer();	
		PrintWriter out = response.getWriter();
		responseString += "<br><a href=\"http://localhost:7001/ShoppingWeb/admin.jsp\">Continue</a>" ;
		out.write(responseString);
		out.close();
		
		
		
	}
	
	public boolean testQueryName(String text) {
		
	   
	   if (text.matches("[0-9]+")) {
		return false ;
	   }
		else {
			
			if (text.length() > 0){
				return true ;
			}
			return false ;
		}
		
	
	}
	
	public boolean testThresholdAmount(String text) {
		
		   
		   if (text.matches("[0-9]+")) {
			return false ;
		   }
			else {
				
				if (text.length() > 0){
					return true ;
				}
				return false ;
			}
			
		
		}

	  public boolean addRules(OEPQueryInterface q){
	    	
		   System.out.println("RECEIVED A REQUEST TO ADD!") ;
		   boolean result = false ;
		   try {
				
			   if (q != null){
				   
				   String queryID = q.getQueryID() ;
				   String queryStr = q.getQuery();
				
				   System.out.println("Add Request! ID: " +  queryID + " Query: " + queryStr);        		
			    	
				   result = adminService.addProcessorQuery(hostname, port, appName, q.getProcessorID(), queryID, queryStr);
				   
			   }
			   			   
		  	} catch (Exception ex ) {
		  		ex.printStackTrace();
		  	}
	    	
	    	return result ;
	    	
	    }
	  
	  public boolean addSelector(OEPQueryInterface q){
	    	
		   System.out.println("RECEIVED A REQUEST TO ADD!") ;
		   boolean result = false ;
		   try {
				
			   if (q != null){
				   
				   String queryID = q.getQueryID() ;
				   String queryStr = q.getQuery();
				   String channel = "AggregationAlertChannel" ;

				   System.out.println("Add Selector! ID: " +  queryID + " Query: " + queryStr);        		
			    	
				   //result = adminService.addProcessorQuery(hostname, port, appName, q.getProcessorID(), queryID, queryStr);
				   result = adminService.addSelectorQuery(hostname, port, appName, channel, queryID);
				   
			   }
			   			   
		  	} catch (Exception ex ) {
		  		ex.printStackTrace();
		  	}
	    	
	    	return result ;
	    	
	    }
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		adminService = new OEPAdminService();
		
	}




	
    
}
