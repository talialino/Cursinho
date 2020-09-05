/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preenchendo;

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Piu
 */

public class classecadastromenor extends classecadastromaior {
    
private int cod_resp;    
private String nome_resp;
private int rg_resp;
private int cpf_resp;
private int fone_resp;
    
    public classecadastromenor(){
    
    }
    
    
    public classecadastromenor(String ne, int cpe, int re, LocalDate dne, String ene,int fe, 
                               LocalDate dc, String ce, int nie, int cor, String nr, int rr, int cr, int fr)
    {
        
        super (ne, cpe, re, dne, ene, fe, dc, ce, nie);
        cod_resp = cor;
        nome_resp = nr;
        rg_resp = rr;
        cpf_resp = cr;
        fone_resp = fr;    
        
    }

    /**
     * @return the cod_resp
     */
    public int getCod_resp() {
        return cod_resp;
    }

    /**
     * @param cod_resp the cod_resp to set
     */
    public void setCod_resp(int cod_resp) {
        this.cod_resp = cod_resp;
    }

    /**
     * @return the nome_resp
     */
    public String getNome_resp() {
        return nome_resp;
    }

    /**
     * @param nome_resp the nome_resp to set
     */
    public void setNome_resp(String nome_resp) {
        this.nome_resp = nome_resp;
    }

    /**
     * @return the rg_resp
     */
    public int getRg_resp() {
        return rg_resp;
    }

    /**
     * @param rg_resp the rg_resp to set
     */
    public void setRg_resp(int rg_resp) {
        this.rg_resp = rg_resp;
    }

    /**
     * @return the cpf_resp
     */
    public int getCpf_resp() {
        return cpf_resp;
    }

    /**
     * @param cpf_resp the cpf_resp to set
     */
    public void setCpf_resp(int cpf_resp) {
        this.cpf_resp = cpf_resp;
    }

    /**
     * @return the fone_resp
     */
    public int getFone_resp() {
        return fone_resp;
    }

    /**
     * @param fone_resp the fone_resp to set
     */
    public void setFone_resp(int fone_resp) {
        this.fone_resp = fone_resp;
    }
    
     public void inseriresp(){
       
        try {
            st.executeUpdate("exec inserirresp '"+nome_resp+"','"+rg_resp+"', '"+cpf_resp+"','"+fone_resp+"'" );  
        }
            catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar responsável");
            System.exit(0);
        }
        
    }
    
}