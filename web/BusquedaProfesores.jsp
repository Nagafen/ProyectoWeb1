<%-- 
    Document   : BusquedaAlumnos
    Created on : 19/02/2017, 01:03:35 AM
    Author     : crist
--%>

<%@page import="controlador.ProfesorDAO"%>
<%@page import="Modelo.Profesor"%>
<%@page import="Modelo.Estudiantes"%>
<%@page import="controlador.EstudianteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
        <title>Buscar Estudiante
        </title></head><body>
            <div style="text-align: center;">
                <form method="get" action="Buscar" name="Buscar">
                    Buscar Profesor<br>
                    <br>Por favor ingrese el ID del profesor que desea encontrar:<br>
                     ID: <input name="id" type="text"><br>
                    <br>
                    <input name="Buscar" type="submit">
                </form>
                 <%
          Profesor profesor = (Profesor)request.getAttribute("profesor");
           if(profesor != null){
               ProfesorDAO prd = new ProfesorDAO();
               prd.ListarUnitario(profesor.getId());
               int id = prd.id;
               String nombre = prd.nuevo1;
               String apellido = prd.nuevo2;
               int ext = prd.ext;
        %>   
          <br>
        <table >
            <tr>
               <td>Id</td>
               <td>Nombre</td> 
               <td>Apellido</td>
               <td>Extencion</td> 
            </tr>
            <tr>
               <td><%=id%></td>
               <td><%=nombre%></td>
               <td><%=apellido%></td>
               <td><%=ext%></td> 
        </tr>
        </table>
        
        <%
           }
        %>
            </div>
        </body>
</html>