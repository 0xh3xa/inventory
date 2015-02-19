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
 * @author nUll
 */
public class CityController {

    public static ArrayList<CityModel> getAllCity() {
        return getCity(-1, "", -1);
    }

    public static ArrayList<CityModel> getAllCityByID(int id) {
        return getCity(-1, "", id);
    }

    public static ArrayList<CityModel> getAllCityByLike(int operation, String pattern) {
        return getCity(operation, pattern, -1);
    }

    private static ArrayList<CityModel> getCity(int operation, String pattern, int id) {

        ArrayList<CityModel> list = null;
        try {
            list = new ArrayList<>();
            String query = "";
            PreparedStatement ps = null;
            if (operation == -1 && pattern == "" && id == -1) {
                query = "SELECT * FROM city";
                ps = Store.crud.getCon().prepareStatement(query);
            } else if (id == -1) {
                query = "SELECT * FROM city WHERE name LIKE ? OR id LIKE ?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, "%" + pattern + "%");
                ps.setString(2, "%" + pattern + "%");

            } else if (id != -1) {
                query = "SELECT * FROM city WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, id);

            }

            ResultSet result = ps.executeQuery();
            while (result.next()) {

                int returnID = Integer.parseInt(result.getString("id"));
                String name = result.getString("name");
                list.add(new CityModel(returnID, name));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                Store.crud.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
            }

            return list;
        }
    }

    /**
     * update, insert, delete user by id
     *
     * @param user
     * @param operation static field in UserModel class
     * @return
     */
    public static int setUpdateCity(int operation, CityModel city) {

        int affected = -1;
        try {
            String query = "";
            PreparedStatement ps = null;
            if (operation == Operation.UPDATE) {
                query = "UPDATE city SET name=? WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, city.getName());
                ps.setInt(2, city.getId());
            } else if (operation == Operation.INSERT) {
                query = "INSERT INTO city (name)  VALUES(?)";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, city.getName());
            } else if (operation == Operation.DELETE) {
                query = "DELETE FROM  city  WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, city.getId());
            }

            affected = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return affected;
        }
    }

}
