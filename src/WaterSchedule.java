public interface WaterSchedule {

    //Interface incase they add more guests that dosent need water
    double calculateWaterAmount(Plant.PlantType plantType, double height);
}
