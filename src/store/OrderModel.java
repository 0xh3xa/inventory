/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nUll
 */
public class OrderModel {

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

    /**
     * @return the isNew
     */
    public boolean isIsNew() {
        return isNew;
    }

    public class SubOrderModel {

        private int id;
        private OrderModel orderModel;
        private ArrayList<ProductModel> listProduct;
        private int quantity;
        private BranchModel branch;
        private ProductModel product;

        public SubOrderModel() {
            this.listProduct = new ArrayList<>();

        }

        public SubOrderModel(OrderModel orderModel, BranchModel branch, ProductModel productModel, int quantity) {
            this();
            this.branch = branch;
            this.listProduct.add(productModel);
            this.product = productModel;
            this.quantity = quantity;

            this.orderModel = orderModel;
            this.orderModel.setSubOrder(this);
            this.orderModel.isNew = false;
            this.orderModel.addTotalPrice(productModel.getPrice().getOrgPrice() * this.quantity);
            productModel.setQuantity(productModel.getQuantity() + this.quantity);
            ProductController.setUpdate(Operation.UPDATE, productModel);

        }

        SubOrderModel(int suID, OrderModel order, BranchModel branch, ProductModel product, int suQuantity) {
            this();
            this.id = suID;
            this.orderModel = order;
            this.branch = branch;
            this.listProduct.add(product);
            this.product = product;
            this.quantity = suQuantity;
            this.orderModel.setSubOrder(this);
            this.orderModel.isNew = false;
            this.orderModel.addTotalPrice(product.getPrice().getOrgPrice() * this.quantity);

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
         * @return the orderModel
         */
        public OrderModel getOrderModel() {
            return orderModel;
        }

        /**
         * @param orderModel the orderModel to set
         */
        public void setOrderModel(OrderModel orderModel) {
            this.orderModel = orderModel;
        }

        /**
         * @return the productModel
         */
        public ArrayList<ProductModel> getProducts() {
            return listProduct;
        }

        public ProductModel getLastProductModel() {
            return listProduct.get(listProduct.size() - 1);
        }

        public double getProductsPrice() {
            double total = -1;
            for (ProductModel product : listProduct) {
                total += product.getPrice().getOrgPrice();
            }
            return total;
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
            this.orderModel.totalPrice -= this.product.getPrice().getOrgPrice() * this.quantity;
        }

        /**
         * @return the branch
         */
        public BranchModel getBranch() {
            return branch;
        }

        /**
         * @param branch the branch to set
         */
        public void setBranch(BranchModel branch) {
            this.branch = branch;
        }

        void setProduct(ProductModel product) {
            this.product = product;
        }

        /**
         * @return the product
         */
        public ProductModel getProduct() {
            return product;
        }

    }

    private int id;
    private SupplierModel supplier;
    private String name;
    private double totalPrice = 0.0;
    private Date date;
    private SubOrderModel subOrder;
    private boolean isNew;

    public OrderModel() {
        isNew = true;
        this.subOrder = null;
    }

    public OrderModel(SupplierModel supplier, String name, double totalPrice, Date date, SubOrderModel subOrder) {
        this();
        this.supplier = supplier;
        this.name = name;
        this.totalPrice = totalPrice;
        this.date = date;
        this.subOrder = subOrder;
    }

    public OrderModel(SupplierModel supplier, String name, double totalPrice, Date date) {
        this();
        this.supplier = supplier;
        this.name = name;
        this.totalPrice = totalPrice;
        this.date = date;

    }

    public OrderModel(String name, double totalPrice, Date date) {
        this();
        this.name = name;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public OrderModel(int id, SupplierModel supplier, String name, double totalPrice, Date date) {
        this.id = id;
        this.supplier = supplier;
        this.name = name;
        this.totalPrice = totalPrice;
        this.date = date;

    }

    public OrderModel(int id, SupplierModel supplier, String name, double totalPrice, Date date, SubOrderModel subOrder) {
        this.id = id;
        this.supplier = supplier;
        this.name = name;
        this.totalPrice = totalPrice;
        this.date = date;
        this.subOrder = subOrder;

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
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the subOrder
     */
    public SubOrderModel getSubOrder() {
        if (subOrder == null) {
            return null;
        }
        return subOrder;
    }

    /**
     * @param subOrder the subOrder to set
     */
    public void setSubOrder(SubOrderModel subOrder) {
        this.subOrder = subOrder;
    }

    private void addTotalPrice(double totalPrice) {
        this.totalPrice += totalPrice;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

}
