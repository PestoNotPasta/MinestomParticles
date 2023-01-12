package io.github.bloepiloepi.particles.shapes.polygon;

import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

//TODO better name
public class MultiPolygon implements ParticleShape {
    private final ParticleShape[] shapes;

    public MultiPolygon(@NotNull ParticleShape[] shapes) {
        this.shapes = shapes;
    }

    @Override
    public @NotNull MultiPolygonIterator iterator(@NotNull ShapeOptions options) {
        return new MultiPolygonIterator(this, options);
    }

    public static @NotNull MultiPolygonBuilder multiPolygon() {
        return new MultiPolygonBuilder();
    }

    @Override
    public String toString() {
        return "MultiPolygon{" +
                "shapes=" + Arrays.toString(shapes) +
                '}';
    }
}
