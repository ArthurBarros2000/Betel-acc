document.getElementById('employee-form').addEventListener('submit', async function(e) {
    e.preventDefault(); 

    // Formata a data para o padrão esperado pelo backend (YYYY-MM-DD)
    const birthdate = new Date(document.getElementById('birthdate').value).toISOString().split('T')[0];
    const admissionDate = new Date(document.getElementById('admission-date').value).toISOString().split('T')[0];

    // Obtém o CPF e remove caracteres não numéricos
    const cpf = document.getElementById('cpf').value.replace(/[^\d]/g, '');

    const formData = {
        nome: document.getElementById('firstname').value,
        idade: birthdate,  // Data de nascimento formatada
        cpf: cpf,          // CPF formatado
        cargo: document.getElementById('position').value,
        senha: document.getElementById('password').value,
        endereco: document.getElementById('address').value,
        dataAdmissao: admissionDate,  // Data de admissão formatada
        salario: parseFloat(document.getElementById('salary').value)  // Converte salário para número
    };

    // Log dos dados a serem enviados
    console.log("Dados a serem enviados:", formData);

    try {
        const response = await axios.post('http://localhost:8080/auth/register', formData);

        if (response.status === 201) {
            alert('Funcionário cadastrado com sucesso!');
            console.log(response.data);
        }
    } catch (error) {
        alert('Não foi possível cadastrar funcionário!');
        if (error.response) {
            console.error('Erro de resposta:', error.response.data);
        } else if (error.request) {
            console.error('Erro de requisição:', error.request);
        } else {
            console.error('Erro:', error.message);
        }
    }
});
