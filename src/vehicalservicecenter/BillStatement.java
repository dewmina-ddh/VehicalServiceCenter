
package vehicalservicecenter;

import java.util.ArrayList;

public class BillStatement {
    
    private String customerName;
    private double totalAmount;
    private ArrayList<Object[]> itemsList;

    public BillStatement(String customerName, double totalAmount, ArrayList<Object[]> itemsList) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.itemsList = itemsList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ArrayList<Object[]> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<Object[]> itemsList) {
        this.itemsList = itemsList;
    }
    
    
    
}
