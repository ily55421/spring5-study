//package com.allenddatmeny.chapter4;
//
//import sun.misc.Timeable;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: linKe
// * @Date: 2022/7/5 23:44
// * @FileName: ProfileListAdd
// * @version: 1.0
// * @Description: TODO  分析list性能
// */
//public class ProfileListAdd {
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        profileArrayListAddEnd();
//        //profileArrayListAddBeginning();
//        //profileLinkedListAddBeginning();
//        //profileLinkedListAddEnd();
//    }
//
//    /**
//     * Characterize the run time of adding to the end of an ArrayList
//     */
//    public static void profileArrayListAddEnd() {
//        Timeable timeable = new Timeable() {
//            List<String> list;
//
//            public void setup(int n) {
//                list = new ArrayList<String>();
//            }
//
//            public void timeMe(int n) {
//                for (int i=0; i<n; i++) {
//                    list.add("a string");
//                }
//            }
//        };
//        int startN = 4000;
//        int endMillis = 1000;
//        runProfiler("ArrayList add end", timeable, startN, endMillis);
//    }
//
//    /**
//     * Characterize the run time of adding to the beginning of an ArrayList
//     */
//    public static void profileArrayListAddBeginning() {
//        // TODO: FILL THIS IN!
//    }
//
//    /**
//     * Characterize the run time of adding to the beginning of a LinkedList
//     */
//    public static void profileLinkedListAddBeginning() {
//        // TODO: FILL THIS IN!
//    }
//
//    /**
//     * Characterize the run time of adding to the end of a LinkedList
//     */
//    public static void profileLinkedListAddEnd() {
//        // TODO: FILL THIS IN!
//    }
//
//    /**
//     * Runs the profiles and displays results.
//     *
//     * @param timeable
//     * @param startN
//     * @param endMillis
//     */
//    private static void runProfiler(String title, Timeable timeable, int startN, int endMillis) {
//        Profiler profiler = new Profiler(title, timeable);
//        XYSeries series = profiler.timingLoop(startN, endMillis);
//        profiler.plotResults(series);
//    }
//}
