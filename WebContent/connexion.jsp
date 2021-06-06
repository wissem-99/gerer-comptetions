<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<link rel="stylesheet"href="connexion.css">
</head>
<body>
<div class="container">
        <section id="content">
          <form action="slogin" method="post">
            <h1>Connexion</h1>
            <div>
              <input type="text" placeholder="email" required="" id="username" name="em"/>
            </div>
            <div>
              <input type="password" placeholder="Mot de Passe" required="" id="password" name="ps" />
            </div>
            <div>
              <input type="submit" value="Connexion" />
              <a href="s9">oublier mot de passe ??</a>
              <a href="s2">inscription</a>
            </div>
          </form><!-- form -->
          
        </section><!-- content -->
      </div><!-- container -->
</body>
</html>