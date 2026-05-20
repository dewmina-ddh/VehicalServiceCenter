package vehicalservicecenter;

public class Customer {

    private String cusId;
    private String name;
    private String nic;
    private String phone;
    private String city;
    private String town;

    public Customer(String cusId, String name, String nic, String phone, String city, String town) {
        this.cusId = cusId;
        this.name = name;
        this.nic = nic;
        this.phone = phone;
        this.city = city;
        this.town = town;
    }

    Customer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCit(String cit) {
        this.city = cit;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
    
    

}
