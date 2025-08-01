public class Lasagna {
    public int expectedMinutesInOven(){
        return 40;
    }

    public int remainingMinutesInOven(int ovenTime) {
        return this.expectedMinutesInOven() - ovenTime;
    }

    public int preparationTimeInMinutes(int numLayers) {
        return numLayers * 2;
    }

    public int totalTimeInMinutes(int numLayers, int ovenTime) {
        return preparationTimeInMinutes(numLayers) + ovenTime;
    }
}
