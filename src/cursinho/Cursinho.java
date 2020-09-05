/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursinho;
import conectando.conexaosql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import preenchendo.classecadastromaior;
import telas.*;
/**
 *
 * @author Piu
 */
public class Cursinho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        conexaosql ligue = new conexaosql();
        ligue.getConnection();
        Statement stmt = ligue.constm();

        inicio chamaframe = new inicio ();
        chamaframe.setVisible(true);
         
        
        
        
    }
    
}
