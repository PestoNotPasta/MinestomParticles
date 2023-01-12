package io.github.bloepiloepi.particles.iterator;

import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public abstract class ParticleShapeIterator<T extends ParticleShape> extends ParticleIterator<T> implements Iterator<ParticleShape> {

    public ParticleShapeIterator(@NotNull T shape, @NotNull ShapeOptions options) {
        super(shape, options);
    }
}