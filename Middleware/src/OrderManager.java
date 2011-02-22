import java.util.Vector;

public class OrderManager {

     public static void main(String[] args)
    {
        Vector<String> test1 = new Vector<String>();
        test1.add("test1");
        test1.add("111ttt");
        test1.add("333");
        Vector<Float> testF = new Vector<Float>();
        testF.add(100.3f);
        testF.add(100.3f);

        testF.add(100.3f);


         OrderManager orderManager = new OrderManager();
         orderManager.addOrder("123", "123", "ef", "efef", "sdf",
                 123f, 0, test1, test1, testF, "test", "test");
    }

    public void addOrder(String order_date, String first_name,
            String last_name, String address, String phone,
            float total_cost, int shipped, 
            Vector<String> product_id, Vector<String> description,
            Vector<Float> item_price, String UID, String password)
    {
        System.out.println("Initializing  DBManager for" + UID + " password: " + password);
        try
        {
            boolean result = Authentication.login(UID, password);
            System.out.println("Authentication result: " + result);

            if(result)
            {
                DBManager dbManager = new DBManager();
                dbManager.writeOrder(order_date,first_name,last_name,address,phone,total_cost, shipped, product_id, description, item_price);
                System.out.println("Calling dbManager.writeOrder");
            }
            else
            {
                System.out.println("Authentication failed for " + UID + " With password " + password);
            }

       }
       catch(Exception e) {
           System.out.println("Error calling OrderManager.addOrder: " + e);
       }

    }

}
