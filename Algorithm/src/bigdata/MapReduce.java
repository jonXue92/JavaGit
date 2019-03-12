package bigdata;

import java.util.*;

class OutputCollector<K, V> {
    public void collect(K key, V value){};
        // Adds a key/value pair to the output buffer
}

class Document {
    public int id;
    public String content;
}

class Pair {
    String key;
    int value;
    Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class MapReduce {
    public static class Map {
        public void map(String str, Document value, OutputCollector<String, Integer> output) {
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int id = value.id;
            String content = value.content;
            String[] words = content.split(" ");
            for (String word: words) {
                if (word.length() > 0) {
                    output.collect(word, 1);
                }
            }
        }
    }
    public static class Reduce {
        private PriorityQueue<Pair> Q = null;
        private int k;
        private Comparator<Pair> pairComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.value != o2.value) {
                    return o1.value - o2.value;
                }
                return o2.key.compareTo(o1.key);
            }
        };
        public void setup(int k) {
            this.k = k;
            Q = new PriorityQueue<Pair>(k, pairComparator);
        }
        public void reduce(String key, Iterator<Integer> values) {
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }
            Pair pair = new Pair(key, sum);
            if (Q.size() < k) {
                Q.offer(pair);
            } else {
                Pair peak = Q.peek();
                if (pairComparator.compare(pair, peak) > 0) {
                    Q.poll();
                    Q.offer(pair);
                }
            }
        }
        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<Pair> pairs = new ArrayList<>();
            while (!Q.isEmpty()) {
                pairs.add(Q.poll());
            }
            int n = pairs.size();
            for (int i = n - 1; i >= 0; i--) {
                Pair pair = pairs.get(i);
                output.collect(pair.key, pair.value);
            }
        }
    }
}
