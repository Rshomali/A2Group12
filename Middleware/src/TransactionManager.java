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
    private ShipmentManager shipMgr;
    private OrderManager orderMgr;
    // Constructor
    public TransactionManager()
        throws RemoteException {
        super();
        invMgr = new InventoryManager();
        shipMgr = new ShipmentManager();
        orderMgr = new OrderManager();
    }

    public void addOrder(String order_date, String first_name, String last_name, String address, String phone, float total_cost, boolean shipped, Vector<String> product_id, Vector<String> description, Vector<Float> item_price, String UID, String pwd)
    {
        System.out.println("Received addOrder transaction: " + order_date);
       try
       {
            
            orderMgr.addOrder( order_date,  first_name,  last_name,  address,  phone,  total_cost,  (shipped? 1 : 0) , product_id, description,  item_price,  UID, pwd);
        }
       catch(Exception e) {
           System.out.println("Error calling OrderManager.addOrder: " + e);
       }

    }

    public void setOrderToShipped(int orderNumber, String UID, String pwd)
    {
        System.out.println("Received setOrderToShipped transaction: " + orderNumber);
        shipMgr.setOrderToShipped( new Integer(orderNumber).toString(),  UID,  pwd);
    }

   public Vector<String> getTrees(String UID, String pwd)
   {
       System.out.println("Received getTrees");
       return invMgr.getTrees(UID,pwd);

   }

   public Vector<String> getSeeds(String UID, String pwd)
   {

      System.out.println("Received getSeeds");
      return invMgr.getSeeds(UID,pwd);
   }

   public Vector<String> getShrubs(String UID, String pwd)
   {

       System.out.println("Received getShrubs");
       return invMgr.getShrubs(UID,pwd);
   }

   public int t(){return 42;}

   public Vector<Vector<String>> getOrder(Integer orderID)
   {

      System.out.println("Received getOrder");
      return orderMgr.getOrder(orderID);
   }

   public Vector<String> getPendingOrders(String UID, String pwd)
   {
      System.out.println("Received getPendingOrders");
      return shipMgr.getPendingOrders();
   }

   public Vector<String> getShipped()
   {
      System.out.println("Received getShipped");
      return shipMgr.getShippedOrders();

   }

   public void addShrubs(String product_code, String description, Integer quantity, Float costPerItem)
   {
       System.out.println("Received addShrubs");
       invMgr.addShrub(product_code, description, quantity, costPerItem);


   }

   public void addTrees(String product_code, String description, Integer quantity, Float costPerItem)
   {
       System.out.println("Received addTrees");
       invMgr.addTree(product_code, description, quantity, costPerItem);

   }

   public void addSeeds(String product_code, String description, Integer quantity, Float costPerItem)
   {
       System.out.println("Received addSeeds");
       invMgr.addSeed(product_code, description, quantity, costPerItem);

   }


   public static void main(String[] args) {

       HistoryLogger logger = HistoryLogger.getInstance();

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
