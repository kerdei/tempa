package hu.kerdei.tempa.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    private List<MeasurementDevice> measurementDevice = new ArrayList<>();

}
