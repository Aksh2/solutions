package stringcount;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StringCountSolution {
	
	private static HashMap<String, Integer> countStrings = null;
	private static Map<String, Integer> sortMap = null;
	
	public static void main(String[] args) {
		countStrings = new HashMap<>();
		sortMap = new HashMap<>();
		String[] input = new String[] {"AAA","AAA","BBB","BBB","BBB","CC","CC", "XXX", "XXX","PP","QQ","XXX","XXX"};
		StringCountSolution.findCount(input);
		StringCountSolution.printTopFiveStrings();
		
		
	}
	
	public static void printTopFiveStrings(){
		sortMap=StringCountSolution.sortHashMap(countStrings);
		int index=0;
		
		for(String keys: sortMap.keySet()){
			if(index!=5){
				System.out.println(keys);
				index++;
			}
		}
		
	}
	
	public static void findCount(String[] input){
		
		for(String word: input){
			
			if(!countStrings.containsKey(word)){
				countStrings.put(word, 1);
			}else{
				countStrings.put(word, countStrings.get(word)+1);
			}
			
		}
		
	}
	
	public static Map<String,Integer> sortHashMap(Map<String, Integer> map){
		
		List<Entry<String,Integer>> list = new LinkedList<Entry<String,Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			
			public int compare(Entry<String, Integer> entry1,Entry<String, Integer> entry2){
				return entry2.getValue().compareTo(entry1.getValue());
			}
		});
			Map<String,Integer> sortMap = new LinkedHashMap<String, Integer>();
			for(Entry<String, Integer> entry: list){
				sortMap.put(entry.getKey(), entry.getValue());
			}
			
		return sortMap;
		
		
		
	}

}
