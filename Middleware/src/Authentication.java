
public class Authentication {


    public static void main(String[] args)
    {
       System.out.println(Authentication.login("test", "test2"));
    }

    
    public static boolean login(String UID, String pwd)
    {
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
            return true;

        else
            return false;
    }

    public static boolean logout(String UID, String pwd)
    {
        return true;
    }
}
