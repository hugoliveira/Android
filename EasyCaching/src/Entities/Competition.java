/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author PAVM
 */
public class Competition {
    private int id;
    private String name;
    private String date;
    private String local;
    private int numCache =0;
    private int numUser=0;
   
    
    public Competition(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumCache() {
        return numCache;
    }

    public void setNumCache(int numCache) {
        this.numCache = numCache;
    }


    public int getNumUser() {
        return numUser;
    }

    public void setNumUser(int numUser) {
        this.numUser = numUser;
    }
    
    
    
}
