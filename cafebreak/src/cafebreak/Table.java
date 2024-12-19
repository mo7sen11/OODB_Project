package cafebreak;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int numberOfChairs;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    public Table() {
        // Default constructor
    }

    public Table(int numberOfChairs) {
        this.numberOfChairs = numberOfChairs;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getNumberOfChairs() { return numberOfChairs; }
    public void setNumberOfChairs(int numberOfChairs) { this.numberOfChairs = numberOfChairs; }

    public List<Reservation> getReservations() { return reservations; }
    public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setTable(this);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setTable(null);
    }
}
