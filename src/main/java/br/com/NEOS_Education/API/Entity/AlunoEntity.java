package br.com.NEOS_Education.API.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity //Indica que será mapeado para uma tabela no banco de dados
@Table(name = "aluno")
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que o valor do 'id' será gerado automaticamente pelo banco de dados
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido! Formato esperado: 000.000.000-00")
    private Long cpf;

    @NotBlank(message = "RG é obrigatório")
    @Pattern(regexp = "[A-Za-z0-9.-]+", message = "RG inválido! Use apenas letras, números, ponto ou hífen.")
    private String rg;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido!")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "\\+?[0-9-]{8,15}", message = "Número de telefone inválido! Digite apenas números, '+' ou '-'.")
    private Long telefone;

    private String curso;

    private String turno;

    //Getters e Setters: métodos usados para acessar e modificar os atributos da classe
    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf(){
        return cpf;
    }

    public void setCpf(Long cpf){
        this.cpf = cpf;
    }

    public String getRg(){
        return rg;
    }

    public void setRg(String rg){
        this.rg = rg;
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

    public String getCurso(){
        return curso;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    public String getTurno(){
        return turno;
    }

    public void setTurno(String turno){
        this.turno = turno;
    }
}