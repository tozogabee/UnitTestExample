package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberListConverter {

    public List<Integer> convert(List<Integer> numbers, MathFunction function) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            result.add(function.apply(num));
        }
        return result;

//        return numbers.stream()
//                .map(integer -> function.apply(integer))
//                .collect(Collectors.toList());
    }
}
