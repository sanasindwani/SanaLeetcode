// we can use bfs to do level wise check
// we made a hashset because operations on hashset uses a complexicity of O(1)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
// if set doesn't contain the endWord then we can't form a transformation
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                String word = q.poll();

                if(word.equals(endWord)){
                    return level;
                }
// since strings are immutable thus we converted our string to arr
                char[] arr = word.toCharArray();
// now we are extracting all char of our word
                for(int i = 0; i < arr.length; i++){
// storing original so that we can put it back again when needed 
                    char orig = arr[i];
// changing our char from a to z
                    for(char c = 'a'; c <= 'z'; c++){
                        arr[i] = c;
// again converted to string to check if it exsists in our set or not 
                        String next = new String(arr);

                        if(set.contains(next)){
                            q.offer(next);
                            set.remove(next);
                        }
                    }

                    arr[i] = orig;
                }
            }
            level++;
        }
        return 0;
    }
}
/*class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        int m = beginWord.length();

        int[] vis = new int[n];

        int level = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String s = q.poll();
                if(s.equals(endWord)) return level; // java doesn't have s == endWord string equations

                
                for(int j = 0; j < n; j++){
                    if(vis[j] == 1) continue;
                    int c = 0;
                    for(int k = 0; k < m; k++){
                        if(s.charAt(k) == wordList.get(j).charAt(k)) c++;
                    }
                    if(c == m-1){
                        q.add(wordList.get(j));
                        vis[j] = 1;
                    }
                }
            }

            level++;
        }

        return 0;
    }
}*/