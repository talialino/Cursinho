/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package preenchendo;

import conectando.conexaosql;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;

/**
 *
 * @author Piu
 */
public class classecadastromaior {
    
    Statement st = conexaosql.stmt;
    
    protected int cod_est;
    protected String nome_est;
    protected int cpf_est;					
    protected int rg_est;
    protected LocalDate data_nasc_est;
    protected String ender_est;
    protected int fone_est;
    protected LocalDate data_cadas;
    protected String curso_est;
    protected int niveis_est;
    
    public classecadastromaior(){
        
        
    }
    public classecadastromaior (String ne, int cpe, int re, LocalDate dne, String ene,
                                int fe, LocalDate dc, String ce, int nie)
    {  
    nome_est = ne;
    cpf_est = cpe;
    rg_est = re;
    data_nasc_est = dne;
    ender_est = ene;
    fone_est = fe;
    data_cadas = dc;
    curso_est = ce;
    niveis_est = nie;
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
     * @return the nome_est
     */
    public String getNome_est() {
        return nome_est;
    }

    /**
     * @param nome_est the nome_est to set
     */
    public void setNome_est(String nome_est) {
        this.nome_est = nome_est;
    }

    /**
     * @return the cpf_est
     */
    public int getCpf_est() {
        return cpf_est;
    }

    /**
     * @param cpf_est the cpf_est to set
     */
    public void setCpf_est(int cpf_est) {
        this.cpf_est = cpf_est;
    }

    /**
     * @return the rg_est
     */
    public int getRg_est() {
        return rg_est;
    }

    /**
     * @param rg_est the rg_est to set
     */
    public void setRg_est(int rg_est) {
        this.rg_est = rg_est;
    }

    /**
     * @return the data_nasc_est
     */
    public LocalDate getData_nasc_est() {
        return data_nasc_est;
    }

    /**
     * @param data_nasc_est the data_nasc_est to set
     */
    public void setData_nasc_est(String data_nasc_est) {
        String pega = data_nasc_est;
        String [] separar = pega.split("/");
        LocalDate datane = LocalDate.of(Integer.parseInt(separar[2]), Integer.parseInt(separar[1]), Integer.parseInt(separar[0]));
        this.data_nasc_est = datane;
    }

    /**
     * @return the ender_est
     */
    public String getEnder_est() {
        return ender_est;
    }

    /**
     * @param ender_est the ender_est to set
     */
    public void setEnder_est(String ender_est) {
        this.ender_est = ender_est;
    }

    /**
     * @return the fone_est
     */
    public int getFone_est() {
        return fone_est;
    }

    /**
     * @param fone_est the fone_est to set
     */
    public void setFone_est(int fone_est) {
        this.fone_est = fone_est;
    }

    /**
     * @return the data_cadas
     */
    public LocalDate getData_cadas() {
        return data_cadas;
    }

    /**
     * @param data_cadas the data_cadas to set
     */
    public void setData_cadas(String data_cadas) {
        String pega = data_cadas;
        String [] separar = pega.split("/");
        LocalDate datac = LocalDate.of(Integer.parseInt(separar[2]), Integer.parseInt(separar[1]), Integer.parseInt(separar[0]));
        this.data_cadas = datac;
    }

    /**
     * @return the curso_est
     */
    public String getCurso_est() {
        return curso_est;
    }

    /**
     * @param curso_est the curso_est to set
     */
    public void setCurso_est(String curso_est) {
        this.curso_est = curso_est;
    }

    /**
     * @return the niveis_est
     */
    public int getNiveis_est() {
        return niveis_est;
    }

    /**
     * @param niveis_est the niveis_est to set
     */
    public void setNiveis_est(int niveis_est) {
        this.niveis_est = niveis_est;
    }

    public void inseriraluno(){
        
         /*JOptionPane.showMessageDialog(null, "Dado final:" +"Data nas " +data_nasc_est +"\n"
                +"Data cadas "+data_cadas +"\n" +curso_est +"\n" +ender_est +"\n" +nome_est +"\n"
                +cpf_est+"\n" +rg_est +"\n" +fone_est +"\n" +niveis_est);*/
        
        try
        {
            
            String inserir = ("exec inserirest '"+nome_est+"','"+cpf_est+"', '"+rg_est+"','"+data_nasc_est+"','"+ender_est+"','"+fone_est+"','"+data_cadas+"','"+curso_est+"','"+niveis_est+"'" );
            st.executeUpdate(inserir);
            System.out.println("Foi");
            
        }
            catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar aluno");
            System.out.println(e);
            System.exit(0); 
        }
        
    }
    
    
}
