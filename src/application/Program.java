package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Department obj = new Department(1, "RH");
		Date x = sdf.parse("17/12/1999");
		Seller seller = new Seller(1, "luan", "luan@gmail.com", x, 2000.0, obj);
		System.out.println(seller);
	}

}
