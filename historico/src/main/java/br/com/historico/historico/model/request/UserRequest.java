package br.com.historico.historico.model.request;

import jakarta.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank
    private String name;


    @NotBlank
    private String document;


    @NotBlank
    private String login;


    @NotBlank
    private String email;


    @NotBlank
    private String password;

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getDocument() {
        return document;
    }

    public void setDocument(@NotBlank String document) {
        this.document = document;
    }

    public @NotBlank String getLogin() {
        return login;
    }

    public void setLogin(@NotBlank String login) {
        this.login = login;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }
}
