package hu.kerdei.tempa.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureMeasurementEntity {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private Long meterID;
    private Double value;
    private LocalDateTime date;
    private String userName;

    public TemperatureMeasurementEntity(Long meterID, Double value, LocalDateTime date, String userName) {
        this.meterID = meterID;
        this.value = value;
        this.date = date;
        this.userName = userName;
    }
}
