package io.github.bloepiloepi.particles.shapes;

import io.github.bloepiloepi.particles.ParticleUtils;
import net.minestom.server.coordinate.Point;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BezierLine extends ParticleShape {
    private final Point[] points;

    public BezierLine(@NotNull Point start, @NotNull Point end,
                      @NotNull Point[] controlPoints,
                      double step) {
        List<Point> positions = new ArrayList<>();

        Point[] points = new Point[2 + controlPoints.length];
        points[0] = start;
        System.arraycopy(controlPoints, 0, points, 1, controlPoints.length);
        points[points.length - 1] = end;

        double time = 0;

        while (time <= 1 + EPSILON) {
            positions.add(ParticleUtils.bezier(points, time));

            time += step;
        }

        this.points = positions.toArray(Point[]::new);
    }

    //TODO options is not fully used for bezier curves (only linePattern)
    @Override
    public @NotNull BezierIterator iterator(@NotNull ShapeOptions options) {
        return new BezierIterator(this, options);
    }

    public static class BezierIterator extends ParticleIterator<BezierLine> implements Iterator<Point> {
        private int index = 0;

        public BezierIterator(BezierLine shape, ShapeOptions options) {
            super(shape, options);
        }

        @Override
        public boolean hasNext() {
            return index < shape.points.length;
        }

        @Override
        public Point next() {
            Point position = shape.points[index];

            index++;

            return position;
        }

        @Override
        public void draw(@NotNull Collection<Player> players, @NotNull Point start, @NotNull LinePattern.Iterator pattern) {
            while (hasNext()) {
                Point position = next();
                if (pattern.next()) {
                    ParticleUtils.drawParticle(players, start.add(position), options);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "BezierLine{" +
                "positions=" + Arrays.toString(points) +
                '}';
    }
}
