package mattiaconsiglio.gestionePrenotazioni.dao;

import lombok.extern.slf4j.Slf4j;
import mattiaconsiglio.gestionePrenotazioni.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReservationsService {
    @Autowired
    private ReservationsDAO rs;

    public void save(Reservation reservation) {
        if (rs.findReserved(reservation.getDate(), reservation.getUser(), reservation.getWorkspace()).isEmpty()) {
            rs.save(reservation);
            log.info("Reservation saved: {}", reservation);
        }
    }

}
