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
public class ProductModel {

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

    public class Price {

        private double orgPrice;
        private double disPrice;

        public Price(double orgPrice, double disPrice) {
            this.orgPrice = orgPrice;
            this.disPrice = disPrice;
        }

        /**
         * @return the orgPrice
         */
        public double getOrgPrice() {
            return orgPrice;
        }

        /**
         * @param orgPrice the orgPrice to set
         */
        public void setOrgPrice(double orgPrice) {
            this.orgPrice = orgPrice;
        }

        /**
         * @return the disPrice
         */
        public double getDisPrice() {
            return disPrice;
        }

        /**
         * @param disPrice the disPrice to set
         */
        public void setDisPrice(double disPrice) {
            this.disPrice = disPrice;
        }

    }
    private int id;
    private SupplierModel supplier;
    private String name;
    private CatogeryModel cat;
    private int quantity;
    private Price price;

    public ProductModel() {

    }

    public ProductModel(String name, SupplierModel supplier, CatogeryModel cat, int quantity, Price price) {

        this.name = name;
        this.cat = cat;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;

    }

    public ProductModel(int id, String name, SupplierModel supplier, CatogeryModel cat, int quantity) {
        this.id = id;
        this.name = name;
        this.cat = cat;
        this.quantity = quantity;
        this.supplier = supplier;

    }

    public ProductModel(int id, String name, SupplierModel supplier,CatogeryModel cat, int quantity, Price price) {
        this.id = id;
        this.name = name;
        this.cat = cat;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
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
     * @return the cat
     */
    public CatogeryModel getCat() {
        return cat;
    }

    /**
     * @param cat the cat to set
     */
    public void setCat(CatogeryModel cat) {
        this.cat = cat;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;

    }

}
