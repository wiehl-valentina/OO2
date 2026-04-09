package ejercicio5.Codigo;

public class HotelStay extends Product {
    private double quote;
    private Hotel hotel;

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        this.quote = cost;
        this.timePeriod = timePeriod;
        this.hotel = hotel;
    }
    
    public double getCost() {
		return quote;
	}

	public void setCost(double cost) {
		this.quote = cost;
	}

    public double priceFactor() {
        return this.quote / this.price();
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.getCost(); 
    }
    
}
