package services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elements.lina.*;
public class EmployeeService {
  
	ArrayList<Employee> empList;
	
	
	public EmployeeService() {
		
	}

	public EmployeeService(ArrayList<Employee> empList) {
		this.empList = empList;
	}

	public void addEmp(String firstName, String lastName, int age, int deptId) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dept_emp_proj", 
                "root", "12345");
		PreparedStatement stmt = connection.prepareStatement("insert into employee (first_name, last_name, age, dept_id) values (?,?,?,?)");
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		stmt.setInt(3, age);
		stmt.setInt(4, deptId);
		stmt.executeUpdate();
		
	}
	
	public ArrayList<Employee> getEmpList() {
		ArrayList<Employee> resList = new ArrayList<Employee>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dept_emp_proj", 
			        "root", "12345");
			Statement stmt = conn.createStatement();
			PreparedStatement stmt2 = conn.prepareStatement("select * from department where dept_id = ?");
			
			ResultSet rs = stmt.executeQuery("select * from employee");
			
			while (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int age = rs.getInt("age");
				int deptId = rs.getInt("dept_id");
				
				stmt2.setInt(1, deptId);
				ResultSet deptRs = stmt2.executeQuery();
				
				Department dept = new Department();
				String deptName = null;
				String deptEmail = null;
				
				// !!!!
				while (deptRs.next()) {
					deptName = deptRs.getString("dept_name");
					deptEmail = deptRs.getString("dept_email");
					dept.setName(deptName);
					dept.setEmail(deptEmail);
					dept.setId(deptId);
				}
				
				//Department dept = new Department(deptId, deptName, deptEmail);
				
				resList.add(new Employee(firstName, lastName, age, dept));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resList;
	}
	
//	public void addEmp(Employee emp, Department dept) {
//		emp.setDepartment(dept);
//		empList.add(emp);
//		//return empList;
//	}
//	public ArrayList<Employee> getEmpList() {
//		return empList;
//	}
}
