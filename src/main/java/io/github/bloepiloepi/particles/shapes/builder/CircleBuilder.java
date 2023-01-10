package io.github.bloepiloepi.particles.shapes.builder;

import io.github.bloepiloepi.particles.shapes.ParticleCircle;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class CircleBuilder {
    private Vec position = Vec.ZERO;
    private double radius = 1;
    private ParticleCircle.Facing facing = ParticleCircle.Facing.Y;

    public @NotNull CircleBuilder position(@NotNull Vec position) {
        this.position = position;
        return this;
    }

    public @NotNull CircleBuilder radius(double radius) {
        this.radius = radius;
        return this;
    }

    public @NotNull CircleBuilder facing(@NotNull ParticleCircle.Facing facing) {
        this.facing = facing;
        return this;
    }

    public @NotNull ParticleCircle build() {
        return new ParticleCircle(position.x(), position.y(), position.z(), radius, facing);
    }
}
