package tokyo.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transferencia")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "origem_id", nullable = false)
    private Conta origem;

    @OneToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Conta destino;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
}
