package br.com.historico.historico.model.request;

import jakarta.validation.constraints.NotBlank;

public class WeaponRequest {

    @NotBlank
    private String situacao;

    @NotBlank
    private String patrimonio;

    @NotBlank
    private  String tipo;

    @NotBlank
    private String distribuicao;

    @NotBlank
    private String propriedade;

    @NotBlank
    private String observacao;

    @NotBlank
    private String numeroSerie;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String calibre;

    @NotBlank
    private String cano;

    @NotBlank
    private String raias;

    @NotBlank
    private String acabamento;

    public @NotBlank String getSituacao() {
        return situacao;
    }

    public void setSituacao(@NotBlank String situacao) {
        this.situacao = situacao;
    }

    public @NotBlank String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(@NotBlank String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public @NotBlank String getTipo() {
        return tipo;
    }

    public void setTipo(@NotBlank String tipo) {
        this.tipo = tipo;
    }

    public @NotBlank String getDistribuicao() {
        return distribuicao;
    }

    public void setDistribuicao(@NotBlank String distribuicao) {
        this.distribuicao = distribuicao;
    }

    public @NotBlank String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(@NotBlank String propriedade) {
        this.propriedade = propriedade;
    }

    public @NotBlank String getObservacao() {
        return observacao;
    }

    public void setObservacao(@NotBlank String observacao) {
        this.observacao = observacao;
    }

    public @NotBlank String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(@NotBlank String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public @NotBlank String getMarca() {
        return marca;
    }

    public void setMarca(@NotBlank String marca) {
        this.marca = marca;
    }

    public @NotBlank String getModelo() {
        return modelo;
    }

    public void setModelo(@NotBlank String modelo) {
        this.modelo = modelo;
    }

    public @NotBlank String getCalibre() {
        return calibre;
    }

    public void setCalibre(@NotBlank String calibre) {
        this.calibre = calibre;
    }

    public @NotBlank String getCano() {
        return cano;
    }

    public void setCano(@NotBlank String cano) {
        this.cano = cano;
    }

    public @NotBlank String getRaias() {
        return raias;
    }

    public void setRaias(@NotBlank String raias) {
        this.raias = raias;
    }

    public @NotBlank String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(@NotBlank String acabamento) {
        this.acabamento = acabamento;
    }
}
