package servlet;

import dao.AlumnowebJpaController;
import dto.Alumnoweb;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/loginservlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener parámetros del formulario
        String dni = request.getParameter("dni");
        String password = request.getParameter("password");
        
        // Validar credenciales
        AlumnowebJpaController alumnoController = new AlumnowebJpaController();
        Alumnoweb alumno = alumnoController.validarAlumno(dni, password);
        
        if (alumno != null) {
            // Crear sesión
            HttpSession session = request.getSession();
            session.setAttribute("alumno", alumno);
            // Redirigir a página principal
            response.sendRedirect("principal.html");
        } else {
            // Guardar mensaje de error en sesión
            HttpSession session = request.getSession();
            session.setAttribute("error", "DNI o contraseña incorrectos");
            // Redirigir de vuelta al login
            response.sendRedirect("index.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}