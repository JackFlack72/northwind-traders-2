package com.northwind.model;

public class Product {
    private int productId;
    private String productName;
    private String supplierId;
    private String categoryId;
    private String quantityPerUnit;
    private String unitPrice;
    private String unitsInStock;
    private String unitsOnOrder;
    private String reorderLevel;
    private String discontinued;

    public Product(int productId, String productName, String supplierId, String categoryId, String quantityPerUnit, String unitPrice, String unitsInStock, String unitsOnOrder, String reorderLevel, String discontinued) {
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getUnitsInStock() {
        return unitsInStock;
    }

    public String getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public String getReorderLevel() {
        return reorderLevel;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setUnitsInStock(String unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public void setUnitsOnOrder(String unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public void setReorderLevel(String reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public String toString() {
        return "\n Products: \n" +
                " productId = " + productId + '\n' +
                " productName = " + productName + '\n' +
                " supplierID = " + supplierId + '\n' +
                " categoryId = " + categoryId + '\n' +
                " quantityPerUnit = " + quantityPerUnit + '\n' +
                " unitPrice = " + unitPrice + '\n' +
                " unitsInStock = " + unitsInStock + '\n' +
                " unitsOnOrder = " + unitsOnOrder + '\n' +
                " reorderLevel = " + reorderLevel + '\n' +
                " discontinued = " + discontinued + '\n';
    }

}