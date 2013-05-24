// Time Limit Exceed

public class Solution126 {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        dict.add(start);
        dict.add(end);
        
        ArrayList<String> list = new ArrayList<String>(dict);
        list.remove(start);
        list.remove(end);
        list.add(0, start);
        list.add(end);
        
        Boolean[][] mem = new Boolean[list.size()][list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            for(int j = i; j < list.size(); j++) {
                mem[i][j] = compare(list.get(i), list.get(j));
                mem[j][i] = mem[i][j];
            }
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(0);
        res.add(tmp);
        
        int level = 1;
        boolean found = false;
        
        while(!found && level <= list.size()) {
            while(res.size() > 0 && res.get(0).size() < level) {
                ArrayList<Integer> str_list = res.remove(0);
                int tail = str_list.get(str_list.size() - 1);
                
                for(int i = 0; i < list.size(); i++) {
                    if(i == tail || str_list.contains(i)) continue;
                    
                    if(mem[i][tail] || mem[tail][i]) {
                        ArrayList<Integer> clone = (ArrayList<Integer>) str_list.clone();
                        clone.add(i);
                        res.add(clone);
                        
                        if(i == list.size() - 1) {
                            found = true;
                        }
                    }
                }
            }
            level++;
        }
        
        ArrayList<ArrayList<String>> fin = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < res.size(); i++) {
            if(res.get(i).get(res.get(i).size() - 1) == list.size() - 1) {
                ArrayList<String> arr = new ArrayList<String>();
                
                for(int j = 0; j < res.get(i).size(); j++) {
                    arr.add(list.get(res.get(i).get(j)));
                }
                
                fin.add(arr);
            }
        }
        
        return fin;
    }
    
    private Boolean compare(String a, String b) {
        boolean diff = false;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                if(diff) {
                    return new Boolean(false);
                } else {
                    diff = true;
                }
            }
        }
        return new Boolean(true);
    }
}