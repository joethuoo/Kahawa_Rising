package register_login;


import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class DBUtil {
        
       private  MainFrame frame;
        
        //Declaring access to the database
                private static final String USERNAME = "root";
                private static final String PASSWORD = "";	
                //we are connecting to a localhost
                private static final String CONN_STRING = "jdbc:mysql://localhost/logincredentials";
        
                public DBUtil(MainFrame frame){
                        
                        this.frame = frame;
                        
                        
                }
        
                public static boolean Connect() throws ClassNotFoundException, SQLException{

                        //get the driver. 
                        Class.forName("com.mysql.jdbc.Driver");

                        //create a new connection
                        Connection conn = null;
                        //create a statement object
                        Statement stmt = null;
                        //create a Resultset object
                      ResultSet rs = null;

                        //get connection
                        try {
                                conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                                System.out.println("********************************************");
                                System.out.println("Connected to MYSQL logincredentials database");
                                System.out.println("********************************************");
                                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                ResultSet.CONCUR_READ_ONLY);
                               rs = stmt.executeQuery("SELECT * from login");
                                //display data of whole database as it is currently, uncomment for debug
                                //displayData(rs);

                        } catch (SQLException e) {
                                //if exception, print error
                                DBUtil.processException(e);
                                return false;
                        }        
                        

                        return true;
                }
                
                public static void closeConnection(ResultSet result, Statement stmt, Connection conn) throws SQLException{
                        
                        //Not closing resources creates problems over a network

                        //if there is a result, close it
                        if(result!=null){
                                result.close();
                        }
                        //if there is a statement, close it
                        if(stmt!=null){
                                stmt.close();
                        }
                        //if there is an established connection, close it
                        if(conn!=null){
                                conn.close();
                        }
                        
                        
                }
        
        
        //This method returns exceptions in a printable form (for dialogs and commandline)
        public static void processException(SQLException e){
                
                //Set a string with all errors in it for JDialog
                String error = new String("Error: " +e.getMessage()
                                + "\nError code: " + e.getErrorCode() + "\nSQL State: " + e.getSQLState());
                
                JOptionPane errorPane = new JOptionPane(error, JOptionPane.ERROR_MESSAGE);
                 JDialog errorDialog = errorPane.createDialog("Error");
                 errorDialog.setAlwaysOnTop(true);
                 errorDialog.setVisible(true);
                
                System.err.println("Error message: " + e.getMessage());
                System.err.println("Error code: " + e.getErrorCode());
                System.err.println("SQL State: " + e.getSQLState());
                
                //exit the program with failure, this can be changed if needed later
                //System.exit(1);
                
                
        }
        
        //this method displays username and password data in the console
        public static void displayData(ResultSet rs) throws SQLException{
                
                while (rs.next()){
                        
                        StringBuffer buffer = new StringBuffer();
                        buffer.append("Key " + rs.getString("userid") + ":");
                        buffer.append("\nFirst Name: " + rs.getString("fname"));
                        buffer.append("\nLast Name: " + rs.getString("lname"));
                        buffer.append("\nAddress: " + rs.getString("address"));
                        buffer.append("\nPhone Number: " + rs.getString("phonenumber"));
                        buffer.append("\n Id Number: "+ rs.getString("idnumber"));
                        buffer.append("\nUsername: " + rs.getString("username"));
                        buffer.append("\nPassword: " + rs.getString("password"));
                        System.out.println(buffer.toString());        
                        
                }
                //Get to the last result of the table
                rs.last();
                System.out.println("Number of Rows in the table: " + rs.getRow());        
        }
        
        //this method sends the register data entered into the database.
        public static boolean updateDatabase(Connection conn, String fname, String lname, String address, String
                        phoneNum,String idNum, String username, String password) throws SQLException{
                
                //create statement to get count of userID's
                Statement getUserID = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                
                //Create preparedStatement with variable placeholders
                PreparedStatement insert = conn.prepareStatement("insert into login (userid, fname, lname, address, " +
                                "phonenumber, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)", ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                
                
                ResultSet returnedUserID = null;
                
                
                try{
                        //get count of UserID's currently in the database, so we can add 1 to it when we add a new user
                        System.out.println("Executing UserID Query");
                        returnedUserID = getUserID.executeQuery("SELECT userid, COUNT(userid) FROM users;");
                        
                        
                }
                catch(SQLException e){
                        //If something happens with the retrieve, then process the exception
                        processException(e);
                }
                //
                while(returnedUserID.next()){
                        
                        int countUserID = returnedUserID.getInt("COUNT(userid)");
                        System.out.println("The value of countUserID is " + countUserID);
                        
                        //increment the userID by 1 for insertion
                        countUserID++;
                        
                        //insert all values into prepared statement
                        insert.setInt(1, countUserID);
                        insert.setString(2, fname);
                        insert.setString(3, lname);
                        insert.setString(4, address);
                        insert.setString(5, phoneNum);
                        insert.setString(6, username);
                        insert.setString(7, password);
                        System.out.println("inserted countUserID into insert statement. Value is: " + countUserID);
                        System.out.println("prepared statement insert is " + insert);
                        System.out.println("All values passed into insert successfully");
                        //execute query
                        insert.execute();       
                }   
                return true;                          
        }
        
        //this method checks the login credentials against the database
        public static void checkLogin(Connection conn, String username, String password) throws SQLException{

                System.out.println("The value of username in checkLogin is: " + username);
                System.out.println("The value of password in checkLogin is: " + password);

                //Create preparedStatement with variable placeholders
                PreparedStatement checkLoginStmt = conn.prepareStatement("SELECT Username pasword FROM login " +
                                "WHERE Username = ? AND password = ?;");
                ResultSet userPassResult = null;
                try{
                        //add variables and execute
                        checkLoginStmt.setString(1, username);
                        checkLoginStmt.setString(2, password);
                        System.out.println("Prepared statement is " + checkLoginStmt);
                        System.out.println("Executing Query");
                        userPassResult = checkLoginStmt.executeQuery();




                }
                catch(SQLException e){
                        //custom dialog box code to go here if user already exists
                        processException(e);

                }

                //if no results found, throw exception
                if (!userPassResult.next()){
                        throw new SQLException("Error: Login does not exist! Please register!");

                }
                //while loop to loop through the ResultSet, if it exists
                while (userPassResult.next()){
                        String retrievedUserName = userPassResult.getString("Username");
                        String retrievedPassword = userPassResult.getString("password");
                        System.out.println("data in database is " + retrievedUserName + retrievedPassword);
                }

                //if all went well, login was successful, function will return to SubmitActionListener.
                System.out.println("Login successful!");


        }
        
        public static void checkUsername(Connection conn, String username) throws SQLException{

                //check username hasnt already been added to database
                System.out.println("The username entered is: " + username);


                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);

                
                        ResultSet rs = null;
                try{
                        System.out.println("Executing Query");
                        rs = stmt.executeQuery("SELECT USERNAME from users");
                }
                catch(SQLException e){
                        //If something happens with the retrieve, then process the exception
                        processException(e);
                }
                
                //while loop to loop through the ResultSet
                while(rs.next()){
                        //new string is set from the username of the ResultSet
                        String retrievedUser = rs.getString("username");
                        //if the strings match, a user is found
                        if (retrievedUser.compareTo(username) == 0){
                                System.out.println("Username found!");
                                closeConnection(rs, stmt, conn);
                                throw new SQLException("Error: Username already exists in database!");
                                
                        }
                        else{
                                //all is well, continue with the game
                                System.out.println("Username NOT found! Start game");
                                
                        }
                }
                rs.last();
                System.out.println("Number of entries are: " + rs.getRow());        

        }

}