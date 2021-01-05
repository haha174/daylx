package before.merge_intervals;

class Solution {
//    public int[][] merge(int[][] intervals) {
//        int n = intervals.length;
//        if (n < 2) {
//            return intervals;
//        }
//        int m = 0;
//
//        outer: for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (canMerge(intervals, i, j)) {
//                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
//                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
//                    intervals[i] = null;
//                    continue outer;
//                }
//            }
//            m++;
//        }
//        int[][] ans = new int[m][2];
//        int j = 0;
//        for (int i = 0; i < n; i++) {
//            if (intervals[i] != null) {
//                ans[j++] = intervals[i];
//            }
//        }
//        return ans;
//    }
//
//    public boolean canMerge(int[][] a, int i, int j) {
//        return Math.max(a[i][0], a[j][0]) <= Math.min(a[i][1], a[j][1]);
//    }

//
//    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
//        ArrayList<int[]> result = new ArrayList<>();
//        if (intervals.length == 0) {
//            return result.toArray(new int[result.size()][0]);
//        }
//        result.add(intervals[0]);
//        for (int i = 1; i < intervals.length; i++) {
//            int[] arr = result.get(result.size() - 1);
//            if (intervals[i][0] <= arr[1]) {
//                arr[1] = Math.max(arr[1],intervals[i][1]);
//            } else {
//                result.add(intervals[i]);
//            }
//        }
//        return result.toArray(new int[result.size()][2]);
//    }


    //4 ms

//    class Node{
//       int f;
//       int s;
//       public Node(int f,int s){
//           this.f=f;
//           this.s=s;
//       }
//    }
//    public int[][] merge(int[][] intervals) {
//        if (intervals==null || intervals.length==0){
//            return intervals;
//        }
//        soft(intervals,0,intervals.length-1);
//        int index=0;
//        LinkedList<Node> resultTmp= new LinkedList<>();
//        Node node=new Node(intervals[index][0],intervals[index][1]);
//        resultTmp.add(node);
//        while (index<intervals.length-1){
//            index++;
//            node=resultTmp.getLast();
//            if (intervals[index][0]>node.s){
//                resultTmp.add(new Node(intervals[index][0],intervals[index][1]));
//            }else{
//                node.s=Math.max(node.s,intervals[index][1]);
//            }
//        }
//        int[][] result=new int[resultTmp.size()][2];
//        System.out.println(resultTmp);
//        index=0;
//        for (Node node1:resultTmp){
//            int[] tt=new int[2];
//            tt[0]=node1.f;
//            tt[1]=node1.s;
//            result[index++]=tt;
//        }
//        return result;
//    }
//    public void soft(int[][] intervals,int begin ,int end){
//        int i=begin;
//        int j=end;
//        int tData=intervals[begin][0];
//        while (i<j){
//            while (i<j && tData<intervals[j][0])
//                j--;
//
//            while (i<j && intervals[i][0]<=tData)
//                i++;
//            if (i<j){
//                swap(intervals,i,j);
//            }
//        }
//        swap(intervals,begin,i);
//        if (i-1>begin)
//            soft(intervals,begin,i-1);
//        if (j+1<end)
//            soft(intervals,j+1,end);
//    }
//
//    public void swap(int[][] intervals,int i,int j){
//        int first=intervals[i][0];
//        int second=intervals[i][1];
//        intervals[i][0]=intervals[j][0];
//        intervals[i][1]=intervals[j][1];
//        intervals[j][0]=first;
//        intervals[j][1]=second;
//    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        int len = intervals.length;
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] <= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    intervals[i] = null;
                    len--;
                    break;
                }
            }
        }
        int num = 0;
        int[][] arr = new int[len][2];
        for (int[] nums : intervals) {
            if (nums != null) {
                arr[num][0] = nums[0];
                arr[num][1] = nums[1];
                num++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
    // [[4,5],[1,4],[0,1]]
         //  int[][] data = {{1, 4}, {2, 5}, {6, 7}, {2, 5}, {2, 5}, {2, 5}};
         int[][] data = {{1,4},{4,5},{0,1}};
        //int[][] data = {{1,3},{2,6},{8,10},{15,18}};
        new Solution().merge(data);
    }
}