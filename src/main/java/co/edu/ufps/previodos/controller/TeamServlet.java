package co.edu.ufps.previodos.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.edu.ufps.previodos.beans.Country;
import co.edu.ufps.previodos.beans.Team;
import co.edu.ufps.previodos.dao.TeamDao;
import jakarta.servlet.RequestDispatcher;
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
			showNewForm(request, response);
			break;
		case "/insert":
			insertarTeam(request, response);
			break;
		case "/delete":
			eliminarTeam(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			actualizarTeam(request, response);
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
	
	private void insertarTeam(HttpServletRequest request, HttpServletResponse response) throws ServletException ,SQLException, IOException {
		
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		
		Team team = new Team(name,country);
		Country countryT = new Country(country);
		
		teamDao.insert(team, countryT);
		
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		int id = Integer.parseInt(request.getParameter("id"));
		
		Team teamActual = teamDao.select(id);
		
		request.setAttribute("Team", teamActual);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Team.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void actualizarTeam(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException, IOException {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			String name = request.getParameter("name");
			String country = request.getParameter("country");
			
			Team team = new Team(id,name,country);
			Country countryT = new Country(id,name);
			
			teamDao.update(team,countryT);
			
			response.sendRedirect("list");
		}
	
	private void eliminarTeam(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		teamDao.delete(id);
		
		response.sendRedirect("list");
	}
	
	private void listTeams(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		List<Team> listTeam = teamDao.selectAll();
		request.setAttribute("listTeams", listTeam);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Teamlist.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Team.jsp");
		dispatcher.forward(request, response);
	}
	
	
}
