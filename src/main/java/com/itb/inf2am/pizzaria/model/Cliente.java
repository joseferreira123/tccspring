package com.itb.inf2am.pizzaria.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 100)
    private String senha;
    @Column(nullable = true, length = 20)
    // Atributos de apoio

    @Transient
    private String message = "";

    @Transient
    private boolean isValid = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public String getEmail(){return email;}

    public void setEmail(String email) {
        this.email = email;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha(){return senha;}

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String getMessage() {
        return message;
    }

    public boolean validarCliente() {

        return isValid;
    }
}
