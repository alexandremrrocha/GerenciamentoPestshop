package modelo.DAO;

import controlador.CAnimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dominio.Animal;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class DAOAnimal {
    
    //Classe responsável pela conexão (sessão) com um banco de dados específico. 
    //As instruções SQL são executadas e os resultados são retornados dentro do contexto de uma conexão.
     private Connection con;
     
    //Pre-compila a query para o banco de dados
    // Cria um objeto PreparedStatement para enviar instruções SQL parametrizadas para o banco de dados.
    //Uma instrução SQL com ou sem parâmetros IN pode ser pré-compilada e armazenada em um objeto PreparedStatement.
    //Esse objeto pode ser usado para executar essa instrução de forma eficiente várias vezes. 
    private PreparedStatement comando;
    
    private final FabricaConexao fConexao = FabricaConexao.getInstancia();
    
    // Método acessado internamente para conectar com o banco
    private void conectar()
    {
        con = fConexao.conexao();
    }
    
    //Método que fecha a conexão com o banco
    private void fechar(){
        try{
            comando.close();
            con.close();
        }catch(SQLException e){
            System.err.println("Erro ao fechar conexão\n"+e.getMessage());
        }
    }
    
    private String validar(Animal animal){
        
        String resposta = ""; 
        if(animal.getNomeAnimal().equals("") || animal.getNumeroCadastro().equals("") || animal.getApelido().equals("") ||
           animal.getEspecie().equals("") || animal.getRaca().equals("") || animal.getPorte().equals("") || animal.getInformacoes().equals("") ||
           animal.getSexo().equals("") || animal.getDataNascimento()== null || animal.getCor().equals("") ||  animal.getPeso().equals("")){ 
           
            resposta = "Preencha todos os Campos!";  
            return resposta;
        
        }
        
         if (!(animal.getEspecie().equals("Canis familiaris") || (animal.getEspecie().equals("Felidae")))){
            resposta = "Digite apenas Canis familiaris/Felidae em espécie.";
            return resposta;
        }
        
        return "";
    }
    
    
    public boolean insereAnimal(Animal animal){
        
        conectar();
        String retornaResposta = validar(animal);
        
        if(retornaResposta.equals("")){
        String sql = "INSERT INTO ANIMAL(nomeAnimal, numeroCadastro, apelido, especie, raca, informacoes, sexo, porte, data_nascimento, cor, peso) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        Date auxDataNascimento = new Date();
            auxDataNascimento = animal.getDataNascimento();
           
        java.sql.Date sqlDataNascimento = new java.sql.Date(auxDataNascimento.getTime());
        
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, animal.getNomeAnimal());
            comando.setString(2, animal.getNumeroCadastro());
            comando.setString(3, animal.getApelido());
            comando.setString(4, animal.getEspecie());
            comando.setString(5, animal.getRaca());
            comando.setString(6, animal.getInformacoes());
            comando.setString(7, animal.getSexo());
            comando.setString(8, animal.getPorte());
            comando.setDate(9, CAnimal.converteDateSQL(animal.getDataNascimento()));
            comando.setString(10, animal.getCor());
            comando.setString(11, animal.getPeso());
            comando.executeUpdate();
            
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao inserir Animal\n"+e.getMessage());
        }finally{
            fechar();
        }
        
        }else {
            
            JOptionPane.showMessageDialog(null, retornaResposta);
        }        
        return false; 
    }
    
     public  ArrayList<Animal> selecionarTodosRegistros()
    {
        conectar();
        //interface utilizada pra guardar dados vindos de um banco de dados
        ResultSet rs;
        String sql = "SELECT * FROM ANIMAL";
        //lista que conterá todas as informações de pessoas no banco de dados
        ArrayList<Animal> listaAnimais = new ArrayList();
        try{
            comando = con.prepareStatement(sql);
            //executeQuery() retorna um conjunto de informações
            rs = comando.executeQuery();
            while(rs.next())
            {
                Animal animal = new Animal();
                animal.setNomeAnimal(rs.getString("NOMEANIMAL"));
                animal.setNumeroCadastro(rs.getString("NUMEROCADASTRO"));
                animal.setApelido(rs.getString("APELIDO"));
                animal.setEspecie(rs.getString("ESPECIE"));
                animal.setRaca(rs.getString("RACA"));
                animal.setInformacoes(rs.getString("INFORMACOES"));
                animal.setSexo(rs.getString("SEXO"));
                animal.setPorte(rs.getString("PORTE"));
                animal.setDataNascimento(rs.getDate("DATA_NASCIMENTO"));
                animal.setCor(rs.getString("COR"));
                animal.setPeso(rs.getString("PESO"));

                listaAnimais.add(animal);
            }
            return listaAnimais;
        }
        catch(SQLException e)
        {
            System.err.println("Erro visualizar Animais\n"+e.getMessage());
            return null;
        }
        finally{
            fechar();
        }
    }
     
    public boolean alteraAnimal(Animal animal)
    {
        conectar();
        String retornaResposta = validar(animal);
        
        java.sql.Date sqlDataNascimento = new java.sql.Date(animal.getDataNascimento().getTime());
      
        if(retornaResposta.equals("")){
        String sql = "UPDATE ANIMAL SET NOMEANIMAL = ?, NUMEROCADASTRO = ?, APELIDO = ?, ESPECIE = ?, RACA = ?, INFORMACOES = ?, SEXO = ?, PORTE = ?, DATA_NASCIMENTO = ?, COR = ?, PESO = ?" 
               + "WHERE NUMEROCADASTRO = ?";
        try{
          comando = con.prepareStatement(sql);
          comando.setString(1, animal.getNomeAnimal());
          comando.setString(2, animal.getNumeroCadastro());
          comando.setString(3, animal.getApelido());
          comando.setString(4, animal.getEspecie());
          comando.setString(5, animal.getRaca());
          comando.setString(6, animal.getInformacoes());
          comando.setString(7, animal.getSexo());
          comando.setString(8, animal.getPorte());
          comando.setDate(9, CAnimal.converteDateSQL(animal.getDataNascimento()));
          comando.setString(10, animal.getCor());
          comando.setString(11, animal.getPeso());
          comando.setString(12, animal.getNumeroCadastro());
          
          //utiliza executeUpdate() para operações que irão modificar a base da dados
         comando.executeUpdate();
          
          return true;
          
        }catch(SQLException e){
            System.err.println("Erro Atualizar Animais\n"+e.getMessage());
        }finally{
            fechar();
        }
        }else {
            JOptionPane.showMessageDialog(null, retornaResposta);
        }        
        return false;
  }
    
   public boolean removeAnimal(String numeroCadastro){
        conectar();
        String sql = "DELETE FROM ANIMAL WHERE NUMEROCADASTRO=?";
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, numeroCadastro);
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao deletar Animais\n"+e.getMessage());
        }finally{
            fechar();
        }
        return false;
    } 
}
