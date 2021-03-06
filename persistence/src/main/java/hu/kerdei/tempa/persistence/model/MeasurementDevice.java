package hu.kerdei.tempa.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "measurement_devices")
public class MeasurementDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private Long meterID;

    @NotNull
    @Size(max = 30, min = 3)
    private String measurerDeviceName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public MeasurementDevice(Long meterID, String measurerDeviceName, User user) {
        this.meterID = meterID;
        this.measurerDeviceName = measurerDeviceName;
        this.user = user;
    }
}
