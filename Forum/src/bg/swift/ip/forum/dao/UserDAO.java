package bg.swift.ip.forum.dao;

import bg.swift.ip.forum.db.DBManager;
import bg.swift.ip.forum.entity.Entity;
import bg.swift.ip.forum.entity.Gender;
import bg.swift.ip.forum.entity.User;

import java.sql.*;
import java.time.LocalDate;


public class UserDAO extends EntityDAO {

    @Override
    public User create(Entity entity) {

        User user = (User) entity;


        String sql = "INSERT  INTO users(email, name, password, gender, age, date_registered, current_status, " +
                "registered_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (DBManager db = new DBManager()) {
            PreparedStatement st = db.getConnection().prepareStatement(sql);

            st.setString(1, user.getEmail());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.setString(4, String.valueOf(user.getGender()));
            st.setInt(5, user.getAge());
            st.setDate(6, Date.valueOf(String.valueOf(LocalDate.now())));
            st.setString(7, "Invisible");
            st.setString(8, "New");

            st.executeUpdate();
            return user;

        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e.getSQLState());
                System.out.println(e.getMessage());
                System.out.println(e.getErrorCode());
                e = e.getNextException();
            }
        }
        return null;
    }

    public User findByEmailAndPassword(String email, String password) {


        String sql = "SELECT id FROM forum.users WHERE email = ? AND password = ?";


        try (DBManager db = new DBManager();
             PreparedStatement st = db.getConnection().prepareStatement(sql)) {

            st.setString(1, email);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                return findById(id);
            }


        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e.getSQLState());
                System.out.println(e.getMessage());
                System.out.println(e.getErrorCode());
                e = e.getNextException();
            }
        }
        return null;
    }

    public User findById(int id) {

        String sql = "SELECT * FROM users where id = ?";

        try (DBManager db = new DBManager();
             PreparedStatement ps = db.getConnection().prepareStatement(sql)) {

            ps.setInt(1, id);


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User retUser = new User();

                retUser.setId(rs.getInt("id"));
                retUser.setEmail(rs.getString("email"));
                retUser.setName(rs.getString("name"));
                retUser.setPassword(rs.getString("password"));
                retUser.setGender(Gender.valueOf(rs.getString("gender")));
                retUser.setAge(rs.getInt("age"));

                return retUser;
            }
        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e.getSQLState());
                System.out.println(e.getMessage());
                System.out.println(e.getErrorCode());
                e = e.getNextException();
            }
        }
        return null;
    }
}
