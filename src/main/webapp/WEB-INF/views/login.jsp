<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Вход" scope="request"/>
<jsp:include page="layout/header.jsp"/>

<div class="auth-container">
    <div class="auth-form">
        <h2>Вход в систему</h2>

        <c:if test="${not empty error}">
            <div class="alert alert-error">
                <c:out value="${error}"/>
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/auth/login" method="post">
            <div class="form-group">
                <label for="username">Логин:</label>
                <input type="text" id="username" name="username" required>
            </div>

            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" id="password" name="password" required>
            </div>

            <button type="submit" class="btn btn-primary">Войти</button>
        </form>

        <p>Нет аккаунта? <a href="${pageContext.request.contextPath}/auth/register">Зарегистрируйтесь</a></p>
    </div>
</div>

<jsp:include page="layout/footer.jsp"/>