package com.example.immolocation.Controleur;

import org.springframework.stereotype.Component;


// evenement de connexion et deconnexion du socket
@Component
public class WebSocketEventListener {

   /* private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {

        logger.info("Recieve a new web socket connection");
    }

    @EventListener
    // extraction du nom de l'utilisateur
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("User Disconnected : " + username);

            Message message = new Message();
            message.setNom_expediteur(username);
            message.setNom_recepteur("");
            message.setMessage("");

            messagingTemplate.convertAndSend("/chatroom/public", message);
        }
    }*/

}