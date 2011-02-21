/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Rami
 */
public class TransactionServer {

    public TransactionServer() {
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new server thread
                if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            String name = "ITransactionManager";
            
            //ITransactionManager stub =
            //    (ITransactionManager) UnicastRemoteObject.exportObject(manager, 0);
            LocateRegistry.createRegistry(1099);
            TransactionManager manager = new TransactionManager();
            //registry.rebind(name, stub);
            Naming.rebind("//localhost/RmiServer", manager);
            System.out.println("TransactionManager bound");
        } catch (Exception e) {
            System.err.println("TransactionManager exception:");
            e.printStackTrace();
        }

        
    }

}
