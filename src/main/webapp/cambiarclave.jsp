<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cambiar Clave</title>
    <!-- Incluye tus estilos SB Admin 2 aquí -->
</head>
<body>
    <div class="container">
        <h1>Cambiar Contraseña</h1>
        
        <% if (session.getAttribute("error") != null) { %>
            <div class="alert alert-danger">
                <%= session.getAttribute("error") %>
                <% session.removeAttribute("error"); %>
            </div>
        <% } %>
        
        <% if (session.getAttribute("exito") != null) { %>
            <div class="alert alert-success">
                <%= session.getAttribute("exito") %>
                <% session.removeAttribute("exito"); %>
            </div>
        <% } %>
        
        <form action="cambiarclave" method="POST">
            <div class="form-group">
                <label>Clave Actual:</label>
                <input type="password" name="claveActual" class="form-control" required>
            </div>
            
            <div class="form-group">
                <label>Nueva Clave (mínimo 6 caracteres):</label>
                <input type="password" name="nuevaClave" class="form-control" required minlength="6">
            </div>
            
            <div class="form-group">
                <label>Confirmar Nueva Clave:</label>
                <input type="password" name="confirmaClave" class="form-control" required minlength="6">
            </div>
            
            <button type="submit" class="btn btn-primary">Cambiar Clave</button>
            <a href="perfil.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>