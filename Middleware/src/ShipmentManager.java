
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;


public class ShipmentManager {


    public static void main(String[] args)
    {
        ShipmentManager manager = new ShipmentManager();
        manager.setOrderToShipped("order1298076900480", "test", "test");
    }

    public void setOrderToShipped(String orderNumber, String UID, String pwd)
    {
        if(Authentication.login(UID, pwd))
        {
            DBManager dbManager = new DBManager();
            try {
                dbManager.setOrderToShipped(orderNumber);
            } catch (SQLException ex) {
               // Logger.getLogger(ShipmentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       HistoryLogger logger = HistoryLogger.getInstance();
       logger.logShipping((new Timestamp(new java.util.Date().getTime())).toString(), Integer.parseInt(orderNumber));
    }

}
