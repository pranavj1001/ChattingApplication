package com.learning.pranavjain.chattingapplication.toolBox;

import android.util.Log;

import com.learning.pranavjain.chattingapplication.interfacer.Update;
import com.learning.pranavjain.chattingapplication.typo.InfoOfFriends;
import com.learning.pranavjain.chattingapplication.typo.InfoOfMessage;
import com.learning.pranavjain.chattingapplication.typo.InfoOfStatus;

import org.xml.sax.Attributes;
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

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if(localName == "friend"){

            InfoOfFriends friend = new InfoOfFriends();
            friend.userName = attributes.getValue(InfoOfFriends.userName);
            String status = attributes.getValue(InfoOfFriends.status);
            friend.port = attributes.getValue(InfoOfFriends.port);

            if(status != null && status.equals("online")){
                friend.status = String.valueOf(InfoOfStatus.ONLINE);
                mOnlineFriends.add(friend);
            }else if(status.equals("unApproved")){
                friend.status = String.valueOf(InfoOfStatus.UNAPPROVED);
                mUnApprovedFriends.add(friend);
            }else {
                friend.status = String.valueOf(InfoOfStatus.OFFLINE);
                mFriends.add(friend);
            }

        }else if(localName == "user"){
            this.userKey = attributes.getValue(InfoOfFriends.userKey);
        }

        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void startDocument() throws SAXException {

        this.mFriends.clear();
        this.mOnlineFriends.clear();
        this.mUnreadMessages.clear();
        super.startDocument();

    }

}
