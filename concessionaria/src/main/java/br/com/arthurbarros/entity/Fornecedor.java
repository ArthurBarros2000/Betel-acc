package br.com.arthurbarros.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

    
@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Codigo_Fornecedor;
    private String Nome_Empresa;
    private String CNPJ;
    private String Telefone;
    private String Email;
    private String Endereco;
    private String Cidade;
    private String Estado;
    private String Pais;
    private Date Data_Cadastro;  
    private String Observacoes;

    // Getters e Setters
    public int getCodigo_Fornecedor() {
        return Codigo_Fornecedor;
    }

    public void setCodigo_Fornecedor(int Codigo_Fornecedor) {
        this.Codigo_Fornecedor = Codigo_Fornecedor;
    }

    public String getNome_Empresa() {
        return Nome_Empresa;
    }

    public void setNome_Empresa(String Nome_Empresa) {
        this.Nome_Empresa = Nome_Empresa;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public Date getData_Cadastro() {
        return Data_Cadastro;
    }

    public void setData_Cadastro(Date Data_Cadastro) {
        this.Data_Cadastro = Data_Cadastro;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }
}

