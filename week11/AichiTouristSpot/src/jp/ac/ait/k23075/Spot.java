package jp.ac.ait.k23075;

public class Spot {
    private String name;
    private double latitude;
    private double longitude;

    public Spot(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Spot(String csvLine, int nameIndex, int positionIndex) {
        String[] csvArray = csvLine.split(",");
        this.name = csvArray[nameIndex];
        String[] positionArray = csvArray[positionIndex].split("[\\(\\) ]");
        this.latitude = Double.parseDouble(positionArray[2]);
        this.longitude = Double.parseDouble(positionArray[1]);
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDistance(Spot spot) {
        return Math.sqrt(Math.pow(spot.getLatitude() - latitude, 2) + Math.pow(spot.getLongitude() - longitude, 2));
    }

    public String toCSVLine(Spot spot) {
        double distance = Math
                .sqrt(Math.pow(spot.getLatitude() - latitude, 2) + Math.pow(spot.getLongitude() - longitude, 2));
        return latitude + "," + longitude + "," + distance + "," + name;
    }
}
