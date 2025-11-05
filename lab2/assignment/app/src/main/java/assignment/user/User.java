package assignment.user;


import java.util.List;

import assignment.cart.Cart;

import java.util.ArrayList;
import java.util.Arrays; //don't know if I need it


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.slf4j.internal.LoggerFactory;

public class User {
    private String userID; 
    private String username; 
    private String firstname; 
    private String lastname;
    // private List<String> titles = new ArrayList<String>(); //problema di Maintainability
    private List<String> titles = new ArrayList<>(); //versione corretta
    private String[] roles = new String[5];
    private boolean accountActive;
    private Cart cart;

    public User(String userID, String username, String firstname, String lastname, 
                boolean accountActive, List<String> titles, String[] roles) {
        this.userID = userID;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountActive = accountActive;
        this.titles = titles;
        this.roles = roles;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean isAccountActive() {
        return accountActive;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountActive(boolean accountActive) {
        this.accountActive = accountActive;
    }

    public void updateUsername(String newUsername) {
        this.username = newUsername;
    }

    public List<String> getTitles(){
        return titles;
    }

    public boolean isActive(){
        //problema di Maintainability
        return isAccountActive();
    }

    public boolean deactivateAccount(String id) {
        if (accountActive && this.userID.equals(id)) { //problema di Reliability
            accountActive = false;
            return true;
        }
        return false;
    }

    public boolean isEquals(User u){
        return u.userID.equals(this.userID); //problema di Reliability
    }

    public void printUserInfo() {
        // System.out.println("User Info: " + firstname + " " + lastname + " (Username: " + username + ")"); //problema di Maintainability
        logger.info("User Info: " + firstname + " " + lastname + " (Username: " + username + ")");
    }

    public void linkCart(Cart cart) throws IllegalArgumentException{
        if(cart == null)
            throw new IllegalArgumentException(); //problema di Mantainability
        this.cart = cart;
    }

    public Cart getCart(){
        return cart;
    }

    public String printAllRoles(){
        return Arrays.toString(roles);  //problema di Reliability
    }
    private static final Logger logger = LoggerFactory.getLogger(User.java);

    public void printEveryRole(){   //problema di Mantainability
        for (int i = roles.length; i > 0; i--){ //problema di Reliability
            // System.out.println(roles[i]);   //problema di Maintainability
            logger.log(roles[i]);
        }
    }



}
