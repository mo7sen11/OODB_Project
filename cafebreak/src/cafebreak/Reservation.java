package cafebreak;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private Table table;

    public Reservation() {
        // Default constructor
    }

    public Reservation(LocalDate date, user user, Table table) {
        this.date = date;
        this.user = user;
        this.table = table;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public user getUser() { return user; }
    public void setUser(user user) { this.user = user; }
    public Table getTable() { return table; }
    public void setTable(Table table) { this.table = table; }
}
