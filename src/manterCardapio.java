
/*
Este caso descreve as etapas para que o administrador do sistema gerencie o cardápio da pizzaria. 
*/

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class manterCardapio {
    
    private String saborPizza;
    private String ingredientes;
    private int id;
    
    public void setsaborPizza(String saborPizza){
        this.saborPizza=saborPizza;
    }
    
    public String getsaborPizza(){
        return saborPizza;
    }
    
    public void setingredientes(String ingredientes){
        this.ingredientes=ingredientes;
    }
    
    public String getingredientes(){
        return ingredientes;
    }
    
    public void setid(int id){
        this.id=id;
    }
    
    public int getid(){
        return id;
    } 
    
/*
1 – Clicar em Manter Cardápio
2 – Mostrar todos os sabores que a pizzaria oferece  
3 – Mostrar todos os ingredientes utilizados 
*/

    public void listarTudo(){
        
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM manterCardapio";
            ///Connection conn =getconn();   
            // create the java statement
            
            try
            {
                
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost/Pizzaria";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "root");
                Statement st = conn.createStatement();

                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);
                
                // iterate through the java resultset
                while (rs.next())
                {
                  int id = rs.getInt("id");
                  String saborPizza = rs.getString("saborPizza");
                  String ingredientes = rs.getString("ingredientes");
                  System.out.format("%d, %s, %s", id, saborPizza, ingredientes); 
                }
                st.close();
                }
            catch (Exception e)
            {
                 System.err.println("Erro");
                 System.err.println(e.getMessage());
            }
           

    }
     
/*
1 – Selecionar Incluir Sabor  
2 – Mostrar tela para inclusão de sabor e ingredientes 
3 – Informar sabor e ingredientes   
4 – Registrar sabor     
*/
     public void incluirSabor(){
            String query = "insert into manterCardapio values ('"+this.id+"',"+this.saborPizza+",'" + this.ingredientes+"');";
            try{     
                
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost/Pizzaria";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "root");
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                st.close();
                
        }
            catch (Exception e)
            {
                 System.err.println("Erro");
                 System.err.println(e.getMessage());
            }
         
         
     }
/*
1 – Selecionar Consultar Sabor   
2 – Mostrar tela de sabores cadastrados 
3 – Selecionar sabor desejado   
4 – Mostrar os ingredientes do sabor    
*/     
     public String consultarSabor(){
       //  String query = "SELECT * FROM manterCardapio where id="+id;
     return null;}
 /*
1 – Selecionar Excluir Sabor   
2 – Mostrar tela de sabores cadastrados 
3 – Selecionar sabor   
4 – Solicitar confirmação de exclusão 
5 – Confirmar exclusão   
6 – Excluir sabor   
*/    
     public void excluirSabor(){
     }

     public static void main(String[] args){
     System.out.println("Opções: 1)listarTudo() 2)incluirSabor() ");
     Scanner scanner = new Scanner(System.in); 
     int i = scanner.nextInt();
    
     if(i==1)
        listarTudo();
     
     else if(i==2)
         incluirSabor();
     
     else{
         System.out.println("Erro");
            exit(0);}
         
     }
}