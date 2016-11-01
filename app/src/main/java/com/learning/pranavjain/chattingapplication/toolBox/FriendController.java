package com.learning.pranavjain.chattingapplication.toolBox;

import com.learning.pranavjain.chattingapplication.typo.InfoOfFriends;

/**
 * Created by Pranav Jain on 11/1/2016.
 */

public class FriendController {

    public static InfoOfFriends[] infoOfFriends = null;
    public static InfoOfFriends[] unapprovedFriends = null;
    public static String activeFriends;

    public static InfoOfFriends checkFriends(String username, String userKey){

        InfoOfFriends result = null;
        if(infoOfFriends != null){

            for(int i = 0; i < infoOfFriends.length; i++){
                if(infoOfFriends[i].userName.equals(username) && infoOfFriends[i].userKey.equals(userKey)){
                    result = infoOfFriends[i];
                    break;
                }
            }

        }

        return result;
    }

    public static InfoOfFriends getInfoOfFriends(String username) {
        InfoOfFriends result = null;
        if(infoOfFriends != null){

            for(int i = 0; i < infoOfFriends.length; i++){
                if(infoOfFriends[i].userName.equals(username)){
                    result = infoOfFriends[i];
                    break;
                }
            }
        }

        return result;
    }

    public static void setInfoOfFriends(InfoOfFriends[] infoOfFriends) {
        FriendController.infoOfFriends = infoOfFriends;
    }
}
