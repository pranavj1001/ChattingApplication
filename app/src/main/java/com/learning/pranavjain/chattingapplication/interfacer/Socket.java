package com.learning.pranavjain.chattingapplication.interfacer;

/**
 * Created by Pranav Jain on 10/31/2016.
 */

public interface Socket {

    public String sendHTTPRequest(String Params);
    public int startListeningPort(int Port);
    public void stopListening();
    public void exit();

}
