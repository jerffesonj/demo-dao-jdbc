package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== Test 1: Department Find By ID ====");
		
		Department dep = departmentDao.findById(1);
		
		System.out.println(dep.toString());	

		
		System.out.print("\n");
		System.out.println("==== Test 2: Department Find All ====");
		
		List<Department> listAll = departmentDao.findAll();
		for(Department obj : listAll) {
			System.out.println(obj.toString());
		}
		
		System.out.print("\n");
		System.out.println("==== Test 3: Department Insert ====");
		
		Department newDepartment = new Department(null, "Food");
		
		departmentDao.insert(newDepartment);
		
		System.out.println("Inserted: New Id = " + newDepartment.toString());
		
		System.out.print("\n");
		System.out.println("==== Test 4: Department Update ====");
		
		Department updatedDep = departmentDao.findById(1);
		
		updatedDep.setName("Maracajeba");
		
		departmentDao.update(updatedDep);
		
		System.out.println("Update Complete");
		
		System.out.print("\n");
		System.out.println("==== Test 5: Department Delete ====");
		
		System.out.println("Enter Id for delete test");
		int id = sc.nextInt();
		
		departmentDao.deleteById(id);
		
		System.out.println("Delete Complete");
		sc.close();
	}

}
