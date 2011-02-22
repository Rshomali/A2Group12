
// Import log4j classes.
import java.sql.Timestamp;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.SimpleLayout;

public class HistoryLogger {

    public static void main(String args[]) {

        HistoryLogger historyLogger = new HistoryLogger();
        
        historyLogger.logLogin("345", new Timestamp(new java.util.Date().getTime()));
        historyLogger.logLogout("678", new Timestamp(new java.util.Date().getTime()));
       
        historyLogger.logShipping(new Timestamp(new java.util.Date().getTime()), 001);
        historyLogger.logOrder("123", new Timestamp(new java.util.Date().getTime()), 001);
    }


    
    private Logger loginLogger = Logger.getLogger("loginLogger");
    private Logger orderLogger = Logger.getLogger("orderLogger");
    private Logger shipmentLogger = Logger.getLogger("shipmentLogger");

    private String log_loginlogoutFile = "log_loginlogout.txt";
    private String log_orderFile = "log_order.txt";
    private String log_shipmentFile = "log_shipment.txt";
    private SimpleLayout layout = new SimpleLayout();

    private FileAppender appender_loginlogout;

    public HistoryLogger()
    {
        try {
            appender_loginlogout = new FileAppender(layout, log_loginlogoutFile, true);
        } catch (Exception e) {
            System.out.println("HistoryLogger: "+ e);
        }
    }

    public void logLogin(String UID, Timestamp timeLogin) {

        loginLogger.addAppender(appender_loginlogout);
        loginLogger.info(timeLogin.toString()+"    user id:"+UID+"  -log in");

    }


    public void logLogout(String UID, Timestamp timeLogout) {


        loginLogger.addAppender(appender_loginlogout);
        loginLogger.info(timeLogout.toString()+"    user id:"+UID+"  -log out");
    }


    public void logOrder(String UID, Timestamp time, int orderNumber) {

        FileAppender appender_order=null;
        try {
            appender_order = new FileAppender(layout, log_orderFile, true);
        } catch (Exception e) {
            System.out.println("HistoryLogger: "+ e);
        }

        orderLogger.addAppender(appender_order);
        orderLogger.info(time.toString()+"    user id:"+UID+"  order number:"+
                orderNumber+"  -make order");
    }


    public void logShipping(Timestamp time, int orderNumber) {

        FileAppender appender_ship=null;
        try {
            appender_ship = new FileAppender(layout, log_shipmentFile, true);
        } catch (Exception e) {
            System.out.println("HistoryLogger: "+ e);
        }

        shipmentLogger.addAppender(appender_ship);
        shipmentLogger.info(time.toString()+"  order number:"+
                orderNumber+"  -make shipment");
    }



    
}
