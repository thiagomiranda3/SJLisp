package br.com.tommiranda.core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.NoSuchElementException;

public final class MathFunctions {

    public static BigDecimal sum(BigDecimal... numbers) {
        return Arrays.stream(numbers)
                     .reduce(BigDecimal::add)
                     .orElseThrow(() -> new NoSuchElementException("No params passed to + operator"));
    }

    public static BigDecimal substract(BigDecimal... numbers) {
        return Arrays.stream(numbers)
                     .reduce(BigDecimal::subtract)
                     .orElseThrow(() -> new NoSuchElementException("No params passed to - operator"));
    }

    public static BigDecimal multiple(BigDecimal... numbers) {
        return Arrays.stream(numbers)
                     .reduce(BigDecimal::multiply)
                     .orElseThrow(() -> new NoSuchElementException("No params passed to * operator"));
    }

    public static BigDecimal divide(BigDecimal... numbers) {
        return Arrays.stream(numbers)
                     .reduce(BigDecimal::divide)
                     .orElseThrow(() -> new NoSuchElementException("No params passed to / operator"));
    }

    public static BigDecimal remainder(BigDecimal... numbers) {
        return Arrays.stream(numbers)
                     .reduce(BigDecimal::remainder)
                     .orElseThrow(() -> new NoSuchElementException("No params passed to % operator"));
    }

    public static BigDecimal max(BigDecimal... numbers) {
        return Arrays.stream(numbers)
                     .reduce(BigDecimal::max)
                     .orElseThrow(() -> new NoSuchElementException("No params passed to max function"));
    }

    public static BigDecimal min(BigDecimal... numbers) {
        return Arrays.stream(numbers)
                     .reduce(BigDecimal::min)
                     .orElseThrow(() -> new NoSuchElementException("No params passed to min function"));
    }
}
