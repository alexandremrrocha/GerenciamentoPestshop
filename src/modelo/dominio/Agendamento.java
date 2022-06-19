package modelo.dominio;

import java.util.Date;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class Agendamento {
    
    private String nomeCliente;
    private String numeroAgendamento;
    private String nomeAnimal;
    private String tipoServico;
    private String valorTotal;
    private Date dataAtendimento;
    private String horaAtendimento;
    private String nomeResponsavel;

    public Agendamento() {}

    public Agendamento(String nomeCliente, String nomeAnimal, String numeroAgendamento, String tipoServico, String valorTotal, Date dataAtendimento, String horaAtendimento, String nomeResponsavel) {
        this.nomeCliente = nomeCliente;
        this.numeroAgendamento = numeroAgendamento;
        this.nomeAnimal = nomeAnimal;
        this.tipoServico = tipoServico;
        this.valorTotal = valorTotal;
        this.dataAtendimento = dataAtendimento;
        this.horaAtendimento = horaAtendimento;
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public String getNumeroAgendamento() {
        return numeroAgendamento;
    }

    public void setNumeroAgendamento(String numeroAgendamento) {
        this.numeroAgendamento = numeroAgendamento;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(String horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }    
    
}
