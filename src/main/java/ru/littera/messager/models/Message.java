package ru.littera.messager.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String message;
    private String author;

    public Message(String title, String message, String author) {
        this.title = title;
        this.message = message;
        this.author = author;
    }
}
