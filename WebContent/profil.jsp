<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

<link rel="stylesheet" href="profil.css">
<body>
<nav class="navbar navbar-light bg-light fixed-top">
    <div class="container-fluid">
      <a class="navbar-brand" href="s4"><button class="btn btn-outline-success">competitions</button></a>
      <a class="btn btn-outline-success" type="submit">Profil</a>
    </div>
  </nav>
  <br><br><br>
<h2 style="text-align:center"> Profile </h2>

<div class="card">
<c:forEach var="c" items="${ client }">
  
  <h1>Nom Prenom : <c:out value="${ c.nom }" /> <c:out value="${ c.prenom }" /> </h1>
  <p>Adresse :  <c:out value="${ c.adr }" /></p>
  <p>Date de Naissance : <c:out value="${ c.dn }" /></p>
 </c:forEach>
  <p><button onclick="myFunction()">Modifier</button></p>
</div>


<div id="mod">
    <h3 >Modification</h3>
    <form action="s8" method="post" name="f">
    <c:forEach var="c" items="${ client }">
        <label for="fname" style="color:black;text-decoration: black;">Nom</label><br>
        <input type="text" id="fname"  name="nom" value=<c:out value="${ c.nom }"/>><br>
        <label for="lname" style="color: black ;">Prenom</label><br>
        <input type="text" id="lname" name="prenom"value=<c:out value="${ c.prenom }"/>><br><br>
        <label for="Dn" style="color: black ;">Date de naissance :</label><br>
        <input type="date" id="Dn"  name="dn" value=<c:out value="${ c.dn }"/>><br><br>
        <label for="city" style="color:black ;">Adresse</label><br>
        <input type="text" id="city"  name="adr" value=<c:out value="${ c.adr }"/>><br><br>
        <label for="password" style="color:black ;">Mot de passe </label><br>
        <input type="text"  name="mdp" value=<c:out value="${ c.mdp }"/>><br><br>
         <label for="password" style="color:black ;">Confirmer Mot de passe</label><br>
        <input type="password" id="pass" name="mdpc" placeholder="Confirmer Password" required="" id="password" />
        </c:forEach>
        <p id="demo"></p>
        <p><button onclick="verif()" >Enregistrer</button></p>
      </form> 
</div>

<script>
function myFunction() {
	
	var x = document.getElementById("mod");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }    
}
function verif() {
	
	  if (f.mdp.value!=f.mdpc.value) {
	    document.getElementById("demo").innerHTML = "Le Meme Mot de passe dans les deux cases";
	    document.getElementById("pass").value= ""
	    return false;
	  }
	} 
</script>

</body>
</html>