<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LisosBook - </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>


<body>
    <nav class="navbar">
        <div class="nav-container">
            <a href="${pageContext.request.contextPath}/book" class="nav-logo">LisosBook</a>
            <div class="nav-menu">
                    <a href="${pageContext.request.contextPath}/main" class="nav-link">Главная страница</a>
                    <a href="${pageContext.request.contextPath}/book" class="nav-link">Все книги</a>
                    <a href="${pageContext.request.contextPath}/collection" class="nav-link">Моя коллекция</a>
                    <a href="${pageContext.request.contextPath}/register" class="nav-link">Регистрация</a>
                    <a href="${pageContext.request.contextPath}/login" class="nav-link">Войти</a>
                    <a href="${pageContext.request.contextPath}/exit" class="nav-link">Выйти</a>

            </div>
        </div>
    </nav>
</body>