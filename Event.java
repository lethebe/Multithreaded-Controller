import java.io.Serializable;

public abstract class Event  implements Serializable, Runnable{

	protected GreenhouseControls greenhouse; //the greenhouse object each event is associated with 
	protected long goalTime;
	private long suspendTime;
	private long startTime;
	protected boolean suspend = false;
	
	
	public Event(long delayTime,GreenhouseControls greenhouse) {
		this.greenhouse=greenhouse;
		this.goalTime = (long)System.currentTimeMillis()+delayTime;
		greenhouse.addEvent(this);
		new Thread(this).start();
		this.startTime=System.currentTimeMillis();	
	}
	
	@Override
	public void run() {
		while(true) {
			while(suspend) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					  }
				}
			}
		if (System.currentTimeMillis() >= this.goalTime) {
			greenhouse.getEvents().remove(this);	
			try {
					this.action();
					System.out.println(this);
					break;
				} catch (ControllerException e) {
					greenhouse.shutdown(e);
				}
				break;
				
			}
			Thread.yield();
			
		}
	}
	 
	public abstract void action() throws ControllerException;
	//Will be overridden with  each specific event sub class
	
	public synchronized void  resumeThread() {
		this.goalTime=this.suspendTime+System.currentTimeMillis();
		this.suspend=false;
		notify();
	}
	public synchronized void  suspendThread() {
		this.suspend=true;
		long current = System.currentTimeMillis();
		if (current >= this.goalTime)
			this.goalTime=0;
		else {
			this.suspendTime = this.goalTime-current;
		}
	}
	
	public long getSuspendTime() {
		return this.suspendTime;
	}
	
	public abstract void resumeRestored();
	
}
