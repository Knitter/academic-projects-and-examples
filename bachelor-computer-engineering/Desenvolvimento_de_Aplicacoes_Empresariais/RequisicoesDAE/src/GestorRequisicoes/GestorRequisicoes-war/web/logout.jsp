<%-- 
    Document   : logout
    Created on : 12/Fev/2008, 23:33:55
    Author     : Knitter
--%>
<%
    //Nao evita o problema da cache devido ao backbutton.
    //Ignorar.
    session.invalidate();
    response.sendRedirect("faces/index.jsp");
%>

