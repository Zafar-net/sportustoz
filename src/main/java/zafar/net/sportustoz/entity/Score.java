package zafar.net.sportustoz.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double secund;
    private Double minute;
    private Double pullUp;
    private Integer ball;

    @ManyToOne
    private Normativ normativ;

    @ManyToOne
    private AppUser user;

}

