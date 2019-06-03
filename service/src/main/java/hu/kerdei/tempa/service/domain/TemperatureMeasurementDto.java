package hu.kerdei.tempa.service.domain;

import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class TemperatureMeasurementDto extends BaseDto {
    private Long meterID;
    private Double value;
    private LocalDateTime date;
    private String userName;
}
