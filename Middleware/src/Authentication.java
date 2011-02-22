
import java.sql.Timestamp;


public class Authentication {


    public static void main(String[] args)
    {
       System.out.println(Authentication.login("test", "test2"));
    }

    
    public static boolean login(String UID, String pwd)
    {
        HistoryLogger logger = HistoryLogger.getInstance();

        DBManager dbManager = new DBManager();
        String db_pwd;
        boolean success = false;
        try
        {
           db_pwd = dbManager.getPassword(UID);
           if( (pwd != null) && (pwd.compareTo(db_pwd)==0))
                success = true;
        }
        catch(Exception e)
        {
            return false;
        }

         System.out.println("No Authentication Exception ....");

        if(success)
        {
            logger.logLogin(UID, (new Timestamp(new java.util.Date().getTime())).toString());
            return true;
        }
        else
            return false;
    }

    public static boolean logout(String UID, String pwd)
    {
        HistoryLogger logger = HistoryLogger.getInstance();
        logger.logLogout(UID, (new Timestamp(new java.util.Date().getTime())).toString());
        return true;
    }
}
