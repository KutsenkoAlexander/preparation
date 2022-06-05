package my.study.coder.path.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        int[] stations = {0, 200, 375, 550, 750, 950};
        int stepSize = 400;
        int startIndex = 0;
        List<Integer> target = new ArrayList<>();

        Object[] result = search(stations, target, startIndex, stepSize).toArray();
        String targetString = Arrays.toString(result);
        out.println("Min numbers of stations is: " + result.length  + ". Stations: " + targetString);
    }

    private static List<Integer> search(int[] stations, List<Integer> target, int startIndex, int stepSize) {
        if (stations.length == 0 || startIndex == stations.length - 1) {
            return target;
        }

        int currentStation = startIndex;
        int result = stations[startIndex];

        while (stepSize >= stations[currentStation]) {
            result = stations[currentStation];
            currentStation++;
        }

        if (stepSize > result) {
            target.add(result);
        } else {
            return target;
        }

        return search(stations, target, currentStation, result + stepSize);
    }
}
