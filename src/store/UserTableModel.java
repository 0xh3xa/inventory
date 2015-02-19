/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.ArrayList;
import pkgnull.framework.*;

/**
 *
 * @author nUll
 */
public class UserTableModel extends GenericTableModel<UserModel> {

    public UserTableModel(ArrayList<UserModel> userList) {
        super(userList, new String[]{"id", "username", "user_type", "password", "phone", "email"},
                new Class[]{Integer.class, String.class, String.class,
                    String.class, String.class, String.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UserModel user = getGenericList().get(rowIndex);
        if (0 == columnIndex) {
            return user.getId()+"";
        } else if (1 == columnIndex) {
            return user.getUsername();
        } else if (2 == columnIndex) {
            return user.getType();
        } else if (3 == columnIndex) {
            return user.getPassword();
        } else if (4 == columnIndex) {
            return user.getPhone();
        } else if (5 == columnIndex) {
            return user.getMail();
        }

        return null;
    }

}
