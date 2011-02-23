/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import java.sql.ResultSet;

public interface ITransactionManager extends Remote
{
   void setOrderToShipped(int orderNumber, String uid, String pwd) throws RemoteException;
   void addOrder(String order_date, String first_name, String last_name, String address, String phone, float total_cost, boolean shipped, Vector<String> product_id, Vector<String> description, Vector<Float> item_price, String UID, String pwd) throws RemoteException;
   Vector<String> getTrees(String UID, String pwd) throws RemoteException;
   Vector<String> getSeeds(String UID, String pwd) throws RemoteException;
   Vector<String> getShrubs(String UID, String pwd) throws RemoteException;
   Vector<Vector<String>> getOrder(Integer orderID) throws RemoteException;
   Vector<String> getPendingOrders(String UID, String pwd)throws RemoteException;
   Vector<String> getShipped() throws RemoteException;
   void addShrubs(String product_code, String description, Integer quantity, Float costPerItem) throws RemoteException;
   void addTrees(String product_code, String description, Integer quantity, Float costPerItem) throws RemoteException;
   void addSeeds(String product_code, String description, Integer quantity, Float costPerItem) throws RemoteException;
   int t() throws RemoteException;
}
