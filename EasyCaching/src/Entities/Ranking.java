/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author PAVM
 */
public class Ranking {
    private String username;
    private int nFound;
    private int nHiden;

    public int getnFound() {
        return nFound;
    }

    public void setnFound(int nFound) {
        this.nFound = nFound;
    }

    public int getnHiden() {
        return nHiden;
    }

    public void setnHiden(int nHiden) {
        this.nHiden = nHiden;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
