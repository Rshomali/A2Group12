
public class Authentication {


    public static void main(String[] args)
    {
       System.out.println(Authentication.login("test", "test2"));
    }

    
    public static boolean login(String UID, String pwd)
    {
        DBManager dbManager = new DBManager();

        if(pwd!=null && pwd.compareTo(dbManager.getPassword(UID))==0)
            return true;

        else
            return false;
    }

    public static boolean logout(String UID, String pwd)
    {
        return true;
    }
}
