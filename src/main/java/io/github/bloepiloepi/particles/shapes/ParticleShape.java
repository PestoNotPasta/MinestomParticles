package io.github.bloepiloepi.particles.shapes;

import io.github.bloepiloepi.particles.shapes.builder.BezierBuilder;
import io.github.bloepiloepi.particles.shapes.builder.CircleBuilder;
import io.github.bloepiloepi.particles.shapes.builder.MultiPolygonBuilder;
import io.github.bloepiloepi.particles.shapes.builder.PolygonBuilder;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public abstract class ParticleShape {
    protected static final double EPSILON = 0.00001;

    public abstract @NotNull ParticleIterator<?> iterator(@NotNull ShapeOptions options);

    /**
     * Shortcut for {@code iterator().draw()}
     */
    public void draw(@NotNull ShapeOptions options,
                     @NotNull Collection<Player> players, @NotNull Vec start) {
        iterator(options).draw(players, start);
    }

    /**
     * Shortcut for {@code iterator().draw()}
     */
    public void draw(@NotNull ShapeOptions options,
                     @NotNull Instance instance, @NotNull Vec start) {
        iterator(options).draw(instance, start);
    }

    public static @NotNull PolygonBuilder polygon() {
        return new PolygonBuilder();
    }

    public static @NotNull MultiPolygonBuilder multiPolygon() {
        return new MultiPolygonBuilder();
    }

    public static @NotNull ParticleSingle single(@NotNull Vec position) {
        return new ParticleSingle(position);
    }

    public static @NotNull ParticleLine line(@NotNull Vec pos1, @NotNull Vec pos2) {
        return new ParticleLine(pos1, pos2);
    }

    public static @NotNull BezierBuilder bezier(@NotNull Vec start, @NotNull Vec end) {
        return new BezierBuilder().start(start).end(end);
    }

    public static @NotNull CircleBuilder circle(@NotNull Vec position) {
        return new CircleBuilder().position(position);
    }

    public static @NotNull MultiPolygon cube(@NotNull Vec position, double width, double height, double depth) {
        return multiPolygon()
                .lineStart(position)
                .lineTo(position.add(width, 0, 0))
                .lineTo(position.add(width, 0, depth))
                .lineTo(position.add(0, 0, depth))

                .jumpTo(position.add(0, height, 0))
                .lineTo(position.add(width, height, 0))
                .lineTo(position.add(width, height, depth))
                .lineTo(position.add(0, height, depth))

                .jumpTo(position)
                .lineTo(position.add(0, height, 0))
                .jumpTo(position.add(width, 0, 0))
                .lineTo(position.add(width, height, 0))
                .jumpTo(position.add(width, 0, depth))
                .lineTo(position.add(width, height, depth))
                .jumpTo(position.add(0, 0, depth))
                .lineTo(position.add(0, height, depth))

                .build();
    }
}
