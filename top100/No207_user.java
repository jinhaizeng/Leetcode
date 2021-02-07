class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i = 0; i < prerequisites.length; ++i) {
            map.put(prerequisites[i][0], prerequisites[i][1]);
        }
        int finalCount = 0;
        for (Integer i: map.keySet()) {
            Integer preCourse = map.get(i);
            Integer count = 1;
            while (preCourse != i && map.containsKey(preCourse) && preCourse != map.get(preCourse)) {
                count++;
                preCourse = map.get(preCourse);
                System.out.println("preCourse: " + preCourse + "i: " + i);
            }
            System.out.println("preCourse: " + preCourse + "map.get(preCourse): " + map.get(preCourse));
            if (preCourse == i || preCourse == map.get(preCourse)) {
                return false;
            }
        }
         return true;
    }
}