document.getElementById('loginForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const CPF = document.getElementById('CPF').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('http://localhost:8080/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ cpf: CPF, password: password })
        });

        if (response.ok) {
            const data = await response.json();
            if (data.token) {
                localStorage.setItem('token', data.token);
                alert('Login realizado!');
                window.location.href = './menu.html';
            } else {
                alert('Erro ao realizar login. Verifique seu CPF e sua senha.');
            }
        } else {
            const errorData = await response.text();
            alert(`Erro no login: ${errorData || 'Verifique suas credenciais.'}`);
        }
    } catch (error) {
        console.error('Erro:', error);
        alert('Não foi possível entrar, tente novamente.');
    }
});
