class MainCLass {
    public static void main(String[] args) {
        GarageObject Garage1 = new GarageObject(5);

        Garage1.addCar(1, 2.09, 7.6, 69, 12);
        Garage1.addCar(2, 2.09, 3.0, 69, 21);
        
        //errors
        Garage1.addCar(3, 2.09, 5.3, 29, 12);
        Garage1.addCar(2, 2.11, 7.6, 29, 12);
        Garage1.addCar(2, 2.11, 7.6, 29, 12);

        // error no available spaces
        Garage1.addCar(1, 2.09, 3.0, 69, 21); //pad
        Garage1.addCar(1, 2.09, 3.0, 69, 21); //pad
        Garage1.addCar(1, 2.10, 7.6, 29, 12); //pad
        
        Garage1.addCar(2, 2.09, 3.0, 69, 21); // ERROR!

        Garage1.printGarageData();
        Garage1.getAvailableSpaces();

        System.out.println("Garage size: " +Garage1.getCars().size() + "\nAvailable spaces: " + Garage1.getAvailableSpaces());

    }
}