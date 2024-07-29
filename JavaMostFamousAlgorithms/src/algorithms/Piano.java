package algorithms;

import java.util.Objects;

public class Piano implements Comparable<Piano> {
    private float mark;

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Piano other) {
        int result = compareToValues(other);

        // If comparison based solely on values returns zero, 
        // indicating that two instances are equal in those fields they have in common,
        // only then we break the tie by comparing data types of the two instances.
        if (result == 0) {
            result = compareTypes(other);
        }

        return result;
    }

    protected int compareToValues(Piano other) {
        if (Objects.isNull(other)) {
            return 1; // All instances are greater than null
        }

        // Base class simply compares Mark properties
        return Float.compare(this.mark, other.mark);
    }

    protected int compareTypes(Piano other) {
        // Base type is considered less than derived type
        // when two instances have the same values of base fields.

        // Instances of two distinct derived types are ordered 
        // by comparing full names of their types when base fields are equal.
        // This is a consistent comparison rule for all instances of the two derived types.

        Class<?> thisType = this.getClass();
        Class<?> otherType = other.getClass();

        if (otherType.isAssignableFrom(thisType)) {
            return -1; // other is subclass of this class
        } else if (thisType.isAssignableFrom(otherType)) {
            return 1; // this is subclass of other class
        } else if (!thisType.equals(otherType)) {
            return thisType.getName().compareTo(otherType.getName());
        }

        return 0;
    }

    @Override
    public String toString() {
        return String.format("Mark=%.1f, Piano", mark);
    }
}

class GrandPiano extends Piano {
    private String producer;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    protected int compareToValues(Piano other) {
        int result = super.compareToValues(other);

        if (result == 0 && other instanceof GrandPiano) {
            GrandPiano gp = (GrandPiano) other;
            String thisProducer = producer != null ? producer : "";
            String otherProducer = gp.producer != null ? gp.producer : "";

            result = thisProducer.compareTo(otherProducer);
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("Mark=%.1f, Producer=%s, GrandPiano", getMark(), producer);
    }
}

class PrivatePiano extends Piano {
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    protected int compareToValues(Piano other) {
        int result = super.compareToValues(other);

        if (result == 0 && other instanceof PrivatePiano) {
            PrivatePiano pp = (PrivatePiano) other;
            String thisOwner = owner != null ? owner : "";
            String otherOwner = pp.owner != null ? pp.owner : "";

            result = thisOwner.compareTo(otherOwner);
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("Mark=%.1f, Owner=%s, PrivatePiano", getMark(), owner);
    }
}
