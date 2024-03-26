package web.carDao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.List;

@Component
public class CarDaoImpl implements CarDao {

    @Override
    public List<Car> count(List<Car> cars, int sublist) {
        return cars.subList(0, sublist);
    }
}
