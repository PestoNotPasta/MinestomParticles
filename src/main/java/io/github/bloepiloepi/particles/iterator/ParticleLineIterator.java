package io.github.bloepiloepi.particles.iterator;

import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import io.github.bloepiloepi.particles.shapes.line.LineIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public abstract class ParticleLineIterator<T extends ParticleShape> extends ParticleIterator<T> implements Iterator<LineIterator> {

    public ParticleLineIterator(@NotNull T shape, @NotNull ShapeOptions options) {
        super(shape, options);
    }
}
