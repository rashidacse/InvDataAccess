/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inventory.db;

import com.inventory.bean.ProductInfo;
import com.inventory.bean.SaleInfo;
import com.inventory.db.manager.SaleManager;
import java.util.ArrayList;
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
public class SaleManagerTest {

    final static SaleManager saleManager = new SaleManager();
    int customerUserId = 4646607;

    public SaleManagerTest() {

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

//     @Test
    public void addSaleOrderTest() {
        ProductInfo productInfo1 = new ProductInfo();
        productInfo1.setId(1);
        productInfo1.setUnitPrice(100);
        productInfo1.setQuantity(300);
        productInfo1.setDiscount(0);
        productInfo1.setPurchaseOrderNo("order1");

        List<ProductInfo> productList = new ArrayList<>();
        productList.add(productInfo1);

        SaleInfo saleInfo = new SaleInfo();
        saleInfo.setProductList(productList);
        saleInfo.setCustomerUserId(customerUserId);
        saleInfo.setOrderNo("order2");
        saleInfo.setStatusId(1);
        saleInfo.setRemarks("remarks2");
        saleInfo.setSaleDate(123);
        saleManager.addSaleOrder(saleInfo);

    }

//    @Test
    public void getAllSaleOrdersTest() {
        List<SaleInfo> saleInfoList = saleManager.getAllSaleOrders();
        System.out.println(saleInfoList);
    }
//    @Test

    public void getSaleOrderTest() {
        SaleInfo saleInfoInfo = saleManager.getSaleOrderInfo("order2");
        System.out.println(saleInfoInfo.getOrderNo());
    }

    @Test
    public void updateSaleOrderTest() {
        ProductInfo productInfo1 = new ProductInfo();
        productInfo1.setId(1);
        productInfo1.setUnitPrice(500);
        productInfo1.setQuantity(800);
        productInfo1.setDiscount(0);
        productInfo1.setPurchaseOrderNo("order1");

        List<ProductInfo> productList = new ArrayList<>();
        productList.add(productInfo1);

        SaleInfo saleInfo = new SaleInfo();
        saleInfo.setProductList(productList);
        saleInfo.setCustomerUserId(customerUserId);
        saleInfo.setOrderNo("order2");
        saleInfo.setStatusId(1);
        saleInfo.setRemarks("rema2");
        saleInfo.setSaleDate(123);
        saleManager.updateSaleOrder(saleInfo);

    }
}
