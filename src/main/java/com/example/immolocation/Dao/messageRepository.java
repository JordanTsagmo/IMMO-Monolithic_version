package com.example.immolocation.Dao;

import com.example.immolocation.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface messageRepository extends JpaRepository<Message,Integer> {
}
