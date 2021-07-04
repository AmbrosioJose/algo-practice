package randomProblems.salesByMatch;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// A more beautiful solution: relying on the O(1) insertion and removal
// Set<Integer> colors = new HashSet<>();
//    int pairs = 0;
//
//    for (int i = 0; i < n; i++) {
//        if (!colors.contains(c[i])) {
//            colors.add(c[i]);
//        } else {
//            pairs++;
//            colors.remove(c[i]);
//        }
//    }
//
//    System.out.println(pairs);

// My Solution
class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> sockMap = new HashMap<Integer, Integer>();
        for(Integer sock : ar){
            if(sockMap.containsKey(sock)){
                int currentSockCount = sockMap.get(sock);
                sockMap.replace(sock, currentSockCount + 1);
            } else {
                sockMap.put(sock, 1);
            }
        }

        Integer totalPairs = 0;

        for(Map.Entry<Integer, Integer> entry: sockMap.entrySet()){
            totalPairs += getPairCount(entry.getValue());
        }

        return totalPairs.intValue();

    }

    public static Integer getPairCount(Integer count){
        return count / 2;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}