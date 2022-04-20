package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.model.Item;
import fa.training.util.DBUtils;
import fa.training.util.SQLCommand;

public class ItemDAOImpl implements ItemDAO{
	private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet results = null;
 
    @Override
    public boolean addItems(final List<Item> items) throws SQLException {
 
        boolean check = false;
        int results[] = null;
        try {
            connection = DBUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = 
				connection.prepareStatement(SQLCommand.ITEM_QUERY_ADD);
 
            items.stream().forEach((item) -> {
                try {
                    preparedStatement.setString(1, item.getProductName());
                    preparedStatement.setString(2, item.getBillCode().trim());
                    preparedStatement.setInt(3, item.getQuantity());
                    preparedStatement.setDouble(4, item.getPrice());
 
                    preparedStatement.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            results = preparedStatement.executeBatch();
            connection.commit();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 
        if (results.length > 0) {
            check = true;
        }
        return check;
    }
    
    @Override
    public boolean deleteItems(final List<Item> items) throws SQLException {
        boolean check = false;
        int results[] = null;
        try {
            connection = DBUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = 
				connection.prepareStatement(SQLCommand.ITEM_QUERY_DELETE);
 
            items.stream().forEach((item) -> {
                try {
 
                    preparedStatement.setString(1, item.getBillCode());
                    preparedStatement.setString(2, item.getProductName());
 
                    preparedStatement.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            results = preparedStatement.executeBatch();
            connection.commit();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 
        if (results.length > 0) {
            check = true;
        }
        return check;
    }
    @Override
    public List<Item> getAllByBillCode(String billCode) 
		throws SQLException {
        List<Item> items = new ArrayList<>();
        Item item = null;
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = 
		connection.prepareStatement(SQLCommand.ITEM_QUERY_FIND_ALL);
            preparedStatement.setString(1, billCode);
            results = preparedStatement.executeQuery();
            while (results.next()) {
                item = new Item();
 
                item.setBillCode(results.getString("bill_code"));
                item.setProductName(results.getString("product_name"));
                item.setQuantity(results.getInt("quantity"));
                item.setPrice(results.getDouble("price"));
 
                items.add(item);
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    @Override
    public boolean checkItemExist(Item item) throws SQLException {
        boolean check = false;
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = 
			connection.prepareStatement(
			SQLCommand.ITEM_QUERY_FIND_CODE_AND_PRODUCT_NAME);
            preparedStatement.setString(1, item.getBillCode());
            preparedStatement.setString(2, item.getProductName());
            results = preparedStatement.executeQuery();
            if (results.next()) {
                check = true;
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    }

}
