document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('cadastroVeiculoForm');

    if (form) {
        console.log('Formulário encontrado');

        form.addEventListener('submit', async function(event) {
            event.preventDefault();

            const formData = new FormData(this);
            const data = {};
            formData.forEach((value, key) => {
                data[key] = value;
            });

            try {
                const response = await fetch('http://localhost:8080/carro', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(data)
                });

                if (response.ok) {
                    const responseData = await response.json();
                    console.log(responseData); 
                    alert('Carro cadastrado com sucesso!');
                    form.reset(); 
                } else {
                    
                    if (response.status === 403) {
                        alert('Acesso negado! Você não tem permissão para cadastrar o veículo.');
                    } else {
                        const errorData = await response.json(); 
                        console.error('Erro do servidor:', errorData);
                        alert('Não foi possível cadastrar o veículo. Verifique os dados e tente novamente.');
                    }
                }
            } catch (error) {
                console.error('Erro:', error);
                alert('Erro ao conectar ao servidor.');
            }
        });
    } else {
        console.error('Formulário não encontrado');
    }
});
