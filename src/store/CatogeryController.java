/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author null
 */
public class CatogeryController {

    public static ArrayList<CatogeryModel> getAllCat() {
        return getAllCat(-1, null);
    }

    public static ArrayList<CatogeryModel> getAllCat(int operation, String pattern) {

        ArrayList<CatogeryModel> list = null;
        try {
            list = new ArrayList<>();
            PreparedStatement ps = null;
            String query = null;
            if (operation == Operation.SEARCH) {
                query = "SELECT * FROM catogery WHERE Id LIKE ? OR name LIKE ?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, "%" + pattern + "%");
                ps.setString(2, "%" + pattern + "%");

            } else {
                query = "SELECT * FROM catogery";
                ps = Store.crud.getCon().prepareStatement(query);

            }
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = Integer.parseInt(result.getString("id"));
                String name = result.getString("name");
                list.add(new CatogeryModel(id, name));
            }
        } catch (Exception ex) {
            Logger.getLogger(CatogeryController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list;
        }

    }

    public static int setUpdate(CatogeryModel cat, int operation) throws SQLException {
        int result = -1;
        String query = "";
        PreparedStatement ps = null;
        if (operation == Operation.INSERT) {
            query = "INSERT INTO catogery (name) VALUES(?)";
            ps = Store.crud.getCon().prepareStatement(query);
            ps.setString(1, query);

        } else if (operation == Operation.UPDATE) {
            query = "UPDATE catogery set name=? WHERE id=?";
            ps = Store.crud.getCon().prepareStatement(query);
            ps.setString(1, cat.getName());
            ps.setInt(2, cat.getId());

        } else if (operation == Operation.DELETE) {
            query = "DELETE FROM catogery WHERE id=?";
            ps = Store.crud.getCon().prepareStatement(query);
            ps.setInt(1, cat.getId());

        }
        try {
            result = Store.crud.setUpdate(query);
        } catch (Exception ex) {
            Logger.getLogger(CatogeryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }
}
