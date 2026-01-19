package dominio;

import java.util.Objects;

public final class Nome {

    private final String nome;

    public Nome(String nome) {
        //verificação de nome vazio
        if(nome == null){
            throw  new IllegalArgumentException("Nome não pode ser nulo!");
        }

        String nomeNormalizado = nome.trim();
        if(nomeNormalizado.isEmpty()){
            throw new IllegalArgumentException("Nome vazio!!");
        }
        this.nome = nomeNormalizado;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nome nome1 = (Nome) o;
        return Objects.equals(nome, nome1.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}

