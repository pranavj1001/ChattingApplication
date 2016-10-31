package com.learning.pranavjain.chattingapplication.interfacer;

import com.learning.pranavjain.chattingapplication.typo.InfoOfFriends;
import com.learning.pranavjain.chattingapplication.typo.InfoOfMessage;

/**
 * Created by Pranav Jain on 10/31/2016.
 */

public interface Update {

    public void updateData(InfoOfMessage[] message, InfoOfFriends[] friends, InfoOfFriends[] unApprovedFriends, String userKey);

}
