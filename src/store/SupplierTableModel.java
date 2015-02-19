/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.ArrayList;
import pkgnull.framework.GenericTableModel;

/**
 *
 * @author null
 */
public class SupplierTableModel extends GenericTableModel<SupplierModel> {

    public SupplierTableModel(ArrayList<SupplierModel> genericList) {
        super(genericList, new String[]{"id", "name", "phone", "email"}, 
                new Class[]{int.class, String.class, String.class, String.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SupplierModel sup = getGenericList().get(rowIndex);
        if (0 == columnIndex) {
            return sup.getId();
        } else if (1 == columnIndex) {
            return sup.getName();
        } else if (2 == columnIndex) {
            return sup.getPhone();
        } else if (3 == columnIndex) {
            return sup.getEmail();
        }
        return null;
    }

}
