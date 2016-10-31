package com.learning.pranavjain.chattingapplication.interfacer;

import java.io.UnsupportedEncodingException;

/**
 * Created by Pranav Jain on 10/31/2016.
 */

public interface Manager {

    public String getUserName();
    public String sendMessage(String fromUsername, String toUsername, String message) throws UnsupportedEncodingException;
    public String authenticateUser(String usernameText, String passwordText) throws UnsupportedEncodingException;
    public void messageReceieved(String username, String message);

    public boolean isNetworkConnected();
    public boolean isUserAuthenticated();
    public String getLastRawFriendList();
    public void exit();

    public String signUpUser(String usernameText, String passwordText, String email);
    public String addNewFriendRequest(String friendUsername);
    public String sendFriendsReqsResponse(String approvedFriendNames, String discardedFriendNames);

}
