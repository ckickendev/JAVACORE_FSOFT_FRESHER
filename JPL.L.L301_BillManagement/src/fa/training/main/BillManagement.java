package fa.training.main;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fa.training.model.Bill;
import fa.training.model.Item;
import fa.training.util.UserInputUtil;

import fa.training.dao.BillDAO;
import fa.training.dao.BillDaoImpl;
import fa.training.dao.ItemDAO;
import fa.training.dao.ItemDAOImpl;

public class BillManagement {

	static BillDAO billDAO = new BillDaoImpl();
	static ItemDAO itemDAO = new ItemDAOImpl();

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		List<Bill> bills = new ArrayList<>();
		List<Item> items = new ArrayList<>();
		String billCode;
		String loop = "";
		Item item = null;
		String choice = "";
		do {
			getMenu();
			System.out.println("Enter your choice:");
			choice = scanner.nextLine();

			switch (choice) {
			case "1":
				Bill bill = new Bill();
				do {
					bill.setBillCode(UserInputUtil.checkBillCode(scanner));
				} while (billDAO.findBillsByBillCode(bill.getBillCode()) != null);

				System.out.println("Enter customer name:");
				bill.setCustomerName(scanner.nextLine());

				System.out.println("Enter discount:");
				bill.setDiscount(UserInputUtil.inputTypeFloat(scanner.nextLine()));

				bill.setCreatedDate(getCurrentDate());

				boolean check = billDAO.saveBill(bill);
				if (check) {
					System.out.println("Saved success!");
				}
				break;
			case "2":
				if (!items.isEmpty()) {
					items.clear();
				}

				billCode = UserInputUtil.checkBillCode(scanner);

				if (billDAO.findBillsByBillCode(billCode) == null) {
					System.out.println("No bill code = " + billCode + " found!");
				} else {
					do {
						item = new Item();

						item.setBillCode(billCode);

						do {
							System.out.println("Enter product name:");
							item.setProductName(scanner.nextLine());
						} while (checkProductExist(items, item.getProductName()));

						System.out.println("Enter quantity:");
						item.setQuantity(UserInputUtil.inputTypeInt(scanner.nextLine()));
						System.out.println("Enter product price:");
						item.setPrice(UserInputUtil.inputTypeDouble(scanner.nextLine()));

						items.add(item);

						System.out.println("Do you want to continue adding (Y|N)?");
						loop = scanner.nextLine();
					} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

					itemDAO.addItems(items);
				}
				break;
			case "3":
				if (!items.isEmpty()) {
					items.clear();
				}
				loop = "";
				billCode = UserInputUtil.checkBillCode(scanner);

				if (billDAO.findBillsByBillCode(billCode) == null) {
					System.out.println("No bill code = " + billCode + " found!");
				} else {
					do {
						item = new Item();

						item.setBillCode(billCode);

						do {
							System.out.println("Enter product name:");
							item.setProductName(scanner.nextLine());
						} while (checkProductExist(items, item.getProductName()));

						items.add(item);

						System.out.println("Do you want to continue deleting (Y|N)?");
						loop = scanner.nextLine();
					} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

					itemDAO.deleteItems(items);
				}
				break;
			case "4":
				bills = billDAO.getAll();
				if (bills.isEmpty()) {
					System.out.println("No bill found!");
				} else {
					System.out.println("---List of bills---");

					bills.stream().sorted(Comparator.comparing(Bill::getCreatedDate)).forEach(System.out::println);
				}
				break;
			case "5":
				System.out.println("Enter customer name:");
				String customerName = scanner.nextLine();
				bills = billDAO.findBillsByCustomerName(customerName);
				if (bills.isEmpty()) {
					System.out.println("No bill found!");
				} else {
					System.out.println("---List of bills---");

					bills.stream().sorted(Comparator.comparing(Bill::getCreatedDate)).forEach(System.out::println);
				}
				break;
			case "6":
				billCode = UserInputUtil.checkBillCode(scanner);

				items = itemDAO.getAllByBillCode(billCode);

				if (items.isEmpty()) {
					System.out.println("No data found!");
				} else {
					System.out.println("---List all items from bill---");
					items.stream().forEach(System.out::println);
				}
				break;
			case "7":
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input!");
				break;
			}
		} while (true);

	}

	public static void getMenu() {
	    System.out.println("-----Menu-----");
	    System.out.println("1. Create new bill");
	    System.out.println("2. Add one or more item(s) into a specific bill");
	    System.out.println("3. Delete one or more item(s) from a bill");
	    System.out.println("4. Display all bills, sorted by created date");
	    System.out.println("5. Display customer's bills, sorted by created date");
	    System.out.println("6. Display items from a specific bill");
	    System.out.println("7. Exit");
	  }

	/**
	 * This method is checked if the product name exist in the list or not
	 * 
	 * @method checkProductExist
	 * @param items, productName
	 * @return true if product name is exist, otherwise false
	 */
	private static boolean checkProductExist(final List<Item> items, final String productName) {
		boolean check = items.stream().anyMatch((Item item) -> productName.equals(item.getProductName()));
		return check;
	}

	public static String getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date());
	}
}
