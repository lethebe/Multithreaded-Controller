
public class ThermostatDay extends Event {

	public ThermostatDay(long delayTime, GreenhouseControls greenhouse) {
		super(delayTime, greenhouse);
	}

	@Override
	public void action() {
		greenhouse.setVariable("thermostat","Day");
		
	}

	@Override
	public String toString() {
		return "Thermostat on Day setting";
	}
	

	@Override
	public void resumeRestored() {
		new ThermostatDay(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}
	
}
