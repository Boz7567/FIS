package assignment.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;   

import java.util.List;

import assignment.cart.Cart;

import java.util.ArrayList; 

public class User {
    private String userID; 
    private String username; 
    private String firstname; 
    private String lastname;
    private List<String> titles = new ArrayList<>();
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
       return isAccountActive();

    }

    public boolean deactivateAccount(String id) {
        if (accountActive && this.userID.equals(id)) {
            accountActive = false;
            return true;
        }
        return false;
    }

    public boolean isEquals(User u){
        return u.userID == this.userID.equals(id);
    }

    public void printUserInfo() {
        logger.info("User Info: " + firstname + " " + lastname + " (Username: " + username + ")");
    }

    public void linkCart(Cart cart) throws IllegalArgumentException{
        if(cart == null)
            throw new IllegalArgumentException("cart must not be null");
        this.cart = cart;
    }

    public Cart getCart(){
        return cart;
    }

    public String printAllRoles(){
        return ArraysToStrings(arrays);
    }
    private static final Logger logger = LoggerFactory.getLogger(User.java);   

    public void printEveryRole(){
        for (int i = roles.length; i > 0; i--){
            logger.log(roles[i]);
        }
    }



}
