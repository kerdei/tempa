package hu.kerdei.tempa.service.domain;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class TemperatureMeasurementDto extends BaseDto {
    private Long meterID;
    private Double value;
    private LocalDate date;
    private String userName;
}
