package com.viagens.planner.participant;

import java.util.UUID;

public record ParticipantData(UUID uuid,  String name, String email, Boolean isCorfirmed) {
}
