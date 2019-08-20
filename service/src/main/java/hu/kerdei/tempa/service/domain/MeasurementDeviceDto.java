package hu.kerdei.tempa.service.domain;

import hu.kerdei.tempa.persistence.model.User;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MeasurementDeviceDto extends BaseDto {
    private Long meterID;
    private String measurerDeviceName;
    private User user;

}
