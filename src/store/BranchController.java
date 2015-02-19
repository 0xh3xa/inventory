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
public class BranchController {
    
    public static ArrayList<BranchModel> getAllBranch(SupplierModel supplier) {
        return getAllBranch(-1, "", -1, supplier);
    }
    
    public static ArrayList<BranchModel> getAllBranchByID(int id, SupplierModel supplier) {
        return getAllBranch(-1, "", id, supplier);
        
    }
    
    public static ArrayList<BranchModel> getAllBranchByLike(String pattern, SupplierModel supplier) {
        return getAllBranch(Operation.SEARCH, pattern, -1, supplier);
        
    }
    
    private static ArrayList<BranchModel> getAllBranch(int operation, String pattern, int id, SupplierModel... supplier) {
        
        ArrayList<BranchModel> branchList = null;
        ResultSet result = null;
        String query = "";
        PreparedStatement ps = null;
        
        try {
            branchList = new ArrayList<BranchModel>();
            
            if (operation == -1 && pattern == "" && id == -1) {
                query = "SELECT * FROM branch,city,supplier WHERE branch.city_id=city.id AND supplier_id=supplier.id AND supplier_id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, supplier[0].getId());
            } else if (id == -1) {
                query = "SELECT * FROM branch,city,supplier WHERE (branch.id LIKE ? OR branch.name LIKE ?) AND city_id=city.id AND supplier_id=supplier.id ";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, "%" + pattern + "%");
                ps.setString(2, "%" + pattern + "%");                
                
            } else if (id != -1) {
                query = "SELECT * FROM branch,city,supplier WHERE branch.id=?  AND branch.city_id=city.id AND supplier.id=? LIMIT 1";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, id);
                ps.setInt(2, supplier[0].getId());
                
            }
            result = ps.executeQuery();
            while (result.next()) {
                
                int returnID = Integer.parseInt(result.getString("id"));
                String name = result.getString("name");
                String address = result.getString("address");
                
                int cityID = Integer.parseInt(result.getString("city.id"));
                String cityName = result.getString("city.name");
                CityModel city = new CityModel(cityID, cityName);
                
                int supID = Integer.parseInt(result.getString("supplier.id"));
                String supName = result.getString("supplier.name");
                String supPhone = result.getString("supplier.phone");
                String supEmail = result.getString("supplier.email");
                
                branchList.add(new BranchModel(returnID, supplier[0], city, name, address));
                
            }
            supplier[0].setBranchList(branchList);
            
            Store.crud.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                Store.crud.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(BranchController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return branchList;
        }
        
    }

    /**
     * update, insert, delete user by id
     *
     * @param user
     * @param operation static field in UserModel class
     * @return
     */
    public static int setUpdateBranch(int operation, BranchModel branch) {
        
        int affected = -1;
        try {
            String query = "";
            PreparedStatement ps = null;
            if (operation == Operation.UPDATE) {
                query = "UPDATE branch SET name=?, address=? , supplier_id=?,city_id=? WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, branch.getName());
                ps.setString(2, branch.getAddress());
                ps.setInt(3, branch.getSupplier().getId());
                ps.setInt(4, branch.getCity().getId());
                ps.setInt(5, branch.getId());
                
            } else if (Operation.INSERT == operation) {
                query = "INSERT INTO branch (name,address,supplier_id,city_id) VALUES(?,?,?,?)";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setString(1, branch.getName());
                ps.setString(2, branch.getAddress());
                ps.setInt(3, branch.getSupplier().getId());
                ps.setInt(4, branch.getCity().getId());
                
            } else if (Operation.DELETE == operation) {
                query = "DELETE FROM  branch  WHERE id=?";
                ps = Store.crud.getCon().prepareStatement(query);
                ps.setInt(1, branch.getId());
                
            }
            
            affected = ps.executeUpdate();
            if (operation == Operation.INSERT) {
                ResultSet executeQuery = ps.executeQuery("SELECT MAX(id) AS id FROM branch");
                executeQuery.next();
                branch.setId(Integer.parseInt(executeQuery.getString("id")));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return affected;
        }
    }
    
}
