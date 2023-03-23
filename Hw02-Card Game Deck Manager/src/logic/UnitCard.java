package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		// Constructor
		this.setName(name);
		this.setBloodCost(bloodCost);
		this.setPower(power);
		this.setHealth(health);
		this.setFlavorText(flavorText);
	}

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}

	public boolean equals(UnitCard other) {
		return this.name.equals(other.name);
	}
	
	public void setHealth(int health) {
		if (health < 1) {
			this.health = 1;
		} else {
			this.health = health;
		}
	}

	public void setPower(int power) {
		if (power < 0) {
			this.power = 0;
		} else {
			this.power = power;
		}
	}

	public void setBloodCost(int bloodCost) {
		if (bloodCost < 0) {
			this.bloodCost = 0;
		} else {
			this.bloodCost = bloodCost;
		}
	}

	public void setName(String name) {
		if (name.isBlank()) {
			this.name = "Creature";
		} else {
			this.name = name;
		}
	}
	
	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}
	
	public int getHealth() {
		return this.health;
	}

	public int getPower() {
		return this.power;
	}

	public String getName() {
		return this.name;
	}
	
	public int getBloodCost() {
		return this.bloodCost;
	}
	
	public String getFlavorText() {
		return this.flavorText;
	}
}
