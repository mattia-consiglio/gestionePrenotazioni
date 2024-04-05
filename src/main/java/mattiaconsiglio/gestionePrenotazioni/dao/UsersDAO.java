package mattiaconsiglio.gestionePrenotazioni.dao;

import mattiaconsiglio.gestionePrenotazioni.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersDAO extends JpaRepository<User, UUID> {
}
