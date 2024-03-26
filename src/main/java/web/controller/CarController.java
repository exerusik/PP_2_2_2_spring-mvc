package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarServiceImpl carService;

    @GetMapping(value = "/cars")
    public String getCars(Model model, HttpServletRequest httpServletRequest) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", 5, "dark"));
        cars.add(new Car("Mercedes", 6, "red"));
        cars.add(new Car("Skoda", 7, "orange"));
        cars.add(new Car("Gelly", 8, "blue"));
        cars.add(new Car("Lada", 9, "green"));

        int count = httpServletRequest.getParameter("count") == null ? cars.size() : Integer.parseInt(httpServletRequest.getParameter("count"));
        if (count <= 0 || count >= cars.size()) {
            count = cars.size();
        }
        cars = carService.count(cars, count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
