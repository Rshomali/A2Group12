
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;


public class ShipmentManager {


    public static void main(String[] args)
    {
        ShipmentManager manager = new ShipmentManager();
        manager.setOrderToShipped("order1298076900480", "test", "test");
    }

    private DBManager dbManager;

    public ShipmentManager()
    {
        dbManager = new DBManager();
    }

    public void setOrderToShipped(String orderNumber, String UID, String pwd)
    {
        if(Authentication.login(UID, pwd))
        {
            try {
                dbManager.setOrderToShipped(orderNumber);
            } catch (SQLException ex) {
               // Logger.getLogger(ShipmentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       HistoryLogger logger = HistoryLogger.getInstance();
       logger.logShipping((new Timestamp(new java.util.Date().getTime())).toString(), Integer.parseInt(orderNumber));
    }

    public Vector<String> getShippedOrders() throws RemoteException
    {
        return dbManager.getShippedOrders();
    }

    public Vector<String> getPendingOrders() throws RemoteException
    {
        return dbManager.getPendingOrders();
    }
}
