package io.github.bloepiloepi.particles.shapes;

import io.github.bloepiloepi.particles.shapes.builder.BezierBuilder;
import io.github.bloepiloepi.particles.shapes.builder.CircleBuilder;
import io.github.bloepiloepi.particles.shapes.builder.MultiPolygonBuilder;
import io.github.bloepiloepi.particles.shapes.builder.PolygonBuilder;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;
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

    public static @NotNull MultiPolygon box(@NotNull Vec center, double width, double height, double depth) {
        double x = width / 2;
        double y = height / 2;
        double z = depth / 2;

        return multiPolygon()
                .addShape(ParticleLine.line(center.add(x, y, z), center.add(-x, y, z)))
                .addShape(ParticleLine.line(center.add(x, y, z), center.add(x, -y, z)))
                .addShape(ParticleLine.line(center.add(x, y, z), center.add(x, y, -z)))
                .addShape(ParticleLine.line(center.add(-x, -y, -z), center.add(x, -y, -z)))
                .addShape(ParticleLine.line(center.add(-x, -y, -z), center.add(-x, y, -z)))
                .addShape(ParticleLine.line(center.add(-x, -y, -z), center.add(-x, -y, z)))
                .addShape(ParticleLine.line(center.add(x, y, -z), center.add(-x, y, -z)))
                .addShape(ParticleLine.line(center.add(x, -y, z), center.add(x, -y, -z)))
                .addShape(ParticleLine.line(center.add(-x, y, z), center.add(-x, -y, z)))
                .addShape(ParticleLine.line(center.add(-x, -y, z), center.add(x, -y, z)))
                .addShape(ParticleLine.line(center.add(-x, y, -z), center.add(-x, y, z)))
                .addShape(ParticleLine.line(center.add(x, -y, -z), center.add(x, y, -z)))
                .build();
    }

    public static @NotNull MultiPolygon cube(@NotNull Vec center, double size) {
        return box(center, size, size, size);
    }
}
