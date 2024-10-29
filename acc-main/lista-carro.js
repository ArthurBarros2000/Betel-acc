document.addEventListener('DOMContentLoaded', () => {
    fetchVeiculos();
});

function fetchVeiculos() {
    fetch('http://localhost:8080/carro')
        .then(response => {
            if (!response.ok) {
                throw new Error(`Servidor não conectado: ${response.status}`);
            }
            return response.json(); 
        })
        .then(data => {
            if (Array.isArray(data)) {
                exibirVeiculos(data); 
            } else {
                throw new Error("Formato de resposta inesperado.");
            }
        })
        .catch(error => console.error('Erro ao pesquisar o veículo:', error));
}

function exibirVeiculos(veiculos) {
    const listaVeiculos = document.getElementById('lista-carro');
    listaVeiculos.innerHTML = '';

    veiculos.forEach(carro => {
        const item = document.createElement('div');
        item.className = 'carro';
        item.innerHTML = `
            <h2>${carro.nome || "Nome não informado"}</h2>
            <p>Marca: ${carro.marca}</p>
            <p>Modelo: ${carro.modelo}</p>
            <p>Ano: ${carro.ano}</p>
            <p>Quilometragem: ${carro.quilometragem}</p>
            <p>Motor: ${carro.motor}</p>
            <p>Cor: ${carro.cor}</p>
            <p>Portas: ${carro.portas}</p>
            <p>Transmissão: ${carro.transmissao}</p>
            <p>Condição: ${carro.condicao}</p>
            <p>Preço: ${carro.preco}</p>
        `;
        listaVeiculos.appendChild(item);
    });
}

window.scrollTo({
    top: 0,
    behavior: 'smooth' 
  });
  
