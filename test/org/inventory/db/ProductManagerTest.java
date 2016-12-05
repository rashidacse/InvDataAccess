/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inventory.db;

import com.inventory.bean.ProductCategoryInfo;
import com.inventory.bean.ProductInfo;
import com.inventory.bean.ProductTypeInfo;
import com.inventory.bean.UOMInfo;
import com.inventory.db.manager.ProductManager;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sampanit
 */
public class ProductManagerTest {

    final static ProductManager productManager = new ProductManager();

    public ProductManagerTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//      @Test
    public void createProductTest() {
        ProductInfo productInfo1 = new ProductInfo();
        productInfo1.setName("a2");
        productInfo1.setCode("b2");
        productInfo1.setLength("c2");
        productInfo1.setWidth("d2");
        productInfo1.setHeight("e2");
        productInfo1.setWeight("f2");
        productInfo1.setUnitPrice(200);
        productManager.createProduct(productInfo1);
    }
    //  @Test

    public void getProductListTest() {
        List<ProductInfo> productInfoList = productManager.getAllProducts();
        System.out.println(productInfoList);
    }

    // @Test
    public void getAllProductCategoriesTest() {
        List<ProductCategoryInfo> productCategoryInfoList = productManager.getAllProductCategories();
        System.out.println(productCategoryInfoList);
    }

    // @Test
    public void getAllProductTypesTest() {
        List<ProductTypeInfo> productTypeInfoList = productManager.getAllProductTypes();
        System.out.println(productTypeInfoList);
    }

    //@Test
    public void getAllUOMsTest() {
        List<UOMInfo> uOMInfoList = productManager.getAllUOMs();
        System.out.println(uOMInfoList);
    }

//    @Test
    public void getProductInfoTest() {
        productManager.getProductInfo(1);
    }

    @Test
    public void getProductInfosTest() {
        productManager.getProductsInfoByName("a");
    }

//    @Test
    public void updateProductTest() {
        ProductInfo productInfo1 = new ProductInfo();
        productInfo1.setId(1);
        productInfo1.setName("uu2");
        productInfo1.setCode("u1u");
        productInfo1.setLength("uu2");
        productInfo1.setWidth("u2u");
        productInfo1.setHeight("u2u");
        productInfo1.setWeight("u2u");
        productInfo1.setUnitPrice(500);
        productManager.updateProduct(productInfo1);

    }

}
