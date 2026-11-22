public class GarageObject {
    private int vehicleType; // 1 for car, 2 for motorcycle, 3 for truck.
    private double vehicleHeight; // Vehicle height in meters.
    private int availableSpaces; // Number of available parking spaces.
    private double parkingHours; // Parking duration in hours.
    private int customerAge; // Customer's age.
    private int arrivalHour; // Arrival time (0–23).

    private String allowed = "Allowed!";

    private double fee; // fee to be calculated 
    private double discountedFee; // final fee to be calculated 
    //private double discount; //calculated and added to !! 

    public GarageObject(int vehicleType, double vehicleHeight, int availableSpaces, double parkingHours, int customerAge, int arrivalHour) {
        this.setVehicleType(vehicleType);
        this.setVehicleHeight(vehicleHeight);
        this.setAvailableSpaces(availableSpaces-1);
        this.setParkingHours(parkingHours);
        this.setArrivalHour(arrivalHour);

        //apply discounts imidiatelly
        this.setDiscounts(); 

        //print from contructor but still use the same function
        this.printGarageData();
    }

    // Getters
    public int getVehicleType() {
        return vehicleType;
    }

    public double getVehicleHeight() {
        return vehicleHeight;
    }

    public int getAvailableSpaces() {
        return availableSpaces;
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

    public double getDiscount() {
        double discount = 0;
        discount = this.getCustomerAge() > 65 ? 0.15 : 0;
        discount = this.getArrivalHour() > 20.0 ? 0.2 : 0;
        return discount * 100.0;
    }

    public double getDiscountedFee() {
        return this.discountedFee;
    }

    // Setters
    public void setVehicleType(int vehicleType) {
        if (vehicleType == 3) { this.allowed = "Denied! Input Error! Trucks not allowed"; }
        this.vehicleType = vehicleType;
    }

    public void setVehicleHeight(double vehicleHeight) {
        if (vehicleHeight > 2.10) { this.allowed = "Input Error! Vehicle height " + String.valueOf(vehicleHeight) + ", vehicles with height above 2.10 not allowed"; };
        this.vehicleHeight = vehicleHeight;
    }

    public void setAvailableSpaces(int availableSpaces) {
        if (availableSpaces <= 0 )  { this.allowed = "Inupt Error! No more available spaces!"; }
        this.availableSpaces = availableSpaces;
    }

    public void setParkingHours(double parkingHours) {
        if(this.vehicleType == 3 || this.vehicleHeight > 2.10 || this.availableSpaces <= 0) return;
        this.parkingHours = parkingHours;
        if (this.vehicleType == 1) { // for cars
            if(parkingHours <= 1.0) {
                this.setFee(3.0);
            } else if (parkingHours > 1 && parkingHours <= 3) {
                this.setFee(6.0);
            } else if(parkingHours >3 && parkingHours <= 6) {
                this.setFee(10.0);
            } else if(parkingHours > 6) {
                this.setFee(15.0);
            }
        } else { // for motorcycles could be else if (this.vehicleType == 2)
            if(parkingHours <= 1.0) {
                this.setFee(2.0);
            } else if (parkingHours > 1 && parkingHours <= 3) {
                this.setFee(4.0);
            } else if(parkingHours >3 && parkingHours <= 6) {
                this.setFee(7.0);
            } else if(parkingHours > 6) {
                this.setFee(10.0);
            }
        }
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public void setArrivalHour(int arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setDiscounts() {
        double discount = 0;

        //Ifs in order to apply always largest discount
        if(this.customerAge >= 65) 
            discount = 0.15;

        if(this.arrivalHour >= 20.0)
            discount = 0.2;

        this.setDiscountedFee(this.fee * (1 - discount));
    }

    public void setDiscountedFee(double discountedFee) {
        this.discountedFee = discountedFee;
    }

    public void printGarageData() {
        System.out.println("Access: " + 
            this.allowed + "\n" + 
            "Vehicle Type: " + 
            (this.vehicleType == 1 ? "Car\n" : "Motorcycle\n") +
            "Original Fee: " +
            String.valueOf(this.fee) + "€\n" +
            "Discount: " + String.valueOf(this.getDiscount()) + " %\n" +
            "Final parking fee: " + String.valueOf(this.getDiscountedFee()) + '\n'
        );
    }
}
