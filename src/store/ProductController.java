/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author null
 */
public class ProductController {

    public static ArrayList<ProductModel> getAllproduct() {
        return getproduct(-1, "", -1, null);
    }

    public static ArrayList<ProductModel> getAllproduct(SupplierModel supplier) {
        return getproduct(-1, "", -1, supplier);
    }

    public static ArrayList<ProductModel> getAllproductByID(int id, SupplierModel supplier) {
        return getproduct(-1, "", id, supplier);
    }

    public static ArrayList<ProductModel> getAllproductByLike(int operation, String pattern) {
        return getproduct(operation, pattern, -1, null);
    }

    private static ArrayList<ProductModel> getproduct(int operation, String pattern, int id, SupplierModel supplier) {

        ArrayList<ProductModel> list = null;
        String query = "";
        PreparedStatement ps = null;
        try {
            list = new ArrayList<>();

            if (supplier == null) {
                if (operation == -1 && pattern == "" && id == -1) {
                    query = "SELECT * FROM product,supplier,catogery WHERE catogery_id=catogery.id AND supplier_id=supplier.id";
                    ps = Store.crud.getCon().prepareStatement(query);
                } else if (id == -1) {
                    query = "SELECT * FROM product,catogery,supplier WHERE (product.name LIKE ? OR product.id LIKE ? ) AND catogery_id=catogery.id AND supplier_id=supplier.id";
                    ps = Store.crud.getCon().prepareStatement(query);
                    ps.setString(1, "%" + pattern + "%");
                    ps.setString(2, "%" + pattern + "%");

                } else if (id != -1) {
                    query = "SELECT * FROM product,supplier,catogery WHERE product.id=? AND catogery_id=catogery.id AND supplier_id=supplier.id LIMIT 1";
                    ps = Store.crud.getCon().prepareStatement(query);
                    ps.setInt(1, id);

                }
            } else if (supplier != null) {
                query = "SELECT * FROM product,supplier,catogery WHERE catogery_id=catogery.id AND supplier_id=supplier.id AND supplier.id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, supplier.getId());
            }
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int returnID = Integer.parseInt(result.getString("product.id"));
                String name = result.getString("product.name");
                int quantity = Integer.parseInt(result.getString("quantity"));

                double orgPrice = Double.parseDouble(result.getString("price"));
                double disPrice = Double.parseDouble(result.getString("dis_price"));

                String catName = result.getString("catogery.name");
                int catID = Integer.parseInt(result.getString("catogery.id"));
                CatogeryModel cat = new CatogeryModel(catID, catName);

                int supID = Integer.parseInt(result.getString("supplier.id"));
                String supName = result.getString("supplier.name");
                String supPhone = result.getString("supplier.phone");
                String supEmail = result.getString("supplier.email");

                supplier = new SupplierModel(supID, supName, supPhone, supEmail);
                ProductModel product = new ProductModel(returnID, name, supplier, cat, quantity);
                product.setPrice(product.new Price(orgPrice, disPrice));
                list.add(product);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Store.crud.closeConnection();

            } catch (Exception ex) {
                Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;

        }
    }

    public static int setUpdate(int operation, ProductModel product) {
        int result = -1;
        try {
            String query = "";
            PreparedStatement ps = null;
            if (operation == Operation.INSERT) {
                query = "INSERT INTO product (name,quantity,supplier_id,catogery_id,price,dis_price) VALUES(?,?,?,?,?,?)";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, product.getName());
                ps.setInt(2, product.getQuantity());
                ps.setInt(3, product.getSupplier().getId());
                ps.setInt(4, product.getCat().getId());
                ps.setDouble(5, product.getPrice().getOrgPrice());
                ps.setDouble(6, product.getPrice().getDisPrice());

            } else if (operation == Operation.UPDATE) {
                
                query = "UPDATE product SET name=?,quantity=?,price=?,dis_price=?,supplier_id=?,catogery_id=? WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, product.getName());
                ps.setInt(2, product.getQuantity());
                ps.setDouble(3, product.getPrice().getOrgPrice());
                ps.setDouble(4, product.getPrice().getDisPrice());
                ps.setDouble(5, product.getSupplier().getId());
                ps.setDouble(6, product.getCat().getId());
                ps.setInt(7, product.getId());

            } else if (operation == Operation.DELETE) {
                query = "DELETE FROM product WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, product.getId());
            }
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
