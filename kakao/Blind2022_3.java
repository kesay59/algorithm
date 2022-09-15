import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

class Solution {
    public int[] solution(int[] fees, String[] records) {
    	HashMap<String, Integer> parkingTimeMap = new HashMap<String, Integer>();
    	HashMap<String, Integer> parkedCarMap = new HashMap<String, Integer>();
    	String[] recordList;
    	for(String record : records) {
    		recordList = record.split("[: ]");
    		if("IN".equals(recordList[3])) {
    			parkedCarMap.put(recordList[2], Integer.parseInt(recordList[1]) + Integer.parseInt(recordList[0]) * 60);
    		}
    		else {
    			int parkingTime = Integer.parseInt(recordList[1]) + Integer.parseInt(recordList[0]) * 60 - parkedCarMap.get(recordList[2]);
    			parkedCarMap.remove(recordList[2]);
    			if(parkingTimeMap.containsKey(recordList[2])) parkingTime += parkingTimeMap.get(recordList[2]);
    			parkingTimeMap.put(recordList[2], parkingTime);
    		}
    	}
    	
    	int finTime = 23 * 60 + 59; 
    	for(String parkedCar : parkedCarMap.keySet()) {
    		int parkingTime = finTime - parkedCarMap.get(parkedCar);
    		if(parkingTimeMap.containsKey(parkedCar)) parkingTime += parkingTimeMap.get(parkedCar);
			parkingTimeMap.put(parkedCar, parkingTime);
    	}
    	
    	
    	int basicTime = fees[0];
    	int basicFee = fees[1];
    	int unitTime = fees[2];
    	int unitFee = fees[3];
    	HashMap<String, Integer> feeMap = new HashMap<String, Integer>();
    	for(String carNumber : parkingTimeMap.keySet()) {
    		int parkingTime = parkingTimeMap.get(carNumber);
    		int fee = 0;
    		if(parkingTime > 0) {
    			parkingTime -= basicTime;
    			fee += basicFee;
    		}
    		if(parkingTime > 0) {
    			int unitCnt = parkingTime / unitTime;
    			if(parkingTime % unitTime != 0) unitCnt++;
    			fee += unitCnt * unitFee;
    		}
    		feeMap.put(carNumber, fee);
    	}
    	
        int[] answer = new int[feeMap.size()];
        Set<String> carNumberSet = feeMap.keySet();
        ArrayList<String> carNumberList = new ArrayList(carNumberSet);
        Collections.sort(carNumberList);
        for(int i = 0; i < carNumberList.size(); i++) {
        	answer[i] = feeMap.get(carNumberList.get(i));
        }
        return answer;
    }
}