package io.github.bloepiloepi.particles.shapes;

import io.github.bloepiloepi.particles.ParticleUtils;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.Player;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

public class ParticleCircle extends ParticleShape {
    private static final double _2PI = 2 * Math.PI;

    private final double x, y, z;
    private final double radius;
    private final double circumference;

    private final Facing facing;

    public ParticleCircle(double x, double y, double z, double radius, @NotNull Facing facing) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        this.facing = facing;

        this.circumference = _2PI * radius;
    }

    @Override
    public @NotNull CircleIterator iterator(@NotNull ShapeOptions options) {
        return new CircleIterator(this, options);
    }

    public static class CircleIterator extends ParticleIterator<ParticleCircle> implements Iterator<Vec> {
        private final int particleCount;
        private final double angleIncrement;

        private double currentAngle = 0;
        private int particles = 0;

        public CircleIterator(ParticleCircle shape, ShapeOptions options) {
            super(shape, options);

            if (options.hasParticleCount()) {
                this.particleCount = options.getParticleCount();
            } else {
                //Stretch behavior
                this.particleCount = (int) Math.round(shape.circumference / options.getParticleDistance());
            }

            this.angleIncrement = _2PI / particleCount;
        }

        @Override
        public boolean hasNext() {
            return particles < particleCount;
        }

        @Override
        public Vec next() {
            double c1 = shape.radius * Math.cos(currentAngle);
            double c2 = shape.radius * Math.sin(currentAngle);

            particles++;
            currentAngle += angleIncrement;

            if (shape.facing == Facing.X) {
                return new Vec(shape.x, shape.y + c1, shape.z + c2);
            } else if (shape.facing == Facing.Y) {
                return new Vec(shape.x + c1, shape.y, shape.z + c2);
            } else {
                return new Vec(shape.x + c1, shape.y + c2, shape.z);
            }
        }

        @Override
        public void draw(@NotNull Collection<Player> players, @NotNull Vec start, @NotNull LinePattern.Iterator pattern) {
            while (hasNext()) {
                Vec position = next();
                if (pattern.next()) {
                    ParticleUtils.drawParticle(players, start.add(position), options);
                }
            }
        }
    }

    public enum Facing {
        X, Y, Z
    }

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
