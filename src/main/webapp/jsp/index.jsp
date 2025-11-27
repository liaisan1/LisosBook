<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>LisosBook - Система коллекционирования книг</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp" />
    <nav class="navbar">
        <div class="nav-container">
            <a href="${pageContext.request.contextPath}/" class="nav-logo">📚 LisosBook</a>
            <div class="nav-menu">
                <a href="${pageContext.request.contextPath}/auth/login" class="nav-link">Вход</a>
                <a href="${pageContext.request.contextPath}/auth/register" class="nav-link">Регистрация</a>
            </div>
        </div>
    </nav>

    <main class="main-content">
        <div class="container">
            <div class="hero-section">
                <h1>Добро пожаловать в LisosBook!</h1>
                <p class="hero-subtitle">Ваша личная система для коллекционирования и управления библиотекой книг</p>

                <div class="hero-features">
                    <div class="feature">
                        <h3>📖 Коллекционируйте книги</h3>
                        <p>Создайте свою уникальную коллекцию любимых книг</p>
                    </div>
                    <div class="feature">
                        <h3>🔍 Управляйте каталогом</h3>
                        <p>Добавляйте, редактируйте и ищите книги в вашей библиотеке</p>
                    </div>
                    <div class="feature">
                        <h3>👤 Персональный доступ</h3>
                        <p>Только вы имеете доступ к вашей личной коллекции</p>
                    </div>
                </div>

                <div class="hero-actions">
                    <a href="${pageContext.request.contextPath}/auth/register" class="btn btn-primary btn-large">
                        Начать коллекционировать
                    </a>
                    <a href="${pageContext.request.contextPath}/auth/login" class="btn btn-secondary">
                        Уже есть аккаунт
                    </a>
                </div>
            </div>
        </div>
    </main>

    <script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>