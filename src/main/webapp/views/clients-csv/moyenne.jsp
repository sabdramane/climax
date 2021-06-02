<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp" %>
	 <div class="container">
        <div class="row">
            <div class="col-md-12 mt-4">
                <h2 class="text-center">Format CSV - Calcul de la moyenne de salaire par type de profession</h2>
                <hr/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 form-group offset-md-3">
               <div class="alert alert-success" role="alert">
                   La moyenne de salaire des <span>${profession}</span>  est <span>${moyenne} K€</span> <br> <br>
                   <a href="/csv/calcul-moyenne" class="btn btn-info">Retour</a>
               </div>
            </div>
        </div>
        
    </div>
<%@ include file="../footer.jsp" %>