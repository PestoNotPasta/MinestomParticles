package io.github.bloepiloepi.particles.iterator;

import io.github.bloepiloepi.particles.LinePattern;
import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public abstract class ParticleIterator<T extends ParticleShape> {
    protected final T shape;
    protected final ShapeOptions options;

    protected ParticleIterator(@NotNull T shape, @NotNull ShapeOptions options) {
        this.shape = shape;
        this.options = options;
    }

    public void draw(@NotNull Instance instance, @NotNull Vec start) {
        draw(instance.getPlayers(), start, options.getPatternIterator());
    }

    public void draw(@NotNull Collection<Player> players, @NotNull Vec start) {
        draw(players, start, options.getPatternIterator());
    }

    public abstract void draw(@NotNull Collection<Player> players, Vec start, LinePattern.Iterator pattern);
}
