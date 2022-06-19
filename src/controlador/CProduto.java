package controlador;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DAO.DAOProduto;
import modelo.dominio.Produto;
/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class CProduto {

   
    
     public boolean cadastrarProduto(Produto produto)
    {
        DAOProduto insereDados = new DAOProduto();
        if(insereDados.insereProduto(produto))
        {
            return true;
        }
        return false;

    }
     public ArrayList<Produto> visualizarProduto ()
    {
        DAOProduto dadosProduto = new DAOProduto();
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        listaProduto = dadosProduto.selecionarTodosRegistros();
        
        return listaProduto;

    }
    
    public boolean atualizarProduto(Produto produto)
    {
         DAOProduto dadosProduto = new DAOProduto();
        if(dadosProduto.alteraProduto(produto))
        {
            return true;
        }
        
        return false;
    }
    
    public boolean deletarProduto(String codigoProduto)
    {
        DAOProduto dadosProduto = new DAOProduto();
        if(dadosProduto.removeProduto(codigoProduto))
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
            Logger.getLogger(CProduto.class.getName()).log(Level.SEVERE, null, ex);
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
