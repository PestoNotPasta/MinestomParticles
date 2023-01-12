package io.github.bloepiloepi.particles.iterator;

import io.github.bloepiloepi.particles.LinePattern;
import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.ParticleUtils;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

public abstract class ParticleVecIterator<T extends ParticleShape> extends ParticleIterator<T> implements Iterator<Vec> {

    public ParticleVecIterator(@NotNull T shape, @NotNull ShapeOptions options) {
        super(shape, options);
    }

    @Override
    public void draw(@NotNull Collection<Player> players, Vec start, LinePattern.Iterator pattern) {
        while (hasNext()) {
            Vec position = next();
            ParticleUtils.drawParticle(players, start.add(position), options);
        }
    }
}
