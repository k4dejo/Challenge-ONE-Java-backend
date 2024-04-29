package com.alura.conversor.modelos;

import com.google.gson.annotations.SerializedName;

public class Pair {
    @SerializedName("base_code")
    String baseCode;
    @SerializedName("target_code")
    String targetCode;
    @SerializedName("conversion_rate")
    double conversionRate;
    @SerializedName("conversion_result")
    double conversionResult;

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }


    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }


}
