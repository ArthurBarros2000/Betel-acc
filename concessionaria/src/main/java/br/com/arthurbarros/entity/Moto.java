package br.com.arthurbarros.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_motos")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Codigo_Moto;
    private String Nome;
    private String Marca;
    private String Modelo;
    private int Ano_Fabricacao;
    private String Cor;
    private int Cilindrada;
    private double Potencia;
    private int Quilometragem;
    private String Tipo; 
    
    // Getters e Setters
    public int getCodigo_Moto() {
        return Codigo_Moto;
    }

    public void setCodigo_Moto(int Codigo_Moto) {
        this.Codigo_Moto = Codigo_Moto;
    }
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getAno_Fabricacao() {
        return Ano_Fabricacao;
    }

    public void setAno_Fabricacao(int Ano_Fabricacao) {
        this.Ano_Fabricacao = Ano_Fabricacao;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public int getCilindrada() {
        return Cilindrada;
    }

    public void setCilindrada(int Cilindrada) {
        this.Cilindrada = Cilindrada;
    }

    public double getPotencia() {
        return Potencia;
    }

    public void setPotencia(double Potencia) {
        this.Potencia = Potencia;
    }

    public int getQuilometragem() {
        return Quilometragem;
    }

    public void setQuilometragem(int Quilometragem) {
        this.Quilometragem = Quilometragem;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
}

