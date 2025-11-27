<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookCollection - Система коллекционирования книг</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <nav class="navbar">
        <div class="nav-container">
            <a href="${pageContext.request.contextPath}/" class="nav-logo">📚 BookCollection</a>
            <div class="nav-menu">
                <a href="${pageContext.request.contextPath}/auth/login" class="nav-link">Вход</a>
                <a href="${pageContext.request.contextPath}/auth/register" class="nav-link">Регистрация</a>
            </div>
        </div>
    </nav>

    <main class="main-content">
        <div class="container">
            <div class="hero-section">
                <h1>Добро пожаловать в BookCollection!</h1>
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

    <style>
        .hero-section {
            text-align: center;
            padding: 4rem 0;
        }

        .hero-section h1 {
            font-size: 3rem;
            margin-bottom: 1rem;
            color: #2c3e50;
        }

        .hero-subtitle {
            font-size: 1.25rem;
            color: #7f8c8d;
            margin-bottom: 3rem;
            max-width: 600px;
            margin-left: auto;
            margin-right: auto;
        }

        .hero-features {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 2rem;
            margin-bottom: 3rem;
        }

        .feature {
            background: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        .feature h3 {
            color: #2c3e50;
            margin-bottom: 1rem;
        }

        .hero-actions {
            display: flex;
            gap: 1rem;
            justify-content: center;
            flex-wrap: wrap;
        }

        .btn-large {
            padding: 1rem 2rem;
            font-size: 1.1rem;
        }

        @media (max-width: 768px) {
            .hero-section h1 {
                font-size: 2rem;
            }

            .hero-actions {
                flex-direction: column;
                align-items: center;
            }
        }
    </style>

    <script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>