package io.github.bloepiloepi.particles.shapes.polygon;

import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ParticlePolygon implements ParticleShape {
    protected final Vec[] points;
    protected final boolean close;

    public ParticlePolygon(@NotNull Vec[] points, boolean close) {
        this.points = points;
        this.close = close;
    }

    public @NotNull PolygonIterator iterator(@NotNull ShapeOptions options) {
        return new PolygonIterator(this, options);
    }

    public static @NotNull PolygonBuilder builder() {
        return new PolygonBuilder();
    }

    @Override
    public String toString() {
        return "ParticlePolygon{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
