// Its usual code is giving TLE because of new test cases
// Thus we tried write a CP style code which checks all possible ways by which we can form the solution 
// We used 2 Steps ->
// Step 1 is for a map which using Word ladder 1 style which stores minimum steps
// Step 2 is do backtrack/dfs starting from end and store it in lists
// this will reduce many unnecessary ways in which we were xploring paths thus better 
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    List<List<String>> ans;
    String b;
    void dfs(String word, List<String> seq){
        if(b.equals(word)){
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int steps = map.get(word);
        int sz = word.length();

        char[] arr = word.toCharArray();

        for(int i = 0; i < sz; i++){
            char orig = arr[i];

            for(char c = 'a'; c <= 'z'; c++){
                arr[i] = c;

                String st = new String(arr);
                if(map.containsKey(st) && map.get(st) < steps){
                    seq.add(st);
                    dfs(st, seq);
                    seq.remove(seq.size() - 1);
                }
            }
            arr[i] = orig;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        b = beginWord;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        map.put(beginWord, 1);

        int sz = beginWord.length();
        set.remove(beginWord);

        while(!q.isEmpty()){
            String s = q.poll();
            int steps = map.get(s);
            char[] arr = s.toCharArray();

            for(int i = 0; i < sz; i++){
                char orig = arr[i];

                for(char ch = 'a'; ch <= 'z'; ch++){
                    arr[i] = ch;

                    if (orig == ch) continue;

                    String word = new String(arr);
                    if(set.contains(word)){
                        q.add(word);
                        set.remove(word);
                        map.put(word, steps+1);
                    }
                }
                arr[i] = orig;
            }
        }
        ans = new ArrayList<>();
        // iska matlab yeah hai ki kya map ke paas key hai.. that means is there any option by which we can reach 
        if(map.containsKey(endWord) == true){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return ans;
    }
}