package application;

import model.entities.Department;

public class Program {

	public static void main(String[] args) {
		Department departmentObj = new Department(1, "Books");

		System.out.println(departmentObj);
	}

}
