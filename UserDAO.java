package dao;
import db.DB;
import model.User;
import java.sql.*;
public class UserDAO{
    public User auth(String u,String p){
        String q="SELECT * FROM users WHERE username=? AND password=?";
        try(Connection c=DB.get();PreparedStatement ps=c.prepareStatement(q)){
            ps.setString(1,u);ps.setString(2,p);
            try(ResultSet r=ps.executeQuery()){
                if(r.next())return new User(r.getInt("id"),u,p);
            }
        }catch(Exception e){}
        return null;
    }
}
