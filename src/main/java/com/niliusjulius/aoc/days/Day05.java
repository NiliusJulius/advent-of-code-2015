package com.niliusjulius.aoc.days;

import com.niliusjulius.aoc.util.Reader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day05 {

    public static void main(String[] args) {
        List<String> input = Reader.readLinesAsList("day05");
        System.out.println(part1(input));
        System.out.println(part2(input));
    }

    private static int part1(List<String> input) {
        int nice = 0;
        for (String word : input) {
            int vowels = 0;
            boolean inARow = false;
            boolean forbiddenCombination = false;
            char previous = '#';
            for (char letter : word.toCharArray()) {
                if (vowels < 3 && (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')) {
                    vowels++;
                }
                if (!inARow && letter == previous) {
                    inARow = true;
                }
                previous = letter;
                if (word.contains("ab") || word.contains("cd") || word.contains("pq") || word.contains("xy")) {
                    forbiddenCombination = true;
                    break;
                }
            }
            if (!forbiddenCombination && inARow && vowels == 3) {
                nice++;
            }
        }
        return nice;
    }

    private static int part2(List<String> input) {
        int nice = 0;
        for (String word : input) {
            Map<String, Integer> combinations = new HashMap<>();
            char previous = '#';
            char beforePrevious = '#';
            int index = 0;
            boolean repeats = false;
            boolean repeatCombinations = false;
            for (char letter : word.toCharArray()) {
                if (!repeats && letter == beforePrevious) {
                    repeats = true;
                }
                if (!repeatCombinations
                        && combinations.containsKey("" + previous + letter)
                        && combinations.get("" + previous + letter) <= index - 2) {
                    repeatCombinations = true;
                }
                if (!combinations.containsKey("" + previous + letter)) {
                    combinations.put("" + previous + letter, index);
                }
                index++;
                beforePrevious = previous;
                previous = letter;
            }
            if (repeats && repeatCombinations) {
                nice++;
            }
        }
        return nice;
    }
}