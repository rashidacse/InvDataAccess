/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.db.manager;

import com.inventory.bean.ProductCategoryInfo;
import com.inventory.bean.ProductInfo;
import com.inventory.bean.ProductTypeInfo;
import com.inventory.bean.UOMInfo;
import com.inventory.db.Database;
import com.inventory.db.repositories.Product;
import com.inventory.exceptions.DBSetupException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nazmul hasan
 */
public class ProductManager {

    private Product product;
    private final Logger logger = LoggerFactory.getLogger(ProductManager.class);

    /**
     * This method will create a product
     *
     * @param productInfo, product info
     * @author nazmul hasan
     */
    public void createProduct(ProductInfo productInfo) {
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();

            product = new Product(connection);
            product.createProduct(productInfo);

            connection.close();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex1) {
                logger.error(ex1.getMessage());
            }
        } catch (DBSetupException ex) {
            logger.error(ex.getMessage());
        }
    }

    /**
     * This method will return all products
     *
     * @return List, product list
     * @author nazmul hasan
     */
    public List<ProductInfo> getAllProducts() {
        List<ProductInfo> productList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();

            product = new Product(connection);
            productList = product.getAllProducts();

            connection.close();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex1) {
                logger.error(ex1.getMessage());
            }
        } catch (DBSetupException ex) {
            logger.error(ex.getMessage());
        }
        return productList;
    }

    /**
     * This method will return all product categories
     *
     * @return List, product category list
     * @author nazmul hasan
     */
    public List<ProductCategoryInfo> getAllProductCategories() {
        List<ProductCategoryInfo> productCategoryList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();

            product = new Product(connection);
            productCategoryList = product.getAllProductCategories();

            connection.close();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex1) {
                logger.error(ex1.getMessage());
            }
        } catch (DBSetupException ex) {
            logger.error(ex.getMessage());
        }
        return productCategoryList;
    }

    /**
     * This method will return all product types
     *
     * @return List, product type list
     * @author nazmul hasan
     */
    public List<ProductTypeInfo> getAllProductTypes() {
        List<ProductTypeInfo> productTypeList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();

            product = new Product(connection);
            productTypeList = product.getAllProductTypes();

            connection.close();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex1) {
                logger.error(ex1.getMessage());
            }
        } catch (DBSetupException ex) {
            logger.error(ex.getMessage());
        }
        return productTypeList;
    }

    /**
     * This method will return all unit of measurements
     *
     * @return List, unit of measurement list
     * @author nazmul hasan
     */
    public List<UOMInfo> getAllUOMs() {
        List<UOMInfo> uomList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();

            product = new Product(connection);
            uomList = product.getAllUOMs();

            connection.close();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex1) {
                logger.error(ex1.getMessage());
            }
        } catch (DBSetupException ex) {
            logger.error(ex.getMessage());
        }
        return uomList;
    }

    public List<ProductInfo> getProductsInfoByName(String  productName) {
        Connection connection = null;
        List<ProductInfo> productList = new ArrayList<>();
        try {
            connection = Database.getInstance().getConnection();

            product = new Product(connection);
            productList = product.getProductsInfoByNmae(productName);
            connection.close();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex1) {
                logger.error(ex1.getMessage());
            }
        } catch (DBSetupException ex) {
            logger.error(ex.getMessage());
        }
        return productList;
    }
      public ProductInfo getProductInfo(int productId) {
        Connection connection = null;
        ProductInfo productInfo = new ProductInfo();
        try {
            connection = Database.getInstance().getConnection();

            product = new Product(connection);
            productInfo = product.getProductInfo(productId);
            connection.close();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex1) {
                logger.error(ex1.getMessage());
            }
        } catch (DBSetupException ex) {
            logger.error(ex.getMessage());
        }
        return productInfo;
    }
        public void updateProduct(ProductInfo productInfo) {
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();

            product = new Product(connection);
            product.updateProduct(productInfo);

            connection.close();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex1) {
                logger.error(ex1.getMessage());
            }
        } catch (DBSetupException ex) {
            logger.error(ex.getMessage());
        }
    }
  
      
}
