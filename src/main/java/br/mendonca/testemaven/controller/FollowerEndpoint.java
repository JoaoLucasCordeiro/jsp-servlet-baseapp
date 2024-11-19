package br.mendonca.testemaven.controller;

import java.io.IOException;
import java.util.List;

public class FollowerEndpoint {
    private final FollowerController controller = new FollowerController();

    public void doPost(String action, String followerId, String followedId) throws IOException {
        controller.handleRequest(action, followerId, followedId);
    }

    public List<String> doGet(String followerId) {
        return controller.getFollowing(followerId);
    }
}