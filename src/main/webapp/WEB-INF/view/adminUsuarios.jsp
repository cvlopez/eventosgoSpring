<%@page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="es.taw.eventosgo.entity.*"%>
<%@page import="es.taw.eventosgo.dao.*"%>html>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Administrador Usuarios</title>

    <!--        Boostrap -->

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

    <!--        W3 CSS -->
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <%
        List<Usuario> listaUsuarios = (List) request.getAttribute("listaUsuarios");
    %>
</head>
<body>

<%@include file="cabecera.jsp" %> <!-- Introduce la cabecera -->

<!-- Sección con la tabla de los usuarios -->
<section class="container rounded shadow-sm w3-padding">
    <header class="container">
        <h1 class="display-1">Lista de usuarios</h1>
        <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search">
            <button class="btn btn-sm btn-outline-secondary" type="submit">Buscar</button>
        </form>
        <a href="ServletAdminCrudUsuarioCrearEditar">Nuevo usuario</a>
    </header>
    <article>
        <table class="table table-responsive-md table-hover table-sm fs-6 text-center" title="Lista de usuarios">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nombre</th>
                <th scope="col">Correo</th>
                <th scope="col">Rol</th>
            </tr>
            </thead>
            <tbody>
            <%
                int i;
                for (i = 0; i < listaUsuarios.size(); i++) {
            %>

            <tr>

                <th scope="row"><%= (i + 1)%></th>
                <td><a href = "ServletAdminCrudUsuario?id=<%=listaUsuarios.get(i).getId()%>"><%= listaUsuarios.get(i).getNombre()%></a></td>
                <td><%= listaUsuarios.get(i).getCorreo()%></td>
                <td><%= listaUsuarios.get(i).getRolDescripcion()%></td>
            </tr>

            <%
                }
                for (int j = 10; j > i; j--) {
            %>
            <tr>
                <th scope="row"><%= (12 - j)%></th>
                <td>*</td>
                <td>*</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </article>
    <!-- Navbar de paginación de los usuarios-->
    <nav aria-label="Paginación de usuarios">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    <!-- END Navbar de paginación de los usuarios-->
</section>
<!-- END Sección con la tabla de los usuarios -->


</body>
</html>
