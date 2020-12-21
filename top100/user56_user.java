class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        })
        List<int[]> result = new ArrayList<int[]>();
        for(int i=0; i < intervals.length; ++i) {
            if((result.size() == 0) || result.get(result.size - 1)[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                result.get(result.size - 1)[1] = Math.max(result.get(result.size - 1)[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}