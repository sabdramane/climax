<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp" %>
	 <div class="container">
        <div class="row">
            <div class="col-md-12 mt-4">
                <h2 class="text-center">Format CSV -Enregistrer un client</h2>
                <hr/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 form-group offset-md-3">
                <form:form modelAttribute="client" action="/csv/nouveau-client" method="post">
                   
                <div class="form-group">
                  <label:label path="nom">Nom</label>
                  <form:input path="nom"  class="form-control" />
                </div>
                <div class="form-group">
                    <label:label path="prenom">prenom</label>
                    <form:input path="prenom"  class="form-control" />
                </div>
                <div class="form-group">
                    <label:label path="age">age</label>
                    <form:input path="age"  class="form-control" />
                </div>
                <div class="form-group">
                    <label:label path="profession">profession</label>
                    <form:select path="profession" items="${professions}" class="form-control" />
                </div>
                <div class="form-group">
                    <label:label path="salaire">salaire</label>
                    <form:input path="salaire"  class="form-control" />
                </div>
               
                <button type="submit" class="btn btn-primary">Valider</button>
                <a href="/donnees-csv" class="btn btn-primary">Annuler</a>
                </form:form>
            </div>
        </div>
        
    </div>
<%@ include file="../footer.jsp" %>