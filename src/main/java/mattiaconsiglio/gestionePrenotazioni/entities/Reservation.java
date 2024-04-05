package mattiaconsiglio.gestionePrenotazioni.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String date;
    @ManyToOne
    private User user;
    @ManyToOne
    private Workspace workspace;
}
