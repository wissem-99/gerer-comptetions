<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

<body>
<nav class="navbar navbar-light bg-light fixed-top">
    <div class="container-fluid">
      <a class="navbar-brand" href="s4"><button class="btn btn-outline-success">competitions</button> </a>
      <a class="btn btn-outline-success" type="submit" href="s8">Profil</a>
    </div>
  </nav>
  <br><br><br>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <h1 class="text-center text-success">Modifier competition</h1>
        <form action="s12" method="post">
          <div class="mb-3">
           
            <label for="ic" class="form-label">Id competition</label>
           <select class="form-control" id="sel1" name="ic">
            <c:forEach var="c" items="${ compt }">
              <option ><c:out value="${ c.ic }" /> </option>
          
            </c:forEach>
            </select>
          </div>
 
          <div class="mb-3">
            <label for="ne" class="form-label">Format </label>
            <select class="form-control" id="sel1" name="f">
              <option value="championat">championat </option>
              <option value="cup">Cup</option>
              <option value="playoff">playoff</option>
            </select>
          </div>
          <div class="mb-3">
            <label for="db" class="form-label">Date Debut</label>
            <input type="date" class="form-control" id="db" name="db" required>
          </div>
          <div class="mb-3">
            <label for="df" class="form-label">Date Fin</label>
            <input type="date" class="form-control" id="df" name="df" required>
          </div>
          
          <div class="mb-3">
            <label for="ne" class="form-label">Nombre equipes paticipes </label>
            <input type="number" class="form-control" id="ne" name="ne" required>
          </div>
          <button type="submit" class="btn btn-success">Submit</button>
        </form>
      </div>
    </div>
  </div>
</body>
</html>