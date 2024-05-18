package br.com.historico.historico.persistence.entity;

import java.util.function.Function;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_weapon")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "situacao", nullable = false)
    private String situacao;

    @Column(name = "patrimonio", nullable = false)
    private String patrimonio;

    @Column(name = "tipo", nullable = false)
    private  String tipo;

    @Column(name = "distribuicao", nullable = false)
    private String distribuicao;

    @Column(name = "propriedade", nullable = false)
    private String propriedade;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    @Column(name = "numeroSerie", nullable = false)
    private String numeroSerie;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "calibre", nullable = false)
    private String calibre;

    @Column(name = "cano", nullable = false)
    private String cano;

    @Column(name = "raias", nullable = false)
    private String raias;

    @Column(name = "acabamento", nullable = false)
    private String acabamento;


    public <W> W map(Function<Weapon, W> func){
        return func.apply(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDistribuicao() {
        return distribuicao;
    }

    public void setDistribuicao(String distribuicao) {
        this.distribuicao = distribuicao;
    }

    public String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(String propriedade) {
        this.propriedade = propriedade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public String getCano() {
        return cano;
    }

    public void setCano(String cano) {
        this.cano = cano;
    }

    public String getRaias() {
        return raias;
    }

    public void setRaias(String raias) {
        this.raias = raias;
    }

    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }
}
