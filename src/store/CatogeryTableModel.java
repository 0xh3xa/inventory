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
public class CatogeryTableModel extends GenericTableModel<CatogeryModel> {

    public CatogeryTableModel(ArrayList<CatogeryModel> genericList) {
        super(genericList, new String[]{"id", "name"}, new Class[]{int.class, String.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CatogeryModel cat = getGenericList().get(rowIndex);
        if (0 == columnIndex) {
            return cat.getId();
        } else if (1 == columnIndex) {
            return cat.getName();
        }
        return null;
    }

}
