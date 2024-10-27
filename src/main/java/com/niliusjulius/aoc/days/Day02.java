package com.niliusjulius.aoc.days;

import com.niliusjulius.aoc.util.Reader;

import java.util.Arrays;
import java.util.List;

public class Day02 {

    public static void main(String[] args) {
        List<String> input = Reader.readLinesAsList("day02");
        System.out.println(part1(input));
        System.out.println(part2(input));
    }

    private static int part1(List<String> input) {
        int square_feet = 0;
        for (String line : input) {
            List<Integer> sizes = Arrays.stream(line.split("x"))
                    .map(Integer::parseInt)
                    .toList();
            int side_a = sizes.get(0)*sizes.get(1);
            int side_b = sizes.get(1)*sizes.get(2);
            int side_c = sizes.get(2)*sizes.get(0);
            int min_side = Math.min(side_a, Math.min(side_b, side_c));
            square_feet += 2*side_a + 2*side_b + 2*side_c + min_side;
        }
        return square_feet;
    }

    private static int part2(List<String> input) {
        int ribbon = 0;
        for (String line : input) {
            List<Integer> sizes = Arrays.stream(line.split("x"))
                    .map(Integer::parseInt)
                    .toList();
            int max_side = Math.max(sizes.get(0), Math.max(sizes.get(1), sizes.get(2)));
            ribbon += 2*sizes.get(0) + 2*sizes.get(1) + 2*sizes.get(2) - 2*max_side;
            ribbon += sizes.get(0) * sizes.get(1) * sizes.get(2);
        }
        return ribbon;
    }

}