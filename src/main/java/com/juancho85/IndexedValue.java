package com.juancho85;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class IndexedValue<T> {
    private int index;
    private T value;

    public static <T> Stream<IndexedValue<T>> withIndices(List<T> list) {
        return IntStream.range(0, list.size())
                .mapToObj(idx -> new IndexedValue<>(idx, list.get(idx)));
    }
}
