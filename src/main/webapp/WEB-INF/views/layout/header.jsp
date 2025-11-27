<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BookCollection - <c:out value="${pageTitle}" default="Главная"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <nav class="navbar">
        <div class="nav-container">
            <a href="${pageContext.request.contextPath}/books" class="nav-logo">📚 BookCollection</a>
            <div class="nav-menu">
                <c:if test="${not empty sessionScope.user}">
                    <a href="${pageContext.request.contextPath}/books" class="nav-link">Все книги</a>
                    <a href="${pageContext.request.contextPath}/collection" class="nav-link">Моя коллекция</a>
                    <span class="nav-user">Привет, ${sessionScope.user.username}!</span>
                    <a href="${pageContext.request.contextPath}/auth/logout" class="nav-link">Выйти</a>
                </c:if>
                <c:if test="${empty sessionScope.user}">
                    <a href="${pageContext.request.contextPath}/auth/login" class="nav-link">Вход</a>
                    <a href="${pageContext.request.contextPath}/auth/register" class="nav-link">Регистрация</a>
                </c:if>
            </div>
        </div>
    </nav>

    <main class="main-content">
        <div class="container">