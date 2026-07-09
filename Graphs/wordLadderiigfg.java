// time complexicity is impossible to predict it depends on cases and varies with different test cases 
class Solution {
    public ArrayList<ArrayList<String>> findSequences(String[] words, String s, String e) {

        ArrayList<ArrayList<String>> list = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        if (!set.contains(e))
            return list;

        Queue<ArrayList<String>> q = new LinkedList<>();

        ArrayList<String> lst = new ArrayList<>();
        lst.add(s);
        q.add(lst);

        boolean found = false;

        while (!q.isEmpty()) {

            int size = q.size();
            Set<String> temp = new HashSet<>();

            while (size-- > 0) {

                ArrayList<String> ls = q.poll();
                String curr = ls.get(ls.size() - 1);

                char[] arr = curr.toCharArray();

                for (int i = 0; i < curr.length(); i++) {

                    char orig = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (orig == ch)
                            continue;

                        arr[i] = ch;

                        String newWord = new String(arr);

                        if (set.contains(newWord)) {

                            ArrayList<String> path = new ArrayList<>(ls);
                            path.add(newWord);

                            if (newWord.equals(e)) {
                                list.add(path);
                                found = true;
                            } else {
                                temp.add(newWord);
                                q.add(path);
                            }
                        }
                    }

                    arr[i] = orig;
                }
            }

            for (String word : temp) {
                set.remove(word);
            }

            if (found)
                return list;
        }

        return list;
    }
}

/*class Solution {
    public ArrayList<ArrayList<String>> findSequences(String[] words, String s, String e) {

// at first we make a set
        Set<String> st = new HashSet<>();
        for (String word : words) {
            st.add(word);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
// then a queue will be made which will store paths to reach to a certain destination
        Queue<List<String>> q = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        ls.add(s);
        q.add(ls);
// this will store all the used string on one level just like temp 
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(s);

        int level = 0;

        while (!q.isEmpty()) {

            List<String> vec = q.poll();
// this will erase all words that have been used at the previous level to transform
            if (vec.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    st.remove(it);
                }
                usedOnLevel.clear();
            }

            String word = vec.get(vec.size() - 1);

            if (word.equals(e)) {
                if (ans.size() == 0)
                    ans.add(new ArrayList<>(vec));
                else if (ans.get(0).size() == vec.size())
                    ans.add(new ArrayList<>(vec));
            }

            for (int i = 0; i < word.length(); i++) {

                char[] arr = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    if (arr[i] == ch)
                        continue;

                    char original = arr[i];
                    arr[i] = ch;

                    String newWord = new String(arr);

                    if (st.contains(newWord)) {

                        vec.add(newWord);

                        List<String> temp = new ArrayList<>(vec);
                        q.add(temp);

                        usedOnLevel.add(newWord);

                        vec.remove(vec.size() - 1);
                    }

                    arr[i] = original;
                }
            }
        }

        return ans;
    }
}*/