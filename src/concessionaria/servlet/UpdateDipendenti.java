package concessionaria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concessionaria.model.Dipendente;
import concessionaria.service.DipendentiDTO;
import concessionaria.service.DipendentiService;

/**
 * Servlet implementation class UpdateDipendenti
 */
@WebServlet({ "/UpdateDipendenti", "/updip" })
public class UpdateDipendenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDipendenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DipendentiDTO dto = null;
		DipendentiService dipsrvc = new DipendentiService();
		String id = request.getParameter("ID");
		String nome = request.getParameter("NOME");
		String cognome = request.getParameter("COGNOME");
		String matricola = request.getParameter("MATRICOLA");
		String ruolo = request.getParameter("RUOLO");
		Long ID= Long.parseLong(id);
		Dipendente dip = new Dipendente(ID, nome, cognome, matricola, ruolo);
		dto = dipsrvc.updateDipendente(dip);
		
		request.setAttribute(DipendentiDTO.NAME, dto);
		if(dto.success()) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/DisplayDipendenti.jsp");
			rd.forward(request, response);
		}
		else {
			// TODO gestione errore
		}
		
		//System.out.println(ID +" " + nome + " " + cognome + " " + matricola + " " + ruolo);
		
	}

}
