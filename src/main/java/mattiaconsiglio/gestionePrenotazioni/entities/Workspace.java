package mattiaconsiglio.gestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "workspaces")
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private WorkspaceType type;
    @ManyToOne
    private Building building;


    public Workspace(String description, WorkspaceType type, Building building) {
        this.description = description;
        this.type = type;
        this.building = building;
    }
}
