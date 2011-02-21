/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;
import java.util.Vector;

public class TransactionManager extends UnicastRemoteObject implements ITransactionManager
{
    public TransactionManager() throws RemoteException
    {
    }

   public  void setOrderToShipped(int orderNumber, String uid, String pwd) throws RemoteException{}
   public  void addOrder(String order_date, String first_name, String last_name, String address, String phone, float total_cost, boolean shipped, Vector<String> product_id, Vector<String> description, Vector<Float> item_price, String UID, String pwd) throws RemoteException{}
   public  Vector<String> getTrees() throws RemoteException{return null;}
   public  Vector<String> getSeeds() throws RemoteException{return null;}
   public  Vector<String> getShrubs() throws RemoteException{return null;}
   public int t(){return 42;}

    public static void main(String args[]) {
        System.out.println("RMI server started");

        // Create and install a security manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
            System.out.println("Security manager installed.");
        } else {
            System.out.println("Security manager already exists.");
        }

        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }

        try {
            //Instantiate RmiServer
            TransactionManager obj = new TransactionManager();

            // Bind this object instance to the name "RmiServer"
            Naming.rebind("//localhost/RmiServer", obj);

            System.out.println("PeerServer bound in registry");
        } catch (Exception e) {
            System.err.println("RMI server exception:" + e);
            e.printStackTrace();
        }
    }
}
