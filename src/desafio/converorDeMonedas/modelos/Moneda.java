package desafio.converorDeMonedas.modelos;

import com.google.gson.annotations.SerializedName;

public class Moneda {
    //@SerializedName("base_code")
    private String nombreA;
    //@SerializedName("target_code")
    private String nombreB;
    //@SerializedName("conversion_rate")
    private double factorConversion;
    //@SerializedName("conversion_result")
    private double resultado;

    public Moneda() {
    }

    public Moneda(MonedaExchanceRate monedaExchanceRate){
        this.nombreA= monedaExchanceRate.base_code();
        this.nombreB= monedaExchanceRate.target_code();
        this.factorConversion= monedaExchanceRate.conversion_rate();
        this.resultado= monedaExchanceRate.conversion_result();

    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getNombreB() {
        return nombreB;
    }

    public void setNombreB(String nombreB) {
        this.nombreB = nombreB;
    }

    public double getFactorConversion() {
        return factorConversion;
    }

    public void setFactorConversion(double factorConversion) {
        this.factorConversion = factorConversion;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Moneda Base='" + nombreA + '\'' +
                ", Moneda Destino='" + nombreB + '\'' +
                ", Tasa=" + factorConversion +
                ", Monto=" + resultado;
    }
}