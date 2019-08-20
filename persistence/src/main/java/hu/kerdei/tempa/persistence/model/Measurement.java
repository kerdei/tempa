package hu.kerdei.tempa.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "measurements")
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double value;

    @NotNull
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id", nullable = false)
    private MeasurementDevice measurementDevice;

    public Measurement(Double value, LocalDateTime date, MeasurementDevice measurementDevice) {
        this.value = value;
        this.date = date;
        this.measurementDevice = measurementDevice;
    }
}
