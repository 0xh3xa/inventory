/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author nUll
 */
public class SupplierModel {

    private int id;
    private String name;
    private String phone;
    private String email;
    private ArrayList<BranchModel> list = new ArrayList<BranchModel>();

    public SupplierModel() {
    }

    public SupplierModel(int id, String name, ArrayList<BranchModel> list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public SupplierModel(String name, String phone, String email, ArrayList<BranchModel> list) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.list = list;
    }

    public SupplierModel(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {

        SupplierModel supplier = (SupplierModel) obj;
        if (this.id == supplier.id) {
            return true;
        }

        return false;
    }

    /**
     * @return the list
     */
    public ArrayList<BranchModel> getBranchList() {
       
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setBranchList(ArrayList<BranchModel> list) {
        this.list = list;
    }

}
