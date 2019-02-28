package lt.teledog.main.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import lt.teledog.main.data.Car;
import lt.teledog.main.service.CarService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoolCarControllerTest {

    @Autowired MockMvc mvc;

    @MockBean CarService carService;

    @Test
    @DisplayName("Cool car test")
    void getCoolCarsTest() throws Exception {

        Collection<Car> carCollection = new ArrayList<>();
        ((ArrayList<Car>) carCollection).add(0, new Car("Car 1"));

        when(carService.getCoolCars()).thenReturn(carCollection);

        String currentURI = "/cool-cars";
        mvc.perform(get(currentURI)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        verify(carService, times(1)).getCoolCars();
    }
}
