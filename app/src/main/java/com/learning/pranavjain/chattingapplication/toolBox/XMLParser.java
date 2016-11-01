package com.learning.pranavjain.chattingapplication.toolBox;

import android.util.Log;

import com.learning.pranavjain.chattingapplication.interfacer.Update;
import com.learning.pranavjain.chattingapplication.typo.InfoOfFriends;
import com.learning.pranavjain.chattingapplication.typo.InfoOfMessage;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Vector;

/**
 * Created by Pranav Jain on 11/1/2016.
 */

public class XMLParser extends DefaultHandler {

    public String userKey = new String();
    public Update update;

    public XMLParser(Update update){
        this.update = update;
    }

    private Vector<InfoOfFriends> mFriends = new Vector<InfoOfFriends>();
    private Vector<InfoOfFriends> mOnlineFriends = new Vector<InfoOfFriends>();
    private Vector<InfoOfFriends> mUnApprovedFriends = new Vector<InfoOfFriends>();

    private Vector<Update> mUnreadMessages = new Vector<Update>();

    public void endDocument() throws SAXException{

        InfoOfFriends[] friends = new InfoOfFriends[mFriends.size() + mOnlineFriends.size()];
        Update[] messages = new Update[mUnreadMessages.size()];

        int onlineFriendCount = mOnlineFriends.size();
        for(int i = 0; i < onlineFriendCount; i++){
            friends[i] = mOnlineFriends.get(i);
        }

        int offlineFriendCount =  mFriends.size();
        for(int i = 0; i < offlineFriendCount; i++){
            friends[i + onlineFriendCount] = mFriends.get(i);
        }

        int unApprovedFriendCount = mUnApprovedFriends.size();
        InfoOfFriends[] unApprovedFriends = new InfoOfFriends[unApprovedFriendCount];

        for(int i = 0; i < unApprovedFriendCount; i++){
            unApprovedFriends[i] = mUnApprovedFriends.get(i);
        }

        int unreadMessageCount = mUnreadMessages.size();
        for(int i = 0; i < unreadMessageCount; i++){
            messages[i] = mUnreadMessages.get(i);
            Log.i("Message Log", "i="+i);
        }

        this.update.updateData((InfoOfMessage[]) messages, friends, unApprovedFriends, userKey);
        super.endDocument();


    }

}
