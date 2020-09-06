
public class PowerOut extends Event{

	public PowerOut(long delayTime, GreenhouseControls greenhouse) {
		super(delayTime, greenhouse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() throws ControllerException {
		greenhouse.setVariable("powerOn", false);
		throw new ControllerException("Power Outage");
	}

	@Override
	public void resumeRestored() {
		new PowerOut(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}
	
	
}
