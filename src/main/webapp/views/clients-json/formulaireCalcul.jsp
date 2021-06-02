<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp" %>
	 <div class="container">
        <div class="row">
            <div class="col-md-12 mt-4">
                <h2 class="text-center">Format JSON - Calcul de la moyenne de salaire par type de profession</h2>
                <hr/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 form-group offset-md-3">
                <form:form modelAttribute="client" action="/json/calcul-moyenne" method="post">
                    <form:label path="profession">Veuillez choisir une profession</form:label>
                    <form:select path="profession" items="${professions}" class="form-control" /><br/>
                    <button type="submit" class="btn btn-primary">Valider</button>
                    <a href="/donnees-json" class="btn btn-primary">Annuler</a>
                </form:form>
            </div>
        </div>
        
    </div>
<%@ include file="../footer.jsp" %>