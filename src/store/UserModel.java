/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

/**
 *
 * @author nUll
 */
public class UserModel {

    private int id;
    
    private String username;
    private String password;
    private String mail;
    private String phone;
    private TypeUserModel type;

    /**
     * empty constructor
     */
    public UserModel() {

    }

    /**
     * declare new user item with the args
     *
     * @param username
     * @param password
     */
    public UserModel(String username, String password) {

        this.username = username;
        this.password = password;

    }

    public UserModel(String username, String password, String mail, String phone, TypeUserModel type) {

        this.username = username;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.type = type;
    }

    public UserModel(int id, String username, String password, String mail, String phone, TypeUserModel type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.type = type;

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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
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
     * @return the type
     */
    public TypeUserModel getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeUserModel type) {
        this.type = type;
    }

}
