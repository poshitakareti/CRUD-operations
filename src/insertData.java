import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class insertData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_schema", "root", "admin123");
            String sql = "INSERT INTO csex(id, name, marks) VALUES (?, ?, ?)";            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,101);
            ps.setString(2,"laxmi");
            ps.setInt(3,60);
            ps.addBatch();
            ps.setInt(1,102);
            ps.setString(2,"naveen");
            ps.setInt(3,90);
            ps.addBatch();
            int rows[]=ps.executeBatch();
            if(rows.length>0){
                System.out.println(rows.length+ " rows Inserted");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}