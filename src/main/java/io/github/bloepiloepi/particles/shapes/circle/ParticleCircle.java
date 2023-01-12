package io.github.bloepiloepi.particles.shapes.circle;

import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class ParticleCircle implements ParticleShape {
    protected static final double _2PI = Math.PI * 2;
    protected final double x, y, z;
    protected double radius;
    protected final double circumference;
    protected final Facing facing;

    public ParticleCircle(double x, double y, double z, double radius, @NotNull Facing facing) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        this.facing = facing;
        this.circumference = _2PI * radius;
    }

    public static CircleBuilder builder(@NotNull Vec position) {
        return new CircleBuilder(position);
    }

    public CircleIterator iterator(@NotNull ShapeOptions options) {
        return new CircleIterator(this, options);
    }

    public enum Facing { X, Y, Z }

    @Override
    public String toString() {
        return "ParticleCircle{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", radius=" + radius +
                ", circumference=" + circumference +
                ", facing=" + facing +
                '}';
    }
}
