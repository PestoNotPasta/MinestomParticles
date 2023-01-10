package io.github.bloepiloepi.particles.shapes.builder;

import io.github.bloepiloepi.particles.shapes.ParticlePolygon;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PolygonBuilder {
    private List<Vec> points = new ArrayList<>();
    private boolean close = true;

    public @NotNull PolygonBuilder points(@NotNull List<Vec> points) {
        this.points = points;
        return this;
    }

    public @NotNull PolygonBuilder addPoint(@NotNull Vec point) {
        this.points.add(point);
        return this;
    }

    public @NotNull PolygonBuilder close(boolean close) {
        this.close = close;
        return this;
    }

    public @NotNull ParticlePolygon build() {
        return new ParticlePolygon(points.toArray(Vec[]::new), close);
    }
}
