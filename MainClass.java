class MainCLass {
    public static void main(String[] args) {
        GarageObject Garage1 = new GarageObject(1, 2.09, 2, 5.3, 29, 12);
        GarageObject Garage2 = new GarageObject(1, 2.09, 2, 7.6, 69, 12);
        GarageObject Garage3 = new GarageObject(2, 2.09, 2, 3.0, 69, 21);
        
        //errors
        GarageObject Garage4 = new GarageObject(3, 2.09, 2, 5.3, 29, 12);
        GarageObject Garage5 = new GarageObject(2, 2.11, 2, 7.6, 29, 12);
        GarageObject Garage6 = new GarageObject(2, 2.11, 0, 7.6, 29, 12);

    }
}