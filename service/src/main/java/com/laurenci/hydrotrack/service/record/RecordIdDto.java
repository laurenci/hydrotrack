package com.laurenci.hydrotrack.service.record;

import java.time.LocalDateTime;

public record RecordIdDto(Long userId, Long drinkId, LocalDateTime date) {
}
