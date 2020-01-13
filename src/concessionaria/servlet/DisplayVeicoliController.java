package concessionaria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concessionaria.service.LoginDTO;
import concessionaria.service.LoginService;
import concessionaria.service.VeicoloDTO;
import concessionaria.service.VeicoloService;
import concessionaria.service.VeicoloVendutoDTO;
import concessionaria.service.VenditaService;

/**
 * Servlet implementation class DisplayVeicoliController
 */
@WebServlet({ "/DisplayVeicoliController", "/dvc", "/dispveic" })
public class DisplayVeicoliController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VeicoloService service  = new VeicoloService();
		VenditaService serviceSold  = new VenditaService();
		VeicoloDTO dto = service.comunicaServlet();
		VeicoloVendutoDTO dtoSold = serviceSold.comunicaServlet("1");
		request.setAttribute(VeicoloDTO.NAME, dto);	
		request.setAttribute(VeicoloVendutoDTO.NAME, dtoSold);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/dispveic.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
