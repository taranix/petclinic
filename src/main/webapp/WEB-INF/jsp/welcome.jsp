<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<petclinic:layout pageName="home">
     <div class="row">
            <div class="col-md-12">
                <spring:url value="/resources/images/pets.png" htmlEscape="true" var="petsImage"/>
                <img class="img-responsive" src="${petsImage}"/>
            </div>
        </div>

    <h2>Incoming visits</h2>

            <c:forEach items="${vets}" var="vet">
                <table  class="table table-striped">
                     <caption>${vet}</caption>
                    <thead>
                        <tr>
                            <th>Time</th>
                            <th>Owner Name</th>
                            <th>Pet name</th>
                        </tr>
                    </thead>
                    <tbody>
                         <!-- Visists -->
                           <c:forEach var="visit" items="${vet.visits}">
                            <tr>
                            <td>
                               <c:out value="${visit.time} "/><br>
                            </td>
                            <td>
                                <c:out value="${visit.pet.owner.firstName} ${visit.pet.owner.lastName}"/><br>
                            </td>
                             <td>
                                <c:out value="${visit.pet.name} "/><br>
                              </td>
                           </tr>
                        </c:forEach>

                    </tbody>

                </table>
            </c:forEach>




</petclinic:layout>
