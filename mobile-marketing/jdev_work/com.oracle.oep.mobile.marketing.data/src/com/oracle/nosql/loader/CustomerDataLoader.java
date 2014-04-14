/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2010, 2013 Oracle and/or its affiliates.  All rights reserved.
 *
 */

package com.oracle.nosql.loader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import com.oracle.mobile.marketing.data.CustomerData;

import oracle.kv.DurabilityException;
import oracle.kv.FaultException;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.RequestTimeoutException;
import oracle.kv.Value;
//import oracle.kv.ValueVersion;

/**
 * An extremely simple KVStore client application that writes and reads a
 * single record.  It can be used to validate an installation.
 *
 * Before running this example program, start a KVStore instance.  The simplest
 * way to do that is to run KV Lite as described in the INSTALL document.  Use
 * the KVStore instance name, host and port for running this program, as
 * follows:
 *
 * <pre>
 * java schema.HelloBigDataWorld -store &lt;instance name&gt; \
 *                               -host  &lt;host name&gt;     \
 *                               -port  &lt;port number&gt;
 * </pre>
 *
 * For all examples the default instance name is kvstore, the default host name
 * is localhost and the default port number is 5000.  These defaults match the
 * defaults for running kvlite, so the simplest way to run the examples along
 * with kvlite is to omit all parameters.
 */
public class CustomerDataLoader {

    private final KVStore store;

    /**
     * Runs the HelloBigDataWorld command line program.
     */
    public static void main(String args[]) {
        try {
            CustomerDataLoader example = new CustomerDataLoader(args);
            example.runExample();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses command line args and opens the KVStore.
     */
    CustomerDataLoader(String[] argv) {

        String storeName = "kvstore";
        String hostName = "localhost";
        String hostPort = "5000";

        final int nArgs = argv.length;
        int argc = 0;

        while (argc < nArgs) {
            final String thisArg = argv[argc++];

            if (thisArg.equals("-store")) {
                if (argc < nArgs) {
                    storeName = argv[argc++];
                } else {
                    usage("-store requires an argument");
                }
            } else if (thisArg.equals("-host")) {
                if (argc < nArgs) {
                    hostName = argv[argc++];
                } else {
                    usage("-host requires an argument");
                }
            } else if (thisArg.equals("-port")) {
                if (argc < nArgs) {
                    hostPort = argv[argc++];
                } else {
                    usage("-port requires an argument");
                }
            } else {
                usage("Unknown argument: " + thisArg);
            }
        }

        store = KVStoreFactory.getStore
            (new KVStoreConfig(storeName, hostName + ":" + hostPort));
    }

    private void usage(String message) {
        System.out.println("\n" + message + "\n");
        System.out.println("usage: " + getClass().getName());
        System.out.println("\t-store <instance name> (default: kvstore) " +
                           "-host <host name> (default: localhost) " +
                           "-port <port number> (default: 5000)");
        System.exit(1);
    }

    /**
     * Performs example operations and closes the KVStore.
     * @throws Exception 
     * @throws FaultException 
     * @throws RequestTimeoutException 
     * @throws DurabilityException 
     */
    void runExample() {
        
        ArrayList<CustomerData> list ;
        FileReader fr = new FileReader();
        list = fr.readCustomerFile() ;
        
        CustomerData data ;
        Iterator<CustomerData> iter = list.iterator();
        
        while (iter.hasNext()) {
        	data = iter.next() ;
        	String keyString = data.getDeviceID() ;
        	try {
                    store.put(Key.createKey(keyString),
                            Value.createValue(data.serialize()));
                System.out.println("Stored:" + keyString);
    			
    		} catch (DurabilityException e) {
    			
    			e.printStackTrace();
    		} catch (RequestTimeoutException e) {
    			
    			e.printStackTrace();
    		} catch (FaultException e) {
    			
    			e.printStackTrace();
    		} catch (IOException e) {
    			
    			e.printStackTrace();
    		}
        	
        	
        }
       
        store.close();
    }
}
