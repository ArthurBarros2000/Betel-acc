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
        
        const response = await axios.post('http://localhost:8080/auth/register', FormData)

        if (response.status === 201) {
            alert('Funcionário cadastrado com sucesso!');
            console.log(response.data);
        }
    } catch (error) {
        alert('Não foi possível cadastrar funcionário!');
        console.error('Erro:', error);
    }
});
           

       
const express = require('localhost');
const app = express();
const port = 8080;

app.use(express.json()); 


app.post('/register', (req, res) => {
    const { firstname, birthdate, cpf, position, password, address, admissionDate, salary } = req.body;

   
    console.log('Novo funcionário!!!:', req.body);

   
    res.status(201).json({ message: 'Funcionário cadastrado!', data: req.body });
});

app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});
