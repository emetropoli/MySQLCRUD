
import java.sql.*;

public class DBConnect {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pre;
    
    public DBConnect(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://testdb.chock9gctztt.us-east-1.rds.amazonaws.com:3306/testdb?user=root&password=rootpassword");
            //jdbc:driver://testdb.chock9gctztt.us-east-1.rds.amazonaws.com:3306/testdb?user=root&password=rootpassword
            st = con.createStatement();
        }catch(Exception ex) {
            System.out.println("ConnectionError| DBConnect constructor: "+ex);
        }
    }
   
    public void Create(){ 
    try{
    String query = "INSERT INTO people (id, name, age) VALUES ( ?, ?, ?)";
 
    PreparedStatement statement = con.prepareStatement(query);
    statement.setString(1, "3");
    statement.setString(2, "Ed");
    statement.setString(3, "23");
 
    int rowsInserted = statement.executeUpdate();
    if (rowsInserted > 0) {
    System.out.println("A new user was inserted successfully!");
    }        
    }catch(Exception ex){
    System.out.println("ErrorWhileInsertingData | Create method: "+ ex);
    }    
    }
    
    public void Read(){
        try{
        String query = "SELECT * FROM people";
        rs = st.executeQuery(query);
        System.out.println("Records from Database");
        while(rs.next()){
            String name = rs.getString("name");
            String age = rs.getString("age");
            System.out.println("Name: "+name+"  "+"Age: "+age );
        }
        }catch(Exception ex){
        System.out.println("ErrorWhileGettingData | Read method: "+ ex);
        
        }
    }

    public void Update(){
            
        try{
            String query = "UPDATE people SET name=?, age=? WHERE id=?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, "George");
            statement.setString(2, "28");
            statement.setString(3, "2");
           
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
        System.out.println("An existing user was updated successfully!");
        }
        }catch(Exception ex){
        System.out.println("ErrorWhileUpdatingData | Update metod"+ ex);
        }
    }
    
    public void Delete(){
        try{
            
            String sql = "DELETE FROM people WHERE name=?";
 
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "Ed");
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
            }
        }catch(Exception ex){
        System.out.println("ErrorWhileDeletingData | Delete metod"+ ex);
        }    
    }    

}

    

