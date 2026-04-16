package com.mazhar.lovable_clone.entity;

import com.mazhar.lovable_clone.enums.MessageRole;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {

    Long id;

    ChatSession chatSession;

    MessageRole role;

    String content;

    String toolCalls;

    Integer tokenUsed;

    Instant createdAt;

}
