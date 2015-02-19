/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author null
 */
public class SupplierController {

    public static ArrayList<SupplierModel> getAllSupplier() {
        return getAllSupplier(-1, "", -1);
    }

    public static ArrayList<SupplierModel> getAllSupplierByLike(String pattern) {
        return getAllSupplier(Operation.SEARCH, pattern, -1);
    }

    public static ArrayList<SupplierModel> getAllSupplierById(int id) {
        return getAllSupplier(-1, "", id);
    }

    public static ArrayList<SupplierModel> getAllSupplier(int operation, String pattern, int id) {
        ArrayList<SupplierModel> list = null;

        try {

            String query = "";
            PreparedStatement ps = null;
            if (operation == -1 && pattern.isEmpty() && id == -1) {
                query = "SELECT * FROM supplier";
                ps = Store.crud.getCon().prepareStatement(query);
            } else if (id == -1) {
                query = "SELECT * FROM supplier WHERE name LIKE ? OR id LIKE ?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, "%" + pattern + "%");
                ps.setString(2, "%" + pattern + "%");

            } else if (id != -1) {
                query = "SELECT * FROM supplier WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, id);

            }

            ResultSet result = ps.executeQuery();

            list = new ArrayList<>();
            while (result.next()) {
                int supID = Integer.parseInt(result.getString("id"));
                String name = result.getString("name");
                String phone = result.getString("phone");
                String email = result.getString("email");

                list.add(new SupplierModel(supID, name, phone, email));
            }

        } catch (Exception ex) {
            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Store.crud.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;

        }
    }

    public static int setUpdate(int operation, SupplierModel supplier) {
        int result = -1;

        try {
            String query = "";
            PreparedStatement ps = null;
            if (operation == Operation.INSERT) {
                query = "INSERT INTO supplier (name,phone,email) VALUES(?,?,?)";

                ps = Store.crud.getCon().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, supplier.getName());
                ps.setString(2, supplier.getPhone());
                ps.setString(3, supplier.getEmail());

            } else if (operation == Operation.UPDATE) {
                query = "UPDATE supplier SET name=?,phone=?,email=? WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, supplier.getName());
                ps.setString(2, supplier.getPhone());
                ps.setString(3, supplier.getEmail());
                ps.setInt(4, supplier.getId());

            } else if (operation == Operation.DELETE) {
                query = "DELETE FROM supplier WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, supplier.getId());

            }
            result = ps.executeUpdate();
            if (operation == Operation.INSERT) {
                
                ResultSet executeQuery = ps.executeQuery("SELECT MAX(id) AS id FROM supplier");
                while (executeQuery.next()) {
                    
                    supplier.setId(Integer.parseInt(executeQuery.getString("id")));
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return result;
        }
    }

}
