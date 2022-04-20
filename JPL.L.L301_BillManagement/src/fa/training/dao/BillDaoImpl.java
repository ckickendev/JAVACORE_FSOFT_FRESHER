package fa.training.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fa.training.model.Bill;
import fa.training.util.DBUtils;
import fa.training.util.SQLCommand;

public class BillDaoImpl implements BillDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private CallableStatement caStatement = null;
	private ResultSet results = null;

	@Override
	public List<Bill> getAll() throws SQLException {
		List<Bill> bills = new ArrayList<>();
		Bill bill = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BILL_QUERY_FIND_ALL);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				bill = new Bill();

				bill.setBillCode(results.getString("bill_code").trim());
				bill.setCustomerName(results.getString("customer_name"));
				bill.setCreatedDate(results.getString("created_date"));
				bill.setDiscount(results.getInt("discount"));
				bill.setTotalPrice(results.getDouble("total_price"));
				bills.add(bill);
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
		return bills;
	}

	@Override
	public boolean saveBill(Bill bill) throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			caStatement = connection.prepareCall(SQLCommand.BILL_QUERY_ADD);

			caStatement.setString(1, bill.getBillCode());
			caStatement.setString(2, bill.getCustomerName());
			caStatement.setString(3, bill.getCreatedDate());
			caStatement.setFloat(4, bill.getDiscount());
			caStatement.registerOutParameter(5, Types.INTEGER);
			caStatement.execute();
			if (caStatement.getInt(5) == 1) {
				check = true;
			}

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (caStatement != null) {
					caStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	@Override
	public Bill findBillsByBillCode(final String billCode) throws SQLException {
		Bill bill = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BILL_QUERY_FIND_BY_CODE);
			preparedStatement.setString(1, billCode);
			results = preparedStatement.executeQuery();
			if (results.next()) {
				bill = new Bill();

				bill.setBillCode(results.getString("bill_code").trim());
				bill.setCustomerName(results.getString("customer_name"));
				bill.setCreatedDate(results.getString("created_date"));
				bill.setDiscount(results.getInt("discount"));
				// bill.setTotalPrice(results.getDouble("total_price"));
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
		return bill;
	}

	public List<Bill> findBillsByCustomerName(final String customerName) throws SQLException {
		List<Bill> bills = new ArrayList<>();
		Bill bill = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BILL_QUERY_FIND_BY_CUSTOMER_NAME);
			preparedStatement.setString(1, customerName);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				bill = new Bill();

				bill.setBillCode(results.getString("bill_code").trim());
				bill.setCustomerName(results.getString("customer_name"));
				bill.setCreatedDate(results.getString("created_date"));
				bill.setDiscount(results.getInt("discount"));
				bill.setTotalPrice(results.getDouble("total_price"));

				bills.add(bill);
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
		return bills;
	}

}
