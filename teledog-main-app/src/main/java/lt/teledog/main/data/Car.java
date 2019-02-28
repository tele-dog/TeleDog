package lt.teledog.main.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class Car {

    public Car(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
}
