package br.mendonca.testemaven.controller;

import java.io.IOException;
import java.util.List;

public class FollowerServlet {
    private final FollowerEndpoint endpoint = new FollowerEndpoint();

    public void doPost(String action, String followerId, String followedId) throws IOException {
        endpoint.doPost(action, followerId, followedId);

    }

    public List<String> doGet(String followerId) {
        return endpoint.doGet(followerId);
    }
}