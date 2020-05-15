package com.application.aled.configWebSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {

    //permet à Spring Boot d’orienter les appelles utilisant le protocole WebSocket
    // vers les endpoints dédiés de votre application Java

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // définit le préfixe d’accès aux éventuels contrôleurs que les clients pourront consommer dans votre API
        //«/ api» pour filtrer les destinations ciblant les méthodes annotées.
        registry.setApplicationDestinationPrefixes("/api");
        registry.enableSimpleBroker("/topic");
    }

    // STOMP définit un protocole permettant au client/serveur de communiquer (bidirectionelles et asychrones)
    // ce qui active la prise en charge STOMP de Spring.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //"*" permet de gérer les CORS lors de l’appel
        registry.addEndpoint("/stomp").setAllowedOrigins("*");
    }
}
