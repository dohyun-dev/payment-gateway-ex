package com.dohyundev.core.payment.domain.model.info.card;

import com.dohyundev.core.payment.domain.enums.CardOwnerType;
import com.dohyundev.core.payment.domain.enums.CardType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record CardInfo(
        @Enumerated(EnumType.STRING)
        CardType cardType,
        @Enumerated(EnumType.STRING)
        CardOwnerType ownerType,
        String number,
        String issuerCode,
        String acquirerCode
) {
}
