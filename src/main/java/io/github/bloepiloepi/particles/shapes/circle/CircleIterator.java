package io.github.bloepiloepi.particles.shapes.circle;

import io.github.bloepiloepi.particles.iterator.ParticleIterator;
import io.github.bloepiloepi.particles.iterator.ParticleVecIterator;
import io.github.bloepiloepi.particles.options.ShapeOptions;
import net.minestom.server.coordinate.Vec;

public class CircleIterator extends ParticleVecIterator<ParticleCircle> {
    private static final double _2PI = 2 * Math.PI;
    private final int particleCount;
    private final double angleIncrement;

    private double currentAngle = 0;
    private int particles = 0;

    public CircleIterator(ParticleCircle shape, ShapeOptions options) {
        super(shape, options);
        this.particleCount = options.hasParticleCount() ? options.getParticleCount() : (int) Math.round(shape.circumference / options.getParticleDistance());
        this.angleIncrement = _2PI / particleCount;
    }

    @Override
    public boolean hasNext() {
        return particles < particleCount;
    }

    @Override
    public Vec next() {
        double c1 = shape.radius * Math.cos(currentAngle);
        double c2 = shape.radius * Math.sin(currentAngle);

        particles++;
        currentAngle += angleIncrement;

        Vec vec = Vec.ZERO;
        switch (shape.facing) {
            case X -> vec = new Vec(shape.x, shape.y + c1, shape.z + c2);
            case Y -> vec = new Vec(shape.x + c1, shape.y, shape.z + c2);
            case Z -> vec = new Vec(shape.x + c1, shape.y + c2, shape.z);
        }
        return vec;
    }
}