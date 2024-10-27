package com.niliusjulius.aoc.days;

import com.niliusjulius.aoc.util.Reader;

public class Day01 {

    public static void main(String[] args) {
        String input = Reader.readLineAsString("day01");
        System.out.println(part1(input));
        System.out.println(part2(input));
    }

    private static int part1(String input) {
        int floor = 0;
        for (char bracket : input.toCharArray()) {
            if (bracket == '(') {
                floor++;
            } else if (bracket == ')') {
                floor--;
            }
        }
        return floor;
    }

    private static int part2(String input) {
        int floor = 0;
        int belowZero = 0;
        for (char bracket : input.toCharArray()) {
            if (bracket == '(') {
                floor++;
            } else if (bracket == ')') {
                floor--;
            }
            belowZero++;
            if (floor == -1) {
                break;
            }
        }
        return belowZero;
    }
}