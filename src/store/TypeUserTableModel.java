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
public class TypeUserTableModel extends GenericTableModel<TypeUserModel> {

    public TypeUserTableModel(ArrayList<TypeUserModel> userTypeLsist) {
        super(userTypeLsist,
                new String[]{"id", "type", "frames"},
                new Class[]{Integer.class, String.class, String.class});
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        TypeUserModel userType = getGenericList().get(rowIndex);
        if (0 == columnIndex) {
            return userType.getId()+"";
        } else if (1 == columnIndex) {
            return userType.getName();
        } else if (2 == columnIndex) {
            return userType.getFrames();
        }

        return null;
    }

}
