package co.edu.ufps.previodos.controller;

import java.io.IOException;
import java.sql.SQLException;

import co.edu.ufps.previodos.beans.Country;
import co.edu.ufps.previodos.beans.Team;
import co.edu.ufps.previodos.dao.TeamDao;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   private TeamDao teamDao;
	
	
    public TeamServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.teamDao= new TeamDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String action = request.getServletPath();
		
		try {
		switch(action) {
		case "/new":
			
			break;
		case "/insert":
			
			break;
		case "/delete":
			
			break;
		case "/edit":
			
			break;
		case "/update":
			
			break;
		default:
			
			break;
		}
		}catch(Exception e) {
			throw new ServletException(e);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException ,SQLException, IOException {
		
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		
		Team team = new Team(name,country);
		Country countryT = new Country(country);
		
		teamDao.insert(team, countryT);
		
		response.sendRedirect("list");
	}

}
