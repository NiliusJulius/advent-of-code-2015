package com.niliusjulius.aoc.days;

import com.niliusjulius.aoc.util.Reader;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Day03 {

    public static void main(String[] args) {
        String input = Reader.readLineAsString("day03");
        System.out.println(part1(input));
        System.out.println(part2(input));
    }

    private static int part1(String input) {
        Map<Point, Integer> houses = new HashMap<>();
        int x = 0;
        int y = 0;
        houses.put(new Point(x, y), 1);
        for (char dir : input.toCharArray()) {
            Point house = move(dir, x, y);
            x = house.x;
            y = house.y;
            if (houses.containsKey(house)) {
                houses.put(house, houses.get(house) + 1);
            } else {
                houses.put(house, 1);
            }
        }
        return houses.size();
    }

    private static int part2(String input) {
        Map<Point, Integer> houses = new HashMap<>();
        int x_santa = 0;
        int y_santa = 0;
        int x_robo = 0;
        int y_robo = 0;
        boolean santa = true;
        houses.put(new Point(x_santa, y_santa), 2);
        for (char dir : input.toCharArray()) {
            Point house;
            if (santa) {
                house = move(dir, x_santa, y_santa);
                x_santa = house.x;
                y_santa = house.y;
            } else {
                house = move(dir, x_robo, y_robo);
                x_robo = house.x;
                y_robo = house.y;
            }

            if (houses.containsKey(house)) {
                houses.put(house, houses.get(house) + 1);
            } else {
                houses.put(house, 1);
            }

            santa = !santa;
        }
        return houses.size();
    }

    private static Point move(char dir, int x, int y) {
        switch (dir) {
            case '<':
                x--;
                break;
            case '>':
                x++;
                break;
            case '^':
                y--;
                break;
            case 'v':
                y++;
                break;
        }
        return new Point(x, y);
    }
}