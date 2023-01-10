package io.github.bloepiloepi.particles.shapes.builder;

import io.github.bloepiloepi.particles.shapes.BezierLine;
import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BezierBuilder {
    private final List<Point> controlPoints = new ArrayList<>();
    private Point start = Vec.ZERO;
    private Point end = Vec.ZERO;
    private double step = 0.1;

    public @NotNull BezierBuilder start(@NotNull Point start) {
        this.start = start;
        return this;
    }

    public @NotNull BezierBuilder end(@NotNull Point end) {
        this.end = end;
        return this;
    }

    public @NotNull BezierBuilder addControlPoint(@NotNull Point controlPoint) {
        this.controlPoints.add(controlPoint);
        return this;
    }

    public @NotNull BezierBuilder step(double step) {
        this.step = step;
        return this;
    }

    public @NotNull BezierLine build() {
        return new BezierLine(start, end, controlPoints.toArray(Point[]::new), step);
    }
}
