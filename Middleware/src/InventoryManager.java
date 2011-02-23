/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Vector;

public class InventoryManager {

    DBManager dbManager = new DBManager();

    public Vector<String> getShrubs(String UID, String pwd)
    {
            boolean result = Authentication.login(UID, pwd);
            if(result)
            {
                return dbManager.getShrubs();
            }
            else
            {
                return null;
            }
       
    }

    public Vector<String> getSeeds(String UID, String pwd)
    {
            boolean result = Authentication.login(UID, pwd);
            System.out.println("Result for getSeed Authentication = " + result);
            if(result)
            {
                return dbManager.getSeed();
            }
            else
            {
                return null;
            }
    }

    public Vector<String> getTrees(String UID, String pwd)
    {
            boolean result = false;
            try
            {
                result = Authentication.login(UID, pwd);
            }
            catch(Exception e)
            {
            }

            if(result)
            {
                return dbManager.getTree();
            }
            else
            {
                return null;
            }
    }
    
    public void addTree(String product_code, String product_description, Integer quantity,
               Float perUnitCost) 
    {
        dbManager.addTree(product_code, product_description, quantity, perUnitCost);
    }
    
    public void addShrub(String product_code, String product_description, Integer quantity,
            Float perUnitCost) 
    {
        dbManager.addShrubs(product_code, product_description, quantity, perUnitCost);
    }
    
    public void addSeed(String product_code, String product_description, Integer quantity,
            Float perUnitCost) 
    {
        dbManager.addSeed(product_code, product_description, quantity, perUnitCost);
    }
}
