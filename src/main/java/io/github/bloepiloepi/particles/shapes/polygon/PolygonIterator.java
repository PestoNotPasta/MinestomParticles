package io.github.bloepiloepi.particles.shapes.polygon;

import io.github.bloepiloepi.particles.LinePattern;
import io.github.bloepiloepi.particles.iterator.ParticleIterator;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import io.github.bloepiloepi.particles.shapes.line.LineIterator;
import io.github.bloepiloepi.particles.shapes.line.ParticleLine;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class PolygonIterator extends ParticleIterator<ParticlePolygon, LineIterator> {
    private int index = 0;

    protected PolygonIterator(ParticlePolygon polygon, ShapeOptions options) {
        super(polygon, options);
    }

    @Override
    public boolean hasNext() {
        return index < shape.points.length - (shape.close ? 0 : 1);
    }

    @Override
    public LineIterator next() {
        Vec position1 = shape.points[index];
        index++;
        Vec position2 = shape.points[hasNext() ? index : 0];
        return ParticleLine.of(position1, position2).iterator(options);
    }

    @Override
    public void draw(@NotNull Collection<Player> players, @NotNull Vec start, @NotNull LinePattern.Iterator pattern) {
        while (hasNext()) {
            LineIterator line = next();
            line.draw(players, start, pattern);
        }
    }
}
