import java.util.ArrayList;

public class GarageObject {

    private int availableSpaces; // Number of available parking spaces.
    private ArrayList<CarObject> cars = null;
 
    //private double discount; //calculated and added to !! 

    public GarageObject(int availableSpaces) {
        this.availableSpaces = availableSpaces;
        this.cars = new ArrayList<CarObject>(availableSpaces);
    }


    public int getAvailableSpaces() {
        return availableSpaces;
    }

    public void updateAvailableSpaces() {
        this.availableSpaces = this.availableSpaces - this.cars.size();
    }

    public void addCar(int vehicleType, double vehicleHeight, double parkingHours, int customerAge, int arrivalHour) {
        CarObject obj = new CarObject(vehicleType, vehicleHeight, parkingHours, customerAge, arrivalHour);

        if (vehicleType == 3) {
            obj.setAllowed(false);
            obj.setAuthorizationString("Input Error! No trucks allowed!");
        }
        if (this.availableSpaces - 1 <= 0 )  { 
            obj.setAllowed(false);
            obj.setAuthorizationString("Inupt Error! No more available spaces!"); 
        }

        if (vehicleHeight > 2.10) {
            obj.setAllowed(false);
            obj.setAuthorizationString("Inupt Error! Vehicle height: " +String.valueOf(vehicleHeight)+ ", only <= 2.10 meters allowed"); 
        }

        // vehicle not allowed? print and skip fees and discounts
        if(!obj.getAllowed()) {
            obj.printCar();
            return;
        }

        // Once car is ok, calculate fees and discounts
        if (vehicleType == 1) { // for cars
            if(parkingHours <= 1.0) {
                obj.setFee(3.0);
            } else if (parkingHours > 1 && parkingHours <= 3) {
                obj.setFee(6.0);
            } else if(parkingHours >3 && parkingHours <= 6) {
                obj.setFee(10.0);
            } else if(parkingHours > 6) {
                obj.setFee(15.0);
            }
        } else { // for motorcycles could be else if (this.vehicleType == 2)
            if(parkingHours <= 1.0) {
                obj.setFee(2.0);
            } else if (parkingHours > 1 && parkingHours <= 3) {
                obj.setFee(4.0);
            } else if(parkingHours >3 && parkingHours <= 6) {
                obj.setFee(7.0);
            } else if(parkingHours > 6) {
                obj.setFee(10.0);
            }
        }

        // set discounts
        this.setDiscounts(obj);

        // print car data
        obj.printCar();
        
        // FInally add cat to ArrayList
        this.cars.add(obj);
        this.updateAvailableSpaces();
    }

    public void printGarageData() {
        System.out.println("-----GARAGE STATUS-----");
        for (int i=0; i<this.cars.size(); i++) {
            this.cars.get(i).printCar();
        }
    }

    public void setDiscounts(CarObject obj) {
        double discount = 0;

        //Ifs in order to apply always largest discount
        if(obj.getCustomerAge() >= 65) 
            discount = 0.15;

        if(obj.getArrivalHour() >= 20.0)
            discount = 0.2;

        obj.setDiscountedFee(obj.getFee() * (1 - discount));
    }

    public ArrayList<CarObject> getCars() {
        return this.cars;
    }
}
