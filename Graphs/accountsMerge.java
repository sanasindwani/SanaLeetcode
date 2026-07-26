// my implementataion doesn't have rank or size kyonki uski need nahi hai
// isme hamne kya-kya kiya
// 1-> sabse pehle we created a hashmap consisting of all mails and when they overlap we merged the account using union(disjoint set)
// 2-> iske baad we merged all the mails based on who the ultimate parent is and then sort it
// 3-> in merged mails ko with name store karke we added it to list of lists and return

/*class DisjointSet{
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }

        int nNode = findUPar(parent.get(node));
        parent.set(node, nNode);

        return parent.get(node);
    }

    public void union(int u, int v){
        int ulpu = findUPar(u);
        int ulpv = findUPar(v);

        if(ulpu == ulpv) return;

        parent.set(ulpv, ulpu);
    }
}
// first we used map data structure to store all the mails with their acccount number 
// Build the Disjoint Set on account indices -> iterate through all mails and made mapping of mail to the node/account number
// meanwhile if there is overlapping we used union and connected the accounts (account numbers)
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mailMap = new HashMap<>();

// now a map of all mails with their respective account numbers is ready
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);

                if(mailMap.containsKey(mail) == false){
                    // hashmap uses put not add don't use .add()
                    mailMap.put(mail, i);
                } else {
                    ds.union(mailMap.get(mail), i);
                }
            }
        }
// abb ham saare same accounts waali mails ko club karenge and will put them in list sorted
        ArrayList<String>[] mergedMail = new ArrayList[n];

        for(int i = 0; i < n; i++)
            mergedMail[i] = new ArrayList<>();
        
        for(Map.Entry<String, Integer> it : mailMap.entrySet()){
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());

            mergedMail[node].add(mail);
        }
// now we'll create our ans List which will contain all arraylists

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(mergedMail[i].size() == 0) continue;

            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            for(String st : mergedMail[i]){
                temp.add(st);
            }

            ans.add(temp);
        }

        return ans;
    }
}*/
class DisjointSet{
    public List<Integer> size = new ArrayList<>();
    public List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i < n; i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int FindUPar(int node){
        if(node == parent.get(node)){
            return node;
        }

        int nNode = FindUPar(parent.get(node));
        parent.set(node, nNode);

        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = FindUPar(u);
        int ulp_v = FindUPar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        HashMap<String, Integer> mailMap = new HashMap<>();

        // Build DSU
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {

                String mail = accounts.get(i).get(j);

                if (!mailMap.containsKey(mail)) {
                    mailMap.put(mail, i);
                } else {
                    ds.unionBySize(mailMap.get(mail), i);
                }
            }
        }

        // Group mails according to ultimate parent
        ArrayList<String>[] mergedMail = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> it : mailMap.entrySet()) {

            String mail = it.getKey();
            int node = ds.FindUPar(it.getValue());

            mergedMail[node].add(mail);
        }

        // Prepare answer
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (mergedMail[i].size() == 0)
                continue;

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            for (String mail : mergedMail[i]) {
                temp.add(mail);
            }

            ans.add(temp);
        }

        return ans;
    }
}