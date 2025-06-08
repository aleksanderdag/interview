package org.example.Cheatsheets;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);

    // TODO: add andthen
//        default <V> Cheatsheets.TriFunction<A, B, C, V> andThen(
//                                Function<? super R, ? extends V> after) {
//        Objects.requireNonNull(after);
//        return (A a, B b, C c) -> after.apply(apply(a, b, c));
//    }
}
