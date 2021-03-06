package hu.kerdei.tempa.service.domain;

import hu.kerdei.tempa.persistence.model.MeasurementDevice;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MeasurementDto extends BaseDto {
    private Double value;
    private LocalDateTime date;
    private MeasurementDevice measurementDevice;
}
