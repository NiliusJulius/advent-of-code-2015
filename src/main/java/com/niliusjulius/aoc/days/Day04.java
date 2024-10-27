package com.niliusjulius.aoc.days;

import com.niliusjulius.aoc.util.Reader;
import com.twmacinta.util.MD5;

public class Day04 {

    public static void main(String[] args) {
        String input = Reader.readLineAsString("day04");
        System.out.println(part1(input));
        System.out.println(part2(input));
    }

    private static int part1(String input) {
        return findStartsWith(input, "00000");
    }

    private static int part2(String input) {
        return findStartsWith(input, "000000");
    }

    private static int findStartsWith(String input, String start) {
        int counter = 0;
        String hash;
        do {
            MD5 md5 = new MD5();
            md5.Update(input + counter);
            hash = md5.asHex();
            counter++;
        } while (!hash.startsWith(start));
        return counter-1;
    }
}