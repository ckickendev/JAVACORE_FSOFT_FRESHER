package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.model.Bill;

public interface BillDAO {

	List<Bill> getAll() throws SQLException;

	boolean saveBill(Bill bill) throws SQLException;

	Bill findBillsByBillCode(String billCode) throws SQLException;

	List<Bill> findBillsByCustomerName(String customerName) throws SQLException;

}
