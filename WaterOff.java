
public class WaterOff extends Event{


	public WaterOff(long delayTime, GreenhouseControls greenhouse) {
		super(delayTime, greenhouse);
	}

	@Override
	public void action() {
		greenhouse.setVariable("water", false);
	}
	
	@Override
	public String toString() {
		return "Water Off";
	}

	@Override
	public void resumeRestored() {
		new WaterOff(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}
}
