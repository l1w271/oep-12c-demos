package com.oracle.oep.demo.admin;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.Iterator;
import java.util.Map;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
//import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class OEPAdminService {

	//public static void initConnection(String hostname, int port, String username, char[] password)
	public JMXConnector getConnection()
           throws IOException,MalformedURLException {
		
           Map<String,Object> env = makeSecureEnv();
           // This is an OSGi necessity
           //env.put(JMXConnectorFactory.DEFAULT_CLASS_LOADER, com.bea.core.jmx.remote.provider.msarmi.ServerProvider.class.getClassLoader() );
           //env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_CLASS_LOADER,com.bea.core.jmx.remote.provider.msarmi.ServerProvider.class.getClassLoader());
           env.put("jmx.remote.protocol.provider.pkgs","com.bea.core.jmx.remote.provider");
           env.put("mx4j.remote.resolver.pkgs","com.bea.core.jmx.remote.resolver");
           env.put("java.naming.factory.initial","com.bea.core.jndi.context.ContextFactory");
           
           JMXServiceURL serviceUrl = new JMXServiceURL("MSARMI","localhost",9002,"/jndi/jmxconnector");
           //System.out.println("Service: " + serviceUrl.toString());
           
           env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,"com.bea.core.jmx.remote.provider");
           System.setProperty("mx4j.remote.resolver.pkgs", "com.bea.core.jmx.remote.resolver");
           JMXConnector connector = JMXConnectorFactory.connect(serviceUrl, env);
           //connector.connect();
           //MBeanServerConnection connection = connector.getMBeanServerConnection();
           
           return connector ;

    }

	// The JMXConnectorFactory.connect() method�s second parameter is a Map
	// object that sets up a
	// secure environment using the makeSecureEnv() method, which looks like the
	// following:
	private Map<String, Object> makeSecureEnv() {
		Map<String, Object> env = new HashMap<String, Object>();
		String username = "wlevs";
		//char[] password = { 'w', 'l', 'e', 'v', 's' };
		char[] password = { 'w', 'e', 'l', 'c', 'o', 'm', 'e', '1' };
		env.put(JMXConnector.CREDENTIALS, new Serializable[] { username, password });
		env.put("jmx.remote.authenticator", "com.bea.core.jmx.server.CEAuthenticator");
		System.setProperty("jmx.remote.authenticator", "com.bea.core.jmx.server.CEAuthenticator");
		return env;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<String> getProcessorRules(String hostname, String port, String application, String processor) {	
		
        String objectType = "CQLProcessor" ;
        String attrName = "AllRules" ;
        JMXConnector connector;
		MBeanServerConnection connection = null ;
		Map<String, String> rules = null ;
		
		try {
			//connector = getConnection(hostname, port);
			connector = getConnection();
			if (connector != null){
				connection = connector.getMBeanServerConnection();
				System.out.println("Made Connection!");
			}
			
			if (connection != null){
		        ObjectName processorName = ObjectName.getInstance("com.bea.wlevs:Name=" + processor  + ",Type=" + objectType + ",Application=" + application );
		        rules = (Map<String, String>) connection.getAttribute(processorName, attrName);
		        connector.close();
			}
		} catch (Exception ex){
			System.out.println("Exception caught getting processor rules!");
			ex.printStackTrace();
		} finally {
			//
		}
		
		ArrayList<String> rulesList = new ArrayList<String>();	
		if (rules!=null){
			Iterator it = rules.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pairs = (Map.Entry)it.next();
		        System.out.println(pairs.getKey() + " = " + pairs.getValue());
		        rulesList.add(pairs.getKey().toString());
		    }
		}
		
		return rulesList;
		
	}

	public boolean addProcessorQuery(String hostname, String port, String application, 
			String processor, String ruleName, String ruleStr) {	
		
        String objectType = "CQLProcessor" ;
        JMXConnector connector;
		MBeanServerConnection connection = null ;
		//check if rule name exists in any processor
		//Map<String, String> rules = null ;
		
		try {
			//connector = getConnection(hostname, port);
			connector = getConnection();
			connection = connector.getMBeanServerConnection();
			
	        ObjectName processorName = ObjectName.getInstance("com.bea.wlevs:Name=" + processor  + ",Type=" + objectType + ",Application=" + application );
	        
	        connection.invoke(processorName, "addQuery", 
	                new Object[] {ruleName, ruleStr}, 
	                new String [] {String.class.getName(), String.class.getName()});
	        connector.close();
	        System.out.println("Added Query: "  + ruleName );
	        return true ;
		} catch (Exception ex){
			System.out.println("Exception!");
			ex.printStackTrace();
			return false ;
		}
		
	}
	
	public void addProcessorView(String hostname, String port, String application, 
			String processor, String ruleName, String ruleStr) {	
		
        String objectType = "CQLProcessor" ;
        JMXConnector connector;
		MBeanServerConnection connection = null ;
		//check if rule name exists in any processor
		//Map<String, String> rules = null ;
		
		try {
			//connector = getConnection(hostname, port);
			connector = getConnection();
			connection = connector.getMBeanServerConnection();
			
	        ObjectName processorName = ObjectName.getInstance("com.bea.wlevs:Name=" + processor  + ",Type=" + objectType + ",Application=" + application );
	        
	        connection.invoke(processorName, "addView", 
	                new Object[] {ruleName, ruleStr}, 
	                new String [] {String.class.getName(), String.class.getName()});
	        connector.close();
	        System.out.println("Added View: "  + ruleName );
		} catch (Exception ex){
			System.out.println("Exception!");
			ex.printStackTrace();
		}
				
		return ;
		
	}
	

	public void replaceProcessorQuery(String hostname, String port, String application, 
			String processor, String ruleName, String ruleStr) {	
		
        String objectType = "CQLProcessor" ;
        JMXConnector connector;
		MBeanServerConnection connection = null ;

		
		try {
			connector = getConnection();
			connection = connector.getMBeanServerConnection();
			
	        ObjectName processorName = ObjectName.getInstance("com.bea.wlevs:Name=" + processor  + ",Type=" + objectType + ",Application=" + application );
	        connection.invoke(processorName, "replaceQuery", 
	                new Object[] {ruleName, ruleStr},  
	                new String [] {String.class.getName(), String.class.getName()});
	        connector.close();
	        System.out.println("Replaced Query: "  +ruleName );
	        
		} catch (Exception ex){
			System.out.println("Exception!");
			ex.printStackTrace();
		}
				
		return ;
		
	}
	
	public boolean addSelectorQuery(String hostname, String port, String application, 
			String channel, String queryName) {	
		
        String objectType = "EventChannel" ;
        JMXConnector connector;
		MBeanServerConnection connection = null ;
		
		try {
			connector = getConnection();
			connection = connector.getMBeanServerConnection();
			
	        ObjectName channelName = ObjectName.getInstance("com.bea.wlevs:Name=" + channel  + ",Type=" + objectType + ",Application=" + application );
	        /* modify a rule */
	        connection.invoke(channelName, "addSelectorQuery", 
	        		new Object[] {queryName}, 
	        		new String [] {String.class.getName()});
	        connector.close();
	        System.out.println("Added Selector Query: "  + queryName );
		} catch (Exception ex){
			System.out.println("Exception!");
			ex.printStackTrace();
		}
				
		return true ;
		
	}
	
	
	public void deleteProcessorQuery(String hostname, String port, String application, 
			String processor, String ruleName) {	
		
        String objectType = "CQLProcessor" ;
        JMXConnector connector;
		MBeanServerConnection connection = null ;
		
		try {
			//connector = getConnection(hostname, port);
			connector = getConnection();
			connection = connector.getMBeanServerConnection();
			
	        ObjectName processorName = ObjectName.getInstance("com.bea.wlevs:Name=" + processor  + ",Type=" + objectType + ",Application=" + application );
	        /* delete a rule */
	        connection.invoke(processorName, "deleteRule", 
	        		new Object[] {ruleName}, 
	        		new String [] {String.class.getName()});
	        connector.close();
	        System.out.println("Deleted Query: "  + ruleName );
		} catch (Exception ex){
			System.out.println("Exception!");
			ex.printStackTrace();
		}
				
		return ;
		
	}

	
	
}
