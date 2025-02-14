package com.marcal.pdumbbell.entities.enums;

import lombok.Getter;

@Getter
public enum WeightMetric {

        KILOGRAMS("kg"),
        GRAMS("g"),
        POUNDS("lb"),
        OUNCES("oz"),
        STONES("st");

        private final String abbreviation;

        WeightMetric(String abbreviation) {
            this.abbreviation = abbreviation;
        }

    @Override
        public String toString() {
            return abbreviation;
        }
}
