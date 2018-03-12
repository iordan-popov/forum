package bg.swift.ip.forum.dao;

import bg.swift.ip.forum.db.DBManager;
import bg.swift.ip.forum.entity.Entity;
import bg.swift.ip.forum.entity.Topic;
import bg.swift.ip.forum.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class TopicDAO extends EntityDAO {


    @Override
    public Topic findById(int id) {

        String sql = "SELECT * FROM topics where id = ?  ";

        try (DBManager db = new DBManager();
             PreparedStatement pt = db.getConnection().prepareStatement(sql)){

            pt.setInt(1, id);

            ResultSet rs = pt.executeQuery();

            if (rs.next()){

                Topic topic = new Topic();
                topic.setName(rs.getString("name"));
                topic.setMessage(rs.getString("message"));
                topic.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());
                topic.setDateModified(rs.getTimestamp("date_modified").toLocalDateTime());
                topic.setForumId(rs.getInt("forums_id"));

                int ownerId = rs.getInt("users_id");
                UserDAO userDAO = new UserDAO();
                User owner = userDAO.findById(ownerId);

                topic.setOwner(owner);

            }
        }catch (SQLException e) {
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
    public Topic create(Entity entity) {

        String sql = "INSERT INTO topics (name, message, date_created, date_modified, users_id, forums_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        /*This wa we change one object to another*/
        Topic topic = (Topic) entity;


        try (DBManager db = new DBManager();
             PreparedStatement pt = db.getConnection().prepareStatement(sql)) {

            pt.setString(1, topic.getName());
            pt.setString(2,topic.getMessage());
            pt.setTimestamp(3, Timestamp.valueOf(topic.getDateCreated()));
            pt.setTimestamp(4, Timestamp.valueOf(topic.getDateModified()));
            pt.setInt(5, topic.getOwner().getId());
            pt.setInt( 6, topic.getForumId());


            pt.executeUpdate();

            return topic;

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

    public List<Topic> getTopicsByForumId(int forumId) {
        List<Topic> topicList = new LinkedList<>();

        String sql = "SELECT * FROM topics WHERE forums_id = ? ";

        try (DBManager db = new DBManager();
             PreparedStatement pt = db.getConnection().prepareStatement(sql)) {

pt.setInt(1, forumId);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Topic topic = new Topic();
                topic.setId(rs.getInt("id"));
                topic.setName(rs.getString("name"));
                topic.setMessage(rs.getString("message"));
                topic.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());
                topic.setDateModified(rs.getTimestamp("date_modified").toLocalDateTime());


                int userId = rs.getInt("users_id");
                UserDAO userDAO = new UserDAO();
                User owner = userDAO.findById(userId);
                topic.setOwner(owner);

                topicList.add(topic);

            }
            return topicList;

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

    public int getForumId(int topicId){

        int forumId = 0;

        String sql = "SELECT forums_id FROM topics WHERE id = ?";

        try (DBManager db = new DBManager();
        PreparedStatement pt = db.getConnection().prepareStatement(sql)){

            pt.setInt(1, topicId);


           ResultSet rs = pt.executeQuery();

           while (rs.next()){

               forumId = rs.getInt("forums_id");
           }
        }catch (SQLException e){
            while (e != null){
                System.out.println(e.getSQLState());
                System.out.println(e.getMessage());
                System.out.println(e.getErrorCode());
                e = e.getNextException();
            }
        }
        return forumId;
    }
}
