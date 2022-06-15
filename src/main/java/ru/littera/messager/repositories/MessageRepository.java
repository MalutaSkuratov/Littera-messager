package ru.littera.messager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.littera.messager.models.Message;

public interface MessageRepository extends JpaRepository <Message,Long> {

    Message findByTitle(String title);
}
