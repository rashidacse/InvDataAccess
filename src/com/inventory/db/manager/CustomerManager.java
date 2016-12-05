/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.db.manager;

import com.inventory.bean.CustomerInfo;
import com.inventory.bean.ProfileInfo;
import com.inventory.bean.SupplierInfo;
import com.inventory.db.Database;
import com.inventory.db.query.helper.EasyStatement;
import com.inventory.db.repositories.Customer;
import com.inventory.db.repositories.Supplier;
import com.inventory.db.repositories.User;
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
public class CustomerManager {

    private User user;
    private Customer customer;
    private final Logger logger = LoggerFactory.getLogger(EasyStatement.class);

    public void createCustomer(CustomerInfo customerInfo) {
        //create a new user
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();
            connection.setAutoCommit(false);

            //right now group id constant. Later update it from configuraiton file
            customerInfo.getProfileInfo().setGroupId(2);

            user = new User(connection);
            int userId = user.createUser(customerInfo.getProfileInfo());

            customerInfo.getProfileInfo().setId(userId);
            customer = new Customer(connection);
            customer.createCustomer(customerInfo);

            connection.commit();
            connection.close();
        } catch (SQLException ex) {
            try {
                if (connection != null) {
                    connection.rollback();
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
     * This method will return all customers
     *
     * @return list, customer list
     */
    public List<CustomerInfo> getAllCustomers() {
        List<CustomerInfo> customerList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();

            customer = new Customer(connection);
            customerList = customer.getAllCustomers();

            connection.close();
        } catch (SQLException ex) {
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
        return customerList;
    }

    public CustomerInfo getCustomerInfo(int customerUserId) {
        CustomerInfo customerInfo = new CustomerInfo();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();
            customer = new Customer(connection);
            customerInfo = customer.getCustomerInfo(customerUserId);
            user = new User(connection);
            customerInfo.getProfileInfo().setAddresses(user.getUserAddresses(customerUserId));
            connection.close();
        } catch (SQLException ex) {
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
        return customerInfo;
    }

    public List<CustomerInfo> getCustomersInfoByName(String customerName) {
        List<CustomerInfo> customerList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();
            customer = new Customer(connection);
            customerList = customer.getCustomersInfoByName(customerName);
            connection.close();
        } catch (SQLException ex) {
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
        return customerList;
    }

    public void updateCustomer(CustomerInfo customerInfo) {
        //create a new user
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();
            connection.setAutoCommit(false);
            user = new User(connection);
            user.updateUser(customerInfo.getProfileInfo());
            connection.commit();
            connection.close();
        } catch (SQLException ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                    connection.close();
                }
            } catch (SQLException ex1) {
                logger.error(ex1.getMessage());
            }
        } catch (DBSetupException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void updateCustomerStatus(int customerUserId) {
        CustomerInfo customerInfo = new CustomerInfo();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();
            user = new User(connection);
            user.updateUserAccountStatus(customerUserId);
            connection.close();
        } catch (SQLException ex) {
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
