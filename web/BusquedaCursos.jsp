<%-- 
    Document   : BusquedaAlumnos
    Created on : 19/02/2017, 01:03:35 AM
    Author     : crist
--%>

<%@page import="controlador.CursosDao"%>
<%@page import="Modelo.Cursos"%>
<%@page import="controlador.EstudianteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
        <title>Buscar Curso
        </title></head><body>
            <div style="text-align: center;">
                <form method="get" action="BuscarAlumno" name="BuscarAlumno">
                    Buscar Curso<br>
                    <br>Por favor ingrese el Codigo del curso que desea encontrar:<br>
                     ID: <input name="codigo" type="text"><br>
                    <br>
                    <input name="Buscar" type="submit">
                </form>
                 <%
          Cursos curso = (Cursos)request.getAttribute("curso");
           if(curso != null){
               CursosDao cursos = new CursosDao();
               cursos.ListarUnitario(curso.getCodigo());
               int id = cursos.codigo;
               String nombre = cursos.nuevo1;
               int dura = cursos.dur;
               int idProf = cursos.idProf;
        %>   
          <br>
        <table >
            <tr>
               <td>Id</td>
               <td>Nombre</td> 
               <td>Apellido</td>
               <td>Telefono</td> 
            </tr>
            <tr>
               <td><%=id%></td>
               <td><%=nombre%></td>
               <td><%=dura%></td>
               <td><%=idProf%></td> 
        </tr>
        </table>
        
        <%
           }
        %>
            </div>
        </body>
</html>