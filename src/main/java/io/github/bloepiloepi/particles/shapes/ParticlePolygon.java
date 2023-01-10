package io.github.bloepiloepi.particles.shapes;

import net.minestom.server.entity.Player;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ParticlePolygon extends ParticleShape {
    private final Vec[] points;
    private final boolean close;

    public ParticlePolygon(@NotNull Vec[] points, boolean close) {
        this.points = points;
        this.close = close;
    }

    public @NotNull PolygonIterator iterator(@NotNull ShapeOptions options) {
        return new PolygonIterator(this, options);
    }

    public static class PolygonIterator extends ParticleIterator<ParticlePolygon> implements Iterator<ParticleLine.LineIterator> {
        private int index = 0;

        protected PolygonIterator(ParticlePolygon polygon, ShapeOptions options) {
            super(polygon, options);
        }

        @Override
        public boolean hasNext() {
            return index < shape.points.length - (shape.close ? 0 : 1);
        }

        @Override
        public ParticleLine.LineIterator next() {
            Vec position1 = shape.points[index];
            index++;
            Vec position2 = shape.points[hasNext() ? index : 0];

            return new ParticleLine(position1, position2).iterator(options);
        }

        @Override
        public void draw(@NotNull Collection<Player> players, @NotNull Vec start, @NotNull LinePattern.Iterator pattern) {
            while (hasNext()) {
                ParticleLine.LineIterator line = next();
                line.draw(players, start, pattern);
            }
        }
    }

    @Override
    public String toString() {
        return "ParticlePolygon{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
