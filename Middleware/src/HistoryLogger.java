
// Import log4j classes.
import java.sql.Timestamp;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.SimpleLayout;

public class HistoryLogger {

    public static void main(String args[]) {

        HistoryLogger historyLogger = new HistoryLogger();
        
        //historyLogger.logLogin("345", new Timestamp(new java.util.Date().getTime()));
        //historyLogger.logLogout("678", new Timestamp(new java.util.Date().getTime()));
       
       // historyLogger.logShipping(new Timestamp(new java.util.Date().getTime()), 001);
        //historyLogger.logOrder("123", new Timestamp(new java.util.Date().getTime()), 001);
    }



    // Private constructor prevents instantiation from other classes

    private static final HistoryLogger INSTANCE = new HistoryLogger();

    private Logger loginLogger = Logger.getLogger("loginLogger");
    private Logger orderLogger = Logger.getLogger("orderLogger");
    private Logger shipmentLogger = Logger.getLogger("shipmentLogger");

    private String log_loginlogoutFile = "log_loginlogout.txt";
    private String log_orderFile = "log_order.txt";
    private String log_shipmentFile = "log_shipment.txt";
    private SimpleLayout layout = new SimpleLayout();

    private FileAppender appender_loginlogout;
    private FileAppender appender_order;
    private FileAppender appender_ship;

    private HistoryLogger()
    {
        try {
            appender_loginlogout = new FileAppender(layout, log_loginlogoutFile, true);
        } catch (Exception e) {
            System.out.println("HistoryLogger: "+ e);
        }


        try {
            appender_order = new FileAppender(layout, log_orderFile, true);
        } catch (Exception e) {
            System.out.println("HistoryLogger: "+ e);
        }

        try {
            appender_ship = new FileAppender(layout, log_shipmentFile, true);
        } catch (Exception e) {
            System.out.println("HistoryLogger: "+ e);
        }

    }


    public static HistoryLogger getInstance() {
        return INSTANCE;
    }

    public void logLogin(String UID, String timeLogin) {

        loginLogger.addAppender(appender_loginlogout);
        loginLogger.info(timeLogin+"    user id:"+UID+"  -log in");
        System.out.println(timeLogin+"    user id:"+UID+"  -log in");
    }


    public void logLogout(String UID, String timeLogout) {


        loginLogger.addAppender(appender_loginlogout);
        loginLogger.info(timeLogout+"    user id:"+UID+"  -log out");
    }


    public void logOrder(String UID, String time, int orderNumber) {
        
        orderLogger.addAppender(appender_order);
        orderLogger.info(time+"    user id:"+UID+"  order number:"+
                orderNumber+"  -make order");
    }


    public void logShipping(String time, int orderNumber) {

        shipmentLogger.addAppender(appender_ship);
        shipmentLogger.info(time+"  order number:"+
                orderNumber+"  -make shipment");
    }



    
}
