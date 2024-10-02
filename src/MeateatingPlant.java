public class MeateatingPlant extends Plant implements WaterSchedule {

    String liquidType = "Proteindryck";

    //Main method to create a meateater, uses super due to using private in the Parent class
    public MeateatingPlant(String name, double height, PlantType plantType) {
        super(name, height, plantType);
    }

    @Override
    public String getLiquidType() {
        return liquidType;
    }

    //Overrides the calculation so its specific for this plant
    @Override
    public double calculateWaterAmount(PlantType plantType, double height) {
        return 0.1 + (1.2 * height);
    }
}
