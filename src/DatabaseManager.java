import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/oop_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2008";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public void saveUniversity(University uni) {
        String sql = "INSERT INTO universities (name, location, education_direction, creation_year, course) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uni.getName());
            pstmt.setString(2, uni.getLocation());
            pstmt.setString(3, uni.getEducationdirect());
            pstmt.setInt(4, uni.getYear());
            pstmt.setString(5, uni.getCourse());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving university: " + e.getMessage());
        }
    }
    public void saveProfessor(Professor prof) {
        String sql = "INSERT INTO professors (name, age, department, experience, knowledge, personal_qualities) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, prof.getName());
            pstmt.setInt(2, prof.getAge());
            pstmt.setString(3, prof.getDep());
            pstmt.setInt(4, prof.getExperience());
            pstmt.setString(5, prof.getKnowledge());
            pstmt.setString(6, prof.getPersonalqual());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving professor: " + e.getMessage());
        }
    }
    public void deleteUniversity(String name) {
        String sql = "DELETE FROM universities WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            int deleted = pstmt.executeUpdate();
            if (deleted > 0) System.out.println("University deleted from DB.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
