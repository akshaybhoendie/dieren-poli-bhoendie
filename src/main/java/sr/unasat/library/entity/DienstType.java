package sr.unasat.library.entity;

import javax.persistence.*;

@Entity
public class DienstType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    private String naam;

    private String code;

    private String omschrijving;

    @OneToOne(mappedBy = "dienstType", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Dienst dienst;

    @Column(nullable = false, columnDefinition = "BIT default 0")
    private boolean actief;


}
