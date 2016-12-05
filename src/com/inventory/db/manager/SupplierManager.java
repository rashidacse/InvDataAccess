/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.db.manager;

import com.inventory.bean.SupplierInfo;
import com.inventory.db.Database;
import com.inventory.db.query.helper.EasyStatement;
import com.inventory.db.repositories.User;
import com.inventory.db.repositories.Supplier;
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
public class SupplierManager {

    private User user;
    private Supplier supplier;
    private final Logger logger = LoggerFactory.getLogger(EasyStatement.class);

    /**
     * This method will create a new supplier
     *
     * @param supplierInfo,
     */
    public void createSupplier(SupplierInfo supplierInfo) {
        //create a new user
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();
            connection.setAutoCommit(false);

            //right now group id constant. Later update it from configuraiton file
            supplierInfo.getProfileInfo().setGroupId(1);
            user = new User(connection);
            int userId = user.createUser(supplierInfo.getProfileInfo());

            supplierInfo.getProfileInfo().setId(userId);
            supplier = new Supplier(connection);
            supplier.createSupplier(supplierInfo);

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
        //add user under a group
        //add address
        //add supplier info
    }

    /**
     * This method will return all suppliers
     *
     * @return list, supplier list
     */
    public List<SupplierInfo> getAllSuppliers() {
        List<SupplierInfo> supplierList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();

            supplier = new Supplier(connection);
            supplierList = supplier.getAllSuppliers();

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
        return supplierList;
    }

    public List<SupplierInfo> getSupplierInfoByName(String supplierName) {
        List<SupplierInfo> supplierList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();

            supplier = new Supplier(connection);
            supplierList = supplier.getSupplierInfoByName(supplierName);

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
        return supplierList;
    }

    public SupplierInfo getSuplierInfo(int suppliedId) {
        SupplierInfo supplierInfo = new SupplierInfo();
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();

            supplier = new Supplier(connection);
            supplierInfo = supplier.getSupplierInfo(suppliedId);

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
        return supplierInfo;
    }

    public void updateSupplier(SupplierInfo supplierInfo) {
        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();
            connection.setAutoCommit(false);
            user = new User(connection);
            user.updateUser(supplierInfo.getProfileInfo());
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

    public void updateSupplierStatus(int customerUserId) {
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
