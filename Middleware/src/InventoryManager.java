/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Vector;

public class InventoryManager {

    DBManager dbManager = new DBManager();

    public Vector<String> getShrubs()
    {
       return dbManager.getShrubs();
    }

    public Vector<String> getSeeds()
    {
       return dbManager.getSeed();
    }

    public Vector<String> getTrees()
    {
        return dbManager.getTree();
    }
}
