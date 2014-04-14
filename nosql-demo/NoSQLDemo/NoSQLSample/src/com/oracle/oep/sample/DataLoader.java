package com.oracle.oep.sample;

import java.io.IOException;

import oracle.kv.DurabilityException;
import oracle.kv.FaultException;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.RequestTimeoutException;
import oracle.kv.Value;

public class DataLoader {
    
    private final KVStore store;

    /**
     * Runs the DataLoader command line program.
     */
    public static void main(String args[]) {
        try {
            DataLoader example = new DataLoader(args);
            example.runExample();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses command line args and opens the KVStore.
     */
    DataLoader(String[] argv) {

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

        final String keyString = "ronaldo";
        
        CustomerDescription description = new CustomerDescription();
        description.setUserId("ronaldo");
        description.setCreditScore(5);
        description.setAddress("Rio de Janeiro");
        description.setCustomerName("Ronaldo Nascimento");
        
        try {
            store.put(Key.createKey(keyString),
                      Value.createValue(description.serialize()));
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
                        
        store.close();
    }

    
    
    
}
