package br.com.arthurbarros.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carro")
public class Carro {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Codigo_Carro;
private int Nome;
private String Cor;
private String Marca;
private int Ano;
private double Quilometragem;
private double Preco;
private String Modelo;
private String Condicao;
private double Motor;
private String Transmissao;
private int Portas;

// getters e setters
public int getCodigo_Carro() {
    return Codigo_Carro;
}

public void setCodigo_Carro(int Codigo_Carro) {
    this.Codigo_Carro = Codigo_Carro;
}
public int getNome() {
    return Nome;
}

public void setNome(int Nome) {
    this.Nome = Nome;
}

public String getCor() {
    return Cor;
}

public void setCor(String Cor) {
    this.Cor = Cor;
}

public String getMarca() {
    return Marca;
}

public void setMarca(String Marca) {
    this.Marca = Marca;
}

public int getAno() {
    return Ano;
}

public void setAno(int Ano) {
    this.Ano = Ano;
}

public double getQuilometragem() {
    return Quilometragem;
}

public void setQuilometragem(double Quilometragem) {
    this.Quilometragem = Quilometragem;
}

public double getPreco() {
    return Preco;
}

public void setPreco(double Preco) {
    this.Preco = Preco;
}

public String getModelo() {
    return Modelo;
}

public void setModelo(String Modelo) {
    this.Modelo = Modelo;
}

public String getCondicao() {
    return Condicao;
}

public void setCondicao(String Condicao) {
    this.Condicao = Condicao;
}

public double getMotor() {
    return Motor;
}

public void setMotor(double Motor) {
    this.Motor = Motor;
}

public String getTransmissao() {
    return Transmissao;
}

public void setTransmissao(String Transmissao) {
    this.Transmissao = Transmissao;
}

public int getPortas() {
    return Portas;
}

public void setPortas(int Portas) {
    this.Portas = Portas;
}



}
