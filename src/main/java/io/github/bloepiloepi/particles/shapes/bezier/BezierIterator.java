package io.github.bloepiloepi.particles.shapes.bezier;

import io.github.bloepiloepi.particles.iterator.ParticleVecIterator;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class BezierIterator extends ParticleVecIterator<ParticleBezier> {
    private int index = 0;

    public BezierIterator(@NotNull ParticleBezier shape, @NotNull ShapeOptions options) {
        super(shape, options);
    }

    @Override
    public boolean hasNext() {
        return index < shape.points.length;
    }

    @Override
    public Vec next() {
        Vec position = shape.points[index];
        index++;
        return position;
    }
}