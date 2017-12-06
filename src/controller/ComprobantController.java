package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComprobantDAO;
import dao.ComprobantDAOImpl;
import model.Comprobant;

/**
 * Servlet implementation class ComprobantController
 */
@WebServlet("/ComprobantController")
public class ComprobantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Comprobant comprobant;
	private List<Comprobant> comprobants;
	private ComprobantDAO comprobantDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComprobantController() {
		super();
		// TODO Auto-generated constructor stub
		comprobant = new Comprobant();
		comprobants = new ArrayList<Comprobant>();
		comprobantDAO = new ComprobantDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {
			comprobant.setDate(request.getParameter("date"));
			comprobant.setIdRequest(request.getParameter("idrequest"));
			comprobant.setTotal(request.getParameter("total"));
			if (comprobant.getId() == 0L) {
				comprobantDAO.createComprobant(comprobant);
			} else {
				comprobantDAO.updateComprobant(comprobant);

			}
			comprobants = comprobantDAO.readAllComprobants();
			request.setAttribute("comprobants", comprobants);
			request.getRequestDispatcher("comprobant_list.jsp").forward(request, response);

		} else if (request.getParameter("btn_new") != null) {
			comprobant = new Comprobant();
			request.getRequestDispatcher("comprobant_form.jsp").forward(request, response);
		} else if (request.getParameter("btn_edit") != null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				comprobant = comprobantDAO.readComprobant(id);
			} catch (IndexOutOfBoundsException e) {
				comprobant = new Comprobant();
			}
			request.setAttribute("comprobant", comprobant);
			request.getRequestDispatcher("comprobant_form.jsp").forward(request, response);
		} else if (request.getParameter("btn_delete") != null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				comprobantDAO.deleteComprobant(id);
				comprobants = comprobantDAO.readAllComprobants();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("comprobants", comprobants);
			request.getRequestDispatcher("comprobant_list.jsp").forward(request, response);
		} else {
			comprobants = comprobantDAO.readAllComprobants();
			request.setAttribute("comprobants", comprobants);
			request.getRequestDispatcher("comprobant_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
