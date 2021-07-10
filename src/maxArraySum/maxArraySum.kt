package maxArraySum

// Java solution
//    similar to fibonacci
//    static int maxSubsetSum(int[] arr) {
//        int includingI = arr[0];
//        int excludingI = 0;
//        int nextExclude;
//
//        for(int i = 1; i < arr.length; i++){
//            nextExclude = Math.max(includingI, excludingI);
//
//            includingI = arr[i] + excludingI;
//            excludingI = nextExclude;
//        }
//
//        return Math.max(includingI, excludingI);
//
//    }