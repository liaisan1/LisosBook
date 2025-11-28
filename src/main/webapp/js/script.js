// Ждем загрузки DOM
document.addEventListener('DOMContentLoaded', function() {

    const form = document.querySelector('form#registerForm');
    if (form) {
        form.addEventListener('submit', function(e) {
            const requiredFields = form.querySelectorAll('[required]');
            let isValid = true;
            let firstInvalidField = null;

            requiredFields.forEach(field => {
                if (!field.value.trim()) {
                    isValid = false;
                    field.style.borderColor = '#e74c3c';
                    if (!firstInvalidField) firstInvalidField = field;
                } else {
                    field.style.borderColor = '';
                }
            });

            if (!isValid) {
                e.preventDefault();
                alert('Пожалуйста, заполните все обязательные поля.');
                if (firstInvalidField) firstInvalidField.focus();
            }
        });
    }

    const formInputs = document.querySelectorAll('input, select, textarea');
    formInputs.forEach(input => {
        input.addEventListener('focus', function() {
            this.style.borderColor = '#3498db';
            this.style.boxShadow = '0 0 5px rgba(52, 152, 219, 0.3)';
        });
        input.addEventListener('blur', function() {
            this.style.borderColor = '';
            this.style.boxShadow = '';
        });
    });

    console.log('LisosBook JS для регистрации загружен!');
});
