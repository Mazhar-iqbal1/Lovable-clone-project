package com.mazhar.lovable_clone.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {

    Long id;

    String name;
    String stripePriceId;

    Integer maxProject;
    Integer maxTokensPerDay;
    Integer maxPreviews;

    Boolean unlimitedAi;

    Boolean active;


}
