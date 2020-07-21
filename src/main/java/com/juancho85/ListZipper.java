package com.juancho85;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListZipper<T1, T2, R> {

    public static <T1, T2, R> Stream<R> zip(
            List<T1> list1,
            List<T2> list2,
            BiFunction<? super T1, ? super T2, ? extends R> mapper) {
        int size = list1.size();
        if (list2.size() != size) {
            throw new IllegalArgumentException("Different list sizes");
        }
        return IntStream.range(0, size)
                .mapToObj(idx -> mapper.apply(list1.get(idx), list2.get(idx)));
    }
}
