package hu.kerdei.tempa.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class TemperatureMeasurementEntity {

    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private Long meterID;
    private Double value;
    private LocalDate date;
    private String userName;

    public TemperatureMeasurementEntity(Long meterID, Double value, LocalDate date, String userName) {
        this.meterID = meterID;
        this.value = value;
        this.date = date;
        this.userName = userName;
    }
}
