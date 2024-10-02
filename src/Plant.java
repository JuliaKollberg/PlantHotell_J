public class Plant implements WaterSchedule {

    //Variabels with Encapsulation
    private String name;
    private double height;
    private String liquidType;

    // Enums for the plant types
    public enum PlantType {PALM, KAKTUS, MEATEATER}
    PlantType plantType;

    //Main method to creating plants
    public Plant(String name, double height, PlantType plantType) {
        this.name = name;
        this.height = height;
        this.plantType = plantType;
    }

    //Added Water Schedual but it can be removed if a plant dosent need water
    @Override
    public double calculateWaterAmount(PlantType plantType, double height) {
        return 0;
    }


    //Getters & Setters
    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
        this.plantType = plantType;
    }

    public void setLiquidType(String liquidType) {
        this.liquidType = liquidType;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public String getLiquidType() {
        return liquidType;
    }

}
