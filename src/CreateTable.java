import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class CreateTable {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_schema", "root", "admin123");
            System.out.println("dbConnected");
            Statement st=con.createStatement();
            st.executeUpdate("create table csex(id int,name varchar(50),marks int)");
            System.out.println("Table Created");
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}