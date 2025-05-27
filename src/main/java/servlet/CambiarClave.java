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
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "CambiarClave", urlPatterns = {"/cambiarclave"})
public class CambiarClave extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Alumnoweb alumno = (Alumnoweb) session.getAttribute("alumno");
        
        if (alumno == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        
        String claveActual = request.getParameter("claveActual");
        String nuevaClave = request.getParameter("nuevaClave");
        String confirmaClave = request.getParameter("confirmaClave");
        
        // Validaciones
        if (nuevaClave == null || nuevaClave.length() < 6) {
            session.setAttribute("error", "La nueva clave debe tener al menos 6 caracteres");
            response.sendRedirect("principal.html");
            return;
        }
        
        if (!nuevaClave.equals(confirmaClave)) {
            session.setAttribute("error", "La nueva clave y su confirmación no coinciden");
            response.sendRedirect("principal.html");
            return;
        }
        
        // Verificar clave actual
        AlumnowebJpaController controller = new AlumnowebJpaController();
        Alumnoweb alumnoActualizado = controller.findAlumnoweb(alumno.getCodiEstdWeb());
        
        if (!BCrypt.checkpw(claveActual, alumnoActualizado.getPassEstd())) {
            session.setAttribute("error", "La clave actual es incorrecta");
            response.sendRedirect("principal.html");
            return;
        }
        
        // Actualizar clave
        String nuevoHash = BCrypt.hashpw(nuevaClave, BCrypt.gensalt());
        alumnoActualizado.setPassEstd(nuevoHash);
        
        try {
            controller.edit(alumnoActualizado);
            session.setAttribute("exito", "¡Contraseña cambiada exitosamente!");
            response.sendRedirect("index.html");
        } catch (Exception e) {
            session.setAttribute("error", "Error al actualizar la clave: " + e.getMessage());
            response.sendRedirect("principal.html");
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