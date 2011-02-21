/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;


/**
 *
 * @author Rami
 */
public class TransactionManager extends UnicastRemoteObject implements ITransactionManager {
    private InventoryManager invMgr;
    // Constructor
    public TransactionManager()
        throws RemoteException {
        super();
        invMgr = new InventoryManager();
    }

    public void addOrder(String order_date, String first_name, String last_name, String address, String phone, float total_cost, boolean shipped, Vector<String> product_id, Vector<String> description, Vector<Float> item_price, String UID, String pwd)
    {
        System.out.println("Received addOrder transaction: " + order_date);
        OrderManager order = new OrderManager();
        order.addOrder( order_date,  first_name,  last_name,  address,  phone,  total_cost,  (shipped? 1 : 0) , product_id, description,  item_price,  UID, pwd);

    }

    public void setOrderToShipped(int orderNumber, String UID, String pwd)
    {
        System.out.println("Received setOrderToShipped transaction: " + orderNumber);
        ShipmentManager shipment = new ShipmentManager();
        shipment.setOrderToShipped( new Integer(orderNumber).toString(),  UID,  pwd);
    }

   public Vector<String> getTrees()
   {
       System.out.println("Received getTrees");
       return invMgr.getTrees();

   }

   public Vector<String> getSeeds()
   {

      System.out.println("Received getSeeds");
      return invMgr.getSeeds();
   }

   public Vector<String> getShrubs()
   {

       System.out.println("Received getShrubs");
       return invMgr.getShrubs();
   }

   public int t(){return 42;}


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
