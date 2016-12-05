/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inventory.db;

import javax.naming.spi.DirStateFactory.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

/**
 *
 * @author sampanit
 */
public class TestRunner {

    public static void main(String[] args) {
        org.junit.runner.Result databaseResult = JUnitCore.runClasses(DatabaseTest.class);
        org.junit.runner.Result productManagerResult = JUnitCore.runClasses(ProductManagerTest.class);
        org.junit.runner.Result supplierManagerResult = JUnitCore.runClasses(SupplierManagerTest.class);
        org.junit.runner.Result customerManagerResult = JUnitCore.runClasses(CustomerManagerTest.class);
        org.junit.runner.Result profileManagerResult = JUnitCore.runClasses(ProfileManagerTest.class);
//before run PurchaseManagerTest.Class you must be set  supplier UserId . this is the dependency of PurchaseManagerTest class      
        org.junit.runner.Result purchaseManagerResult = JUnitCore.runClasses(PurchaseManagerTest.class);
//before run SaleManagerTest.class you must be set  customer UserId . this is the dependency of PurchaseManagerTest class
        org.junit.runner.Result saleManagerResult = JUnitCore.runClasses(SaleManagerTest.class);
        org.junit.runner.Result stockManagerResult = JUnitCore.runClasses(StockManagerTest.class);

        for (Failure failure : databaseResult.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(databaseResult.wasSuccessful());
        for (Failure failure : productManagerResult.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(productManagerResult.wasSuccessful());

        for (Failure failure : supplierManagerResult.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(supplierManagerResult.wasSuccessful());

        for (Failure failure : customerManagerResult.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(customerManagerResult.wasSuccessful());
        for (Failure failure : profileManagerResult.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(profileManagerResult.wasSuccessful());

        for (Failure failure : purchaseManagerResult.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(purchaseManagerResult.wasSuccessful());

        for (Failure failure : saleManagerResult.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(saleManagerResult.wasSuccessful());

        for (Failure failure : stockManagerResult.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(stockManagerResult.wasSuccessful());

    }

}
