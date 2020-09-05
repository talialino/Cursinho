/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preenchendo;

import conectando.conexaosql;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Piu
 */
public class classechamada {

 Statement st = conexaosql.stmt;
 
 private LocalDate data_cham;				
 private int cod_est;					
 private int frequenc_cham;			
    
 public classechamada(){
    
}

 public classechamada(LocalDate dc, int ce, int fc) 
 {
     data_cham = dc;
     cod_est = ce;
     frequenc_cham = fc;
 }

    /**
     * @return the data_cham
     */
    public LocalDate getData_cham() {
        return data_cham;
    }

    /**
     * @param data_cham the data_cham to set
     */
    public void setData_cham(String data_cham) {
        String [] separar = data_cham.split("/");
        LocalDate datac = LocalDate.of(Integer.parseInt(separar[2]), Integer.parseInt(separar[1]), Integer.parseInt(separar[0]));
        this.data_cham = datac;
        
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
     * @return the frequenc_cham
     */
    public int getFrequenc_cham() {
        return frequenc_cham;
    }

    /**
     * @param frequenc_cham the frequenc_cham to set
     */
    public void setFrequenc_cham(int frequenc_cham) {
        this.frequenc_cham = frequenc_cham;
    }
    
    public void inserirchamada(){
         try
        {
            JOptionPane.showMessageDialog(null,"Dados: \n" +data_cham +"\n" +cod_est +"\n" +frequenc_cham);
            
            st.executeUpdate("exec inserirchama '"+data_cham+"','"+cod_est+"', '"+frequenc_cham+"'" );
            
            System.out.println("Foi");
            
        }
            catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir chamada");
            System.out.println(e);
            System.exit(0);
        }
        
    }



}
