package easy.green.check_if_n_and_its_double_exist;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++){
			map.put(arr[i], i);
		}

		for(int n = 0; n < arr.length; n++){
			if(map.containsKey(arr[n]*2) && map.get(arr[n]*2) != n){
				return true;
			}
		}
        return false;
    }
}
