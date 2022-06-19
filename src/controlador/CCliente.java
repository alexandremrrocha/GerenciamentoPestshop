package controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.DAO.DAOCliente;
import modelo.dominio.Cliente;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class CCliente {
    
    public boolean cadastrarCliente(Cliente cliente)
    {
        DAOCliente insereDados = new DAOCliente();
        if(insereDados.insereCliente(cliente))
        {
            return true;
        }
        return false;

    }
    
    public ArrayList<Cliente> visualizarClientes ()
    {
        DAOCliente dadosCliente = new DAOCliente();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes = dadosCliente.selecionarTodosRegistros();
        
        return listaClientes;

    }
    
    public boolean atualizarCliente(Cliente cliente)
    {
        DAOCliente dadosCliente = new DAOCliente();
        if(dadosCliente.alteraCliente(cliente))
        {
            return true;
        }
        
        return false;
    }
    
    public boolean deletarCliente(String cpf)
    {
        DAOCliente dadosCliente = new DAOCliente();
        if(dadosCliente.removeCliente(cpf))
        {
            return true;
        }
        
        return false;
    }
    
//    public static Date converteStringDate(String data) 
//    {
//        DateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
//        Date novaData = null;
//        try {
//            novaData = formatado.parse(data);
//        } catch (ParseException ex) {
//            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return novaData;
//    }
//    
//    public static java.sql.Date converteDateSQL (Date data)
//    {
//        return new java.sql.Date(data.getTime());
//    }
//    
//    public static String converteDataString (Date data)
//    {
//        DateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
//        String auxData = formatado.format(data);
//        return auxData;
//    }
    
}
