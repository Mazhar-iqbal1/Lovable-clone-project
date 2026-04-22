package com.mazhar.lovable_clone.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {

    Long id;

    User user; //Subscription has a RELATIONSHIP with User and Plan, And in JPA/ORM, we represent relationships using objects, not IDs.

    Plan plan;

    String stripeSubscriptionId;
    String status;

    Instant currentPeriodStart;
    Instant currentPeriodEnd;

    Boolean cancelAtPeriodEnd=false;

    Instant createdAt;
    Instant updatedAt;
}
