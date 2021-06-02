<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp" %>
	 <div class="container">
        <div class="row">
            <div class="col-md-12 mt-4">
                <h1 class="text-center">Liste des clients à partir de fichier de format XML </h1>
                <hr/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 mb-2 mt-3" >
                <a href="/xml/calcul-moyenne" class="btn btn-info">Calculer la moyenne de salaire</a>
                <a href="/xml/nouveau-client" class="btn btn-info">Nouveau client</a>
            </div>
        </div>
        <div class="row">
           <div class="col-md-10">
            <table class="table">
                <thead>
                    <tr>
                        <th>Nom et prénom</th>
                        <th>Age</th>
                        <th>Profession</th>
                        <th>Salaire</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach  items="${clients}" var="client"> 
                         <tr> 
                            <td>${client.nom} ${client.prenom}</td>
                            <td>${client.age}</td>
                            <td>${client.profession} </td>
                            <td>${client.salaire} K€</td>
                         </tr> 
                     </c:forEach>  
                </tbody>
            </table>
           </div>
        </div>
    </div>
<%@ include file="../footer.jsp" %>