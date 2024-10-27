package com.niliusjulius.aoc.days;

import com.niliusjulius.aoc.util.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day06 {

    public static void main(String[] args) {
        List<String> input = Reader.readLinesAsList("day06");
        System.out.println(part1(input));
        System.out.println(part2(input));
    }

    private static int part1(List<String> input) {
        int[][] grid = new int[1000][1000];
        for (String line : input) {
            Pattern onPattern = Pattern.compile("turn on");
            Pattern offPattern = Pattern.compile("turn off");
            List<Integer> numbers = determineNumbers(line);
            if (onPattern.matcher(line).find()) {
                changeGrid(grid, 0, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), 1);
            } else if (offPattern.matcher(line).find()) {
                changeGrid(grid, 1, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), 1);
            } else {
                changeGrid(grid, 2, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), 1);
            }
        }
        return countOn(grid);
    }

    private static int part2(List<String> input) {
        int[][] grid = new int[1000][1000];
        for (String line : input) {
            Pattern onPattern = Pattern.compile("turn on");
            Pattern offPattern = Pattern.compile("turn off");
            List<Integer> numbers = determineNumbers(line);
            if (onPattern.matcher(line).find()) {
                changeGrid(grid, 0, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), 2);
            } else if (offPattern.matcher(line).find()) {
                changeGrid(grid, 1, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), 2);
            } else {
                changeGrid(grid, 2, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), 2);
            }
        }
        return countOn(grid);
    }

    private static List<Integer> determineNumbers(String line) {
        Pattern numberPattern = Pattern.compile("[0-9]+");
        Matcher matcher = numberPattern.matcher(line);
        List<Integer> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        return numbers;
    }

    private static void changeGrid(int[][] grid, int type, int x1, int y1, int x2, int y2, int part) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (part == 1) {
                    switch (type) {
                        case 0:
                            grid[i][j] = 1;
                            break;
                        case 1:
                            grid[i][j] = 0;
                            break;
                        case 2:
                            grid[i][j] = grid[i][j] = grid[i][j] == 1 ? 0 : 1;
                            break;
                    }
                } else if (part == 2) {
                    switch (type) {
                        case 0:
                            grid[i][j] += 1;
                            break;
                        case 1:
                            grid[i][j] -= 1;
                            break;
                        case 2:
                            grid[i][j] += 2;
                            break;
                    }
                    if (grid[i][j] < 0) {
                        grid[i][j] = 0;
                    }
                }
            }
        }
    }

    private static int countOn(int[][] grid) {
        int count = 0;
        for (int i = 0; i <= 999; i++) {
            for (int j = 0; j <= 999; j++) {
                count += grid[i][j];
            }
        }
        return count;
    }
}