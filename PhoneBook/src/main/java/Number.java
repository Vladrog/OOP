import java.util.Objects;

public class Number {
    private String number;
    private NumberType type;

    public Number(String number, NumberType type) {
        this.number = number;
        this.type = type;
    }

    public final String getNumber() {
        return number;
    }

    public final NumberType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return Objects.equals(number, that.number) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }

    @Override
    public String toString() {
        return number + ' ' + type.name();
    }
}
