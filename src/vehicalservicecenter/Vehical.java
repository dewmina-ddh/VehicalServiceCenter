
package vehicalservicecenter;

public class Vehical {
    
    private String vno;
    private String make;
    private String brand;
    private String model;
    private String fuel;
    private String reading;
    private String color;
    private String year;
    private String cusId;

    public Vehical(String vno, String make, String brand, String model, String fuel, String reading, String color, String year, String cusId) {
        this.vno = vno;
        this.make = make;
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
        this.reading = reading;
        this.color = color;
        this.year = year;
        this.cusId = cusId;
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }
    

    

    
    
    
    
}
