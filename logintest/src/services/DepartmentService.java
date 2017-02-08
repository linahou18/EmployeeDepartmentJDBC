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

public class DepartmentService {

	ArrayList<Department> deptList;
	
	public DepartmentService() {

	}

	public DepartmentService(ArrayList<Department> deptList) {
		this.deptList = deptList;
	}
	
	public void addDept(String deptName, String deptEmail) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dept_emp_proj", 
                "root", "12345");
		PreparedStatement stmt = connection.prepareStatement("insert into department (dept_name, dept_email) values (?,?)");
		stmt.setString(1, deptName);
		stmt.setString(2, deptEmail);
		stmt.executeUpdate();
		
	}
	
	public ArrayList<Department> getDeptList() {
		ArrayList<Department> resList = new ArrayList<Department>();
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
			ResultSet rs = stmt.executeQuery("select * from department");
			PreparedStatement stmt2 = conn.prepareStatement("select * from employee where dept_id = ?");
			while (rs.next()) {
				int id = rs.getInt("dept_id");
				String deptName = rs.getString("dept_name");
				String deptEmail = rs.getString("dept_email");
				// load emp list
				ArrayList<Employee> empList = new ArrayList<Employee>();
				stmt2.setInt(1, id);
				ResultSet empRs = stmt2.executeQuery();
				while (empRs.next()) {
					int empId = empRs.getInt("emp_id");
					String first = empRs.getString("first_name");
					String last = empRs.getString("last_name");
					Integer age = empRs.getInt("age");
					if (empRs.wasNull()) {
						age = null;
					}
					empList.add(new Employee(empId, first, last, age, null));
				}
				resList.add(new Department(id, deptName, deptEmail, empList));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resList;
	}
	
	
//	public void addDept(ArrayList<Employee> allEmps, String dName, String[] empsChoose) {
//		Department newDept = new Department(dName);
//		for (int i = 0; i < empsChoose.length; i++) {
//			int empId = Integer.parseInt(empsChoose[i]);
//			for (int j = 0; j < allEmps.size(); j++) {
//				Employee curEmp = allEmps.get(j);
//				if (empId == curEmp.getId()) {
//					newDept.getEmpList().add(curEmp);
//					break;
//				}
//			}
//		}
//		deptList.add(newDept);
//	}
//	public void addDept(String dName) {
//		Department newDept = new Department(dName);
//		deptList.add(newDept);
//	}
//	
//	public ArrayList<Department> getDept() {
//		return deptList;
//	}
//
//	public void updateEmpInDept(Department d, Employee e) {
//		d.getEmpList().add(e);
//	}
	
}
