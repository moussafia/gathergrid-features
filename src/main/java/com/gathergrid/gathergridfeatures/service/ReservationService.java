package com.gathergrid.gathergridfeatures.service;
import com.gathergrid.gathergridfeatures.domain.Reservation;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.ReservationRepository;
public class ReservationService {
    private final ReservationRepository userRepository;

    public ReservationService() {
      userRepository = new ReservationRepository();
    }

    public Reservation save(Reservation reservation){
         userRepository.save(reservation);
        return reservation ;
    }
}
