class Pair{
    int num;
    char ch;

    Pair(int num, char ch){
        this.num = num;
        this.ch = ch;
    }
}
class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        HashMap<Character, Integer> freq = new HashMap<>();

        for(int i = 0; i < len; i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.num - a.num);

        for(Map.Entry<Character, Integer> entry : freq.entrySet()){
            char ch = entry.getKey();
            int num = entry.getValue();

            pq.offer(new Pair(num, ch));
        }

        StringBuilder st = new StringBuilder();

        while(!pq.isEmpty()){
            Pair v = pq.poll();
            int n = v.num;
            char c = v.ch;

            while(n-- > 0){
                st.append(c);
            }
        }

        return st.toString();
    }
}