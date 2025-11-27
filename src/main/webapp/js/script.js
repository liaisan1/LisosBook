/**
 * JavaScript для улучшения пользовательского опыта
 * Простые функции, которые легко объяснить
 */

// Ждем загрузки DOM
document.addEventListener('DOMContentLoaded', function() {

    // 1. ПОДТВЕРЖДЕНИЕ УДАЛЕНИЯ
    const deleteLinks = document.querySelectorAll('a[onclick], .btn-danger');
    deleteLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            // Если ссылка содержит текст "Удалить" - спрашиваем подтверждение
            if (link.textContent.includes('Удалить') || link.classList.contains('btn-danger')) {
                if (!confirm('Вы уверены, что хотите выполнить это действие?')) {
                    e.preventDefault(); // Отменяем действие
                }
            }
        });
    });

    // 2. ВАЛИДАЦИЯ ФОРМ
    const forms = document.querySelectorAll('form');
    forms.forEach(form => {
        form.addEventListener('submit', function(e) {
            const requiredFields = form.querySelectorAll('[required]');
            let isValid = true;
            let firstInvalidField = null;

            // Проверяем все обязательные поля
            requiredFields.forEach(field => {
                if (!field.value.trim()) {
                    isValid = false;
                    field.style.borderColor = '#e74c3c';

                    // Запоминаем первое невалидное поле
                    if (!firstInvalidField) {
                        firstInvalidField = field;
                    }
                } else {
                    field.style.borderColor = '';
                }
            });

            // Если есть ошибки - показываем сообщение и фокусируемся на первом поле
            if (!isValid) {
                e.preventDefault();
                alert('Пожалуйста, заполните все обязательные поля.');
                if (firstInvalidField) {
                    firstInvalidField.focus();
                }
            }
        });
    });

    // 3. АВТОМАТИЧЕСКОЕ СКРЫТИЕ СООБЩЕНИЙ
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(alert => {
        setTimeout(() => {
            alert.style.opacity = '0';
            alert.style.transition = 'opacity 0.5s ease';
            setTimeout(() => {
                if (alert.parentNode) {
                    alert.parentNode.removeChild(alert);
                }
            }, 500);
        }, 5000); // Исчезают через 5 секунд
    });

    // 4. ПОДСВЕТКА АКТИВНЫХ ССЫЛОК В НАВИГАЦИИ
    const currentPath = window.location.pathname;
    const navLinks = document.querySelectorAll('.nav-link');

    navLinks.forEach(link => {
        if (link.getAttribute('href') === currentPath) {
            link.style.backgroundColor = '#34495e';
            link.style.fontWeight = 'bold';
        }
    });

    // 5. ПРОСТАЯ АНИМАЦИЯ ДЛЯ КАРТОЧЕК
    const cards = document.querySelectorAll('.book-card, .collection-card');

    cards.forEach(card => {
        card.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-5px)';
        });

        card.addEventListener('mouseleave', function() {
            this.style.transform = 'translateY(0)';
        });
    });

    // 6. ПОДСКАЗКИ ДЛЯ ПОЛЕЙ ФОРМ
    const formInputs = document.querySelectorAll('input, select, textarea');

    formInputs.forEach(input => {
        // Показываем подсказку при фокусе
        input.addEventListener('focus', function() {
            this.style.borderColor = '#3498db';
            this.style.boxShadow = '0 0 5px rgba(52, 152, 219, 0.3)';
        });

        // Убираем подсказку при потере фокуса
        input.addEventListener('blur', function() {
            this.style.borderColor = '';
            this.style.boxShadow = '';
        });
    });

    // 7. ПРОГРЕСС БАР ДЛЯ ДЛИТЕЛЬНЫХ ОПЕРАЦИЙ
    const longOperationButtons = document.querySelectorAll('.btn-primary, .btn-success');

    longOperationButtons.forEach(button => {
        button.addEventListener('click', function() {
            // Показываем индикатор загрузки
            const originalText = this.textContent;
            this.textContent = 'Загрузка...';
            this.disabled = true;

            // Через 5 секунд возвращаем исходное состояние (на случай ошибки)
            setTimeout(() => {
                this.textContent = originalText;
                this.disabled = false;
            }, 5000);
        });
    });

    console.log('✅ LisosBook JavaScript загружен и готов к работе!');
});

/**
 * Простая функция для динамического поиска (можно добавить позже)
 */
function simpleSearch(inputId, containerClass) {
    const input = document.getElementById(inputId);
    const container = document.querySelector(containerClass);

    if (input && container) {
        input.addEventListener('input', function() {
            const searchTerm = this.value.toLowerCase();
            const items = container.querySelectorAll('.book-card, .collection-card');

            items.forEach(item => {
                const text = item.textContent.toLowerCase();
                if (text.includes(searchTerm)) {
                    item.style.display = 'block';
                } else {
                    item.style.display = 'none';
                }
            });
        });
    }
}