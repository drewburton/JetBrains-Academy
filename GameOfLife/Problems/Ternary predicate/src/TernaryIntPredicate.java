@FunctionalInterface
public interface TernaryIntPredicate<T, R> {
    R test(T val1, T val2, T val3);
}

public static final TernaryIntPredicate allValuesAreDifferentPredicate = (x, y, z) -> (x == y || y == z || x == z ? false : true);