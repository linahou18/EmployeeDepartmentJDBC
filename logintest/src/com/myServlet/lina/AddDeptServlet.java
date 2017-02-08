package com.myServlet.lina;

import com.elements.lina.*;

import services.DepartmentService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddDeptServlet
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dName = request.getParameter("deptname");
		String dEmail = request.getParameter("deptemail");
		
		DepartmentService ds = new DepartmentService();
		try {
			ds.addDept(dName, dEmail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Department> deptList = ds.getDeptList();
		request.setAttribute("departments", deptList);
		//HttpSession session = request.getSession();
//		ArrayList<Department> depts = (ArrayList<Department>)session.getAttribute("departments");
//		if (depts == null) {
//			depts = new ArrayList<Department>();
//		}
		
		
//		DepartmentService departmentService = new DepartmentService(depts);
//		departmentService.addDept(dName);
//		depts = departmentService.getDept();
//		session.setAttribute("departments", depts);


		request.getRequestDispatcher("addDept.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
