package com.mmelo.provider.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProviderMessage {
    SERVER_ERROR("An unexpected error has occurred. Please try again"),
    RESOURCE_NOT_FOUND("Requested resource could not be found");

    private final String message;
}