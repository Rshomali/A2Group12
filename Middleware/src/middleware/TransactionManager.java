/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middleware;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author Rami
 */
public interface TransactionManager extends Remote{

    boolean addOrder(String order_date, String first_name, String last_name, String address, String phone, float total_cost, boolean shipped, String ordertable, Vector<String>[] product_id, Vector<String>[] description, float[] item_price, String UID, String pwd)
            throws RemoteException;
    boolean setOrderToShipped(int orderNumber, String UID, String pwd)
            throws RemoteException;

}
