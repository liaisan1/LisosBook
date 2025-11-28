<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<body>
<form action="${pageContext.request.contextPath}/admin" method="post">
    <input type="hidden" name="form" value="book">
    <label>Название книги:</label>
    <input type="text" name="title" placeholder="Введите название книги" required><br><br>

    <label>Автор:</label>
    <input type="text" name="author" placeholder="Введите ФИО автора" required><br><br>

    <label>Год выпуска:</label>
    <input type="text" name="publicationYear" placeholder="Введите год выпуска книги" required><br><br>

    <label>Жанр:</label>
    <input type="text" name="genre" placeholder="Введите жанр книги" required><br><br>

    <button type="submit" name="action" value="addBook">Добавить книгу</button>
</form>>

<form action="${pageContext.request.contextPath}/admin" method="post">
    <input type="hidden" name="form" value="book">

    <label>Название книги:</label>
    <input type="text" name="title" placeholder="Введите название книги" required><br><br>

    <button type="submit" name="action" value="deleteBook">Удалить книгу</button>
</form>
</body>