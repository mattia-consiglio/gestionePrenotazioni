package mattiaconsiglio.gestionePrenotazioni.dao;

import lombok.extern.slf4j.Slf4j;
import mattiaconsiglio.gestionePrenotazioni.entities.Workspace;
import mattiaconsiglio.gestionePrenotazioni.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkspacesService {
    @Autowired
    private WorkspacesDAO ws;

    public void save(Workspace workspace) {
        try {
            findExistingWorkspace(workspace);
        } catch (RecordNotFoundException e) {
            ws.save(workspace);
            log.info("Workspace saved: " + workspace);
        }
    }

    public Workspace findExistingWorkspace(Workspace workspace) {
        return ws.findFirstByDescriptionAndTypeAndBuildingAndMaxOccupants(workspace.getDescription(), workspace.getType(), workspace.getBuilding(), workspace.getMaxOccupants()).orElseThrow(() -> new RecordNotFoundException("Workspace not found"));
    }


    public Workspace getByDescription(String description) {
        return ws.findFirstByDescription(description).orElseThrow(() -> new RecordNotFoundException("Workspace not found"));
    }
}
