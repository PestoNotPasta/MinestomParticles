package io.github.bloepiloepi.particles.shapes.circle;

import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class CircleBuilder {
    private final Vec center;
    private double radius = 1;
    private ParticleCircle.Facing facing = ParticleCircle.Facing.Y;

    public CircleBuilder(@NotNull Vec center) {
        this.center = center;
    }

    public CircleBuilder radius(double radius) {
        this.radius = radius;
        return this;
    }

    public CircleBuilder facing(@NotNull ParticleCircle.Facing facing) {
        this.facing = facing;
        return this;
    }

    public ParticleCircle build() {
        return new ParticleCircle(center.x(), center.y(), center.z(), radius, facing);
    }
}