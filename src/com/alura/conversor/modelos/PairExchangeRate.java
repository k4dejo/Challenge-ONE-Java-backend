package com.alura.conversor.modelos;

public record PairExchangeRate(String baseCode, String targetCode, double conversionRate, double conversionResult) {
}
