
public class ThermostatNight extends Event {

	public ThermostatNight(long delayTime, GreenhouseControls greenhouse) {
		super(delayTime, greenhouse);
	}

	@Override
	public void action() {
		greenhouse.setVariable("thermostat", "Night");
	}
	
	@Override
	public String toString() {
		return "Thermostat on Night Setting";
	}

	@Override
	public void resumeRestored() {
		new ThermostatNight(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}
	

}
