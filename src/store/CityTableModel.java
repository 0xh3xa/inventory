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
public class CityTableModel extends GenericTableModel<CityModel> {

    public CityTableModel(ArrayList<CityModel> arr) {
        super(arr, new String[]{"id", "name"},
                new Class[]{Integer.class, String.class});
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        CityModel city = getGenericList().get(rowIndex);
        if (0 == columnIndex) {
            return city.getId() + "";
        } else if (1 == columnIndex) {
            return city.getName();
        }
        return null;
    }
}
