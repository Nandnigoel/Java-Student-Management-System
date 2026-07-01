import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection{
    private static final String URL =
            "jdbc:mysql://localhost:3306/student_management_system";

    private static final String USER = "root";

    private static final String PASSWORD = "SEQUEL@146";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void main(String[] args) throws Exception {
        Connection con = getConnection();

        if (con != null) {
            System.out.println("Database Connected Successfully!");
        }

        con.close();
    }

}