package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public class IntPair {
        public int uniqueNum = 0;
        public int frequency = 0;

        public IntPair(int uniqueNum, int frequency) {
            this.uniqueNum = uniqueNum;
            this.frequency = frequency;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Counts and stores the frequency of unique integers in a hashmap.
        for (int i : nums) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        // Makes a maxHeap priority queue based on the highest frequency of unique
        // integers.
        PriorityQueue<IntPair> heap = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);

        // Adds each key and value into the priority queue as a single object.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            heap.add(new IntPair(key, value));
        }

        // Extracts the k most frequent unique values and adds them to an array
        int[] answer = new int[k];
        for (int i = 0; i < answer.length; i++) {
            IntPair newPair = heap.poll();
            answer[i] = newPair.uniqueNum;
        }

        return answer;
    }
}
