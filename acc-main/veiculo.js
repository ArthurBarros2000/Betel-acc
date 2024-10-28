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
                    const responseData = await response.json(); // Captura a resposta do servidor
                    console.log(responseData); // Loga a resposta do servidor
                    alert('Carro cadastrado com sucesso!');
                    form.reset(); // Limpa o formulário após o cadastro
                } else {
                    // Trata diferentes códigos de status da resposta
                    if (response.status === 403) {
                        alert('Acesso negado! Você não tem permissão para cadastrar o veículo.');
                    } else {
                        const errorData = await response.json(); // Captura detalhes do erro
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
