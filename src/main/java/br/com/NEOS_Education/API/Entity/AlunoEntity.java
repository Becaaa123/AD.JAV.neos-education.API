package br.com.NEOS_Education.API.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity //Indica que será mapeado para uma tabela no banco de dados
@Table(name = "aluno")
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que o valor do 'id' será gerado automaticamente pelo banco de dados

    private Long id;
    private String nome;
    private String email;
    private Long telefone;

    //Getters e Setters: métodos usados para acessar e modificar os atributos da classe
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone(){
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
}