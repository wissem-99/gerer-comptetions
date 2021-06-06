<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <h1 class="text-center text-success">Ajouter Equipe </h1>
                                    <form action="s7" method="post">
                                        <div class="mb-3">
                                            <label for="ie" class="form-label">Identifiant </label>
                                            <input type="text" class="form-control" id="ie" name="id_e">
                                        </div>
                                        <div class="mb-3">
                                            <label for="nc" class="form-label">Nom equipe </label>
                                            <input type="text" class="form-control" id="nc" name="nom_e">
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label for="np" class="form-label">Nom president </label>
                                            <input type="text" class="form-control" id="np" name="nomp_e">
                                        </div>
                                        <div class="mb-3">
                                            <label for="df" class="form-label">date fondation </label>
                                            <input type="date" class="form-control" id="df" name="df">
                                        </div>
                                        <div class="mb-3">
                                            <label for="nt" class="form-label">Nom Terrain </label>
                                            <input type="text" class="form-control" id="nt" name="nom_t">
                                        </div>
                                        <button type="submit" class="btn btn-success">Ajouter</button>
                                    </form>
                                </div>
                            </div>
                        </div>
</body>
</html>