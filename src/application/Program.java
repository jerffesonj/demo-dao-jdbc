package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== Test 1: Seller Find By ID ====");
		
		Seller seller = sellerDao.findById(7);
		
		System.out.println(seller.toString());
		
		System.out.print("\n");
		System.out.println("==== Test 2: Seller Find Department ====");
		
		Department dep = new Department(2, null);
		
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for(Seller obj : list) {
			System.out.println(obj.toString());
		}
		
		System.out.print("\n");
		System.out.println("==== Test 3: Seller Find All ====");
		
		List<Seller> listAll = sellerDao.findAll();
		for(Seller obj : listAll) {
			System.out.println(obj.toString());
		}
		
		System.out.print("\n");
		System.out.println("==== Test 4: Seller Insert ====");
		
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 1000.0, dep);
		
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted: New Id = " + newSeller.toString());
		
		System.out.print("\n");
		System.out.println("==== Test 5: Seller Update ====");
		
		seller = sellerDao.findById(1);
		
		seller.setName("Maracajeba");
		
		sellerDao.update(seller);
		
		System.out.println("Update Complete");
		
		
		System.out.print("\n");
		System.out.println("==== Test 5: Seller Delete ====");
		System.out.println("Enter Id for delete test");
		
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);
		
		System.out.println("Delete Complete");
		sc.close();
	}

}
