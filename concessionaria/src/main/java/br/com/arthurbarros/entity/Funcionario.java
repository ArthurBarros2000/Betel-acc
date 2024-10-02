package br.com.arthurbarros.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Codigo_Funcionario;
    private String Nome;
    private int Idade;
    private String CPF;
    private String Endereco;
    private double Salario;
    private String Cargo;
    private Date Data_Admissao;  
    // Getters e Setters
    public int getCodigo_Funcionario() {
        return Codigo_Funcionario;
    }

    public void setCodigo_Funcionario(int Codigo_Funcionario) {
        this.Codigo_Funcionario = Codigo_Funcionario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public Date getData_Admissao() {
        return Data_Admissao;
    }

    public void setData_Admissao(Date Data_Admissao) {
        this.Data_Admissao = Data_Admissao;
    }
}