package assignment.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import assignment.cart.Cart;

import org.h2.security.SHA256;

public class UsersManager {

    public static final String BASIC_USER_ID = "User00-"; //problema di Maintainability x2
    public static final List<User> users = new ArrayList<>(); //problema di Maintainability x2


    public boolean findUserFromDB(String userID) throws SQLException {
        String pwd = System.getenv("SECRET");
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", BASIC_USER_ID+userID, pwd)) { //cambiato in BASIC_USER_ID, //problema di Security
            String query = "select firstname, lastname " + "from USERS where username="+ (BASIC_USER_ID+userID); //cambiato in BASIC_USER_ID
            PreparedStatement stmt = conn.prepareStatement(query); //problema di Reliability
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                if(rs != null)
                    return true;
            return false;



        } catch (SQLException e) { //problema di Maintainability
            return false;
        }
    }

    void addUser(User user) throws SQLException{
        if(!findUserFromDB(user.getUserID()))
            users.add(user);
    }
    
    void removeEmptyTitlesFromUser(User user) {      
        List<String> titles = user.getTitles();
        // for (int i = 0; i < titles.size(); i++) {
        for(int i = titles.size()-1; i>=0; i--)
          if (titles.get(i).isEmpty()) {
            titles.remove(i); 
          }
        }
    }

    void addCartToUser(User user, Cart cart) throws Exception{ //problema di Maintainability
        try
        {
            user.linkCart(cart);
        }
        catch(Exception e)
        {
            throw e;
        }
    }









}
