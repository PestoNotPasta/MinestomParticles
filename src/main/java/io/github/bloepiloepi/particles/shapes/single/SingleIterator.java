package io.github.bloepiloepi.particles.shapes.single;

import io.github.bloepiloepi.particles.iterator.ParticleVecIterator;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;

import java.util.Iterator;

public class SingleIterator extends ParticleVecIterator<ParticleSingle> implements Iterator<Vec> {
    private boolean done = false;

    protected SingleIterator(ParticleSingle shape, ShapeOptions options) {
        super(shape, options);
    }

    @Override
    public boolean hasNext() {
        return !done;
    }

    @Override
    public Vec next() {
        done = true;
        return shape.point;
    }
}
