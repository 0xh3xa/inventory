/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import pkgnull.framework.CRUD;

public class Store {

    //declare member static to share obj for all program
    public static CRUD crud;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {   

            //changing apperach of program
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            //create obj form crud
            crud = new CRUD(Conf.DATABASE, Conf.mysqlUser, Conf.mysqlPassword);

            LoginDialog userLoginDialog = new LoginDialog(null, true);
            userLoginDialog.setVisible(true);
            if (userLoginDialog.isFinished()) {

                //show mainfram of program and send user obj to constructor
                MainFrame mainFram = new MainFrame(userLoginDialog.getUser());
                mainFram.setVisible(true);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
