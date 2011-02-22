


import java.sql.*;
import java.util.Calendar;
import java.util.Vector;

/**
 *
 * @author tae
 */

public class DBManager {
    /**
     * @param args the command line arguments
     */


    String SQLServerIP = "localhost";
	String remoteUserID = "remote";
	String remoteUserPWD = "remote_pass";

	public String getPassword(String UID){

        String msgString = null;        // String for displaying non-error messages
        String SQLstatement = null;     // String for building SQL queries
        Connection DBConn = null;       // MySQL connection handle
        String errString = null;        // String for displaying errors
        Boolean connectError = false;   // Error flag

        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer

        String password = null;



        if(UID!=null){
            try{
                              //load JDBC driver class for MySQL
                    Class.forName( "com.mysql.jdbc.Driver" );
                                      //define the data source
                    String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/userDB";
                    //create a connection to the db - note the default account is remoteUserID
                    //and the password is remoteUserPWD - you will have to set this
                    //account up in your database
                    DBConn = DriverManager.getConnection(sourceURL,remoteUserID,remoteUserPWD);

                } catch (Exception e) {

                    errString =  "\nError connecting to userinfo database\n" + e;
                    System.out.println(errString);
                    connectError = true;

                } // end try-catch

            if ( !connectError )
            {
                try
                {
                    //DBConn.createStatement();

                    s = DBConn.createStatement();

                //    SQLstatement = ("Select password from test WHERE userid='test');

                    res = s.executeQuery( "SELECT password FROM userinfo WHERE userid=\""+UID+"\"");
                    int found = 0;
                    while (res.next())
                    {
                       found++;
                       password = res.getString(1);

                    } // while

                    if (found == 0)
                        return null;

                    //System.out.println(res.getString(1));
                    //Display the data in the textarea
                } catch (Exception e) {

                    System.out.println(e.getMessage());
                    System.out.println("Errors at getting password from userinfo db");
                } // end try-catch
            } // if connect check
        }
        return password;
    }


   public Vector<String> getSeed(){

         Vector<String> msgString = new Vector<String>();        // String for displaying non-error messages
        String SQLstatement = null;     // String for building SQL queries
        Connection DBConn = null;       // MySQL connection handle
        String errString = null;        // String for displaying errors
        Boolean connectError = false;   // Error flag

        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer

        if(true){
            try{
                              //load JDBC driver class for MySQL
                    Class.forName( "com.mysql.jdbc.Driver" );
                                      //define the data source
                    String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/inventory";
                    //create a connection to the db - note the default account is remoteUserID
                    //and the password is remoteUserPWD - you will have to set this
                    //account up in your database
                    DBConn = DriverManager.getConnection(sourceURL,remoteUserID,remoteUserPWD);

                } catch (Exception e) {

                    errString =  "\nError connecting to userinfo database\n" + e;
                    System.out.println(errString);
                    connectError = true;

                } // end try-catch

            if ( !connectError )
            {
                try
                {
                    s = DBConn.createStatement();

                    res = s.executeQuery( "Select * from seeds");


                while (res.next())
                {
                    msgString.add(res.getString(1)+" : "+res.getString(2)+" : $"+res.getString(4)+" : "+res.getString(3)+" units in stock\n");
					/*
                    msgString.add(" : ");
                    msgString.add(res.getString(2));
                    msgString.add(" : $");
                    msgString.add(res.getString(4));
                    msgString.add(" : ");
                    msgString.add(res.getString(3));
                    msgString.add(" units in stock")
  */
                } // while

                    //System.out.println(res.getString(1));
                    //Display the data in the textarea
                } catch (Exception e) {

                    System.out.println(e.getMessage());
                    System.out.println("Errors at getting password from inventory db");
                } // end try-catch
            } // if connect check
        }
        return msgString;
    }

   public Vector<String> getTree(){


        Vector<String> msgString = new Vector<String>();        // String for displaying non-error messages
        String SQLstatement = null;     // String for building SQL queries
        Connection DBConn = null;       // MySQL connection handle
        String errString = null;        // String for displaying errors
        Boolean connectError = false;   // Error flag

        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer

        if(true){
            try{
                              //load JDBC driver class for MySQL
                    Class.forName( "com.mysql.jdbc.Driver" );
                                      //define the data source
                    String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/inventory";
                    //create a connection to the db - note the default account is remoteUserID
                    //and the password is remoteUserPWD - you will have to set this
                    //account up in your database
                    DBConn = DriverManager.getConnection(sourceURL,remoteUserID,remoteUserPWD);

                } catch (Exception e) {

                    errString =  "\nError connecting to userinfo database\n" + e;
                    System.out.println(errString);
                    connectError = true;

                } // end try-catch

            if ( !connectError )
            {
                try
                {
                    s = DBConn.createStatement();

                    res = s.executeQuery( "Select * from trees");

                    while (res.next())
                {

                    msgString.add(res.getString(1)+" : "+res.getString(2)+" : $"+res.getString(4)+" : "+res.getString(3)+" units in stock\n");
/*
                    msgString.add(res.getString(1));
                    msgString.add(" : ");
                    msgString.add(res.getString(2));
                    msgString.add(" : $");
                    msgString.add(res.getString(4));
                    msgString.add(" : ");
                    msgString.add(res.getString(3));
                    msgString.add(" units in stock");

                    */
                } // while

                    //System.out.println(res.getString(1));
                    //Display the data in the textarea
                } catch (Exception e) {

                    System.out.println(e.getMessage());
                    System.out.println("Errors at getting password from inventory db");
                } // end try-catch
            } // if connect check
        }


        return msgString;
    }
public Vector<String> getShrubs(){


         Vector<String> msgString = new Vector<String>();        // String for displaying non-error messages
        String SQLstatement = null;     // String for building SQL queries
        Connection DBConn = null;       // MySQL connection handle
        String errString = null;        // String for displaying errors
        Boolean connectError = false;   // Error flag

        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer

        if(true){
            try{
                              //load JDBC driver class for MySQL
                    Class.forName( "com.mysql.jdbc.Driver" );
                                      //define the data source
                    String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/inventory";
                    //create a connection to the db - note the default account is remoteUserID
                    //and the password is remoteUserPWD - you will have to set this
                    //account up in your database
                    DBConn = DriverManager.getConnection(sourceURL,remoteUserID,remoteUserPWD);

                } catch (Exception e) {

                    errString =  "\nError connecting to userinfo database\n" + e;
                    System.out.println(errString);
                    connectError = true;

                } // end try-catch

            if ( !connectError )
            {
                try
                {
                    s = DBConn.createStatement();

                    res = s.executeQuery( "Select * from shrubs");

                    while (res.next())
                {
                    msgString.add(res.getString(1)+" : "+res.getString(2)+" : $"+res.getString(4)+" : "+res.getString(3)+" units in stock\n");
					/*
                    msgString.add(res.getString(1));
                    msgString.add(" : ");
                    msgString.add(res.getString(2));
                    msgString.add(" : $");
                    msgString.add(res.getString(4));
                    msgString.add(" : ");
                    msgString.add(res.getString(3));
                    msgString.add(" units in stock");
					*/
                    
                } // while

                    //System.out.println(res.getString(1));
                    //Display the data in the textarea
                } catch (Exception e) {

                    System.out.println(e.getMessage());
                    System.out.println("Errors at getting password from inventory db");
                } // end try-catch
            } // if connect check
        }
        return msgString;
    }


    public void writeOrder(String order_date, String first_name,
            String last_name, String address, String phone, float total_cost,
            int shipped, Vector<String> product_id,
            Vector<String> description, Vector<Float> item_price)
    {

        int beginIndex;                 // String parsing index
        Boolean connectError = false;   // Error flag
        int endIndex;                   // String paring index
        String firstName = null;        // Customer's first name
        Connection DBConn = null;       // MySQL connection handle
        int executeUpdateVal;           // Return value from execute indicating effected rows
        String errString = null;        // String for displaying errors
        //String errString = null;        // String for displaying errors

              // Tree, seed, or shrub description
        Boolean executeError = false;   // Error flag
        String lastName = null;         // Customer's last name
        String msgString = null;        // String for displaying non-error messages
        String orderTableName = null;   // This is the name of the table that lists the items
        String sPerUnitCost = null;     // String representation of per unit cost
        String orderItem = null;        // Order line item from jTextArea2
        Float perUnitCost;              // Cost per tree, seed, or shrub unit
        String productID = null;        // Product id of tree, seed, or shrub
        Statement s = null;             // SQL statement pointer
        String SQLstatement = null;     // String for building SQL queries

        //orderTableName = "orderinfo";

        if((order_date!=null && first_name!=null && last_name!=null &&
                address!=null && phone!=null && total_cost >=0
                && shipped !=1 && product_id!=null
                && description!=null && item_price!=null )){
            System.out.println("dbManager.writeOrder 1");
            try
            {
                msgString = ">> Establishing Driver...";
                   //load JDBC driver class for MySQL
                Class.forName( "com.mysql.jdbc.Driver" );

                msgString = ">> Setting up URL...";
                 //define the data source
                String SQLServerIP = "localhost";
                String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/orderinfo";

                msgString = ">> Establishing connection with: " + sourceURL + "...";

                //create a connection to the db - note the default account is remoteUserID
                //and the password is remoteUserPWD - you will have to set this
                //account up in your database

                DBConn = DriverManager.getConnection(sourceURL,remoteUserID,remoteUserPWD);

            } catch (Exception e) {

                System.out.println("Error: connecting orderinfo DB");

                connectError = true;

            } // end try-catch
        }else {
            System.out.println("dbManager.writeOrder 2");
            System.out.println("Error: order information");
            connectError = true;

        }// customer data check
/********************************************************/
        if (!connectError )
        {
            System.out.println("dbManager.writeOrder 3");
            //making order####
            Calendar rightNow = Calendar.getInstance();

            int TheHour = rightNow.get(rightNow.HOUR_OF_DAY);
            int TheMinute = rightNow.get(rightNow.MINUTE);
            int TheSecond = rightNow.get(rightNow.SECOND);
            int TheDay = rightNow.get(rightNow.DAY_OF_WEEK);
            int TheMonth = rightNow.get(rightNow.MONTH);
            int TheYear = rightNow.get(rightNow.YEAR);
            orderTableName = "order" + String.valueOf(rightNow.getTimeInMillis());

            String dateTimeStamp = TheMonth + "/" + TheDay + "/" + TheYear + " "
                    + TheHour + ":" + TheMinute  + ":" + TheSecond;



            // Get the order data
            try
            {
                s = DBConn.createStatement();

                SQLstatement = ( "CREATE TABLE " + orderTableName +
                            "(item_id int unsigned not null auto_increment primary key, " +
                            "product_id varchar(20), description varchar(80), " +
                            "item_price float(7,2) );");

                executeUpdateVal = s.executeUpdate(SQLstatement);

            } catch (Exception e) {


                System.out.println("\nProblem creating order table " + orderTableName);
                executeError = true;

            } // try

            System.out.println("dbManager.writeOrder 4");

            if ( !executeError )
            {
                System.out.println("dbManager.writeOrder 5");
                try
                {
                    SQLstatement = ( "INSERT INTO orders (order_date, " + "first_name, " +
                        "last_name, address, phone, total_cost, shipped, " +
                        "ordertable) VALUES ( '" + order_date + "', " +
                        "'" + first_name + "', " + "'" + last_name + "', " +
                        "'" + address + "', " + "'" + phone + "', " +
                        total_cost + ", " + 0 + ", '" + orderTableName +"' );");

                    executeUpdateVal = s.executeUpdate(SQLstatement);

                } catch (Exception e1) {

                    errString =  "\nProblem with inserting into table orders:: " + e1;
                    //jTextArea3.append(errString);
                    executeError = true;

                    try
                    {
                        SQLstatement = ( "DROP TABLE " + orderTableName + ";" );
                        executeUpdateVal = s.executeUpdate(SQLstatement);

                    } catch (Exception e2) {

                        errString =  "\nProblem deleting unused order table:: " +
                                orderTableName + ":: " + e2;
                        //jTextArea3.append(errString);

                    } // try

                } // try

            } //execute error check






/**********************************************************/
       
        if ( !connectError && !executeError )
        {
            // Now we create a table that contains the itemized list
            // of stuff that is associated with the order

            for (int i = 0; i < product_id.size(); i++ )
            {
        
                if (description.elementAt(i)!=null )
                {
                    SQLstatement = ( "INSERT INTO " + orderTableName +
                        " (product_id, description, item_price) " +
                        "VALUES ( '" + product_id.elementAt(i) + "', " + "'" +
                        description.elementAt(i) + "', " + item_price.elementAt(i) + " );");
                    try
                    {
                        executeUpdateVal = s.executeUpdate(SQLstatement);
                        msgString =  "\nORDER SUBMITTED FOR: " + firstName + " " + lastName;
        
                        // Clean up the display

                    } catch (Exception e) {

                        errString =  "\nProblem with inserting into table " + orderTableName +
                            ":: " + e;
        
                    } // try

                } // line length check

            } //for each line of text in order table


            	try {
				/*
				 * Ok, so now we've got the order set up, lets reduce
				 * the quantities available in the inventory. This isn't
				 * really hard as long as we know that there are no
				 * products with the same ID in the inventories tables.
				 * We'll first guarantee that and then will take care
				 * of reducint the quantities available in the
				 * inventory.
				 */
				String[] invTables = { "seeds", "shrubs", "trees" };
				String sql = "select p, count(*) from (";
				boolean first = true;
				for (String t : invTables) {
					if (!first) {
						sql += " union all ";
					} else {
						first = false;
					}

					sql += "select '" + t + "' as t, product_code as "
							+ "p, description as d from inventory."
							+ t;
				}

				sql += ") f group by p, d having(count(*)) > 1";
				/* Don't you just ** love ** SQL? ... */

				ResultSet rs = s.executeQuery(sql);
				if (rs.next()) {
					/* Trouble! */
					throw new Exception("More than one product found "
							+ "in more than one inventory table with "
							+ "code = '" + rs.getString("p") + "' "
							+ "and description = '" + rs.getString("d")
							+ "'.");
				}

				/* Now, just perform the updates... */
				for (String t : invTables) {
					sql = "update inventory." + t + ", (select "
							+ "product_id p, description d, count(*) q "
							+ "from " + orderTableName + " group by "
							+ "p, d) o set quantity = quantity "
							+ "- o.q where product_code = p and "
							+ "description = d";
					/* Ahhh, can you live without join updates? :) */
					s.executeUpdate(sql);

					/*
					 * If we wanted to be *really* sure we've done the
					 * right thing we should at least check the total
					 * number of updated rows to be sure that we've
					 * updates the right number of products... anyway,
					 * who cares? I'm not paying for wrong inventory
					 * updates... am I?
					 */
				}

				/*
				 * We're not closing the statement because it looks noone is
				 * closing anything around... we just let the garbage collector
				 * do its work...
				 */
			} catch (Exception e) {
				errString =  "\nProblem with inserting into table "
						+ orderTableName + ":: " + e;
				System.out.println(errString);
			}



        }






        }



    }


   /*
        precondition
            orderNumber has to be in the orders table

        postconditions
            the row for the orderNumber’s field “shipped” is true
  */
    public boolean setOrderToShipped(String orderNumber) throws SQLException{

        String SQLstatement = null;     // String for building SQL queries
        String msgString = null;        // String for displaying non-error messages

        Boolean connectError = false;   // Error flag
        String firstName = null;        // Customer's first name
        Connection DBConn = null;       // MySQL connection handle
        Boolean executeError = false;   // Error flag
        String errString = null;        // String for displaying errors
        int executeUpdateVal;           // Return value from execute indicating effected rows
        String orderItem = null;        // Order line item from jTextArea2
        String productID = null;        // Product id of tree, seed, or shrub
        Statement s = null;             // SQL statement pointer


        String orderTableName = "orders";
        String ColumnShipped = "shipped";

        if (orderNumber != null)
        {
            try
            {
                msgString = ">> Establishing Driver...";
               //load JDBC driver class for MySQL
                Class.forName( "com.mysql.jdbc.Driver" );

                msgString = ">> Setting up URL...";
                //jTextArea3.append("\n"+msgString);

                //define the data source

                String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/orderinfo";

                msgString = ">> Establishing connection with: " + sourceURL + "...";
                //jTextArea3.append("\n"+msgString);

                //create a connection to the db - note the default account is remoteUserID
                //and the password is remoteUserPWD - you will have to set this
                //account up in your database

                DBConn = DriverManager.getConnection(sourceURL,remoteUserID,remoteUserPWD);

            } catch (Exception e) {

                errString =  "\nError connecting to orderinfo database\n" + e;
                //jTextArea3.append(errString);
                connectError = true;

            } // end try-catch

        } else {

            errString =  "\nMissing customer information!!!\n";
            //jTextArea3.append(errString);
            connectError = true;

        }// customer data check


        if (!connectError )
        {
            String existedOrderNumber=null;
            ResultSet res = null;               // SQL query result set pointer


             s = DBConn.createStatement();
            res = s.executeQuery( "SELECT ordertable FROM orders WHERE ordertable='"+orderNumber+"'");

                    while (res.next())
                    {
                       existedOrderNumber = res.getString(1);

                    } // while

            if(existedOrderNumber==null) return false;

             try
            {
                s = DBConn.createStatement();
                SQLstatement = ( "UPDATE " + orderTableName +" SET shipped=1 WHERE ordertable=\""+orderNumber+"\"");
                executeUpdateVal = s.executeUpdate(SQLstatement);
                 //userid=\""+UID+"\""
            }catch (Exception e) {

                errString =  "\nProblem updating shiping info " + orderTableName +":: " + e;
                executeError = true;

            }

        }
        return true;
    }
}