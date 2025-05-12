package com.viagens.planner.participant;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PartipantService {

    public void registerParticipantsToEvent(List<String> participantsToInvite, UUID tripId ) {
    };

    public void triggerConfirmationEmailToParticipants(UUID tripId){};
}
