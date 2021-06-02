<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
	 <div class="container">
        <div class="row">
            <div class="col-md-12 mt-4">
                <h1 class="text-center">Rapports statistiques sur les données clients </h1>
                <hr/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4  ">
                    <div class="card" style="width: 18rem;">
                        <img src="../images/csvimg.png" class="card-img-top" alt="...">
                        <div class="card-body">
                        <h5 class="card-title">Données CSV</h5>
                        <p class="card-text">Rapports statistiques sur des données de format CSV</p>
                        <a href="/donnees-csv" class="btn btn-primary">Accéder</a>
                        </div>
                    </div>
            </div>
            <div class="col-md-4  ">
                <div class="card" style="width: 18rem;">
                    <img src="../images/xmlimg.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Données XML</h5>
                        <p class="card-text">Rapports statistiques sur des données de format XML</p>
                        <a href="/donnees-xml" class="btn btn-primary">Accéder</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4  ">
                <div class="card" style="width: 18rem;">
                    <img src="../images/jsonimg.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Données JSON</h5>
                        <p class="card-text">Rapports statistiques sur des données de format json</p>
                        <a href="/donnees-json" class="btn btn-primary">Accéder</a>
                    </div>
                </div>     
        	</div>
        </div>
    </div>
<%@ include file="footer.jsp" %>