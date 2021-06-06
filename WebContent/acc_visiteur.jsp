<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<style>
.cc
{
display:none;}
.football
{
background-color:red;
}
.handball
{
background-color:#0D5E9A ;
}
.basketball
{
background-color:#A2F0EF ;}
.volyball
{background-color:#C750A5 ;
}

</style>
<body>
<nav class="navbar navbar-light bg-light fixed-top">
        <div class="container-fluid">
          <a class="navbar-brand" href="s3">competitions </a> 
        </div>
      </nav>
      <br><br><br>
     
<h2> voici les listes des compétitions genéres par notre service </h2>
<h3>Chaque couleur regroupe disciplines </h3>
   <div class="row">
      <c:forEach var="c" items="${ compt }">
      <div class="col-sm-4">
      <div class="card">
      <div class="card-body <c:out value="${ c.cd }" />">
      <form action="s6" method="post">
        <p class="card-text"> Nom :<c:out value="${ c.nc }" /></p>
        <p class="card-text  "> Decpline :<c:out value="${ c.cd }" /></p>
        <p class="card-text"> Genre : <c:out value="${ c.gen}" /></p>
        <p class="card-text"> Categorie: <c:out value="${ c.cat}" /></p>
         <p class="card-text"> Nb equipes max  <c:out value="${ c.nbe}" /></p>
        <p class="card-text"> Date Debut : <c:out value="${ c.db}" /></p>
        <p class="card-text"> Date Fin: <c:out value="${ c.df}" /></p>
        </form>
      </div>
    </div>
    </div>
      </c:forEach>
      </div>
</body>
</html>