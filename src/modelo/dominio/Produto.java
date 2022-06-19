package modelo.dominio;

import java.util.Date;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class Produto {
    
    private String nomeProduto;
    private String codigoProduto;
    private String fornecedor;
    private String marca;
    private String valorCusto;
    private String valorVenda;
    private String quantidade;
    private Date dataVencimento;

    public Produto() {}

    public Produto(String nomeProduto, String codigoProduto, String fornecedor, String marca, String valorCusto, String valorVenda, String quantidade, Date dataVencimento) {
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.fornecedor = fornecedor;
        this.marca = marca;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.quantidade = quantidade;
        this.dataVencimento = dataVencimento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(String valorCusto) {
        this.valorCusto = valorCusto;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
   
}
