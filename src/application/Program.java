package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Seller seller = new Seller(1, "Adryel", "adryel@gmail.com", new Date(), new Department(1, "Adryel"));

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println(seller);
	}
}
