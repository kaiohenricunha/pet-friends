package com.pet_friends.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

/**
 * Abstract base class for all commands in the Pet Friends application.
 * Provides common properties such as a unique identifier and timestamp.
 */
@Getter
@NoArgsConstructor
public abstract class BaseCommand {
    private final String commandId = UUID.randomUUID().toString();
    private final Instant timestamp = Instant.now();
}
