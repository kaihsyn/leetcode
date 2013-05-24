public class Solution128 {
    public int longestConsecutive(int[] num) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int max = 1;
        
        for(int i : num) {
            if(map.containsKey(i)) {
                continue;
            }
            
            map.put(i, 1);
            
            if(map.containsKey(i+1)) {
                max = Math.max(max, merge(map, i, i+1));
            }
            
            if(map.containsKey(i-1)) {
                max = Math.max(max, merge(map, i-1, i));
            }
        }
        return max;
    }
    
    private int merge(HashMap<Integer,Integer> map, int left, int right) {
        int rightest = right + map.get(right) - 1;
        int leftest = left - map.get(left) + 1;
        int len = rightest - leftest + 1;
        map.put(rightest, len);
        map.put(leftest, len);
        return len;
    }
}