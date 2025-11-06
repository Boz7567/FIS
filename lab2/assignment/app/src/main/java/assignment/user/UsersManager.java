package assignment.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import assignment.cart.Cart;

public class UsersManager {

    public static final String BASIC_USER_ID = "User00-"; //problema di Maintainability x2
    protected static final List<User> users = new ArrayList<>(); //problema di Maintainability x2
    private final String pwd = System.getenv("SECRET");
    

    public boolean findUserFromDB(String userID) throws SQLException {
        PreparedStatement stmt = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", BASIC_USER_ID+userID, pwd)) { //cambiato in BASIC_USER_ID, //problema di Security
            String query = "select firstname, lastname " + "from USERS where username="+ (BASIC_USER_ID+userID); //cambiato in BASIC_USER_ID
            stmt = conn.prepareStatement(query); //problema di Reliability
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                return true;    //problema di Maintainability
            return false;



        } catch (SQLException e) { //problema di Maintainability
            return false;
        }
        finally{
            if(stmt != null) //don't know if I need this check
                stmt.close();
        }
    }

    void addUser(User user) throws SQLException{
        if(!findUserFromDB(user.getUserID()))
            users.add(user);
    }
    
    void removeEmptyTitlesFromUser(User user) {      
        List<String> titles = user.getTitles();
        for(int i = titles.size()-1; i>=0; i--){
          if (titles.get(i).isEmpty()) {
            titles.remove(i); 
          }
        }
    }

    void addCartToUser(User user, Cart cart) { //problema di Maintainability
            user.linkCart(cart);
    }
}