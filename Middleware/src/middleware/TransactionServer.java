/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middleware;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Rami
 */
public class TransactionServer {

    public TransactionServer() {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "TransactionManager";
            TransactionManager manager = new TransactionManagerImpl() {};
            TransactionManager stub =
                (TransactionManager) UnicastRemoteObject.exportObject(manager, 0);
            Registry registry = LocateRegistry.createRegistry(2020);
            registry.rebind(name, stub);
            System.out.println("TransactionManager bound");
        } catch (Exception e) {
            System.err.println("TransactionManager exception:");
            e.printStackTrace();
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new server thread
        TransactionServer transactionServer = new TransactionServer();
    }

}
