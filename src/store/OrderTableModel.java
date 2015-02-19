/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.ArrayList;
import java.util.Date;
import pkgnull.framework.GenericTableModel;

/**
 *
 * @author null
 */
public class OrderTableModel extends GenericTableModel<OrderModel> {

    public static class SubOrderTableModel extends GenericTableModel<OrderModel.SubOrderModel> {

        public SubOrderTableModel(ArrayList<OrderModel.SubOrderModel> arr) {
            super(arr,
                    new String[]{"id", "order", "product", "branch", "quantity", "item_price"},
                    new Class[]{int.class, OrderModel.class, ProductModel.class, BranchModel.class, int.class, double.class});
        }

        @Override
        public Object getValueAt(int row, int columnIndex) {
            OrderModel.SubOrderModel subOrder = getGenericList().get(row);
            if (0 == columnIndex) {
                return subOrder.getId();
            } else if (1 == columnIndex) {
                return subOrder.getOrderModel();
            } else if (2 == columnIndex) {
                return subOrder.getLastProductModel();
            } else if (3 == columnIndex) {
                return subOrder.getBranch();
            } else if (4 == columnIndex) {
                return subOrder.getQuantity();
            } else if (5 == columnIndex) {
                return subOrder.getLastProductModel().getPrice().getOrgPrice();
            }
            return null;

        }

    }

    public OrderTableModel(ArrayList<OrderModel> arr) {
        super(arr,
                new String[]{"id", "name", "Supplier", "date", "total_price"},
                new Class[]{int.class, String.class, SupplierModel.class, Date.class, double.class});
    }

    @Override
    public Object getValueAt(int row, int columnIndex) {
        OrderModel order = getGenericList().get(row);
        if (0 == columnIndex) {
            return order.getId();
        } else if (1 == columnIndex) {
            return order.getName();
        } else if (2 == columnIndex) {
            return order.getSupplier();
        } else if (3 == columnIndex) {
            return order.getDate();
        } else if (4 == columnIndex) {
            return order.getTotalPrice();
        }
        return null;

    }

}
