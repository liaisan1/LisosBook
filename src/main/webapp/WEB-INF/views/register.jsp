<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Регистрация" scope="request"/>
<jsp:include page="layout/header.jsp"/>

<div class="auth-container">
    <div class="auth-form">
        <h2>Регистрация</h2>

        <c:if test="${not empty error}">
            <div class="alert alert-error">
                <c:out value="${error}"/>
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/auth/register" method="post">
            <div class="form-group">
                <label for="username">Логин:</label>
                <input type="text" id="username" name="username" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" id="password" name="password" required>
            </div>

            <div class="form-group">
                <label for="confirmPassword">Подтвердите пароль:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
            </div>

            <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
        </form>

        <p>Уже есть аккаунт? <a href="${pageContext.request.contextPath}/auth/login">Войдите</a></p>
    </div>
</div>

<jsp:include page="layout/footer.jsp"/>