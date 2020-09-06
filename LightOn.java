
public class LightOn extends Event {

	public LightOn(long delayTime, GreenhouseControls greenhouse) {
		super(delayTime, greenhouse);
	}
	@Override
	public void action() {
		greenhouse.setVariable("light", true);
	}
	@Override 
	public String toString() {
		return "Light On";
	}
	@Override
	public void resumeRestored() {
		new LightOn(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}
	
}
