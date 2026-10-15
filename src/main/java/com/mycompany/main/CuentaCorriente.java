/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author jerar
 */
public class CuentaCorriente extends CuentaBancaria{
    public String nombreEmpresa;
    private double limiteSobregiro;
    private double sobregiroUtilizado=0.0;
   public CuentaCorriente(String numeroCuenta,String titular,double saldoInicial,String nombreEmpresa,double limiteSobregiro) {
       super(numeroCuenta,titular,saldoInicial);
         this.limiteSobregiro=limiteSobregiro;
         this.nombreEmpresa=nombreEmpresa;
   }
       public double getLimiteSobregiro(){
           return limiteSobregiro;
       }
        public double getSobregiroUtilizado(){
           return sobregiroUtilizado;
       }
        
        public boolean retirarConSobregiro(double monto) {
    if (monto <= 0) {
        System.out.println("Monto inválido.");
        return false;
    }

    if (getSaldo() >= monto) {
        return retirar(monto);
    }

    double disponibleSobregiro = limiteSobregiro - sobregiroUtilizado;
    if (monto <= getSaldo() + disponibleSobregiro) {
        double diferencia = monto - getSaldo();
        if (getSaldo() > 0) {
            retirar(getSaldo());
        }
        double recargo = diferencia * 0.03;
        sobregiroUtilizado += diferencia + recargo;
        System.out.println("Sobregiro usado: L. " + diferencia
                + " + recargo 3%: L. " + recargo);
        return true;
    }

   
    System.out.println("Operación rechazada: excede el cupo de sobregiro.");
    return false;
}

public void pagarSobregiro(double monto) {
    if (monto <= 0) {
        System.out.println("Monto inválido.");
        return;
    }
    if (sobregiroUtilizado == 0) {
        System.out.println("No hay deuda de sobregiro.");
        return;
    }

    double pago = Math.min(monto, sobregiroUtilizado);
    sobregiroUtilizado -= pago;

    double sobrante = monto - pago;
    if (sobrante > 0) {
        depositar(sobrante);
    }
    System.out.println("Deuda pagada:  " + pago + "  Sobregiro pendiente:  " + sobregiroUtilizado);
    }
   
}
