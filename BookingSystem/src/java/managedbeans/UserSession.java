/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.Random;

/**
 *
 * @author Mikael
 */
public class UserSession {

    String user;

    /**
     * Creates a new instance of UserSession
     */
    public UserSession() {
        Random random = new Random();

        this.response = random.nextInt(5);
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    int response;

    public void setResponse(int response) {
        this.response = response;
    }


    

    
    public int getResponse() {

        return response;
    }
}
