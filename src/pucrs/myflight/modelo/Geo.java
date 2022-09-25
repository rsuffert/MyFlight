package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;
	
	public static double distancia (Geo loc1, Geo loc2) {
		final int RAIO_DA_TERRA_KM = 6371;
		double lat1Radianos = Math.toRadians(loc1.getLatitude());
		double lon1Radianos = Math.toRadians(loc1.getLongitude());
		double lat2Radianos = Math.toRadians(loc2.getLatitude());
		double lon2Radianos = Math.toRadians(loc2.getLongitude());

		return 2*RAIO_DA_TERRA_KM*Math.asin(Math.sqrt(Math.pow(Math.sin((lat1Radianos-lat2Radianos)/2), 2) + Math.pow(Math.sin((lon1Radianos-lon2Radianos)/2), 2) * Math.cos(lat1Radianos) * Math.cos(lat2Radianos)));
	}

	public double distancia (Geo loc) {
		final int RAIO_DA_TERRA_KM = 6371;
		double estaLatRadianos = Math.toRadians(this.latitude);
		double estaLonRadianos = Math.toRadians(this.longitude);
		double locLatRadianos = Math.toRadians(loc.getLatitude());
		double locLonRadianos = Math.toRadians(loc.getLongitude());

		return 2*RAIO_DA_TERRA_KM*Math.asin(Math.sqrt(Math.pow(Math.sin((estaLatRadianos-locLatRadianos)/2), 2) + Math.pow(Math.sin((estaLonRadianos-locLonRadianos)/2), 2) * Math.cos(estaLatRadianos) * Math.cos(locLatRadianos)));		
	}

	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
}
