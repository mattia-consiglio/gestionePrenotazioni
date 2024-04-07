package mattiaconsiglio.gestionePrenotazioni.dao;

import mattiaconsiglio.gestionePrenotazioni.entities.Building;
import mattiaconsiglio.gestionePrenotazioni.entities.Workspace;
import mattiaconsiglio.gestionePrenotazioni.entities.WorkspaceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WorkspacesDAO extends JpaRepository<Workspace, UUID> {
    Optional<Workspace> findFirstByDescriptionAndTypeAndBuildingAndMaxOccupants(String description, WorkspaceType type, Building building, int maxOccupants);

    Optional<Workspace> findFirstByDescription(String description);
}
