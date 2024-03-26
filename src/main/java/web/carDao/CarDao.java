package web.carDao;

import web.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> count(List<Car> cars, int sublist);

}
