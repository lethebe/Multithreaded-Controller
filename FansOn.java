
public class FansOn extends Event {

	public FansOn(long delayTime, GreenhouseControls greenhouse) {
		super(delayTime, greenhouse);
	}

	@Override
	public void action() {
		greenhouse.setVariable("fans", true);
	}
	
	@Override
	public String toString() {
		return "Fans On";
	}

	@Override
	public void resumeRestored() {
		new FansOn(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}

}
