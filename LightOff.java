
public class LightOff extends Event {

	public LightOff(long delayTime, GreenhouseControls greenhouse) {
		super(delayTime, greenhouse);
	}

	@Override
	public void action() {
		greenhouse.setVariable("light", false);
	}
	@Override
	public String toString() {
		return "Light Off";
	}

	@Override
	public void resumeRestored() {
		new LightOff(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}
}
