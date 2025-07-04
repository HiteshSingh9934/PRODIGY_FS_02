package dao;
import db.DB;
import model.Employee;
import java.sql.*;
import java.util.*;
public class EmployeeDAO{
    public List<Employee> all(){
        List<Employee> list=new ArrayList<>();
        String q="SELECT * FROM employees";
        try(Connection c=DB.get();Statement s=c.createStatement();ResultSet r=s.executeQuery(q)){
            while(r.next())list.add(new Employee(r.getInt("id"),r.getString("name"),r.getString("email"),r.getDouble("salary")));
        }catch(Exception e){}
        return list;
    }
    public boolean insert(Employee e){
        String q="INSERT INTO employees(name,email,salary)VALUES(?,?,?)";
        try(Connection c=DB.get();PreparedStatement p=c.prepareStatement(q)){
            p.setString(1,e.name());p.setString(2,e.email());p.setDouble(3,e.salary());
            return p.executeUpdate()==1;
        }catch(Exception ex){return false;}
    }
    public boolean update(Employee e){
        String q="UPDATE employees SET name=?,email=?,salary=? WHERE id=?";
        try(Connection c=DB.get();PreparedStatement p=c.prepareStatement(q)){
            p.setString(1,e.name());p.setString(2,e.email());p.setDouble(3,e.salary());p.setInt(4,e.id());
            return p.executeUpdate()==1;
        }catch(Exception ex){return false;}
    }
    public boolean delete(int id){
        String q="DELETE FROM employees WHERE id=?";
        try(Connection c=DB.get();PreparedStatement p=c.prepareStatement(q)){
            p.setInt(1,id);
            return p.executeUpdate()==1;
        }catch(Exception ex){return false;}
    }
}
