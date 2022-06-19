package modelo.DAO;

import controlador.CAgendamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dominio.Agendamento;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class DAOAgendamento {

    //Classe responsável pela conexão (sessão) com um banco de dados específico. 
    //As instruções SQL são executadas e os resultados são retornados dentro do contexto de uma conexão.
     private Connection con;
     
     //Pre-compila a query para o banco de dados
    // Cria um objeto PreparedStatement para enviar instruções SQL parametrizadas para o banco de dados.
    //Uma instrução SQL com ou sem parâmetros IN pode ser pré-compilada e armazenada em um objeto PreparedStatement.
    //Esse objeto pode ser usado para executar essa instrução de forma eficiente várias vezes. 
    private PreparedStatement comando;
    
    private final FabricaConexao fConexao = FabricaConexao.getInstancia();
    
    private void conectar()
    {
        con = fConexao.conexao();
    }
    
    private void fechar(){
        try{
            comando.close();
            con.close();
        }catch(SQLException e){
            System.err.println("Erro ao fechar conexão\n"+e.getMessage());
        }
    }
    
    private String validar(Agendamento agendamento){
        
        String resposta = ""; 
        if(agendamento.getNomeCliente().equals("") || agendamento.getNumeroAgendamento().equals("") || agendamento.getNomeAnimal().equals("") ||
           agendamento.getTipoServico().equals("") || agendamento.getValorTotal().equals("") || agendamento.getDataAtendimento()== null ||
           agendamento.getHoraAtendimento().equals("") || agendamento.getNomeResponsavel().equals("")){ 
           
            resposta = "Preencha todos os Campos!";  
            return resposta;
        
        }
        
         if ((agendamento.getTipoServico().equals("Banho") || agendamento.getTipoServico().equals("Tosa"))){
            if(!(agendamento.getValorTotal().equals("25"))){
                resposta = " O valor total de Banho ou Tosa é 25 reais";
                return resposta;
            }
        }
         
         if ((agendamento.getTipoServico().equals("Banho e Tosa"))){
            if(!(agendamento.getValorTotal().equals("50"))){
                resposta = " O valor total de Banho e Tosa é 50 reais";
                return resposta;
            }
        }
         
         if ((agendamento.getTipoServico().equals("Vacinação"))){
            if(!(agendamento.getValorTotal().equals("75"))){
                resposta = " O valor total da Vacinação é 75 reais";
                return resposta;
            }
        }
         if ((agendamento.getTipoServico().equals("Consulta"))){
            if(!(agendamento.getValorTotal().equals("100"))){
                resposta = " O valor total da Consulta é 100 reais";
                return resposta;
            }
        }
        
        return "";
    }
    
    public boolean insereAgendamento(Agendamento agendamento){
        
        conectar();
        String retornaResposta = validar(agendamento);
        
        Date auxDataAtendimento = new Date();
            auxDataAtendimento = agendamento.getDataAtendimento();
            
        if(retornaResposta.equals("")){
        String sql = "INSERT INTO AGENDAMENTO(nomeCliente, numeroAgendamento, nomeAnimal, tipoServico, valorTotal, data_atendimento, horario_atendimento, nomeResponsavel) VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, agendamento.getNomeCliente());
            comando.setString(2, agendamento.getNumeroAgendamento());
            comando.setString(3, agendamento.getNomeAnimal());
            comando.setString(4, agendamento.getTipoServico());
            comando.setString(5, agendamento.getValorTotal());
            comando.setDate(6, CAgendamento.converteDateSQL(agendamento.getDataAtendimento()));
            comando.setString(7, agendamento.getHoraAtendimento());
            comando.setString(8, agendamento.getNomeResponsavel());  
            comando.executeUpdate();
            
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao inserir Agendamento\n"+e.getMessage());
        }finally{
            fechar();
        }
        }else {
            
            JOptionPane.showMessageDialog(null, retornaResposta);
        }      
        return false;
    }
    
    
 public  ArrayList<Agendamento> selecionarTodosRegistros()
    {
        conectar();
        //interface utilizada pra guardar dados vindos de um banco de dados
        ResultSet rs;
        String sql = "SELECT * FROM AGENDAMENTO";
        //lista que conterá todas as informações de pessoas no banco de dados
        ArrayList<Agendamento> listaAgendamento = new ArrayList();
        try{
            comando = con.prepareStatement(sql);
            //executeQuery() retorna um conjunto de informações
            rs = comando.executeQuery();
            while(rs.next())
            {
                Agendamento agendamento = new Agendamento();
                agendamento.setNomeCliente(rs.getString("NOMECLIENTE"));
                agendamento.setNumeroAgendamento(rs.getString("NUMEROAGENDAMENTO"));
                agendamento.setNomeAnimal(rs.getString("NOMEANIMAL"));
                agendamento.setTipoServico(rs.getString("TIPOSERVICO"));
                agendamento.setValorTotal(rs.getString("VALORTOTAL"));
                agendamento.setDataAtendimento(rs.getDate("DATA_ATENDIMENTO"));
                agendamento.setHoraAtendimento(rs.getString("HORARIO_ATENDIMENTO"));
                agendamento.setNomeResponsavel(rs.getString("NOMERESPONSAVEL"));
                

                listaAgendamento.add(agendamento);
            }
            return listaAgendamento;
        }
        catch(SQLException e)
        {
            System.err.println("Erro visualizar Agendamento\n"+e.getMessage());
            return null;
        }
        finally{
            fechar();
        }
    }
 public boolean alteraAgendamento(Agendamento agendamento)
    {
        conectar();
        String retornaResposta = validar(agendamento);
        
        java.sql.Date sqlDataAtendimento = new java.sql.Date(agendamento.getDataAtendimento().getTime());
        
        if(retornaResposta.equals("")){
            String sql = "UPDATE AGENDAMENTO SET NOMECLIENTE = ?, NUMEROAGENDAMENTO = ?, NOMEANIMAL = ?, TIPOSERVICO = ?, VALORTOTAL = ?, DATA_ATENDIMENTO = ?, HORARIO_ATENDIMENTO = ?, NOMERESPONSAVEL = ?" + "WHERE NUMEROAGENDAMENTO = ?";
        try{
          comando = con.prepareStatement(sql);
          comando.setString(1, agendamento.getNomeCliente());
          comando.setString(2, agendamento.getNumeroAgendamento());
          comando.setString(3, agendamento.getNomeAnimal());
          comando.setString(4, agendamento.getTipoServico());
          comando.setString(5, agendamento.getValorTotal());
          comando.setDate(6, CAgendamento.converteDateSQL(agendamento.getDataAtendimento()));
          comando.setString(7, agendamento.getHoraAtendimento());
          comando.setString(8, agendamento.getNomeResponsavel());
          comando.setString(9, agendamento.getNumeroAgendamento());
          
          
          //utiliza executeUpdate() para operações que irão modificar a base da dados
         comando.executeUpdate();
          
          return true;
          
      }catch(SQLException e){
          System.err.println("Erro Atualizar Agendamento\n"+e.getMessage());
      }finally{
          fechar();
      }
       }else {
            
            JOptionPane.showMessageDialog(null, retornaResposta);
        }  
       return false;
  }
    
   public boolean removeAgendamento(String numeroAgendamento){
        conectar();
        String sql = "DELETE FROM AGENDAMENTO WHERE NUMEROAGENDAMENTO=?";
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, numeroAgendamento);
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao deletar Agendamento\n"+e.getMessage());
        }finally{
            fechar();
        }
        return false;
    } 

   
    
}
