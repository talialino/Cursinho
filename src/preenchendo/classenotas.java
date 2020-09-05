/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preenchendo;

import conectando.conexaosql;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Piu
 */
public class classenotas {
   
 Statement st = conexaosql.stmt;
 Connection con;
 
private int cod_not;
private int cod_est;
private int nivel_not;
private double nota_test_not;			
private double nota_prov_not;			
private String media_descri_not;
    
    public classenotas(){
    
    }
 
public classenotas(int cd, int ce, int nin, double nt, double np,
                  String md) 
{
    cod_not = cd;
    cod_est = ce;
    nivel_not = nin;
    nota_test_not = nt;
    nota_prov_not = np;
    media_descri_not = md;
}

    /**
     * @return the cod_not
     */
    public int getCod_not() {
        return cod_not;
    }

    /**
     * @param cod_not the cod_not to set
     */
    public void setCod_not(int cod_not) {
        this.cod_not = cod_not;
    }

    /**
     * @return the cod_est
     */
    public int getCod_est() {
        return cod_est;
    }

    /**
     * @param cod_est the cod_est to set
     */
    public void setCod_est(int cod_est) {
        this.cod_est = cod_est;
    }

    /**
     * @return the nivel_not
     */
    public int getNivel_not() {
        return nivel_not;
    }

    /**
     * @param nivel_not the nivel_not to set
     */
    public void setNivel_not(int nivel_not) {
        this.nivel_not = nivel_not;
    }

    /**
     * @return the nota_test_not
     */
    public double getNota_test_not() {
        return nota_test_not;
    }

    /**
     * @param nota_test_not the nota_test_not to set
     */
    public void setNota_test_not(double nota_test_not) {
        this.nota_test_not = nota_test_not;
    }

    /**
     * @return the nota_prov_not
     */
    public double getNota_prov_not() {
        return nota_prov_not;
    }

    /**
     * @param nota_prov_not the nota_prov_not to set
     */
    public void setNota_prov_not(double nota_prov_not) {
        this.nota_prov_not = nota_prov_not;
    }

    /**
     * @return the media_descri_not
     */
    public String getMedia_descri_not() {
        return media_descri_not;
    }

    /**
     * @param media_descri_not the media_descri_not to set
     */
    public void setMedia_descri_not(String media_descri_not) {
        this.media_descri_not = media_descri_not;
    }
    
    public void inserirnotas(){
         try
        {
            JOptionPane.showMessageDialog(null,"Dados: \n" +cod_est +"\n" +cod_not +"\n" +media_descri_not +"\n"
            +nota_prov_not +"\n" +nota_test_not);
            
            st.executeUpdate("exec inserirnotas '"+cod_est+"','"+nivel_not+"', '"+nota_test_not+"', '"+nota_prov_not+"',"
                             + "'"+media_descri_not+"'" );
            System.out.println("Foi");
        }
            catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar notas");
            System.out.println(e);
            System.exit(0); 
        }
       
    }
    
   /* public String media(){        
        
        String x = "";
        
        try
        {
            ResultSet rs = st.executeQuery("select dbo.calcmedia('"+nota_test_not+"','"+nota_prov_not+"')");
            
            while (rs.next()){
                Float m = rs.getFloat("calcmedia.media");
                if(m >= 6)
           {
               x = "Aprovado";
           }
           else
           {
               x ="Reprovado";
           }
           
           JOptionPane.showMessageDialog(null, "Valor da média: \n" +m);
            }
            
                      
           
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao calcular média");
            System.out.println(e);
            System.exit(0);
        }      
        
        return x;
        
    }*/
    
    public String executeStoredProcedure(){
                                    
    try 
    {  
        
        
        CallableStatement cstmt = con.prepareCall("{call dbo.calcmedia(?,?)}");
        cstmt.setFloat("media", 5);
        cstmt.registerOutParameter("media", java.sql.Types.FLOAT);  
        cstmt.execute(); 
       // cstmt.executeUpdate("select dbo.calcmedia('"+nota_test_not+"','"+nota_prov_not+"')");

        JOptionPane.showMessageDialog(null,"Dados: \n" +"\n" +cod_not +"\n" +media_descri_not +"\n"
            +nota_prov_not +"\n" +nota_test_not);
        
        float m = cstmt.getFloat("media");
        
        if(m >= 6)
           {
               media_descri_not = "Aprovado";
           }
           else
           {
               media_descri_not ="Reprovado";
           }
        
           
           JOptionPane.showMessageDialog(null, "Valor da média: \n" +m);
          
    }  
    catch (HeadlessException | SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao calcular média");
            System.out.println(e);
            System.exit(0);
        }      
    
    return media_descri_not;
}
    

    
    




    
}
