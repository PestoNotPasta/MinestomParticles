package io.github.bloepiloepi.particles.shapes.line;

import io.github.bloepiloepi.particles.iterator.ParticleIterator;
import io.github.bloepiloepi.particles.iterator.ParticleLineIterator;
import io.github.bloepiloepi.particles.iterator.ParticleVecIterator;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class LineIterator extends ParticleVecIterator<ParticleLine> {
    private final Vec current, delta;
    private final int particleCount;
    private int particles = 0;

    public LineIterator(@NotNull ParticleLine line, ShapeOptions options) {
        super(line, options);
        this.particleCount = !options.hasParticleCount() ? options.getParticleCount() : (int) Math.round(line.length / options.getParticleDistance());
        this.delta = line.delta.div(particleCount);
        this.current = line.start;
    }

    @Override
    public boolean hasNext() {
        return particles < particleCount;
    }

    @Override
    public Vec next() {
        Vec position = new Vec(current.x(), current.y(), current.z());
        current.add(delta);
        particles++;
        return position;
    }
}