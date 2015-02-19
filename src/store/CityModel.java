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
public class CityModel {

    private int id;
    private String name;

    public CityModel() {
    }

    public CityModel(int id) {
        this.id = id;
    }

    public CityModel(String name) {

        this.name = name;
    }

    public CityModel(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        CityModel city = (CityModel) obj;
        if (city.id == this.id) {
            return true;
        }

        return false;
    }

}
