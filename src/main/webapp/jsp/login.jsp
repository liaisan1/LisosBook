<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<jsp:include page="/jsp/header.jsp" />
<div class="auth-container">
    <div class="auth-form">
        <h2>Вход в систему</h2>

            <div class="alert alert-error">
            </div>

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
</body>


