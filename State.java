import java.io.Serializable;
import java.util.HashMap;

public class State implements Serializable{

	HashMap<String,Object> state = new HashMap<>();
	
	class Tuple <K,V>{
		private final K key;
		private final V value;
		
		public Tuple(K key, V value) {
			this.key=key;
			this.value=value;
		}
		
		public K getKey() {
			return this.key;
		}
		
		public V getValue() {
			return this.value;
		}
		
	}
	
	public State(String eventFile) { 
		this.addState("fans", false);
		this.addState("water", false);
		this.addState("light", false);
		this.addState("thermostat", "Day");
		this.addState("powerOn", true);
		this.addState("windowOk", true);
		this.addState("eventFile", eventFile);
		this.addState("errorcode", 0);
	}
	
	public synchronized void  addState(String key, Object value) {
		Tuple<String,Object> tuple = new Tuple<>(key,value);
		state.put(tuple.getKey(), tuple.getValue());	
	}
		
	public synchronized boolean  getFans() {
		return (boolean)state.get("fans");
	}
	
	public synchronized boolean getWater() {
		return (boolean)state.get("water");
	}
	public synchronized boolean getLight() {
		return (boolean)state.get("light");
	}
	public synchronized boolean getPower() {
		return (boolean)state.get("powerOn");
	}
	public synchronized boolean getWindow() {
		return (boolean)state.get("windowOk");
	}
	public  synchronized String getThermostat() {
		return (String)state.get("thermostat");
	}
	public synchronized  String getEventFile() {
		return (String)state.get("eventFile");
	}
	public synchronized int getErrorcode() {
		return (int)state.get("errorcode");
	}
	
	public int size() {
		return this.state.size();
	}
	
	@Override
	public synchronized String toString() {
		return "\n-------System Status-------"+"\nFans: "+this.getFans()+"\nWater: "+this.getWater()
		+"\nLight: "+this.getLight()+ "\nThermostat: "+this.getThermostat()
		+"\nPower On: "+this.getPower()+"\nWindow Ok: "+this.getWindow()
		+"\nEvent File: "+this.getEventFile()+"\nError Code: "+this.getErrorcode()+"\n--------------------------";
	}
	
	public static void main(String[] args) {
		State s = new State("hello");
		s.addState("light", true);
		System.out.println(s);
	}
	
}
	
	
	
	

