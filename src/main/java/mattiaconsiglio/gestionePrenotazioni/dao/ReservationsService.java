package mattiaconsiglio.gestionePrenotazioni.dao;

import lombok.extern.slf4j.Slf4j;
import mattiaconsiglio.gestionePrenotazioni.entities.Reservation;
import mattiaconsiglio.gestionePrenotazioni.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Reservation> getAllByUser(User user) {
        return rs.findAllByUser(user);
    }
}
