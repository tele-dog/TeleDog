package lt.teledog.main.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lt.teledog.main.data.Car;
import lt.teledog.main.service.CarService;

@RestController
@RequiredArgsConstructor
class CoolCarController {

    private final CarService carService;

    @GetMapping("/cool-cars")
    public Collection<Car> coolCars() {
        return carService.getCoolCars();
    }

}
