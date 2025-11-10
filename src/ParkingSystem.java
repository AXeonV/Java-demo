import java.util.HashMap;

public class ParkingSystem {
	private int totalCap;
	private int remainingCap;
	private Car[] carEvents =  new Car[0];

	ParkingSystem(int totalCap) {
		this.totalCap = totalCap;
		this.remainingCap = totalCap;
	}

	public int getRemainingCap() {
		return remainingCap;
	}

	public boolean entry(String plate, String type, String day, String time) {
		if (this.remainingCap == 0) return false;
		this.remainingCap--;
		int total = carEvents.length;
		Car[] tmpEvents = new Car[total + 1];
		System.arraycopy(carEvents, 0, tmpEvents, 0, total);
		Car cur = new Car(plate, type);
		cur.setEntryDay(day);
		cur.setEntryTime(time);
		tmpEvents[total] = cur;
		carEvents = tmpEvents;
		return true;
	}

	public void exit(String plate, String day, String time) {
		this.remainingCap++;
		for (int i = carEvents.length - 1; i >= 0; --i)
			if (carEvents[i].getPlateNumber().equals(plate)) {
				carEvents[i].setExitDay(day);
				carEvents[i].setExitTime(time);
				break;
			}
	}

	public Car[] allCarEvents() {
		return carEvents;
	}

	public double totalFee() {
		double total = 0;
		for (int i = carEvents.length - 1; i >= 0; --i) {
			if (carEvents[i].getExitDay().isEmpty())
				continue;
			total += carEvents[i].getFee();
		}
		return total;
	}
}
