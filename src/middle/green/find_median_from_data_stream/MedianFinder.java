package middle.green.find_median_from_data_stream;


import java.text.DecimalFormat;
import java.util.PriorityQueue;
//
//class MedianFinder {
//    int offset=100000;
//    int[] buckets = new int[2*offset+1];
//    int size=0;
//    public MedianFinder() {
//
//    }
//
//    public void addNum(int num) {
//        if (buckets[num+offset]==0){
//            size++;
//        }
//        buckets[num+offset]++;
//    }
//
//    public double findMedian() {
//        if (size%2==0){
//            return toOneDecimal( (getKNum(size / 2) + getKNum(size / 2 + 1)) /2.0);
//        }else {
//            return toOneDecimal(getKNum(size/2+1));
//        }
//    }
//
//    public double toOneDecimal(double value) {
//        DecimalFormat df = new DecimalFormat("#.0");
//        return Double.parseDouble(df.format(value));
//    }
//
//    private int getKNum(int k){
//        for (int i=0;i<buckets.length;i++){
//            if (buckets[i]>0){
//                k--;
//            }
//            if (k==0){
//                return i-offset;
//            }
//        }
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        MedianFinder finder=new MedianFinder();
//        finder.addNum(1);
//        finder.addNum(2);
//        System.out.println(finder.findMedian());
//        finder.addNum(3);
//        System.out.println(finder.findMedian());
//
//    }
//}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


class MedianFinder {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}


