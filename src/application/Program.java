package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== Test 1: Seller Find By ID ====");
		
		Seller seller = sellerDao.findById(7);
		
		System.out.println(seller.toString());
		
		System.out.println("==== Test 2: Seller Find Department ====");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller obj : list) {
			System.out.println(obj.toString());
		}
	}

}
