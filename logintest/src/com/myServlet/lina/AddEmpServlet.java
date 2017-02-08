package com.myServlet.lina;

import com.elements.lina.*;

import services.DepartmentService;
import services.EmployeeService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		int deptId = Integer.parseInt(request.getParameter("deptSelect"));
		// System.out.println(deptChoose);

		EmployeeService es = new EmployeeService();
		try {
			es.addEmp(firstName, lastName, age, deptId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Employee> empList = es.getEmpList();
		request.setAttribute("employees", empList);

		// get all depts ready for dropdownlist
		DepartmentService ds = new DepartmentService();
		ArrayList<Department> deptList = ds.getDeptList();
		request.setAttribute("departments", deptList);
		
		// Department d = null;
		// Employee e = new Employee(name, age);
		//
		// HttpSession session = request.getSession();
		// ArrayList<Employee> emps =
		// (ArrayList<Employee>)session.getAttribute("employees");
		// ArrayList<Department> depts =
		// (ArrayList<Department>)session.getAttribute("departments");
		//
		// // get the department obj choosed -> d
		// for (int i = 0; i < depts.size(); i++) {
		// if (depts.get(i).getDeptName().equals(deptChoose)) {
		// d = depts.get(i);
		// }
		// }
		// if (emps == null) {
		// emps = new ArrayList<Employee>();
		// }
		// EmployeeService employeeService = new EmployeeService(emps);
		// employeeService.addEmp(e, d);
		// emps = employeeService.getEmpList();
		// session.setAttribute("employees", emps);
		//
		// DepartmentService departmentService = new DepartmentService(depts);
		// departmentService.updateEmpInDept(d, e);

		request.getRequestDispatcher("addEmp.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
