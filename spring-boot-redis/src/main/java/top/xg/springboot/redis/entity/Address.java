package top.xg.springboot.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
/**
 * @author Lenovo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address implements Serializable {
    @Serial
    private static final long serialVersionUID = -6194099528735822976L;

    private String province;
    private String city;
}
