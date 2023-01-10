package io.github.bloepiloepi.particles.shapes;

import io.github.bloepiloepi.particles.ParticleUtils;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.Player;
import net.minestom.server.coordinate.Point;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

public class ParticleSingle extends ParticleShape {
    private final double x, y, z;

    public ParticleSingle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public ParticleSingle(@NotNull Point position) {
        this(position.x(), position.y(), position.z());
    }

    @Override
    public @NotNull SingleIterator iterator(@NotNull ShapeOptions options) {
        return new SingleIterator(this, options);
    }

    public static class SingleIterator extends ParticleIterator<ParticleSingle> implements Iterator<Point> {
        private boolean done = false;

        protected SingleIterator(ParticleSingle shape, ShapeOptions options) {
            super(shape, options);
        }

        @Override
        public boolean hasNext() {
            return !done;
        }

        @Override
        public Point next() {
            done = true;

            return new Vec(shape.x, shape.y, shape.z);
        }

        @Override
        public void draw(@NotNull Collection<Player> players, @NotNull Point start, @NotNull LinePattern.Iterator pattern) {
            Point position = next();
            if (pattern.next()) {
                ParticleUtils.drawParticle(players, start.add(position), options);
            }
        }
    }
}
