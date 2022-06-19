package controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DAO.DAOAgendamento;
import modelo.dominio.Agendamento;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class CAgendamento {
   
    public boolean cadastrarAgendamento(Agendamento agendamento)
    {
        DAOAgendamento insereDados = new DAOAgendamento();
        if(insereDados.insereAgendamento(agendamento))
        {
            return true;
        }
        return false;

    }
     public ArrayList<Agendamento> visualizarAgendamento ()
    {
        DAOAgendamento dadosAgendamento = new DAOAgendamento();
        ArrayList<Agendamento> listaAgendamento = new ArrayList<Agendamento>();
        listaAgendamento = dadosAgendamento.selecionarTodosRegistros();
        
        return listaAgendamento;

    }
    
    public boolean atualizarAgendamento(Agendamento agendamento)
    {
         DAOAgendamento dadosAgendamento = new DAOAgendamento();
        if(dadosAgendamento.alteraAgendamento(agendamento))
        {
            return true;
        }
        
        return false;
    }
    
    public boolean deletarAgendamento(String nomeCliente)
    {
        DAOAgendamento dadosAgendamento = new DAOAgendamento();
        if(dadosAgendamento.removeAgendamento(nomeCliente))
        {
            return true;
        }
        
        return false;
    }
    
    public static Date converteStringDate(String data) 
    {
        DateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
        Date novaData = null;
        try {
            novaData = formatado.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(CAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novaData;
    }
    
    public static java.sql.Date converteDateSQL (Date data)
    {
        return new java.sql.Date(data.getTime());
    }
    
    public static String converteDataString (Date data)
    {
        DateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
        String auxData = formatado.format(data);
        return auxData;
    }
    
}
