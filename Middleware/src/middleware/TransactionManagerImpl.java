/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middleware;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;


/**
 *
 * @author Rami
 */
public class TransactionManagerImpl extends UnicastRemoteObject implements TransactionManager {
    // Constructor
    public TransactionManagerImpl()
        throws RemoteException {
        super();
    }

    public boolean addOrder(String order_date, String first_name, String last_name, String address, String phone, float total_cost, boolean shipped, String ordertable, Vector<String> product_id[], Vector<String> description[], float item_price[], String UID, String pwd)
    {
        OrderManager order = new OrderManager();
        return order.addOrder( order_date,  first_name,  last_name,  address,  phone,  total_cost,  shipped,  ordertable, product_id, description,  item_price,  UID, pwd);
    }

    public boolean setOrderToShipped(int orderNumber, String UID, String pwd)
    {
        ShipmentManager shipment = new ShipmentManager();
        return shipment.setOrderToShipped( orderNumber,  UID,  pwd);
    }

}
