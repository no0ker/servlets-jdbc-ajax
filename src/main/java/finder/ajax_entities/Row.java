package finder.ajax_entities;

public class Row {
    private String firstName;
    private String middleName;
    private String secondName;
    private String city;
    private String carColor;
    private String model;

    public Row(String firstName, String middleName, String secondName, String city, String carColor, String model) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.city = city;
        this.carColor = carColor;
        this.model = model;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
