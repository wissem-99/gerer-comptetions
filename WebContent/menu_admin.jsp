<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
    crossorigin="anonymous"></script>
<body>
    <nav class="navbar navbar-light bg-light fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="s4"><button class="btn btn-outline-success">competitions</button></a>
            <a class="btn btn-outline-success " type="submit" href="s8">Profil</a>

        </div>
        <nav>
            <div class="nav nav-tabs bg-light " id="nav-tab" role="tablist">
                <button class="nav-link active " id="nav-1-tab" data-bs-toggle="tab" data-bs-target="#nav-1"
                    type="button" role="tab" aria-controls="nav-1" aria-selected="false">Description</button>
                <button class="nav-link " id="nav-equipe-tab" data-bs-toggle="tab" data-bs-target="#nav-equipe"
                    type="button" role="tab" aria-controls="nav-equipe" aria-selected="false">equipes</button>
                <button class="nav-link" id="nav-joueur-tab" data-bs-toggle="tab" data-bs-target="#nav-joueur"
                    type="button" role="tab" aria-controls="nav-joueur" aria-selected="false">joueures</button>
                <button class="nav-link" id="nav-arbitre-tab" data-bs-toggle="tab" data-bs-target="#nav-arbitre"
                    type="button" role="tab" aria-controls="nav-arbitre" aria-selected="false">arbitres</button>
                <button class="nav-link" id="nav-match-tab" data-bs-toggle="tab" data-bs-target="#nav-match"
                    type="button" role="tab" aria-controls="nav-match" aria-selected="false">Matches</button>
            </div>
        </nav>
    </nav>
    <br><br><br><br>
    <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-1" role="tabpanel" aria-labelledby="nav-1-tab">
            <table class="table table-bordered border-success table-dark">
                <thead>
                    <tr>
                        <th scope="col">Id </th>
                        
                        <th scope="col">nom </th>
                        <th scope="col">Descipline</th>
                        <th scope="col">Categorie</th>
                        <th scope="col"> date debut </th>
                        <th scope="col"> date fin</th>
                        <th scope="col">nb equipes</th>
                        <th scope="col">Format</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${ compt }">
                <tr>
                <td> <c:out value="${ c.ic }" /></td>

                <td>  <c:out value="${ c.nc }"/></td>
                <td> <c:out value="${ c.cd }"/></td>
            
                <td><c:out value="${ c.cat }"/></td>
                <td><c:out value="${ c.db }"/></td>
                <td><c:out value="${ c.df }"/></td>
                <td><c:out value="${ c.nbe}"/></td>
                <td><c:out value="${ c.f }"/></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
          
        </div>
        <div class="tab-pane fade" id="nav-equipe" role="tabpanel" aria-labelledby="nav-equipe-tab">
            <table class="table table-bordered border-success table-dark">
                <thead>
                    <tr>
                        <th scope="col">id equipe </th>
                        <th scope="col">nom equipe </th>
                        <th scope="col">nom president </th>
                      
                        <th scope="col"> date de fondation </th>
                        <th scope="col"> nom de Terrain</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${ equipe }">
                <tr>
                <td> <c:out value="${ c.id_e }" /></td>
                <td>  <c:out value="${ c.nom_e }"/></td>
                <td> <c:out value="${ c.nomp_e }"/></td>
               
                <td><c:out value="${ c.df}"/></td>
                <td><c:out value="${ c.nom_t }"/></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <h1> Configurer votre liste des equipes</h1>
            <div class="d-flex align-items-start">
                <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">

                    <button class="nav-link active" id="v-pills-ajouter-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-ajouter" type="button" role="tab" aria-controls="v-pills-ajouter"
                        aria-selected="true">ajouter</button>
                    <button class="nav-link" id="v-pills-modifier-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-modifier" type="button" role="tab" aria-controls="v-pills-modifier"
                        aria-selected="false">modifier</button>
                    <button class="nav-link" id="v-pills-supprimer-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-supprimer" type="button" role="tab" aria-controls="v-pills-supprimer"
                        aria-selected="false">supprimer</button>
                </div>
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-ajouter" role="tabpanel"
                        aria-labelledby="v-pills-ajouter-tab">
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
                    </div>
                    <div class="tab-pane fade" id="v-pills-modifier" role="tabpanel"
                        aria-labelledby="v-pills-modifier-tab">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <h1 class="text-center text-success">Modifier equipe </h1>
                                    <form action="s15" method="post">
                                        <div class="mb-3">
                                            <label for="cars">Choose equipe:</label>
                            
                                            <select class="btn btn-secondary btn-sm dropdown-toggle " name="id_e"
                                                id="eqm">
                                                <c:forEach var="c" items="${ equipe }">
           <option>      <c:out value="${ c.id_e }" /></option>
                 </c:forEach>
                                            </select>
                                        
                                          
                                        </div>
                                       
                                        <div class="mb-3">
                                            <label for="np" class="form-label">Nom president </label>
                                            <input type="text" class="form-control" id="np" name="nomp_e">
                                        </div>
                                        <div class="mb-3">
                                            <label for="np" class="form-label">Nom equipe</label>
                                            <input type="text" class="form-control" id="np" name="nom_e">
                                        </div>
                                        <div class="mb-3">
                                            <label for="nt" class="form-label">Nom Terrain </label>
                                            <input type="text" class="form-control" id="nt" name="nom_t">
                                        </div>
                                        <button type="submit" class="btn btn-success">Modifier</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="tab-pane fade" id="v-pills-supprimer" role="tabpanel"
                        aria-labelledby="v-pills-supprimer-tab">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <h1 class="text-center text-success">Supprimer equipe </h1>
                                    <form action="s16" method="post">
                                        <div class="mb-3">
                                            <label for="ie" class="form-label">id equipe</label>
                                            <select class="btn btn-secondary btn-sm dropdown-toggle " name="id_e"
                                                id="eqm">
                                                <c:forEach var="c" items="${ equipe }">
           <option>      <c:out value="${ c.id_e }" /></option>
                 </c:forEach>
                                            </select>
                                        </div>
                                        <button type="submit" class="btn btn-success">Supprimer</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="nav-joueur" role="tabpanel" aria-labelledby="nav-joueur-tab">
            <table class="table table-bordered border-success table-dark">
                <thead>
                    <tr>
                        <th scope="col">id </th>
                        <th scope="col">Nom </th>
                        <th scope="col">Prenom</th>
                        <th scope="col">Date de naissance</th>
                        <th scope="col">pays/region</th>
                        <th scope="col">status</th>
                       
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${ joueur }">
                <tr>
                <td> <c:out value="${ c.idj }" /></td>
                <td>  <c:out value="${ c.nomj }"/></td>
                <td> <c:out value="${ c.prenomj }"/></td>
                <td><c:out value="${ c.dnj }"/></td>
                <td><c:out value="${ c.pays}"/></td>
                <td><c:out value="${ c.stj }"/></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <h1> Configurer votre liste des joueures</h1>
            <div class="d-flex align-items-start">
                <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">

                    <button class="nav-link active" id="v-pills-ajouterj-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-ajouterj" type="button" role="tab" aria-controls="v-pills-ajouterj"
                        aria-selected="true">Ajouter</button>
                    <button class="nav-link" id="v-pills-modifierj-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-modifierj" type="button" role="tab"
                        aria-controls="v-pills-modifierj-tab" aria-selected="false">Modifier</button>
                    <button class="nav-link" id="v-pills-supprimerj-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-supprimerj" type="button" role="tab" aria-controls="v-pills-supprimerj"
                        aria-selected="false">Supprimer</button>
                </div>
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-ajouterj" role="tabpanel"
                        aria-labelledby="v-pills-ajouterj-tab">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <h1 class="text-center text-success">Ajouter joueur </h1>
                                    <form action="ajout_joueur" method="post">
                                        <div class="mb-3">
                                            <label for="ie" class="form-label">Identifiant </label>
                                            <input type="text" class="form-control" id="ie" name="idj">
                                        </div>
                                       
                                        <div class="mb-3">
                                            <label for="nc" class="form-label">Nom </label>
                                            <input type="text" class="form-control" id="nc" name="nomj">
                                        </div>
                                        <div class="mb-3">
                                            <label for="np" class="form-label">Prenom </label>
                                            <input type="text" class="form-control" id="np" name="prenomj">
                                        </div>
                                        <div class="mb-3">
                                            <label for="df" class="form-label">date de naissance </label>
                                            <input type="date" class="form-control" id="df" name="dnj">
                                        </div>
                                        <div class="mb-3">
                                            <label for="nt" class="form-label">pays</label>
                                            <input type="text" class="form-control" id="nt" name="pays">
                                        </div>
                                        <select class="btn btn-success dropdown-toggle" eqm" id="eqm" name="stj">
                                             <option>Libre</option>
                                             <c:forEach var="c" items="${ equipe }">
           <option>      <c:out value="${ c.id_e }" /></option>
           </c:forEach>
                                        </select>
                                        <br><br>
                                        <button type="submit" class="btn btn-success">Ajouter</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="v-pills-modifierj" role="tabpanel"
                        aria-labelledby="v-pills-modifierj-tab">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <h1 class="text-center text-success">Modifier joueur </h1>
                                    <form action="modif_joueur" method="post">
                                        <div class="mb-3">
                                            <label for="cars">Choisir joueur:</label>

                                            <select class="btn btn-secondary btn-sm dropdown-toggle " name="idj"
                                                id="eqm">
                                                <c:forEach var="c" items="${ joueur }">
           <option>      <c:out value="${ c.idj }" /></option>
           </c:forEach>
                                            </select>
                                            <select class="btn btn-success dropdown-toggle" eqm" id="eqm" name="stj">
                                             <option>Libre</option>
                                             <c:forEach var="c" items="${ equipe }">
           <option>      <c:out value="${ c.nom_e }" /></option>
           </c:forEach>
                                        </select>
                                        </div>
                     
                                        <br><br>
                                        <button type="submit" class="btn btn-success">Modidier</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="tab-pane fade" id="v-pills-supprimerj" role="tabpanel"
                        aria-labelledby="v-pills-supprimerj-tab">
                        <div class="container">

                            <div class="row">
                                <div class="col-12">
                                    <h1 class="text-center text-success">Supprimer joueur </h1>
                                    <form action="supp_joueur" method="post">
                                        <div class="mb-3">
                                            <label for="ie" class="form-label">id joueur</label>
                                            <select class="btn btn-secondary btn-sm dropdown-toggle " name="idj"
                                                id="eqm">
                                                <c:forEach var="c" items="${ joueur }">
           <option>      <c:out value="${ c.idj }" /></option>
           </c:forEach>
                                            </select>
                                        </div>
                                        <button type="submit" class="btn btn-success">Supprimer</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="nav-arbitre" role="tabpanel" aria-labelledby="nav-arbitre-tab">
            <table class="table table-bordered border-success table-dark">
                <thead>
                    <tr>
                        <th scope="col">id</th>
                         <th scope="col">Nom</th>
                        <th scope="col">Prenom</th>
                        <th scope="col">Date de naissance</th>
                        <th scope="col">pays</th>
                  
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${ arbitre }">
                <tr>
                <td> <c:out value="${ c.idar }" /></td>
                <td>  <c:out value="${ c.nomar }"/></td>
                <td> <c:out value="${ c.prenomar }"/></td>
                <td><c:out value="${ c.dnar}"/></td>
                <td><c:out value="${ c.paysar }"/></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="d-flex align-items-start">
                <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">

                    <button class="nav-link active" id="v-pills-ajouterr-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-ajouterr" type="button" role="tab" aria-controls="v-pills-ajouterr"
                        aria-selected="true">Ajouter</button>
                   
                    <button class="nav-link" id="v-pills-supprimerr-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-supprimerr" type="button" role="tab" aria-controls="v-pills-supprimerr"
                        aria-selected="false">Supprimer</button>
                </div>
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-ajouterr" role="tabpanel"
                        aria-labelledby="v-pills-ajouterr-tab">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <h1 class="text-center text-success">Ajouter arbitre</h1>
                                    <form action="ajout_arbitre" method="post">
                                        <div class="mb-3">
                                            <label for="ie" class="form-label">Identifiant </label>
                                            <input type="text" class="form-control" id="ie" name="idar">
                                        </div>
                                      
                                        <div class="mb-3">
                                            <label for="nc" class="form-label">Nom </label>
                                            <input type="text" class="form-control" id="nc" name="nomar">
                                        </div>
                                        <div class="mb-3">
                                            <label for="np" class="form-label">Prenom </label>
                                            <input type="text" class="form-control" id="np" name="prenomar">
                                        </div>
                                        <div class="mb-3">
                                            <label for="df" class="form-label">date de naissance </label>
                                            <input type="date" class="form-control" id="df" name="dnar">
                                        </div>
                                        <div class="mb-3">
                                            <label for="nt" class="form-label">pays </label>
                                            <input type="text" class="form-control" id="nt" name="paysar">
                                        </div>
                                        <button type="submit" class="btn btn-success">Ajouter</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="tab-pane fade" id="v-pills-supprimerr" role="tabpanel"
                        aria-labelledby="v-pills-supprimerr-tab">
                        <div class="container">

                            <div class="row">
                                <div class="col-12">
                                    <h1 class="text-center text-success">Supprimer arbitre </h1>
                                    <form action="supp_arbitre" method="post">
                                        <div class="mb-3">
                                             <select class="btn btn-secondary btn-sm dropdown-toggle " name="idj"
                                                id="eqm">
                                                <c:forEach var="c" items="${ arbitre }">
           <option>      <c:out value="${ c.idar }" /></option>
           </c:forEach>
                                            </select>
                                        </div>
                                        <button type="submit" class="btn btn-success">Supprimer</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="nav-match" role="tabpanel" aria-labelledby="nav--match-tab">.
            <table class="table table-bordered border-success table-dark">
                <thead>
                    <tr>
                        <th scope="col">Id </th>
                        <th scope="col">Journée/Tour</th>
                        <th scope="col">Equipe 1 </th>
                        <th scope="col">Equipe 2</th>
                        <th scope="col">Terrain</th>
                        <th scope="col"> Date </th>
                        <th scope="col">Resultat</th>
                        <th scope="col">Arbitre</th>
                        <th scope="col"> Etat</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${ match }">
                <tr>
                <td> <c:out value="${ c.idm }" /></td>
                <td>  <c:out value="${ c.jtm }"/></td>
                <td> <c:out value="${ c.eq1 }"/></td>
                <td><c:out value="${ c.eq2 }"/></td>
                <td><c:out value="${ c.tm}"/></td>
                <td><c:out value="${ c.dm }"/></td>
                 <td><c:out value="${ c.rm }"/></td>
                  <td><c:out value="${ c.arm }"/></td>
                   <td><c:out value="${ c.etat }"/></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="d-flex align-items-start">
                <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <button class="nav-link active" id="v-pills-ajouterm-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-ajouterm" type="button" role="tab" aria-controls="v-pills-ajouterm"
                        aria-selected="true">Ajouter</button>
                    <button class="nav-link" id="v-pills-saisir-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-saisir" type="button" role="tab" aria-controls="v-pills-saisir-tab"
                        aria-selected="false">Modifier</button>
                </div>
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-ajouterm" role="tabpanel"
                        aria-labelledby="v-pills-ajouterm-tab">
                        <div class="container">

                            <div class="row">
                                <div class="col-12">
                                    <h1 class="text-center text-success">Ajouter Match</h1>
                                    <form action="ajout_match" method="post">
                                        <div class="mb-3">
                                            <label for="ie" class="form-label">Identifiant </label>
                                            <input type="text" class="form-control" id="ie" name="idm">
                                        </div>
                                      <div class="mb-3">
                                            <label for="ie" class="form-label">Journée/Tour </label>
                                            <input type="text" class="form-control" id="ie" name="jtm">
                                        </div>
                                        <p> Equipe à domicile :</p>
                                        <select class="btn btn-success dropdown-toggle " name="eq1" id="ed">
                                            <c:forEach var="c" items="${ equipe }">
                                           <option> <c:out value="${ c.nom_e }" /> </option>
                                                </c:forEach>
                                        </select><br>
                                        <p> Equipe  à exterieur:</p>
                                        <select class="btn btn-success dropdown-toggle" name="eq2" id="ed">
                                            <c:forEach var="c" items="${ equipe }">
                                           <option> <c:out value="${ c.nom_e }" /> </option>
                                                </c:forEach>
                                        </select><br><br>
                                        <p> Arbitre:</p>
                                        <select class="btn btn-success dropdown-toggle" name="arm">
                                             <c:forEach var="c" items="${ arbitre }">
                                           <option> <c:out value="${ c.nomar }" />  <c:out value="${ c.prenomar }" /></option>
                                                </c:forEach>
                                        </select><br>
                                        <p>Terrain</p>
                                        <select class="btn btn-success dropdown-toggle " name="tm">
                                        <c:forEach var="c" items="${ equipe }">
                                           <option> <c:out value="${ c.nom_t }" /> </option>
                                                </c:forEach>
                                        </select><br>
                                
                                        <div class="mb-3">
                                            <label for="df" class="form-label">date de Match </label>
                                            <input type="date" class="form-control" id="df" name="dm">
                                        </div>
                                        <br>
                                        <button type="submit" class="btn btn-success">Ajouter</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="v-pills-saisir" role="tabpanel" aria-labelledby="v-pills-saisir-tab">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <h1 class="text-center text-success">Saisir Match</h1>
                                    <form action="modif_match" method="post">
                                        <select class="btn btn-success dropdown-toggle" id="mr" name="idm">
                                            <c:forEach var="c" items="${ match_non_joues }">
                                           <option> <c:out value="${ c.idm }" /> </option>
                                                </c:forEach>
                                        </select><br>
                                        <div class="mb-3">
                                            <label for="sm" class="form-label">Resultat</label>
                                            <input type="text" class="form-control" id="sm" name="rm"
                                             placeholder="eq1 5-1 eq2">
                                        </div>
                                 
                                        <button type="submit" class="btn btn-success">Saisir</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
</body>
</html>