package dominio;

import java.util.Objects;

public class Usuario {

    private final Nome nome;
    private final Email email;
    private final int idade;

    public Usuario(Nome nome, Email email, int idade) {

        if(idade <= 0 || idade >= 150){
            throw new IllegalArgumentException("Idade inválida.");
        }

        if(nome == null || email == null){
            throw new IllegalArgumentException("Nome e email são obrigatórios.");
        }

        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Nome getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return email.equals(email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
