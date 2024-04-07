package mattiaconsiglio.gestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
public class Reservation implements HasId {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private LocalDate date;
    @ManyToOne
    private User user;
    @ManyToOne
    private Workspace workspace;

    public Reservation(LocalDate date, User user, Workspace workspace) {
        this.date = date;
        this.user = user;
        this.workspace = workspace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(user, that.user) && Objects.equals(workspace, that.workspace);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", user=" + user +
                ", workspace=" + workspace +
                '}';
    }
}
