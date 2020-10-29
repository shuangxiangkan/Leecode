package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TimeMap {
	
	Map<HashMap<String, String>,Integer> map;
    /** Initialize your data structure here. */
    public TimeMap() {
    	map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
    	HashMap<String, String> m=new HashMap<>();
    	m.put(key, value);
		map.put(m, timestamp);
    }
    
    public String get(String key, int timestamp) {
    	int max=-1;
    	String v="";
    	for(HashMap<String, String> m:map.keySet()) {
    		if(m.containsKey(key)) {
    			int t=map.get(m);
    			if(t==timestamp)
    				return m.get(key);
    			else {
    				if(max<t&&t<timestamp) {
    					max=t;
    					v=m.get(key);
    				}
    			}
    		}
    	}
    	return v;
    }
}

public class P981 {
	public static void main(String[] args) {
//		["TimeMap","set","set","get","get","get","get","get"]
//				[[],
//				 ["love","high",10],
//				 ["love","low",20],
//				 ["love",5],
//				 ["love",10],
//				 ["love",15],
//				 ["love",20],
//				 ["love",25]]
		
		
		TimeMap obj=new TimeMap();
//		obj.set("foo","bar",1);
//		String param1=obj.get("foo",1);
//		String param2=obj.get("foo",3);
//		obj.set("foo","bar2",4);
//		String param3=obj.get("foo",4);
//		String param4=obj.get("foo",5);
//		System.out.println(param1);
//		System.out.println(param2);
//		System.out.println(param3);
//		System.out.println(param4);
		
		obj.set("love","high",10);
		obj.set("love","low",20);
		String param1=obj.get("love",5);
		String param2=obj.get("love",10);
		String param3=obj.get("love",15);
		String param4=obj.get("love",20);
		String param5=obj.get("love",25);
		System.out.println(param1);
		System.out.println(param2);
		System.out.println(param3);
		System.out.println(param4);
		System.out.println(param5);
	}
	
}
