/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nUll
 */
public class TypeUserController {

    /**
     * get user by id
     *
     * @param id
     * @return
     */
    public static ArrayList<TypeUserModel> getTypes() {
        return getType(-1, "", -1);
    }

    public static ArrayList<TypeUserModel> getTypeByLike(String pattern) {
        return getType(Operation.SEARCH, pattern, -1);
    }

    public static TypeUserModel getTypeByID(int id) {
        return getType(-1, "", id).get(0);
    }

    private static ArrayList<TypeUserModel> getType(int operation, String pattern, int id) {

        ArrayList<TypeUserModel> list = null;
        try {
            list = new ArrayList<TypeUserModel>();
            String query = "";
            PreparedStatement ps = null;
            if (operation == -1 && pattern == "" && id == -1) {
                query = "SELECT * FROM usertype";
                ps = Store.crud.getCon().prepareStatement(query);
            } else if (id == -1) {
                query = "SELECT * FROM usertype WHERE name LIKE ? OR id LIKE ? ";
                ps = Store.crud.getCon().prepareStatement(query);

                ps.setString(1, "%" + pattern + "%");
                ps.setString(2, "%" + pattern + "%");

            } else if (id != -1) {
                query = "SELECT * FROM usertype WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);

                ps.setInt(1, id);

            }
            ResultSet result = ps.executeQuery();
            while (result.next()) {

                int returnID = Integer.parseInt(result.getString("id"));
                String name = result.getString("name");
                String frames = result.getString("frames");

                list.add(new TypeUserModel(returnID, name, frames));

            }
            Store.crud.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }

    }

    /**
     * update, insert, delete user by id
     *
     * @param userType
     * @p
     * @param userTypearam user
     * @param operation static field in UserModel class
     * @return
     */
    public static int setUpdateUser(TypeUserModel userType, int operation) {

        int affected = -1;
        try {
            String query = "";
            PreparedStatement ps = null;

            if (operation == Operation.UPDATE) {
                query += "UPDATE usertype SET name=?, frames=? WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, userType.getName());
                ps.setString(2, userType.getFrames());
                ps.setInt(3, userType.getId());

            } else if (operation == Operation.INSERT) {
                query += "INSERT INTO usertype (name,frames)  VALUES(?,?)";
                ps = Store.crud.getCon().prepareStatement(query);

                ps.setString(1, userType.getName());
                ps.setString(2, userType.getFrames());

            } else if (operation == Operation.DELETE) {
                query += "DELETE FROM  usertype  WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);

                ps.setInt(1, userType.getId());
            } else {
                return affected;
            }

            affected = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return affected;
    }

}
