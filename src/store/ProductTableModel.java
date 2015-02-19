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
public class ProductTableModel extends GenericTableModel<ProductModel> {

    public ProductTableModel(ArrayList<ProductModel> list) {
        super(list, new String[]{"id", "name", "supplier", "catogery", "quantity", "price", "discount_price"},
                new Class[]{int.class, String.class, String.class, String.class, String.class, String.class, double.class, double.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductModel product = getGenericList().get(rowIndex);
        if (0 == columnIndex) {
            return product.getId();
        } else if (1 == columnIndex) {
            return product.getName();
        } else if (2 == columnIndex) {
            return product.getSupplier();
        } else if (3 == columnIndex) {
            return product.getCat();
        } else if (4 == columnIndex) {
            return product.getQuantity();
        } else if (5 == columnIndex) {
            return product.getPrice().getOrgPrice();
        } else if (6 == columnIndex) {
            return product.getPrice().getDisPrice();
        }
        return null;
    }

}
