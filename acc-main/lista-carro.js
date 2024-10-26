Document.addEventListener('DOMContentLoades', () =>{
fetch ('htpp://localhost:8080/carro')
.then(Response => Response.json())
.then(data =>{
    exibirVeiculos(data);
})
.catch(error => console.error('ERRO AO PERSQUISAR VEICULO',error));
});
function exibirVeiculos(carro){
    const listaVeiculos = document.getElementById('lista-carro');
    listaVeiculos.innerHTML = '';

    veiculos.forEach(carro => {
     const item = document.createElement ('div')  ;
     item.className = 'carro';
     item.innerHTML = `
     <h2>${carros.nome}</h2>
     <p>marca: ${carro.marca}</p>
     <p>modelo: ${carro.modelo}</p>
     <p>ano: ${carro.ano}</p>
     <p>quilometragem: ${carro.quilometragem}</p>
     <p>motor: ${carro.motor}</p>
     <p>cor: ${carro.cor}</p>
     <p>portas: ${carro.portas}</p>
     <p>transmissao: ${carro.transmissao}</p>
     <p>condicao: ${carro.condicao}</p>
     <p>preço: ${carro.preco}</p>

     `;
     listacarro.appendChild(item);

    });
}
document.addEventListener('DOMContentLoaded', () => {
    fetchVeiculos();
});
