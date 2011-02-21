
import java.sql.SQLException;
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
    }

}
