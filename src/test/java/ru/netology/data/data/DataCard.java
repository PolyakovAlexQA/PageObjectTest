package ru.netology.data.data;

import lombok.Value;

public class DataCard {
    private DataCard() {

    }

    @Value
    public static class NumberCard {
        private String firstNumber;
        private String secondNumber;
    }

    public static NumberCard getNumberCard() {
        return new NumberCard("5559 0000 0000 0001", "5559 0000 0000 0002");
    }
}