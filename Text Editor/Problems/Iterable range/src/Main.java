import java.util.Iterator;

class Range implements Iterable<Long> {

    private long fromInclusive;
    private long toExclusive;

    public Range(long from, long to) {
        this.fromInclusive = from;
        this.toExclusive = to;
    }

    @Override
    public Iterator<Long> iterator() {
        return new Iterator<>() {
            Long current = fromInclusive;

            @Override
            public boolean hasNext() {
                return current < toExclusive;
            }

            @Override
            public Long next() {
                return current++;
            }
        };
    }
}