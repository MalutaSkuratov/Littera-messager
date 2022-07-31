package ru.littera.messager.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.littera.messager.dto.MessageDTO;
import ru.littera.messager.models.Message;
import ru.littera.messager.repositories.MessageRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {

    @Value("${file.path}")
    private String filePath;
    private final MessageRepository messageRepository;


    @GetMapping
    public String messages(Model model){
        model.addAttribute("messages", messageRepository.findAll());
        return "messages";
    }

    @PostMapping("/messages/new")
    public String createMessage(@ModelAttribute MessageDTO messageDTO){
        Message message = new Message(messageDTO.getTitle(),
                messageDTO.getMessage(),
                messageDTO.getAuthor());
        messageRepository.save(message);
        return "redirect:/";
    }

    @PostMapping("/message/delete/{id}")
    public String deleteMessage(@PathVariable Long id ){
        messageRepository.deleteById(id);
        return "redirect:/";

    }


}
