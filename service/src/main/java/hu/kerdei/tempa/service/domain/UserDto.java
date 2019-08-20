package hu.kerdei.tempa.service.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserDto extends BaseDto {
    private String firstName;
    private String lastName;
    private String userName;
}