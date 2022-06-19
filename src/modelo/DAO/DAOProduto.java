package modelo.DAO;


import controlador.CProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dominio.Produto;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class DAOProduto {

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
    
    private String validar(Produto produto){
        
        String resposta = ""; 
        if(produto.getNomeProduto().equals("") || produto.getCodigoProduto().equals("") ||  produto.getFornecedor().equals("")
            ||  produto.getMarca().equals("") ||  produto.getValorCusto().equals("") ||  produto.getValorVenda().equals("") ||
            produto.getQuantidade().equals("") ||  produto.getDataVencimento() == null){ 
           
            resposta = "Preencha todos os Campos!";  
            return resposta;
        
        }
        
        if (!(produto.getFornecedor().equals("Purina - Dog Show") || (produto.getFornecedor().equals("Royal Canin")
                || produto.getFornecedor().equals("Pedigree")))){
            resposta = "Digite apenas Purina - Dog Show/Royal Canin/Pedigree em fornecedor.";
            return resposta;
        }
        
        return "";
        }
    
    public boolean insereProduto(Produto produto){
        
        conectar();
        String retornaResposta = validar(produto);
        
        if(retornaResposta.equals("")){
        String sql = "INSERT INTO PRODUTO(nomeProduto, codigoProduto, fornecedor, marca, valorCusto, valorVenda, quantidade, dataVencimento) VALUES (?,?,?,?,?,?,?,?)";
        
        Date auxDataVencimento = new Date();
            auxDataVencimento = produto.getDataVencimento();
        
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, produto.getNomeProduto());
            comando.setString(2, produto.getCodigoProduto());
            comando.setString(3, produto.getFornecedor());
            comando.setString(4, produto.getMarca());
            comando.setString(5, produto.getValorCusto());
            comando.setString(6, produto.getValorVenda());
            comando.setString(7, produto.getQuantidade());
            comando.setDate(8, CProduto.converteDateSQL(produto.getDataVencimento()));
 
            comando.executeUpdate();
            
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao inserir Produto\n"+e.getMessage());
        }finally{
            fechar();
        }
        
        }else {
            
            JOptionPane.showMessageDialog(null, retornaResposta);
        }        
        return false;
    }
    
    
 public  ArrayList<Produto> selecionarTodosRegistros()
    {
        conectar();
        //interface utilizada pra guardar dados vindos de um banco de dados
        ResultSet rs;
        String sql = "SELECT * FROM PRODUTO";
        //lista que conterá todas as informações de pessoas no banco de dados
        ArrayList<Produto> listaProduto = new ArrayList();
        try{
            comando = con.prepareStatement(sql);
            //executeQuery() retorna um conjunto de informações
            rs = comando.executeQuery();
            while(rs.next())
            {
                Produto produto = new Produto();
                produto.setNomeProduto(rs.getString("NOMEPRODUTO"));
                produto.setCodigoProduto(rs.getString("CODIGOPRODUTO"));
                produto.setFornecedor(rs.getString("FORNECEDOR"));
                produto.setMarca(rs.getString("MARCA"));        
                produto.setValorCusto(rs.getString("VALORCUSTO"));
                produto.setValorVenda(rs.getString("VALORVENDA"));
                produto.setQuantidade(rs.getString("QUANTIDADE"));
                produto.setDataVencimento(rs.getDate("DATAVENCIMENTO"));

                listaProduto.add(produto);
            }
            return listaProduto;
        }
        catch(SQLException e)
        {
            System.err.println("Erro visualizar Produto\n"+e.getMessage());
            return null;
        }
        finally{
            fechar();
        }
    }
    public boolean alteraProduto(Produto produto){
        conectar();
        String retornaResposta = validar(produto);
    
        java.sql.Date sqlDataVencimento = new java.sql.Date(produto.getDataVencimento().getTime());
        
        if(retornaResposta.equals("")){
        String sql = "UPDATE PRODUTO SET NOMEPRODUTO = ?, CODIGOPRODUTO = ?, FORNECEDOR = ?, MARCA = ?, "
               + "VALORCUSTO = ?, VALORVENDA = ?, QUANTIDADE = ?, DATAVENCIMENTO = ?" + "WHERE CODIGOPRODUTO = ?";
        
        try{
          comando = con.prepareStatement(sql);
          comando.setString(1, produto.getNomeProduto());
          comando.setString(2, produto.getCodigoProduto());
          comando.setString(3, produto.getFornecedor());
          comando.setString(4, produto.getMarca());
          comando.setString(5, produto.getValorCusto());
          comando.setString(6, produto.getValorVenda());
          comando.setString(7, produto.getQuantidade());
          comando.setDate(8, CProduto.converteDateSQL(produto.getDataVencimento()));
          comando.setString(9, produto.getCodigoProduto());
          
          
          //utiliza executeUpdate() para operações que irão modificar a base da dados
          comando.executeUpdate();
          
          return true;
          
        }catch(SQLException e){
            System.err.println("Erro Atualizar Produto\n"+e.getMessage());
        }finally{
            fechar();
        }
        
        }else {
            JOptionPane.showMessageDialog(null, retornaResposta);
        }     
       return false;
    }
    
    public boolean removeProduto(String codigoProduto){
        conectar();
        String sql = "DELETE FROM PRODUTO WHERE CODIGOPRODUTO=?";
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, codigoProduto);
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Erro ao deletar Produto\n"+e.getMessage());
        }finally{
            fechar();
        }
        return false;
    } 
    
}
