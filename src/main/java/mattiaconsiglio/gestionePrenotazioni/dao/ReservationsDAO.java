package mattiaconsiglio.gestionePrenotazioni.dao;

import mattiaconsiglio.gestionePrenotazioni.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservationsDAO extends JpaRepository<Reservation, UUID> {
}
