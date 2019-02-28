package lt.teledog.main.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.teledog.main.data.Car;
import lt.teledog.main.data.CarRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    @Bean
    ApplicationRunner init(CarRepository repository) {
        return args -> {
            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti", "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(
                    name -> repository.save(new Car(name)));
            repository.findAll().forEach(System.out::println);
        };
    }

    public Collection<Car> getCoolCars() {
        return carRepository.findAll().stream().filter(this::isCool).collect(Collectors.toList());
    }

    private boolean isCool(Car car) {
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
    }
}
