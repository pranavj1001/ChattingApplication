package com.learning.pranavjain.chattingapplication.toolBox;

import com.learning.pranavjain.chattingapplication.typo.InfoOfMessage;

/**
 * Created by Pranav Jain on 11/1/2016.
 */

public class MessageController {

    public static final String taken = "taken";
    public static InfoOfMessage[] infoOfMessages = null;

    public static InfoOfMessage[] getInfoOfMessages() {
        return infoOfMessages;
    }

    public static void setInfoOfMessages(InfoOfMessage[] infoOfMessages) {
        MessageController.infoOfMessages = infoOfMessages;
    }

    public static InfoOfMessage checkMessage(String username){
        InfoOfMessage result = null;

        for(int i = 0; i < infoOfMessages.length; i++){
            result = infoOfMessages[i];
            break;
        }
        return result;
    }
}
