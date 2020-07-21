package com.juancho85;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CartesianProduct {

    public static Stream<String> getCartesianProduct(List<List<String>> input) {
        Stream<Supplier<Stream<String>>> streamOfStreamSuppliers = input.stream().map(list -> list::stream);
        Supplier<Stream<String>> streamSupplier = streamOfStreamSuppliers.reduce((s1, s2) ->
                () -> s1.get().flatMap(a -> s2.get().map(b -> a + " " + b)))
                .orElse(() -> Stream.of(""));
        return streamSupplier.get();
    }

}
