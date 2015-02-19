/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author null
 */
public class OrderController {

    public static ArrayList<OrderModel> getAllOrder() {

        return getOrders(-1, "", -1);

    }

    public static OrderModel getAllOrderByID(int id) {

        return getOrders(Operation.SEARCH, "", id).get(0);

    }

    public static ArrayList<OrderModel> getAllOrderByLike(String pattern) {

        return getOrders(Operation.SEARCH, pattern, -1);
    }

    private static ArrayList<OrderModel> getOrders(int operation, String pattern, int id) {
        ArrayList<OrderModel> list = null;
        ArrayList<ProductModel> pList = null;
        try {
            list = new ArrayList<>();
            pList = new ArrayList<>();
            String query = "";
            PreparedStatement ps = null;
            //get all orders and it's relations
            if (operation == -1 && pattern == "" && id == -1) {
                query = "SELECT * "
                        + "FROM orderT as ot,sub_order as so,branch as br,city as ci,supplier as sup,product as pr,sub_invoice as si,invoice as inv,catogery as ca "
                        + "WHERE ("
                        + "so.order_id=ot.id "
                        + "AND so.product_id=pr.id "
                        + "AND so.branch_id=br.id "
                        + "AND pr.catogery_id=ca.id "
                        + "AND pr.supplier_id=sup.id "
                        + "AND si.product_id=pr.id "
                        + "AND si.invoice_id=inv.id "
                        + "AND br.city_id=ci.id "
                        + "AND br.supplier_id=sup.id "
                        + "AND ot.supplier_id=sup.id"
                        + ")";

                ps = Store.crud.getCon().prepareStatement(query);

            } else if (id == -1) {//get order by pattern
                query = "SELECT * "
                        + "FROM orderT as ot,sub_order as so,branch as br,city as ci,supplier as sup,product as pr,sub_invoice as si,invoice as inv,catogery as ca "
                        + "WHERE "
                        + "(so.order_id=ot.id "
                        + "AND so.product_id=pr.id "
                        + "AND so.branch_id=br.id "
                        + "AND pr.catogery_id=ca.id "
                        + "AND pr.supplier_id=sup.id "
                        + "AND si.product_id=pr.id "
                        + "AND si.invoice_id=inv.id "
                        + "AND br.city_id=ci.id "
                        + "AND br.supplier_id=sup.id "
                        + "AND ot.supplier_id=sup.id) "
                        + "AND ot.id LIKE ? OR ot.name=?";

                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, "%" + pattern + "%");
                ps.setString(2, "%" + pattern + "%");

            } else if (id != -1) {//get order by id
                query = "SELECT * "
                        + "FROM orderT as ot,sub_order as so,branch as br,city as ci,supplier as sup,product as pr,sub_invoice as si,invoice as inv,catogery as ca "
                        + "WHERE ("
                        + "so.order_id=ot.id "
                        + "AND so.product_id=pr.id "
                        + "AND so.branch_id=br.id "
                        + "AND pr.catogery_id=ca.id "
                        + "AND pr.supplier_id=sup.id "
                        + "AND si.product_id=pr.id "
                        + "AND si.invoice_id=inv.id "
                        + "AND br.city_id=ci.id "
                        + "AND br.supplier_id=sup.id "
                        + "AND ot.supplier_id=sup.id"
                        + ")"
                        + " AND order.id = ?";

                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, id);
            }

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                //supplier obj.
                int supID = Integer.parseInt(result.getString("sup.id"));
                String supName = result.getString("sup.name");
                String supPhone = result.getString("sup.phone");
                String supEmail = result.getString("sup.email");
                SupplierModel supplier = new SupplierModel(id, supName, supPhone, supEmail);
                //city obj.
                int ciID = Integer.parseInt(result.getString("ci.id"));
                String ciName = result.getString("ci.name");
                CityModel city = new CityModel(ciID, ciName);

                //branch obj.
                int brID = Integer.parseInt(result.getString("br.id"));
                String brName = result.getString("br.name");
                String brAddress = result.getString("br.name");
                BranchModel branch = new BranchModel(brID, supplier, city, brName, brAddress);

                //cat obj
                int caID = Integer.parseInt(result.getString("ca.id"));
                String caName = result.getString("ca.name");
                CatogeryModel catogery = new CatogeryModel(id, caName);

                //product obj
                int prID = Integer.parseInt(result.getString("pr.id"));
                String prName = result.getString("pr.name");
                int prQuantity = Integer.parseInt(result.getString("pr.quantity"));
                double prPrice = Double.parseDouble(result.getString("pr.price"));
                double prDisPrice = Double.parseDouble(result.getString("pr.dis_price"));
                ProductModel product = new ProductModel(prID, prName, supplier, catogery, prQuantity);
                ProductModel.Price price = product.new Price(prPrice, prDisPrice);
                product.setPrice(price);
                pList.add(product);
                //order obj.
                int orID = Integer.parseInt(result.getString("ot.id"));
                String orName = result.getString("ot.name");
                double orTotalPrice = Double.parseDouble(result.getString("ot.total_price"));

                Date orDate = result.getDate("ot.date");

                OrderModel order = new OrderModel(orID, supplier, orName, orTotalPrice, orDate);

                //sub-order obj
                int suID = Integer.parseInt(result.getString("so.id"));
                int suQuantity = Integer.parseInt(result.getString("so.quantity"));
                double suPriceItem = Double.parseDouble(result.getString("so.price_item"));
                OrderModel.SubOrderModel subOrder = order.new SubOrderModel(suID, order, branch, product, suQuantity);
                order.setSubOrder(subOrder);
                list.add(order);
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Store.crud.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
    }

    public static int setUpdate(int operation, OrderModel order) {

        PreparedStatement ps = null;
        String query = "";
        int result = -1;

        try {
            if (operation == Operation.INSERT) {
                if (order.isIsNew()) {//add only orderT table.
                    query = "INSERT INTO orderT (supplier_id,name,total_price,date) VALUES(?,?,?,?);";
                    ps = Store.crud.getCon().prepareStatement(query.toString());
                    ps.setInt(1, order.getSupplier().getId());
                    ps.setString(2, order.getName());
                    ps.setDouble(3, order.getTotalPrice());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(order.getDate());
                    ps.setString(4, date);
                    ps.executeUpdate();

                } else {//add suborder obj.
                    query = "INSERT INTO sub_order (order_id,product_id,branch_id,quantity,price_item) VALUES(?,?,?,?,?)";
                    ps = Store.crud.getCon().prepareStatement(query);
                    ps.setInt(1, order.getId());
                    ps.setInt(2, order.getSubOrder().getLastProductModel().getId());
                    ps.setInt(3, order.getSubOrder().getBranch().getId());
                    ps.setInt(4, order.getSubOrder().getQuantity());
                    ps.setDouble(5, order.getSubOrder().getLastProductModel().getPrice().getOrgPrice());

                }
            } else if (operation == Operation.UPDATE) {
                query = "UPDATE orderT SET supplier_id=?,name=?,total_price=?,date=?"
                        + "WHERE orderT.id=? ";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, order.getSupplier().getId());
                ps.setString(2, order.getName());
                ps.setDouble(3, order.getTotalPrice());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                String date = sdf.format(order.getDate());
                ps.setString(4, date);
                ps.setInt(5, order.getId());
                if (order.getSubOrder() != null) {
                    query = "UPDATE sub_order SET branch_id=?,order_id=?,product_id=?,quantity=?,price_item=?"
                            + "WHERE id=?";
                    ps = Store.crud.getCon().prepareStatement(query);
                    ps.setInt(1, order.getSubOrder().getBranch().getId());
                    ps.setInt(2, order.getId());
                    ps.setInt(3, order.getSubOrder().getLastProductModel().getId());
                    ps.setInt(4, order.getSubOrder().getQuantity());
                    ps.setDouble(5, order.getSubOrder().getLastProductModel().getPrice().getOrgPrice());
                    ps.setInt(6, order.getSubOrder().getId());

                }
            } else if (operation == Operation.DELETE) {

                query = "DELETE FROM sub_order WHERE order_id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, order.getId());
                ps.executeUpdate();

                if (order.isIsNew()) {
                    query = "DELETE FROM orderT WHERE id=?";
                    ps = Store.crud.getCon().prepareStatement(query);
                    ps.setInt(1, order.getId());
                    result = ps.executeUpdate();
                }
                return result;

            }

            result = ps.executeUpdate();
            if (operation == Operation.INSERT) {
                if (order.isIsNew()) {
                    query = "SELECT MAX(id) AS id FROM orderT";
                    ResultSet executeQuery = ps.executeQuery(query);
                    executeQuery.next();
                    order.setId(Integer.parseInt(executeQuery.getString("id")));
                } else {
                    query = "UPDATE orderT SET total_price=? WHERE id=?";
                    ps = Store.crud.getCon().prepareStatement(query);
                    ps.setDouble(1, order.getTotalPrice());
                    ps.setInt(2, order.getId());
                    result = ps.executeUpdate();
                    query = "SELECT MAX(id) AS id FROM sub_order";
                    ResultSet executeQuery = ps.executeQuery(query);
                    executeQuery.next();
                    order.getSubOrder().setId(Integer.parseInt(executeQuery.getString("id")));
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return result;
        }
    }
}
