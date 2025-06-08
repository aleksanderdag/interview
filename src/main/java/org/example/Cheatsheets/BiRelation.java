package org.example.Cheatsheets;

@FunctionalInterface
public interface BiRelation<T, U, R> {
    R[] apply(T t, U u);
}
