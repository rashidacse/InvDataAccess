/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inventory.db;

import com.inventory.bean.ProductInfo;
import com.inventory.bean.PurchaseInfo;
import com.inventory.db.manager.PurchaseManager;
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
public class PurchaseManagerTest {

    final static PurchaseManager purcheshManager = new PurchaseManager();
    int supplierUserId = 1805505;

    public PurchaseManagerTest() {
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

//    @Test
    public void getAllProductCategoriesTest() {
        ProductInfo productInfo1 = new ProductInfo();
        productInfo1.setId(1);
        productInfo1.setUnitPrice(100);
        productInfo1.setQuantity(500);
        productInfo1.setDiscount(0);
        List<ProductInfo> productList = new ArrayList<>();
        productList.add(productInfo1);
        PurchaseInfo purchaseInfo = new PurchaseInfo();
        purchaseInfo.setProductList(productList);
        purchaseInfo.setSupplierUserId(supplierUserId);
        purchaseInfo.setOrderNo("order1");
        purchaseInfo.setStatusId(1);
        purchaseInfo.setRemarks("remarks1");
        purchaseInfo.setRequestShippedDate(456);
        purcheshManager.addPurchaseOrder(purchaseInfo);

    }
//     @Test

    public void getAllPurchaseOrdersTest() {
        List<PurchaseInfo> purchaseInfoList = purcheshManager.getAllPurchaseOrders();
        System.out.println(purchaseInfoList);
    }

//    @Test
    public void getPurchaseOrderTest() {
        PurchaseInfo pInfo = purcheshManager.getPurchaseOrderInfo("order1");
        System.out.println(pInfo.getOrderNo());
    }

//    @Test
    public void updatePurchaseOrderTest() {
         ProductInfo productInfo1 = new ProductInfo();
        productInfo1.setId(2);
        productInfo1.setUnitPrice(800);
        productInfo1.setQuantity(700);
        productInfo1.setDiscount(0);
        List<ProductInfo> productList = new ArrayList<>();
        productList.add(productInfo1);
        PurchaseInfo purchaseInfo = new PurchaseInfo();
        purchaseInfo.setProductList(productList);
        purchaseInfo.setSupplierUserId(supplierUserId);
        purchaseInfo.setOrderNo("order1");
        purchaseInfo.setStatusId(3);
        purchaseInfo.setRemarks("uremarks1");
        purchaseInfo.setRequestShippedDate(456);
        purcheshManager.updatePurchaseOrder(purchaseInfo);
    }

}
