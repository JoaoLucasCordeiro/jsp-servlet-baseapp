package br.mendonca.testemaven.services;

import java.sql.SQLException;
import java.util.List;

import br.mendonca.testemaven.dao.FollowerDAO;

public class FollowerService {

    private FollowerDAO dao = new FollowerDAO();

    public void follow(String followerId, String followedId) throws ClassNotFoundException, SQLException {
        dao.follow(followerId, followedId);
    }

    public void unfollow(String followerId, String followedId) throws ClassNotFoundException, SQLException {
        dao.unfollow(followerId, followedId);
    }

    public List<String> listFollowing(String followerId) throws ClassNotFoundException, SQLException {
        return dao.listFollowing(followerId);
    }
}