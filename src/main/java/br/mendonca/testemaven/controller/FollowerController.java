package br.mendonca.testemaven.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.mendonca.testemaven.services.FollowerService;

public class FollowerController {
    private FollowerService service = new FollowerService();

    public void handleRequest(String action, String followerId, String followedId) throws IOException {
        try {
            if ("follow".equals(action)) {
                service.follow(followerId, followedId);
            } else if ("unfollow".equals(action)) {
                service.unfollow(followerId, followedId);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getFollowing(String followerId) {
        try {
            return service.listFollowing(followerId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}