package modelo.DAO;

import controlador.CCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dominio.Cliente;
//import modelo.dominio.Cliente

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class DAOCliente {
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
    
    private String validar(Cliente cliente){
        
        String resposta = ""; 
        if(cliente.getNomeCompleto().equals("") || cliente.getCpf().equals("   .   .   -  ") || cliente.getEndereco().equals("")
            || cliente.getBairro().equals("") || cliente.getCidade().equals("") || cliente.getUf().equals("") ||
            cliente.getCep().equals("     -   ") || cliente.getTelefone().equals("(  ) .    -    ") ||  cliente.getEmail().equals("")){ 
           
            resposta = "Preencha todos os Campos!";  
            return resposta;
        
        }
        
         if (!((cliente.getEmail().contains("@")) && (cliente.getEmail().contains(".")))){
            resposta = "Digite um E-mail Válido! Ex: exemplo@email.com";
            return resposta;
        }
        
        return "";
    }
    
    public boolean insereCliente(Cliente cliente){
        
        conectar();
        String retornaResposta = validar(cliente);
        
        if(retornaResposta.equals("")){
        String sql = "INSERT INTO CLIENTE(nomeCompleto, cpf, endereco, bairro, cidade, uf, cep, telefone, email) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, cliente.getNomeCompleto());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getEndereco());
            comando.setString(4, cliente.getBairro());
            comando.setString(5, cliente.getCidade());
            comando.setString(6, cliente.getUf());
            comando.setString(7, cliente.getCep());
            comando.setString(8, cliente.getTelefone());
            comando.setString(9, cliente.getEmail());
            comando.executeUpdate();
            
            return true;
            
        }catch(SQLException e){
            System.err.println("Erro ao inserir Cliente\n"+e.getMessage());
       
        }finally{
            fechar();
        }
        
        }else {
            
            JOptionPane.showMessageDialog(null, retornaResposta);
        }        
        return false; 
    }
    
     public  ArrayList<Cliente> selecionarTodosRegistros()
    {
        conectar();
        //interface utilizada pra guardar dados vindos de um banco de dados
        ResultSet rs;
        String sql = "SELECT * FROM CLIENTE";
        //lista que conterá todas as informações de pessoas no banco de dados
        ArrayList<Cliente> listaClientes = new ArrayList();
        try{
            comando = con.prepareStatement(sql);
            //executeQuery() retorna um conjunto de informações
            rs = comando.executeQuery();
            while(rs.next())
            {
                Cliente cliente = new Cliente();
                cliente.setNomeCompleto(rs.getString("NOMECOMPLETO"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setBairro(rs.getString("BAIRRO"));
                cliente.setCidade(rs.getString("CIDADE"));
                cliente.setUf(rs.getString("UF"));
                cliente.setCep(rs.getString("CEP"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setEmail(rs.getString("EMAIL"));
                listaClientes.add(cliente);
            }
            return listaClientes;
        }
        catch(SQLException e)
        {
            System.err.println("Erro visualizar Clientes\n"+e.getMessage());
            return null;
        }
        finally{
            fechar();
        }
    }
     
    public boolean alteraCliente(Cliente cliente){
      
        conectar();
        String retornaResposta = validar(cliente);
      
        if(retornaResposta.equals("")){
        String sql = "UPDATE CLIENTE SET NOMECOMPLETO = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, UF = ?, CEP = ?, TELEFONE = ?, EMAIL = ?"
               + "WHERE CPF = ?";
        try{
          comando = con.prepareStatement(sql);
          comando.setString(1, cliente.getNomeCompleto());
          comando.setString(2, cliente.getEndereco());
          comando.setString(3, cliente.getBairro());
          comando.setString(4, cliente.getCidade());
          comando.setString(5, cliente.getUf());
          comando.setString(6, cliente.getCep());
          comando.setString(7, cliente.getTelefone());
          comando.setString(8, cliente.getEmail());
          comando.setString(9, cliente.getCpf());
          //utiliza executeUpdate() para operações que irão modificar a base da dados
         comando.executeUpdate();
          
          return true;
          
        }catch(SQLException e){
          System.err.println("Erro Atualizar Clientes\n"+e.getMessage());
        }finally{
          fechar();
        }
        
        }else {
            JOptionPane.showMessageDialog(null, retornaResposta);
        }        
        return false;
    }
    
   public boolean removeCliente(String cpf){
        conectar();
        String sql = "DELETE FROM CLIENTE WHERE CPF=?";
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, cpf);
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao deletar Clientes\n"+e.getMessage());
        }finally{
            fechar();
        }
        return false;
    }
}
