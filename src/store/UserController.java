/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nUll
 */
public class UserController {
    
    public static final int START_TIME = 0;
    public static final int END_TIME = 1;
    
    public static void setLog(int userID, int timeType) throws Exception {
        
        GregorianCalendar gc = new GregorianCalendar();
        
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        
        Date dateObj = gc.getTime();
        String time = sdf.format(dateObj);
        String query = "";
        PreparedStatement ps = null;
        if (timeType == START_TIME) {
            
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(dateObj);
            
            query = "INSERT INTO log (start_time,date,user_id) VALUES(?,?,?)";
            ps = Store.crud.getCon().prepareStatement(query);
            ps.setString(1, time);
            ps.setString(2, date);
            ps.setInt(3, userID);
        } else if (timeType == END_TIME) {
            query = "UPDATE log SET end_time=? WHERE user_id=? AND end_time is null";
            ps = Store.crud.getCon().prepareStatement(query);
            ps.setString(1, time);
            ps.setInt(2, userID);
        }
        ps.executeUpdate();
    }
    
    public static UserModel checkUserLogin(String username, String password) {
        return getUser(-1, "", -1, username, password).get(0);
    }
    
    public static ArrayList<UserModel> getAllUser() {
        return getUser(-1, "", -1, "", "");
    }
    
    public static ArrayList<UserModel> getUserByLike(String pattern) {
        return getUser(Operation.SEARCH, pattern, -1, "", "");
    }
    
    public static ArrayList<UserModel> getUserByID(int id) {
        return getUser(-1, "", id, "", "");
    }
    
    private static ArrayList<UserModel> getUser(int operation, String pattern, int id, String username, String password) {
        
        ArrayList<UserModel> list = null;
        try {
            list = new ArrayList<>();
            String query = "";
            PreparedStatement ps = null;
            
            if (operation == -1 && id == -1 && password == "" && username == "" && password == "") {
                query = "SELECT * FROM user";
                ps = Store.crud.getCon().prepareStatement(query);
                
            } else if (operation != -1) {
                query = "SELECT * FROM user WHERE username LIKE ? OR  id LIKE ?";
                ps = Store.crud.getCon().prepareStatement(query);
                
                ps.setString(1, "%" + pattern + "%");
                ps.setString(2, "%" + pattern + "%");
            } else if (operation == -1) {
                query = "SELECT * FROM user WHERE username=? AND password=? ";
                ps = Store.crud.getCon().prepareStatement(query);
                MessageDigest msg = MessageDigest.getInstance("md5");
                byte[] encPasswrod = msg.digest(password.getBytes());
                ps.setString(1, username);
                ps.setString(2, new String(encPasswrod));
                
            }
            
            ResultSet result = ps.executeQuery();
            int returnID = -1;
            while (result.next()) {
                
                returnID = Integer.parseInt(result.getString("id"));
                String returnUsername = result.getString("username");
                String returnPsassword = result.getString("password");
                String mail = result.getString("email");
                String phone = result.getString("phone");
                
                int typeID = Integer.parseInt(result.getString("usertype_id"));
                TypeUserModel typeUser = TypeUserController.getTypeByID(typeID);
                
                list.add(new UserModel(returnID, returnUsername, returnPsassword, mail, phone, typeUser));
                
            }
            if (operation == -1 && username != "") {
                setLog(id, END_TIME);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                Store.crud.closeConnection();
                
            } catch (Exception ex) {
                Logger.getLogger(UserController.class
                        .getName()).log(Level.SEVERE, null, ex);
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
    public static int setUpdateUser(UserModel user, int operation) {
        
        int affected = -1;
        try {
            String query = "";
            PreparedStatement ps = null;
            if (Operation.UPDATE == operation) {
                query = "UPDATE user SET username=?, password=?, email=?, phone=?,usertype_id=? WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getMail());
                ps.setString(4, user.getPhone());
                ps.setInt(5, user.getType().getId());
                ps.setInt(6, user.getId());
                
            } else if (Operation.INSERT == operation) {
                query = "INSERT INTO user (username,password,email,phone,usertype_id)  VALUES(?,?,?,?,?)";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getMail());
                ps.setString(4, user.getPhone());
                ps.setInt(5, user.getType().getId());
                
            } else if (Operation.DELETE == operation) {
                query = "DELETE FROM  user  WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, user.getId());
                
            }
            affected = ps.executeUpdate();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return affected;
        }
    }
    
}
