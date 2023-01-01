package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Dao.LocataireRepository;
import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Model.Message;
import com.example.immolocation.Service.BailleurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class tchatController {
    @Autowired
    BailleurRepository bailleurRepository;
    @Autowired
    LocataireRepository locataireRepository;
    @Autowired
    BailleurServiceImpl bailleurService;
    @Autowired
    Message message;
    @Autowired
    com.example.immolocation.Dao.messageRepository messageRepository;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message chatMessage,
                           SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    @GetMapping("/messageBailleur")
    public String messageBailleur(HttpServletRequest httpServletRequest, Model model){

        HttpSession httpSession= httpServletRequest.getSession();
        SecurityContext securityContext= (SecurityContext)
                httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        String login =securityContext.getAuthentication().getName();
        List<Locataire> locataires= new ArrayList<>();
        System.out.println(login);

        locataires.addAll(bailleurService.locataireselonloginBailleur(login));
        model.addAttribute("listeDesLocataireDeBailleur",locataires);
        model.addAttribute("listeDesLocataireDeBailleur",locataires);
        System.out.println(locataires);

       model.addAttribute("nomDuBailleur", bailleurRepository.nomBailleur(login));
        System.out.println(bailleurRepository.nomBailleur(login));
        return "index";
    }
    @GetMapping("/messageLocataire")
    public String messageLocataire(HttpServletRequest httpServletRequest, Model model){

        HttpSession httpSession= httpServletRequest.getSession();
        SecurityContext securityContext= (SecurityContext)
                httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        String login =securityContext.getAuthentication().getName();



        model.addAttribute("nomDuLocataire", locataireRepository.non_locataire(login));
        System.out.println(locataireRepository.non_locataire(login));

        return "messagerieLocataire";
    }

    @PostMapping("/locataire/message/{loginlocataire}")
    public void renvoimsg(@PathVariable String loginlocataire ){
        message.setLocataire(locataireRepository.retourlocataire(loginlocataire));

    }


    @PostMapping("/sauvegarde")
    public String  sauvegarde(HttpServletRequest httpServletRequest ){

        HttpSession httpSession= httpServletRequest.getSession();
        SecurityContext securityContext= (SecurityContext)
                httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        String login =securityContext.getAuthentication().getName();

        message.setBailleur(bailleurRepository.retoureBailleur(login));
        messageRepository.save(message);
        return "message";
    }
    @PostMapping("/locataire/message2/{loginlocataire}")
    public void renvoimsg2(HttpServletRequest httpServletRequest, @PathVariable String loginlocataire ){

        HttpSession httpSession= httpServletRequest.getSession();
        SecurityContext securityContext= (SecurityContext)
                httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        String login =securityContext.getAuthentication().getName();

    }
}
