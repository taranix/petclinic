<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag body-content="empty" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>


<%@ attribute name="name" required="true" rtexprvalue="true" description="Name of corresponding property in bean object" %>
<%@ attribute name="label" required="true" rtexprvalue="true"  description="Label appears in red color if input is considered as invalid after submission" %>
<%@ attribute name="pattern" required="true" type="java.lang.String" %>
<%@ attribute name="time" required="true" rtexprvalue="true" description="Time value" %>

<!--
<fmt:parseDate value="${time}" pattern="HH:mm" var="parsedTime" type="time"/>
<fmt:formatDate value="${parsedTime}" type="time" pattern="${pattern}"/>
-->

<spring:bind path="${name}">
    <c:set var="cssGroup" value="form-group ${status.error ? 'has-error' : '' }"/>
    <c:set var="valid" value="${not status.error and not empty status.actualValue}"/>
    <div class="${cssGroup}">
        <label class="col-sm-2 control-label">${label}</label>

        <div class="col-sm-10">
            <form:input class="form-control" path="${name}" value="${parsedTime}" />
            <c:if test="${valid}">
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
            </c:if>
            <c:if test="${status.error}">
                <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
                <span class="help-inline">${status.errorMessage}</span>
            </c:if>
        </div>
    </div>
</spring:bind>
