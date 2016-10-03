package finder.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String firstName;
    private String secondName;
    private City city;
    private Set<Car> cars;
    public User(){}

    public User(String firstName, String secondName, City city, Set<Car> cars) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;
        this.cars = cars;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Car> getCar() {
        return cars;
    }

    public List<String> getCarColors() {
        List<String> result = new ArrayList<String>();
        for(Car car : cars){
            result.add(car.getColor());
        }
        return  result;
    }

    public void setCar(Set<Car> cars) {
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public City getCity() {
        return city;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}