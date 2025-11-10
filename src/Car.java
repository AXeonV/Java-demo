import java.util.Calendar;

public class Car {
	private String plateNumber;
	private int type;
	private String entryDay = "";
	private String entryTime = "";
	private String exitDay = "";
	private String exitTime = "";

	public Car(String plateNumber, String type) {
		this.plateNumber = plateNumber;
		this.type = switch (type) {
			case "Standard"    -> 1;
			case "Large"       -> 2;
			case "Extra Large" -> 3;
			default -> throw new IllegalStateException("Unexpected value: " + type);
		};
	}

	public String toString() {
		String Type = switch (type) {
			case 1 -> "Standard";
			case 2 -> "Large";
			case 3 -> "Extra Large";
			default -> "";
		};
		return String.format("""
				{
				  "plateNumber": "%s",
				  "type": "%s",
				  "entryDay": "%s",
				  "entryTime": "%s",
				  "exitDay": "%s",
				  "exitTime": "%s"
				}""", plateNumber, Type, entryDay, entryTime, exitDay, exitTime);
	}

	private Calendar getCurCal(Calendar cur, String dat) {
		String[] dats = dat.split("-");
		Calendar cal = (Calendar) cur.clone();
		int year = Integer.parseInt(dats[0]);
		int month = Integer.parseInt(dats[1]);
		int day = Integer.parseInt(dats[2]);
		cal.set(year, month - 1, day);
		cal.getTime();
		return cal;
	}

	public double getFee() {
		if (exitDay.isEmpty() || exitTime.isEmpty())
			return 0.0f;
		Calendar cur = Calendar.getInstance();
		Calendar stDay = getCurCal(cur, entryDay);
		Calendar edDay = getCurCal(cur, exitDay);
		double totalFee = 0.0f;
		for (Calendar i = (Calendar) stDay.clone(); !i.after(edDay); i.add(Calendar.DAY_OF_YEAR, 1)) {
			double stTime = 0.0f, edTime = 24.0f;
			if (i.equals(stDay)) stTime = Double.parseDouble(entryTime);
			if (i.equals(edDay)) edTime = Double.parseDouble(exitTime);
			boolean isWeekend = i.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || i.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
			if (isWeekend) {
				totalFee += 5.0f;
				totalFee += (edTime - stTime - 1 > 0) ? (edTime - stTime - 1) * 1.5f : 0.0f;
			}
			else {
				totalFee += (Math.min(edTime, 8) - stTime > 0) ? (Math.min(edTime, 8) - stTime) * 1.5f : 0.0f;
				totalFee += (edTime > 8 && stTime < 20) ? 15.0f : 0.0f;
				totalFee += (Math.min(edTime, 20) - Math.max(stTime, 8) - 1 > 0) ? (Math.min(edTime, 20) - Math.max(stTime, 8) - 1) * 3.0f : 0.0f;
				totalFee += (edTime - Math.max(stTime, 20) > 0) ? (edTime - Math.max(stTime, 20)) * 1.5f : 0.0f;
			}
		}
		return totalFee * type;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plate) {
		this.plateNumber = plate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getEntryDay() {
		return entryDay;
	}
	public void setEntryDay(String Day) {
		this.entryDay = Day;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String time) {
		this.entryTime = time;
	}
	public String getExitDay() {
		return exitDay;
	}
	public void setExitDay(String Day) {
		this.exitDay = Day;
	}
	public String getExitTime() {
		return exitTime;
	}
	public void setExitTime(String time) {
		this.exitTime = time;
	}
}
