package com.mazhar.lovable_clone.dto.subscription;

import java.time.Instant;

public record SubscriptionResponse(
        String name,
        String status,
        Instant periodEnd,
        Long TokedUsedThisCyc
) {
}
