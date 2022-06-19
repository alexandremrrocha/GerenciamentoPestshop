package controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DAO.DAOAnimal;
import modelo.dominio.Animal;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class CAnimal {
    
    public boolean cadastrarAnimal(Animal animal)
    {
        DAOAnimal insereDados = new DAOAnimal();
        if(insereDados.insereAnimal(animal))
        {
            return true;
        }
        return false;

    }
    
    public ArrayList<Animal> visualizarAnimal ()
    {
        DAOAnimal dadosAnimal = new DAOAnimal();
        ArrayList<Animal> listaAnimais = new ArrayList<Animal>();
        listaAnimais = dadosAnimal.selecionarTodosRegistros();
        
        return listaAnimais;

    }
    
    public boolean atualizarAnimal(Animal animal)
    {
        DAOAnimal dadosAnimal = new DAOAnimal();
        if(dadosAnimal.alteraAnimal(animal))
        {
            return true;
        }
        
        return false;
    }
    
    public boolean deletarAnimal(String raca)
    {
        DAOAnimal dadosAnimal = new DAOAnimal();
        if(dadosAnimal.removeAnimal(raca))
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
            Logger.getLogger(CAnimal.class.getName()).log(Level.SEVERE, null, ex);
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
