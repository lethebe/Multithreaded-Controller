
public class FansOff extends Event{

	public FansOff(long delayTime, GreenhouseControls greenhouse) {
		super(delayTime, greenhouse);
	}

	@Override
	public void action() {
		greenhouse.setVariable("fans", false);
	}
	
	@Override
	public String toString() {
		return "Fans Off";
	}

	@Override
	public void resumeRestored() {
		new FansOff(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}

}
