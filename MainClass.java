class MainCLass {
    public static void main(String[] args) {
        double income = Double.valueOf(args[0]);
        if(income < 30000) System.out.println("Tax 10% : " + income * 0.10);
        else if (income < 50000) System.out.println("Tax 20% : " + income * 0.20);
        else if (income >= 50000) System.out.println("Tax 35% : " + income * 0.35);
    }
}