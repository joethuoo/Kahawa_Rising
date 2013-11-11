package register_login;


import java.sql.SQLException;
public class Main {
        
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
                
                //creates a new MainFrame
               /*MainFrame m =*/ new MainFrame();
                
                //starts connection to the database
                DBUtil.Connect();
                
                        
        }
                
}