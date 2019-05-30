package hu.kerdei.tempa.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
abstract class BaseDto {
    private Long id;
}
