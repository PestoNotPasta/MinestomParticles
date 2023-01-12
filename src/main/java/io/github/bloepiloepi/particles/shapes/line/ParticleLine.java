package io.github.bloepiloepi.particles.shapes.line;

import io.github.bloepiloepi.particles.ParticleShape;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class ParticleLine implements ParticleShape {
    final Vec start, end, delta;
    final double length;

    private ParticleLine(@NotNull Vec start, @NotNull Vec end) {
        this.start = start;
        this.end = end;
        this.delta = end.sub(start);

        double dx = delta.x();
        double dy = delta.y();
        double dz = delta.z();
        this.length = Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static ParticleLine of(@NotNull Vec pos1, @NotNull Vec pos2) {
        return new ParticleLine(pos1, pos2);
    }

    public @NotNull LineIterator iterator(@NotNull ShapeOptions options) {
        return new LineIterator(this, options);
    }

    @Override
    public String toString() {
        return "ParticleLine{" +
                "x1=" + start.x() +
                ", y1=" + start.y() +
                ", z1=" + start.z() +
                ", x2=" + end.x() +
                ", y2=" + end.y() +
                ", z2=" + end.z() +
                '}';
    }
}