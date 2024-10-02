public class Kaktusar extends Plant implements WaterSchedule {
    String liquidType = "Mineralvatten";

    //Main method to create a kaktus, uses super due to using private in the Parent class
    public Kaktusar(String name, double height, PlantType plantType) {
        super(name, height, plantType);
    }

    @Override
    public String getLiquidType() {
        return liquidType;
    }

    //Overrides the calculation so its specific for this plant
    public double calculateWaterAmount(PlantType plantType, double height) {
        return 0.02;
    }
}
