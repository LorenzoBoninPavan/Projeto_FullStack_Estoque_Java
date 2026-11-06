/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Objects;

/**
 *
 * @author Aluno
 */
public class Fornecedor {
    // Atributos
    private int id;
    private String cnpj;
    private String razaoSocial;
    private String email;
    private String telefone;
    
    // Métodos de encapsulamento
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    /* Os dois próximos métodos abaixo servem para poder comparar o fornecedor de 
       minhaCompra (na TelaCompra) com os objetos de Fornecedor do combobox de Fornecedor */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fornecedor fornecedor = (Fornecedor) obj;
        return this.id == fornecedor.id; // visto que id é um identificador único para o fornecedor
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Utiliza o mesmo campo de comparação
    }    
}
