
public class Main {

    
    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        
        connect.Create();
        connect.Read();
        connect.Update();
        connect.Delete();
        
    }
    
}
