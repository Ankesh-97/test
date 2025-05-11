package functional_interfaces;

@FunctionalInterface
public interface TriFunction<S,T,U,V> {
    S apply(T t, U u, V v);
}
