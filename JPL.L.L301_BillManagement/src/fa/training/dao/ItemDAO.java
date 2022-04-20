package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.model.Item;

public interface ItemDAO {
	boolean addItems(List<Item> items) throws SQLException;

	boolean deleteItems(List<Item> items) throws SQLException;

	List<Item> getAllByBillCode(String billCode) throws SQLException;

	boolean checkItemExist(Item item) throws SQLException;

}
