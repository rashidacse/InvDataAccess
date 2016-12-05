/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inventory.db;

import com.inventory.bean.AddressCategoryInfo;
import com.inventory.bean.AddressTypeInfo;
import com.inventory.db.manager.ProfileManager;
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
public class ProfileManagerTest {

    final static ProfileManager profileManager = new ProfileManager();

    public ProfileManagerTest() {

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

    @Test
    public void getAllAddressTypesTest() {
        List<AddressTypeInfo> addressTypeList = profileManager.getAllAddressTypes();

        System.out.println(addressTypeList);
    }

    @Test

    public void getAllAddressCategoriesTest() {
        List<AddressCategoryInfo> addressCategoryList = profileManager.getAllAddressCategories();

        System.out.println(addressCategoryList);
    }
    
  

}
