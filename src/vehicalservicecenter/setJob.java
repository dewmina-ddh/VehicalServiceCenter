package vehicalservicecenter;

import java.util.ArrayList;

public class setJob {

    private String jobId;
    private String vehicleNo;
    private String odometerReading;
    private double totalAmount;
    private java.util.ArrayList<String> serviceList;
    private String serviceType;
    private String additionalServices;

    public setJob(String jobId, String vehicleNo, String odometerReading, double totalAmount, ArrayList<String> serviceList, String serviceType, String additionalServices) {
        this.jobId = jobId;
        this.vehicleNo = vehicleNo;
        this.odometerReading = odometerReading;
        this.totalAmount = totalAmount;
        this.serviceList = serviceList;
        this.serviceType = serviceType;
        this.additionalServices = additionalServices;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(String odometerReading) {
        this.odometerReading = odometerReading;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ArrayList<String> getServiceList() {
        return serviceList;
    }

    public void setServiceList(ArrayList<String> serviceList) {
        this.serviceList = serviceList;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(String additionalServices) {
        this.additionalServices = additionalServices;
    }

}
