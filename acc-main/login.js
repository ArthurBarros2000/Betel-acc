const loginForm = document.getElementById('loginForm');

        
        loginForm.addEventListener('submit', async (e) => {
            e.preventDefault(); 

            
            const CPF = document.getElementById('CPF').value;
            const password = document.getElementById('password').value;

           
            try {
                const response = await fetch('htpp://localhost:8080/login', { 
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
                        alert('Cadastrado com sucesso !');
                        window.location.href = './menu.html';
                    } else {
                        alert('Erro ao realizar login. Verifique suas credenciais.');
                    }
                } else {
                    
                    alert('Erro no login. Verifique suas credenciais.');
                }
            } catch (error) {
                console.error('Erro:', error);
                alert('Não foi possível entrar, tente novamente.');
            }
        });
