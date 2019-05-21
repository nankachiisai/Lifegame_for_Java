package dev.happinessfield.lifegame.Exceptions;

public class OutOfFieldException extends IllegalArgumentException {
    public OutOfFieldException() {
    }

    public OutOfFieldException(int x, int y) {
        // System.out.println("x: " + x + ", y: " + y);
    }
}
