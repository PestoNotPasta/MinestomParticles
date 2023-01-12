package io.github.bloepiloepi.particles.shapes.bezier;

import io.github.bloepiloepi.particles.ParticleUtils;
import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticleBezier implements ParticleShape {
    final Vec[] points;

    public ParticleBezier(@NotNull Vec[] points, double step) {
        List<Vec> positions = new ArrayList<>();
        double time = 0;
        while (time <= 1 + EPSILON) {
            positions.add(ParticleUtils.bezier(points, time));
            time += step;
        }
        this.points = positions.toArray(Vec[]::new);
    }

    public static BezierBuilder builder() {
        return new BezierBuilder();
    }

    //TODO options is not fully used for bezier curves (only linePattern)
    @Override
    public BezierIterator iterator(@NotNull ShapeOptions options) {
        return new BezierIterator(this, options);
    }

    @Override
    public String toString() {
        return "BezierLine{" + "positions=" + Arrays.toString(points) + '}';
    }
}