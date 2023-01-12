package io.github.bloepiloepi.particles.shapes.bezier;

import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BezierBuilder {
    private final List<Vec> points = new ArrayList<>();
    private double step = 0.1;

    public @NotNull BezierBuilder addControlPoint(@NotNull Vec controlPoint) {
        this.points.add(controlPoint);
        return this;
    }

    public @NotNull BezierBuilder step(double step) {
        this.step = step;
        return this;
    }

    public @NotNull ParticleBezier build() {
        if (points.size() < 2)
            throw new IllegalArgumentException("There must be at least two control points");

        return new ParticleBezier(points.toArray(Vec[]::new), step);
    }
}
