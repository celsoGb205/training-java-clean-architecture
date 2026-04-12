package net.javaguides.dominio;

import java.util.Objects;

public class Email {

    private final String email;

    public Email(String email) {
        if(email == null){
            throw new IllegalArgumentException("email não pode ser null.");
        }

        String emailNormalizado = email.trim();
        if(emailNormalizado.isEmpty() || !emailNormalizado.contains("@")){
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = emailNormalizado;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
