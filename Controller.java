import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Controller implements Serializable {

	protected List<Event> events = new ArrayList<>();
	
	
	
	public synchronized void addEvent(Event event) {
		events.add(event);
	}
	
	public List<Event> getEvents() {
		return this.events;
	}
	
	public synchronized void suspendAll() {
		for (Event e : events) {
			e.suspendThread();
		}
	}
	
	public synchronized void resumeAll() {
		for (Event e : events) {
			e.resumeThread();
		}
	}
	
	public abstract void shutdown(ControllerException e);
	//shutsdown system and creates log/dump.out when error occurs
	
	
	public synchronized void  resumeRestoredAll(){
		List<Event> temp = new ArrayList<>();
		for (Event e : events) {
			temp.add(e);
		}
		for (Event e : temp) {
			e.resumeRestored();
		}
		
	}

}
