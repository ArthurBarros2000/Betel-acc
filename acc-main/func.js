document.getElementById('employee-form').addEventListener('submit', async function(e) {
    e.preventDefault(); 

    
    const formData = {
        firstname: document.getElementById('firstname').value,
        birthdate: document.getElementById('birthdate').value,
        cpf: document.getElementById('cpf').value,
        position: document.getElementById('position').value,
        password: document.getElementById('password').value,
        address: document.getElementById('address').value,
        admissionDate: document.getElementById('admission-date').value,
        salary: document.getElementById('salary').value
    };

    try {
        
        const response = await axios.post('http://localhost:8080/auth/register', formData)

        if (response.status === 201) {
            alert('Funcionário cadastrado com sucesso!');
            console.log(response.data);
        }
    } catch (error) {
        alert('Não foi possível cadastrar funcionário!');
        console.error('Erro:', error);
    }
});