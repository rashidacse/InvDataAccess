/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.bean;

/**
 *
 * @author nazmul hasan
 */
public class CustomerInfo {
    private ProfileInfo userInfo;
    public CustomerInfo()
    {
        userInfo = new ProfileInfo();
    }

    public ProfileInfo getProfileInfo() {
        return userInfo;
    }

    public void setProfileInfo(ProfileInfo userInfo) {
        this.userInfo = userInfo;
    }
    
}
