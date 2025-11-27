<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Все книги" scope="request"/>
<jsp:include page="layout/header.jsp"/>

<div class="page-header">
    <h1>Каталог книг</h1>
    <a href="${pageContext.request.contextPath}/books/new" class="btn btn-primary">Добавить книгу</a>
</div>

<div class="search-section">
    <form action="${pageContext.request.contextPath}/books/search" method="get" class="search-form">
        <input type="text" name="q" placeholder="Поиск книг..." value="${searchQuery}">
        <button type="submit" class="btn btn-secondary">Найти</button>
    </form>
</div>

<c:if test="${not empty error}">
    <div class="alert alert-error">
        <c:out value="${error}"/>
    </div>
</c:if>

<div class="books-grid">
    <c:forEach var="book" items="${books}">
        <div class="book-card">
            <h3><c:out value="${book.title}"/></h3>
            <p class="book-author">Автор: <c:out value="${book.author}"/></p>
            <p class="book-details">
                <strong>ISBN:</strong> <c:out value="${book.isbn}"/><br>
                <strong>Год:</strong> <c:out value="${book.publicationYear}"/><br>
                <strong>Жанр:</strong> <c:out value="${book.genre}"/>
            </p>

            <div class="book-actions">
                <c:if test="${not collectionService.isBookInCollection(sessionScope.user.id, book.id)}">
                    <form action="${pageContext.request.contextPath}/collection/add" method="get" class="inline-form">
                        <input type="hidden" name="bookId" value="${book.id}">
                        <select name="condition" required>
                            <option value="">Выберите состояние</option>
                            <option value="Новая">Новая</option>
                            <option value="Отличная">Отличная</option>
                            <option value="Хорошая">Хорошая</option>
                            <option value="Удовлетворительная">Удовлетворительная</option>
                            <option value="Плохая">Плохая</option>
                        </select>
                        <button type="submit" class="btn btn-success btn-small">В коллекцию</button>
                    </form>
                </c:if>
                <c:if test="${collectionService.isBookInCollection(sessionScope.user.id, book.id)}">
                    <span class="in-collection">✅ В вашей коллекции</span>
                </c:if>

                <div class="admin-actions">
                    <a href="${pageContext.request.contextPath}/books/edit?id=${book.id}" class="btn btn-warning btn-small">Редактировать</a>
                    <a href="${pageContext.request.contextPath}/books/delete?id=${book.id}"
                       class="btn btn-danger btn-small"
                       onclick="return confirm('Удалить эту книгу?')">Удалить</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<c:if test="${empty books}">
    <div class="empty-state">
        <p>Книг не найдено.</p>
        <a href="${pageContext.request.contextPath}/books/new" class="btn btn-primary">Добавить первую книгу</a>
    </div>
</c:if>

<jsp:include page="layout/footer.jsp"/>