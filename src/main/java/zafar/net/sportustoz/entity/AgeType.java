package zafar.net.sportustoz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.apache.catalina.User;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class AgeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @OneToMany(mappedBy = "ageType")
    private Set<AppUser> appUsers;

    @OneToMany(mappedBy = "ageType")
    private List<Normativ> normativs;

}

