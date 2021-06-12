package com.hackmann.polarity.events.serverEvents;

import com.hackmann.polarity.chat.ChatRoom;
import com.hackmann.polarity.events.Event;
import com.hackmann.polarity.events.clientEvents.ReceiveMessageEvent;
import com.hackmann.polarity.user.User;

public class SendMessageEvent implements Event {

    private String className;
    private String sender;
    private String message;

    public SendMessageEvent(String className, String sender, String message) {
        this.className = className;
        this.sender = sender;
        this.message = message;
    }

    @Override
    public void run(User user) {
        ChatRoom chatRoom = user.getChatRoom();
        chatRoom.sendMessage(new ReceiveMessageEvent(this.sender, this.message), user);
    }
}
