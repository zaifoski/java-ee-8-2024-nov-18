package net.ensode.javaee8book.jsfwebsocket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class JsfWebSocketController implements Serializable {

    @Inject
    private JsfWebSocketMessageSender jsfWebSocketMessageSender;

    private String userName;
    private String message;
    private String selectedChannel;

    public void updateChannel() {
        // Logic for channel switching if needed, now we just set the selected channel
    }

    public void sendMessage() {
        jsfWebSocketMessageSender.send(String.format("%s: %s", userName, message));
    }

    public String navigateToChatPage() {
        return "chat";
    }

    public JsfWebSocketMessageSender getJsfWebSocketMessageSender() {
        return jsfWebSocketMessageSender;
    }

    public void setJsfWebSocketMessageSender(JsfWebSocketMessageSender jsfWebSocketMessageSender) {
        this.jsfWebSocketMessageSender = jsfWebSocketMessageSender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSelectedChannel() {
        return selectedChannel;
    }
    public void setSelectedChannel(String selectedChannel) {
        this.selectedChannel = selectedChannel;
    }

}
