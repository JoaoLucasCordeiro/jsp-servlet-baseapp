package br.mendonca.testemaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowerDAO {

    public void follow(String followerId, String followedId) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "INSERT INTO followers (follower_id, followed_id) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, followerId);
        stmt.setString(2, followedId);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void unfollow(String followerId, String followedId) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "DELETE FROM followers WHERE follower_id = ? AND followed_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, followerId);
        stmt.setString(2, followedId);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<String> listFollowing(String followerId) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "SELECT followed_id FROM followers WHERE follower_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, followerId);
        ResultSet rs = stmt.executeQuery();
        List<String> following = new ArrayList<>();
        while (rs.next()) {
            following.add(rs.getString("followed_id"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return following;
    }
}