document.getElementById('cadastroVeiculoForm').addEventListener('submit', async function(event) {
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
            alert('Carro cadastrado com sucesso!');
        } else {Ve
            alert('Não foi possível  cadastrar o veículo.');
        }
    } catch (error) {
        console.error('Erro:', error);
        alert('Erro ao conectar.');
    }
});
app.post('/carros', (req, res) => {
    const veiculo = req.body;
    
    res.status(201).json({ message: 'Carro cadastrado com sucesso!!!' });
});
