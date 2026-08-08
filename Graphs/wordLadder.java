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


// WordLadder matlab -> HashSet + BFS + checking all possible char at that position
// I use BFS because every edge represents changing one character, so the first time I reach endWord, I've found the shortest transformation sequence. I remove words from the HashSet when I enqueue them, which prevents revisiting the same word.

/*class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // firstly we'll make a hashset 
        // as we can retrieve from hashset with a TC of O(1) it will give us constant lookup

        HashSet<String> dic = new HashSet<>(wordList);
        if(dic.contains(endWord) == false) return 0;

        // now we'll use bfs and the use a count and as soon as we get the endWord we'll return the count 
        int count = 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            count++;

            for(int len = 0; len < size; len++){
                String s = q.poll();

                char[] arr = s.toCharArray();
                
                for(int i = 0; i < arr.length; i++){
                    char orig = arr[i];

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if (ch == orig) continue;

                        arr[i] = ch;

                        String str = new String(arr);

                        if(str.equals(endWord)) return count+1;
                        if(dic.contains(str)){
                            dic.remove(str);
                            q.add(str);
                        }
                    }

                    arr[i] = orig;
                }
            }
        }
        return 0;
    }
}*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // i used bfs because every edge represents changing one character and when i found the endWord for the first time that will be the shortest transformation sequence 
        // hashset provides constant retrieval of words 
        // and i remove from hashset after i found the word thus would prevent revisting them again and again

        HashSet<String> set = new HashSet<>(wordList);
        if(set.contains(endWord) == false) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            count++;

            for(int i = 0; i < size; i++){
                String s = q.poll();

                char[] arr = s.toCharArray();

                for(int len = 0; len < arr.length; len++){
                    char orig = arr[len];

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        arr[len] = ch;

                        String str = new String(arr);
// equals hai equal nahi
                        if(str.equals(endWord)) return count+1;

                        if(set.contains(str)){
                            set.remove(str);
                            q.add(str);
                        }
                    }
                    arr[len] = orig;
                }
            }
        }
        return 0;
    }
}