public class CarObject {
    private int vehicleType; // 1 for car, 2 for motorcycle, 3 for truck.
    private double vehicleHeight; // Vehicle height in meters.

    private double parkingHours; // Parking duration in hours.
    private int customerAge; // Customer's age.
    private int arrivalHour; // Arrival time (0–23).

    private double fee; // fee to be calculated 
    private double discountedFee; // final fee to be calculated

    private boolean allowed = true;
    private String authorizationString = "";

    // Contructor
    public CarObject(int vehicleType, double vehicleHeight, double parkingHours, int customerAge, int arrivalHour) {
        this.setVehicleType(vehicleType);
        this.setVehicleHeight(vehicleHeight);
        this.setParkingHours(parkingHours);
        this.setArrivalHour(arrivalHour);
        this.setCustomerAge(customerAge);
    }

    // Getters
    public int getVehicleType() {
        return vehicleType;
    }

    public double getVehicleHeight() {
        return vehicleHeight;
    }

    public double getParkingHours() {
        return parkingHours;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public int getArrivalHour() {
        return arrivalHour;
    }


    public double getDiscountedFee() {
        return this.discountedFee;
    }

    public double getFee() {
        return this.fee;        
    }

    public boolean getAllowed() {
        return this.allowed;
    }

    public String getAuthorizationString() {
        return this.authorizationString;
    }

    public double getDiscount() {
        double discount = 0;
        discount = this.getCustomerAge() > 65 ? 0.15 : 0;
        discount = this.getArrivalHour() > 20.0 ? 0.2 : 0;
        return discount * 100.0;
    }

    // Setters
    public void setAuthorizationString(String str) {
        this.authorizationString = str;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleHeight(double vehicleHeight) {
        this.vehicleHeight = vehicleHeight;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public void setArrivalHour(int arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public void setParkingHours(double parkingHours) {
        this.parkingHours = parkingHours;
    }


    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setDiscountedFee(double discountedFee) {
        this.discountedFee = discountedFee;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public void printCar() {
        String vehicle_t = "";
        switch(this.vehicleType) {
            case 1:
                vehicle_t = "Car";
                break;
            case 2:
                vehicle_t = "Motorcycle";
                break;
            case 3:
                vehicle_t = "Truck";
                break;

        }
        System.out.println("Access: " + 
            (this.getAllowed() ? "Allowed" : "Denied: " + this.getAuthorizationString()) + "\n" + 
            "Vehicle Type: " +vehicle_t+ '\n'+ 
            "Original Fee: " +
            String.valueOf(this.getFee()) + "€\n" +
            "Discount: " + String.valueOf(this.getDiscount()) + " %\n" +
            "Final parking fee: " + String.valueOf(this.getDiscountedFee()) + '\n'
        );
    }
    
}
