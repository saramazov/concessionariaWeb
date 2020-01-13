package concessionaria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concessionaria.service.DipendentiDTO;
import concessionaria.service.DipendentiService;

/**
 * Servlet implementation class DisplayDipendenti
 */
@WebServlet({ "/DisplayDipendenti", "/dispdip" })
public class DisplayDipendenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDipendenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DipendentiDTO dto = null;
		DipendentiService dipsrv = new DipendentiService();
		dto=dipsrv.listaDipendenti();
		request.setAttribute(DipendentiDTO.NAME, dto);
		if(dto.success()) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/DisplayDipendenti.jsp");
			rd.forward(request, response);
		}
		else {
			
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/GestioneErrori.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
