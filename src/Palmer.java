public class Palmer extends Plant implements WaterSchedule {

    String liquidType = "Kranvatten";

    //Main method to create a palm, uses super due to using private in the Parent class
    public Palmer(String name, double height, PlantType plantType) {
        super(name, height, plantType);
    }

    @Override
    public String getLiquidType() {
        return liquidType;
    }

    //Overrides the calculation so its specific for this plant
    public double calculateWaterAmount(PlantType plantType, double height) {
        return (0.5 * height);
    }

}
