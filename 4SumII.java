class Solution {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		int result = 0;
		for (int numA : A) {
			for (int numB : B) {
				int sum = numA + numB;
				//store the sum of first two number into the hash map
				//if sum exist in the map, find how many of the set are in the hash and add 1
				map1.put(sum, map1.getOrDefault(sum, 0) + 1);
			}
		}
		for (int numC : C) {
			for (int numD : D) {
				int sum = numC + numD;
				map2.put(sum, map2.getOrDefault(sum, 0) + 1);
			}
		}
		for (int value : map1.keySet()) {
			if (map2.containsKey(-value)) {
				//if the sum A+-A = 0, so try to find -A value in map2
				result += (map1.get(value) * map2.get(-value));
			}
		}
		return result;
	}
}