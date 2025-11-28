<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <title>LisosBook — Главная</title>
</head>

<body>
<jsp:include page="/jsp/header.jsp" />

<!-- Большой приветственный блок -->
<section class="hero-landing">
    <h1>Добро пожаловать в LisosBook</h1>
    <p>Простая и удобная платформа для хранения ваших любимых книг и создания личного каталога.</p>
</section>

<!-- Вертикальные информационные блоки -->
<section class="features-landing-vertical">
    <div class="feature-card-vertical" style="background-color: #8A2BE2;">
        <h2>Добавляйте книги</h2>
        <p>Сохраняйте информацию о книгах, которые вам нравятся, в одном месте.</p>
    </div>

    <div class="feature-card-vertical" style="background-color: #6A1FB5;">
        <h2>Ищите книги</h2>
        <p>Находите книги по названию или автору быстро и без лишних усилий.</p>
    </div>

    <div class="feature-card-vertical" style="background-color: #4C0F8A;">
        <h2>Храните свои коллекции</h2>
        <p>Создавайте свои списки и держите любимые книги под рукой.</p>
    </div>
</section>

<!-- Вводная секция -->
<section class="landing-footer">
    <p>LisosBook — просто и удобно храните ваши книги!</p>
</section>

</body>
