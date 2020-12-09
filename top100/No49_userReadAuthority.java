class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList(); 
        Map<String, List> ans = new HashMap<String, List>();
        for(String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            System.out.println(key);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());    
            }
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }
} 