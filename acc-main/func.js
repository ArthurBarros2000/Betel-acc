document.getElementById('employee-form').addEventListener('submit', async function(e) {
    e.preventDefault(); 

    
    const birthdate = document.getElementById('birthdate').value;
    const admissionDate = document.getElementById('admission-date').value;

   
    const cpf = document.getElementById('cpf').value.replace(/[^\d]/g, '');

  
    const formData = {
        nome: document.getElementById('firstname').value,
        idade: birthdate,  
        cpf: cpf,         
        cargo: document.getElementById('position').value,
        senha: document.getElementById('password').value,
        endereco: document.getElementById('address').value,
        dataAdmissao: admissionDate,  
        salario: parseFloat(document.getElementById('salary').value)  
    };

    
    console.log("Dados a serem enviados:", formData);

    try {
        const response = await axios.post('http://localhost:8080/auth/register', formData);

        if (response.status === 201 || response.status === 200) {  
            alert('Funcionário cadastrado com sucesso!');
            console.log(response.data);
        }
    } catch (error) {
        alert('Ocorreu um erro ao cadastrar um funcionário.');
        
       
        if (error.response) {
            console.error('Erro de resposta:', error.response.data);
            console.error('Status code:', error.response.status);
        } else if (error.request) {
            console.error('Erro de requisição:', error.request);
        } else {
            console.error('Erro:', error.message);
        }
    }
});
