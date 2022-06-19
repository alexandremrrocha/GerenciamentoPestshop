package modelo.dominio;

import java.util.Date;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class Animal {
    private String nomeAnimal;
    private String numeroCadastro;
    private String apelido;
    private String especie;
    private String raca;
    private String informacoes;
    private String sexo;
    private String porte;
    private Date dataNascimento;
    private String cor;
    private String peso;
    
    public Animal(){}

    public Animal(String nomeAnimal, String numeroCadastro, String apelido, String especie, String raca, String informacoes, String sexo, String porte, Date dataNascimento, String cor, String peso) {
        this.nomeAnimal = nomeAnimal;
        this.numeroCadastro = numeroCadastro;
        this.apelido = apelido;
        this.especie = especie;
        this.raca = raca;
        this.informacoes = informacoes;
        this.sexo = sexo;
        this.porte = porte;
        this.dataNascimento = dataNascimento;
        this.cor = cor;
        this.peso = peso;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }
    
    public String getNumeroCadastro() {
        return numeroCadastro;
    }

    public void setNumeroCadastro(String numeroCadastro) {
        this.numeroCadastro = numeroCadastro;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
       
}
