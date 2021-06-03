<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
    
        <link rel="stylesheet" href="/css/bootstrap-4/css/bootstrap.min.css" >
	    <script src="/css/bootstrap-4/js/bootstrap.min.js"></script>
        <title>Agitex-Climax</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm navbar-dark bg-info">
            <a class="navbar-brand" href="#">Climax</a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                aria-expanded="false" aria-label="Toggle navigation"></button>
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Accueil <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                            Rapports statistiques
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                        <li><a class="dropdown-item" href="/donnees-csv">Données CSV</a></li>
                        <li><a class="dropdown-item" href="/donnees-xml">Données XML</a></li>
                        <li><a class="dropdown-item" href="/donnees-json">Données JSON</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="#">A propos</a>
                </li>
                </ul>            
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Rechercher">
                </form>
            </div>
        </nav>