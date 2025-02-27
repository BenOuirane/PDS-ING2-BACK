package com.application.aled.repository;

import com.application.aled.entity.Message;
import com.application.aled.entity.Objects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByObjects(Objects objects);
}
