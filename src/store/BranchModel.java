package store;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nUll
 */
@XmlRootElement(name = "BranchModel")
public class BranchModel {

    private int id;
    private String name;
    private SupplierModel supplier;
    private CityModel city;
    private String address;

    public BranchModel() {
    }

    public BranchModel(SupplierModel supplier, CityModel city, String name, String address) {
        this.name = name;
        this.address = address;
        this.supplier = supplier;
        this.city = city;
    }

    public BranchModel(int id, SupplierModel supplier, CityModel city, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.supplier = supplier;
        this.city = city;
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
     * @return the city_id
     */
    public CityModel getCity() {
        return city;
    }

    /**
     * @param city_id the city_id to set
     */
    public void setCity(CityModel city) {
        this.city = city;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return name;
    }

    /**
     * @return the supplier
     */
    public SupplierModel getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(SupplierModel supplier) {
        this.supplier = supplier;
    }

    boolean contains(String pattern) {
        return name.contains(pattern) || (id+"").contains(pattern);

    }

}
