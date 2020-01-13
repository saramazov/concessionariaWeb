package concessionaria.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concessionaria.model.Veicolo;
import concessionaria.service.LoginDTO;
import concessionaria.service.LoginService;
import concessionaria.service.VeicoloDTO;
import concessionaria.service.VeicoloService;
import concessionaria.service.VeicoloVendutoDTO;
import concessionaria.service.VenditaService;

/**
 * Servlet implementation class CompraController
 */
@WebServlet({ "/CompraController", "/compra", "/cc" })
public class CompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		VenditaService service  = new VenditaService();
		VeicoloService serviceDisplay = new VeicoloService();
		VeicoloVendutoDTO dto = service.comunicaServlet(id);
		VeicoloDTO dtoVeicoli = serviceDisplay.comunicaServlet();
		request.setAttribute(VeicoloVendutoDTO.NAME, dto);	
		request.setAttribute(VeicoloDTO.NAME, dtoVeicoli);
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
