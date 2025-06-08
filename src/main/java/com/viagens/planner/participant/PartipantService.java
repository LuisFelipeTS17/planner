package com.viagens.planner.participant;

import com.viagens.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PartipantService {

    @Autowired
    private ParticipantRepository repository;

    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip ) {
       List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, trip)).toList();

       this.repository.saveAll(participants);

        System.out.println(participants.get(0).getId());

    };
    public ParticipantCreateResponse registerParticipantToEvent(String email, Trip trip) {
        Participant newPartaticipant = new Participant(email, trip);
        this.repository.save(newPartaticipant);

        return new ParticipantCreateResponse(newPartaticipant.getId());
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId){};
    public void triggerConfirmationEmailToParticipants(String email){};

    public List<Participant> getAllParticipantsFromEvent(UUID tripId){
        return this.repository.findByTripId(tripId);
    }
}
