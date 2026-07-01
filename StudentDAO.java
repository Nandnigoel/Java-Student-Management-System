import java.sql.*;

public class StudentDAO {

    public void addStudent(Student student) throws Exception {

        Connection con = DBConnection.getConnection();

        String query =
                "INSERT INTO students(id, name, age, course) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, student.getId());
        ps.setString(2, student.getName());
        ps.setInt(3, student.getAge());
        ps.setString(4, student.getCourse());

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student added successfully!");
        }

        ps.close();
        con.close();
    }

    public void displayStudents() throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM students";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age") + " " +
                    rs.getString("course")
            );
        }
        con.close();
    }

    public void searchStudent(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM students WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age") + " " +
                    rs.getString("course")
            );
        } else {
            System.out.println("Student not found!");
        }
        rs.close();
        ps.close();
        con.close();
    }

    public void updateStudent(Student student) throws Exception {
        Connection con = DBConnection.getConnection();
        String query =
            "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getCourse());
        ps.setInt(4, student.getId());
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
        ps.close();
        con.close();
    }

    public void deleteStudent(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "DELETE FROM students WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
        ps.close();
        con.close();
    }
}