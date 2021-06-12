package com.hackmann.polarity.chat;

import com.hackmann.polarity.events.Event;
import com.hackmann.polarity.events.clientEvents.JoinedRoomEvent;
import com.hackmann.polarity.user.User;
import org.apache.logging.log4j.message.Message;

import java.util.ArrayList;

public class ChatRoom {

    private ArrayList<User> members = new ArrayList<>();
    private String topic;
    private boolean open = true;

    public ChatRoom(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return this.topic;
    }

    public void join(User user) {
        if (this.open) {
            System.out.println("Added user.");
            this.members.add(user);
            user.getConnection().send(new JoinedRoomEvent());
        }
    }

    public void sendMessage(Event content, User sender) {
        for (User user : this.members) {
            if (user != sender) {
                user.getConnection().send(content);
            }
        }
    }

    public void shutdown() {
        for (User user : this.members) {
            // Send them a kick out notication
        }
        this.members.clear();
        this.open = false;
    }
}
