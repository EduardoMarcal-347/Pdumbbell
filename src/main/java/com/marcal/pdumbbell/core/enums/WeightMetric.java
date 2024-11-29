package com.marcal.pdumbbell.core.enums;

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

        public String getAbbreviation() {
            return abbreviation;
        }

        @Override
        public String toString() {
            return abbreviation;
        }
}
