package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Seller s = new Seller(1, "Adryel", "adryel@gmail.com", new Date(), new Department(1, "Adryel"));
		System.out.println(s);
	}
}
