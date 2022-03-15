package sr.unasat.library.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dienst {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private DienstType dienstType;

    private LocalDateTime datum;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Gebruiker aangemaaktDoor;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Gebruiker afgehanldDoor;

    private String opmerking;

    @Column(nullable = false, columnDefinition = "BIT default 0")
    private boolean actief;

    @ManyToOne
    private Lidmaatschap lidmaatschap_id;



}
