package report;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComprobantDAOImpl;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class ComprobantReport
 */
@WebServlet("/ComprobantReport")
public class ComprobantReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ComprobantDAOImpl dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprobantReport() {
        super();
        // TODO Auto-generated constructor stub
        dao = new ComprobantDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "R:\\Clases\\Cuatrimerte IV 2017\\Desarrollo de aplicaciones II\\Unidad1\\Eclipse\\07-09-17\\Project4\\src\\report\\comprobants.jrxml";
		try {
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("logo_utng", this.getServletContext().getRealPath("/") + "/images/logo_utng.jpg");
			data.put("logo_iso", this.getServletContext().getRealPath("/") + "/images/logo_iso.jpg");
			
			Class.forName("org.postgresql.Driver");
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/comprobantdb", "postgres", "utng");
			JasperPrint print = JasperFillManager.fillReport(report, data, connection);
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (JRException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
