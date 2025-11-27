<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Моя коллекция" scope="request"/>
<jsp:include page="layout/header.jsp"/>

<div class="page-header">
    <h1>Моя коллекция книг</h1>
    <a href="${pageContext.request.contextPath}/books" class="btn btn-primary">Все книги</a>
</div>

<c:if test="${not empty error}">
    <div class="alert alert-error">
        <c:out value="${error}"/>
    </div>
</c:if>

<div class="collection-grid">
    <c:forEach var="item" items="${collection}">
        <div class="collection-card">
            <h3><c:out value="${item.book.title}"/></h3>
            <p class="book-author">Автор: <c:out value="${item.book.author}"/></p>
            <p class="book-details">
                <strong>ISBN:</strong> <c:out value="${item.book.isbn}"/><br>
                <strong>Год:</strong> <c:out value="${item.book.publicationYear}"/><br>
                <strong>Жанр:</strong> <c:out value="${item.book.genre}"/><br>
                <strong>Состояние:</strong> <c:out value="${item.condition}"/><br>
                <strong>Добавлено:</strong> ${item.addedDate}
            </p>

            <div class="collection-actions">
                <a href="${pageContext.request.contextPath}/collection/remove?bookId=${item.bookId}"
                   class="btn btn-danger btn-small"
                   onclick="return confirm('Удалить книгу из коллекции?')">Удалить из коллекции</a>
            </div>
        </div>
    </c:forEach>
</div>

<c:if test="${empty collection}">
    <div class="empty-state">
        <p>Ваша коллекция пуста.</p>
        <a href="${pageContext.request.contextPath}/books" class="btn btn-primary">Добавить книги в коллекцию</a>
    </div>
</c:if>

<jsp:include page="layout/footer.jsp"/>