package EmpDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeImpl implements EmployeeInterface {
	Scanner sc=new Scanner(System.in);

	@Override
	public void addEmployee()  {
		System.out.println("Enter Id, Name, Salary");
		int id=sc.nextInt();
		String name=sc.next();
		Double sal=sc.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
			PreparedStatement ps=con.prepareStatement("insert into emp(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, sal);
			ps.execute();
			con.close();
			System.out.println("Employee Is Saved");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee() {
		try {
			System.out.println("Enter Id");
			int id=sc.nextInt();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
			PreparedStatement ps=con.prepareStatement("delete from emp where id=?");
			ps.setInt(1, id);
			ps.execute();
			con.close();
			System.out.println("Employee Deleted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void updateEmployee() {
		System.out.println("1:Update Name\n2:Update Salary\n");
		System.out.println("Enter Choice");
		int c=sc.nextInt();
		switch(c) {
		case 1:
			try {
				System.out.println("Enter Name");
				String name=sc.next();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
				PreparedStatement ps=con.prepareStatement("update emp set empName=?");
				ps.setString(1, name);
				ps.execute();
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		case 2:
			try {
				System.out.println("Enter Sal");
				Double sal=sc.nextDouble();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
				PreparedStatement ps=con.prepareStatement("update emp set empSal=?");
				ps.setDouble(c, sal);
				ps.execute();
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void getEmployee() {
		try {
			System.out.println("Enter id");
			int id=sc.nextInt();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
			PreparedStatement ps=con.prepareStatement("select * from emp where id=?");
			ps.setInt(1, id);
			ps.execute();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAllEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
			PreparedStatement ps=con.prepareStatement("delete from emp");
			ps.execute();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
			PreparedStatement ps=con.prepareStatement("select * from emp");
			ps.execute();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
