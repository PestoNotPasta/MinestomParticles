package io.github.bloepiloepi.particles.shapes.single;

import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class ParticleSingle implements ParticleShape {
    final Vec point;

    private ParticleSingle(Vec point) {
        this.point = point;
    }

    public static ParticleSingle of(@NotNull Vec point) {
        return new ParticleSingle(point);
    }

    @Override
    public @NotNull SingleIterator iterator(@NotNull ShapeOptions options) {
        return new SingleIterator(this, options);
    }
}