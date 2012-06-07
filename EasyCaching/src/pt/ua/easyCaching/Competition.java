package pt.ua.easyCaching;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


/**
 *
 * @author PAVM
 */

public class Competition {
    private int idcompeticao;
 
    private String nome;
   
    private String datainicio;
   
    private String localprova;
  
    public Competition() {
    }

    public Competition(int idcompeticao) {
        this.idcompeticao = idcompeticao;
    }

    public int getIdcompeticao() {
        return idcompeticao;
    }

    public void setIdcompeticao(int idcompeticao) {
        this.idcompeticao = idcompeticao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }

    public String getLocalprova() {
        return localprova;
    }

    public void setLocalprova(String localprova) {
        this.localprova = localprova;
    }

    
}
