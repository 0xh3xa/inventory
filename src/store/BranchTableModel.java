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
public class BranchTableModel extends GenericTableModel<BranchModel> {

    public BranchTableModel(ArrayList<BranchModel> arr) {
        super(arr, new String[]{"id", "name", "supplier", "city", "address"},
                new Class[]{Integer.class, String.class, String.class, String.class, String.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BranchModel branch = getGenericList().get(rowIndex);
        if (0 == columnIndex) {
            return branch.getId() + "";
        } else if (1 == columnIndex) {
            return branch.getName();
        } else if (2 == columnIndex) {
            return branch.getSupplier();
        } else if (3 == columnIndex) {
            return branch.getCity().getName();
        } else if (4 == columnIndex) {
            return branch.getAddress();
        }
        return null;
    }
}
