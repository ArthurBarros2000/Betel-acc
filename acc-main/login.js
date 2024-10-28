const loginForm = document.getElementById('loginForm');

loginForm.addEventListener('submit', async (e) => {
    e.preventDefault(); 

    const CPF = document.getElementById('CPF').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('http://localhost:8080/auth/login', {  // Corrigido para /auth/login
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ CPF: CPF, password: password }),
        });

        if (response.ok) {
            const data = await response.json(); 
            console.log(data); 

            if (data.token) {
                localStorage.setItem('token', data.token); 
                alert('Login realizado com sucesso!');
                window.location.href = './menu.html';
            } else {
                alert('Erro ao realizar login. Verifique suas credenciais.');
            }
        } else {
            const errorData = await response.json(); // Tenta obter detalhes do erro
            alert(`Erro no login: ${errorData.message || 'Verifique suas credenciais.'}`);
        }
    } catch (error) {
        console.error('Erro:', error);
        alert('Não foi possível entrar, tente novamente.');
    }
});

// Função para fazer requisições autenticadas com o token
async function fetchWithToken(url, options = {}) {
    const token = localStorage.getItem('token');
    if (!token) {
        alert("Usuário não autenticado. Faça login novamente.");
        return;
    }

    const headers = {
        'Content-Type': 'application/json',
        ...options.headers,
        'Authorization': `Bearer ${token}` 
    };

    try {
        const response = await fetch(url, {
            ...options,
            headers: headers,
        });

        return response;  // Retorna a resposta para que possa ser manipulada posteriormente
    } catch (error) {
        console.error('Erro ao fazer requisição autenticada:', error);
    }
}

// Exemplo de como usar a função fetchWithToken para fazer requisições autenticadas
async function getUserData() {
    try {
        const response = await fetchWithToken('http://localhost:8080/userdata', {
            method: 'GET'
        });

        if (response && response.ok) {
            const data = await response.json();
            console.log(data);
        } else if (response) {
            console.error('Erro ao buscar dados do usuário.', response.status);
        } else {
            console.error('Erro ao buscar dados do usuário.');
        }
    } catch (error) {
        console.error('Erro:', error);
    }
}
