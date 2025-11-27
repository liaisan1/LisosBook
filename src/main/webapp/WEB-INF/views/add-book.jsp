<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Добавить книгу" scope="request"/>
<jsp:include page="layout/header.jsp"/>

<div class="form-container">
    <h1>Добавить новую книгу</h1>

    <c:if test="${not empty error}">
        <div class="alert alert-error">
            <c:out value="${error}"/>
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/books/new" method="post" class="book-form">
        <div class="form-group">
            <label for="title">Название книги:</label>
            <input type="text" id="title" name="title" required>
        </div>

        <div class="form-group">
            <label for="author">Автор:</label>
            <input type="text" id="author" name="author" required>
        </div>

        <div class="form-group">
            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn">
        </div>

        <div class="form-group">
            <label for="publicationYear">Год издания:</label>
            <input type="number" id="publicationYear" name="publicationYear" required>
        </div>

        <div class="form-group">
            <label for="genre">Жанр:</label>
            <input type="text" id="genre" name="genre" required>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Добавить книгу</button>
            <a href="${pageContext.request.contextPath}/books" class="btn btn-secondary">Отмена</a>
        </div>
    </form>
</div>

<jsp:include page="layout/footer.jsp"/>