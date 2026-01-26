package dominio;

import java.util.Objects;

public class Email {

    private final String valor;

    public Email(String valor) {
        if(valor == null){
            throw new IllegalArgumentException("Email não pode ser null!");
        }

        String valorNormalizado = valor.trim();

        if(valorNormalizado.isEmpty() || !valorNormalizado.contains("@")){
            throw new IllegalArgumentException("Email invalido!!");
        }
        this.valor = valorNormalizado;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(valor, email.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valor);
    }
}
