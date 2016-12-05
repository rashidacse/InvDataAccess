/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.db.repositories;

import com.inventory.bean.ProductCategoryInfo;
import com.inventory.bean.ProductInfo;
import com.inventory.bean.ProductTypeInfo;
import com.inventory.bean.UOMInfo;
import com.inventory.db.query.helper.Constant;
import com.inventory.db.query.helper.QueryField;
import com.inventory.db.query.helper.QueryManager;
import com.inventory.db.query.helper.EasyStatement;
import com.inventory.exceptions.DBSetupException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nazmul hasan
 */
public class Product {

    private Connection connection;

    /**
     * *
     * Restrict to call without connection
     */
    private Product() {
    }

    public Product(Connection connection) {
        this.connection = connection;
    }

    public List<ProductCategoryInfo> getAllProductCategories() throws DBSetupException, SQLException {
        List<ProductCategoryInfo> productCategoryList = new ArrayList<>();
        try (EasyStatement stmt = new EasyStatement(connection, QueryManager.GET_ALL_PRODUCT_CATEGORIES)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProductCategoryInfo productCategoryInfo = new ProductCategoryInfo();
                productCategoryInfo.setId(rs.getInt(QueryField.ID));
                productCategoryInfo.setTitle(rs.getString(QueryField.TITLE));
                productCategoryList.add(productCategoryInfo);
            }
        }
        return productCategoryList;
    }

    public List<ProductTypeInfo> getAllProductTypes() throws DBSetupException, SQLException {
        List<ProductTypeInfo> productTypeList = new ArrayList<>();
        try (EasyStatement stmt = new EasyStatement(connection, QueryManager.GET_ALL_PRODUCT_TYPES)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProductTypeInfo productTypeInfo = new ProductTypeInfo();
                productTypeInfo.setId(rs.getInt(QueryField.ID));
                productTypeInfo.setTitle(rs.getString(QueryField.TITLE));
                productTypeList.add(productTypeInfo);
            }
        }
        return productTypeList;
    }

    public List<UOMInfo> getAllUOMs() throws DBSetupException, SQLException {
        List<UOMInfo> uomList = new ArrayList<>();
        try (EasyStatement stmt = new EasyStatement(connection, QueryManager.GET_ALL_UOMS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UOMInfo uomInfo = new UOMInfo();
                uomInfo.setId(rs.getInt(QueryField.ID));
                uomInfo.setTitle(rs.getString(QueryField.TITLE));
                uomList.add(uomInfo);
            }
        }
        return uomList;
    }

    public void createProduct(ProductInfo productInfo) throws DBSetupException, SQLException {

        try (EasyStatement stmt = new EasyStatement(connection, QueryManager.CREATE_PRODUCT)) {
            //add some validation. If the values are not set then assign nulll instead of zero
            stmt.setInt(QueryField.CATEGORY_ID, productInfo.getProductCategoryInfo().getId());
            stmt.setInt(QueryField.TYPE_ID, productInfo.getProductTypeInfo().getId());
            stmt.setInt(QueryField.STANDARD_UOM_ID, productInfo.getStandardUOM().getId());
            stmt.setInt(QueryField.SALE_UOM_ID, productInfo.getSaleUOM().getId());
            stmt.setInt(QueryField.PURCHASE_UOM_ID, productInfo.getPurchasingUOM().getId());

            stmt.setString(QueryField.NAME, productInfo.getName());
            stmt.setString(QueryField.CODE, productInfo.getCode());
            stmt.setString(QueryField.LENGTH, productInfo.getLength());
            stmt.setString(QueryField.WIDTH, productInfo.getWidth());
            stmt.setString(QueryField.HEIGHT, productInfo.getHeight());
            stmt.setString(QueryField.WEIGHT, productInfo.getWeight());
            stmt.setDouble(QueryField.UNIT_PRICE, productInfo.getUnitPrice());
            stmt.executeUpdate();
        }
    }

    public void updateProduct(ProductInfo productInfo) throws DBSetupException, SQLException {

        try (EasyStatement stmt = new EasyStatement(connection, QueryManager.UPDATE_PRODUCT_INFO)) {
            stmt.setInt(QueryField.ID, productInfo.getId());
            stmt.setInt(QueryField.CATEGORY_ID, productInfo.getProductCategoryInfo().getId());
            stmt.setInt(QueryField.TYPE_ID, productInfo.getProductTypeInfo().getId());
            stmt.setString(QueryField.NAME, productInfo.getName());
            stmt.setString(QueryField.CODE, productInfo.getCode());
            stmt.setString(QueryField.LENGTH, productInfo.getLength());
            stmt.setString(QueryField.WIDTH, productInfo.getWidth());
            stmt.setString(QueryField.HEIGHT, productInfo.getHeight());
            stmt.setString(QueryField.WEIGHT, productInfo.getWeight());
            stmt.setDouble(QueryField.UNIT_PRICE, productInfo.getUnitPrice());
            stmt.executeUpdate();
        }
    }

    public void updateProductStatus(int productId) throws DBSetupException, SQLException {
        try (EasyStatement stmt = new EasyStatement(connection, QueryManager.UPDATE_PRODUCT_STATUS)) {
            stmt.setInt(QueryField.ID, productId);
            stmt.setBoolean(QueryField.STATUS_ID, Constant.STATUS_TYPE_INACTIVE);
            stmt.executeUpdate();
        }
    }

    public List<ProductInfo> getAllProducts() throws DBSetupException, SQLException {
        List<ProductInfo> productList = new ArrayList<>();
        try (EasyStatement stmt = new EasyStatement(connection, QueryManager.GET_ALL_PRODUCTS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProductInfo productInfo = new ProductInfo();
                productInfo.setId(rs.getInt(QueryField.ID));
                productInfo.getProductCategoryInfo().setTitle(rs.getString(QueryField.PRODUCT_CATEGORY));
                productInfo.getProductTypeInfo().setTitle(rs.getString(QueryField.PRODUCT_TYPE));
                productInfo.setName(rs.getString(QueryField.NAME));
                productInfo.setCode(rs.getString(QueryField.CODE));
                productInfo.setLength(rs.getString(QueryField.LENGTH));
                productInfo.setWidth(rs.getString(QueryField.WIDTH));
                productInfo.setHeight(rs.getString(QueryField.HEIGHT));
                productInfo.setWeight(rs.getString(QueryField.WEIGHT));
                productInfo.setUnitPrice(rs.getDouble(QueryField.UNIT_PRICE));
                productList.add(productInfo);
            }
        }
        return productList;
    }

    public List<ProductInfo> getProductsInfoByNmae(String productName) throws DBSetupException, SQLException {
        List<ProductInfo> productList = new ArrayList<>();
        try (EasyStatement stmt = new EasyStatement(this.connection, QueryManager.GET_PRODUCT_INFO_BY_NAME);) {
            stmt.setString(QueryField.NAME, "%" + productName + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProductInfo productInfo = new ProductInfo();
                productInfo.setId(rs.getInt(QueryField.ID));
                productInfo.setName(rs.getString(QueryField.NAME));
                productInfo.setCode(rs.getString(QueryField.CODE));
                productInfo.setLength(rs.getString(QueryField.LENGTH));
                productInfo.setWidth(rs.getString(QueryField.WIDTH));
                productInfo.setHeight(rs.getString(QueryField.HEIGHT));
                productInfo.setWeight(rs.getString(QueryField.WEIGHT));
                productInfo.setUnitPrice(rs.getDouble(QueryField.UNIT_PRICE));
                productList.add(productInfo);
            }
        }
        return productList;
    }

    public ProductInfo getProductInfo(int productId) throws DBSetupException, SQLException {
        ProductInfo productInfo = new ProductInfo();
        try (EasyStatement stmt = new EasyStatement(this.connection, QueryManager.GET_PRODUCT_INFO);) {
            stmt.setInt(QueryField.ID, productId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                productInfo.setId(rs.getInt(QueryField.ID));
                productInfo.getProductCategoryInfo().setTitle(rs.getString(QueryField.PRODUCT_CATEGORY));
                productInfo.getProductTypeInfo().setTitle(rs.getString(QueryField.PRODUCT_TYPE));
                productInfo.setName(rs.getString(QueryField.NAME));
                productInfo.setCode(rs.getString(QueryField.CODE));
                productInfo.setLength(rs.getString(QueryField.LENGTH));
                productInfo.setWidth(rs.getString(QueryField.WIDTH));
                productInfo.setHeight(rs.getString(QueryField.HEIGHT));
                productInfo.setWeight(rs.getString(QueryField.WEIGHT));
                productInfo.setUnitPrice(rs.getDouble(QueryField.UNIT_PRICE));
            }
        }
        return productInfo;
    }

}
