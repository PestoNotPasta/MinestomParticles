package io.github.bloepiloepi.particles.shapes.polygon;

import io.github.bloepiloepi.particles.LinePattern;
import io.github.bloepiloepi.particles.iterator.ParticleIterator;
import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class MultiPolygonIterator extends ParticleIterator<MultiPolygon, ParticleShape> {
    private int index = 0;

    protected MultiPolygonIterator(MultiPolygon shape, ShapeOptions options) {
        super(shape, options);
    }

    @Override
    public boolean hasNext() {
        return index < shape.shapes.length;
    }

    @Override
    public ParticleShape next() {
        ParticleShape result = shape.shapes[index];
        index++;
        return result;
    }

    @Override
    public void draw(@NotNull Collection<Player> players, @NotNull Vec start, @NotNull LinePattern.Iterator pattern) {
        while (hasNext()) {
            ParticleShape shape = next();
            shape.iterator(options).draw(players, start, pattern.reset());
        }
    }
}
