<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
  <link rel="stylesheet"href="inscit.css">
<body>
<div class="container">
        <section id="content">
          <form action="inscrit" method="post" name="f">
            <h1>Créer Compte</h1>
            <div>
              <input type="text" placeholder="nom" required="" id="firstname" name="nom" />
            </div>
            <div>
                <input type="text" placeholder="prenom" required="" id="lastname" name="prenom" />
            </div>
            <div>
                <input type="date" placeholder="Date De Naissance" required="" id="date" name="dn" />
              </div>
            <div>
                <input type="text" placeholder="adresse" required="" id="adr" name="adr"/>
            </div>
           
           
            <div>
                <input type="email" placeholder="Email" required="" id="email" name="mail"/>
            </div>
         
            <div>
              <input type="password" placeholder="Mot de passe" required="" id="password" name="mdp"/>
            </div>
            <div>
                <input type="password" placeholder="Confirmer Password" required="" id="pass" name="mdpc"/>
              </div>
               <p id="demo"></p>
            <div>
                <input type="submit" value="Créer Compte" onclick="verif()" />
            </div>
          </form><!-- form -->
         
        </section><!-- content -->
      </div><!-- container -->
      <script>
      function verif() {
    	  
    	  if (f.mdp.value!=f.mdpc.value) {
    	    document.getElementById("demo").innerHTML = "Le Meme Mot de passe dans les deux cases";
    	    document.getElementById("pass").value = ""
    	    return false;
    	  }
    	} 
      </script>
</body>
</html>