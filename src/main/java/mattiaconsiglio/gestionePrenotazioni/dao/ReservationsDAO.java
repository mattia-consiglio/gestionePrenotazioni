package mattiaconsiglio.gestionePrenotazioni.dao;

import mattiaconsiglio.gestionePrenotazioni.entities.Reservation;
import mattiaconsiglio.gestionePrenotazioni.entities.User;
import mattiaconsiglio.gestionePrenotazioni.entities.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationsDAO extends JpaRepository<Reservation, UUID> {
    @Query("SELECT r FROM Reservation r WHERE (r.date = :date AND r.user = :user) OR (r.workspace = :workspace AND r.date = :date)")
    List<Reservation> findReserved(LocalDate date, User user, Workspace workspace);
}
