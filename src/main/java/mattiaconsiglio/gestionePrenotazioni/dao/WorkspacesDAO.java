package mattiaconsiglio.gestionePrenotazioni.dao;

import mattiaconsiglio.gestionePrenotazioni.entities.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspacesDAO extends JpaRepository<Workspace, UUID> {
}
