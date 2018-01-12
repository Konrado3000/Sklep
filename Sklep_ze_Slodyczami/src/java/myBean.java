/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Student
 */
@Named(value = "myBean")
@SessionScoped
public class myBean implements Serializable {

    private String login , password ; 

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String logIN()
    {
        if("konrad".equals(login) && "123".equals(password))
        {
            return "admin_panel";
        }
        else return null;
       
    }
    
    
    
    
    public myBean() {
        
        
        
    }
    
}
