/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectando;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Piu
 */
public class conexaosql {
    
    public static Statement stmt; 
    private Connection cone;
    private String conexao = "jdbc:sqlserver://localhost:1433;user=sa;password=123456;databaseName=projetocurso";
    private  String DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver" ;

  public Connection getConnection() 
  {
      
    try 
    {
        Class.forName(DRIVER ); 
        cone = DriverManager.getConnection(conexao);  
        System.out.println("Foi Cone");
       
    } catch (Exception e) 
    {  
        System.out.println("Não foi");
         System.out.println(e);

            System.exit(0); 

    }
     return cone;
  }
  
  public Statement constm() {
      
      try 
    {
        Class.forName(DRIVER ); 
        cone = DriverManager.getConnection(conexao);  
        stmt = cone.createStatement();
        System.out.println("Foi stmt");
        
    } catch (Exception e) 
    {  
        System.out.println("Não foi");
         System.out.println(e);

            System.exit(0); 

    }
      return stmt;
  }
  
  
  
    
  
    
        
        
        
}
