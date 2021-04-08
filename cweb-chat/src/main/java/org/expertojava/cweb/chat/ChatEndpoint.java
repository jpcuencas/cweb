package org.expertojava.cweb.chat;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by expertojava on 23/10/15.
 */
@ServerEndpoint("/ChatWS/{sala}")
public class ChatEndpoint {
    String nick;

    @OnOpen
    public void onOpen(Session sesion, @PathParam("sala") String sala) {
        sesion.getUserProperties().put("sala", sala);
        if(sesion.getRequestParameterMap().get("nick")==null) {
            nick = "Sin lista";
        } else if(sesion.getRequestParameterMap().get("nick").size()>0) {
            nick = sesion.getRequestParameterMap().get("nick").get(0);
        } else {
            nick = "Lista vacia";
        }
    }

    @OnMessage
    public void onMessage(Session sesion, String mensaje) {
        for(Session s : sesion.getOpenSessions()) {
            try {
                if(sesion.getUserProperties().get("sala").equals(s.getUserProperties().get("sala"))) {
                    s.getBasicRemote().sendText(nick + ";" + mensaje);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
