/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inventory.db;

import com.inventory.bean.ProfileInfo;
import com.inventory.bean.SupplierInfo;
import com.inventory.db.manager.SupplierManager;
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
public class SupplierManagerTest {
   final static SupplierManager supplierManager = new SupplierManager(); 
    public SupplierManagerTest() {
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

    public void createSupplierTest() {
        ProfileInfo userInfo = new ProfileInfo();
        userInfo.setFirstName("Customer1");
        userInfo.setLastName("ln1");
        userInfo.setEmail("email1");
        userInfo.setPhone("phone1");
        userInfo.setFax("fax1");
        SupplierInfo supplierInfo = new SupplierInfo();
        supplierInfo.setProfileInfo(userInfo);
        supplierInfo.setRemarks("remarks2");
        supplierManager.createSupplier(supplierInfo);
    }

//    @Test
    public void getAllSuppliersTest() {
        List<SupplierInfo> supllierList = supplierManager.getAllSuppliers();
        System.out.println(supllierList);
    }
//    @Test
    public void getSuppliersByName() {
        List<SupplierInfo> supllierList = supplierManager.getSupplierInfoByName("ln1");
    }
  
//    @Test
    public void getSupplierTest() {
        SupplierInfo supllierInfo = supplierManager.getSuplierInfo(1);
        System.out.println(supllierInfo.getProfileInfo().getFirstName());
    }
    //    @Test

    public void updateSupplierTest() {
        ProfileInfo userInfo = new ProfileInfo();
        userInfo.setFirstName("Customer1");
        userInfo.setLastName("ln1");
        userInfo.setEmail("email1");
        userInfo.setPhone("phone1");
        userInfo.setFax("fax1");
        SupplierInfo supplierInfo = new SupplierInfo();
        supplierInfo.setProfileInfo(userInfo);
        supplierInfo.setRemarks("remarks2");
        supplierManager.updateSupplier(supplierInfo);
    }
       //    @Test
    public void deleteCustomerInfoTest() {
       supplierManager.updateSupplierStatus(1233);
    }
}
