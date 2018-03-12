package bg.swift.ip.forum.dao;

import bg.swift.ip.forum.db.DBManager;
import bg.swift.ip.forum.entity.Comment;
import bg.swift.ip.forum.entity.Entity;
import bg.swift.ip.forum.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;


public class CommentDAO extends EntityDAO {


    String findByIDSQL = "SELECT * FROM replies WHERE id = ?";


    @Override
    public Comment findById(int id) {

        return findById(id, true);
    }


    public Comment findById(int id, boolean setOwner) {
        try (DBManager db = new DBManager();
             PreparedStatement pst = db.getConnection().prepareStatement(findByIDSQL)) {


            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                Comment comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setCommentText(rs.getString("message"));
                comment.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());
                comment.setDateModified(rs.getTimestamp("date_modified").toLocalDateTime());


                if (setOwner) {
                    int userId = rs.getInt("users_id");
                    UserDAO userDAO = new UserDAO();
                    User owner = userDAO.findById(userId);
                    comment.setOwner(owner);
                }
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

    @Override
    public Comment create(Entity entity) {

        String sql = "INSERT INTO replies (message, date_created, date_modified, users_id, topic_id) " +
                "VALUES (?, ?, ?, ?, ?)";

        Comment comment = (Comment) entity;

        try (DBManager db = new DBManager();
             PreparedStatement pt = db.getConnection().prepareStatement(sql)) {

            pt.setString(1, comment.getCommentText());
            pt.setTimestamp(2, Timestamp.valueOf(comment.getDateCreated()));
            pt.setTimestamp(3, Timestamp.valueOf(comment.getDateModified()));
            pt.setInt(4, comment.getOwner().getId());
            pt.setInt(5, comment.getTopicId());

            pt.executeUpdate();
                return comment;

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

    public List<Comment> getAllCommentsMainPage() {
        List<Comment> commentList = new LinkedList<>();

        String sql = "SELECT * FROM replies WHERE topic_id = ?";

        try (DBManager db = new DBManager();
             PreparedStatement pt = db.getConnection().prepareStatement(sql)) {

            pt.setInt(1, 1);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setCommentText(rs.getString("message"));
                comment.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());
                comment.setDateModified(rs.getTimestamp("date_modified").toLocalDateTime());


                int userId = rs.getInt("users_id");
                UserDAO userDAO = new UserDAO();
                User owner = userDAO.findById(userId);
                comment.setOwner(owner);

                commentList.add(comment);

            }
            return commentList;

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

    public List<Comment> getCommentsByTopicId(int topicId){

        List<Comment> commentList = new LinkedList<>();

        String sql = "SELECT * FROM replies WHERE topic_id = ?";

        try (DBManager db = new DBManager();
             PreparedStatement pt = db.getConnection().prepareStatement(sql)) {

            pt.setInt(1, topicId);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setCommentText(rs.getString("message"));
                comment.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());
                comment.setDateModified(rs.getTimestamp("date_modified").toLocalDateTime());


                int userId = rs.getInt("users_id");
                UserDAO userDAO = new UserDAO();
                User owner = userDAO.findById(userId);
                comment.setOwner(owner);

                commentList.add(comment);

            }
            return commentList;

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
