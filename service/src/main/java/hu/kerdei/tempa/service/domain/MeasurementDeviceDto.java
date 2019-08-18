package hu.kerdei.tempa.service.domain;

import hu.kerdei.tempa.persistence.model.Measurement;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MeasurementDeviceDto extends BaseDto {
    private Long meterID;
    private String measurerDeviceName;
    private List<Measurement> measurements = new ArrayList<>();

}
