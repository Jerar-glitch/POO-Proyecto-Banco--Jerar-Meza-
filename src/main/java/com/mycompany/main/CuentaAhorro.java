/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author jerar
 */
public class CuentaAhorro extends CuentaBancaria {
   //una variable propia de CuentaAhorro
    public double tasaInteresAnual; 
    //este es un constructor que le pasa parametros al constructor padre    
    public CuentaAhorro(String NumeroCuenta, String Titular, double SaldoInicial, double TasaInteresAnual) {
        super(NumeroCuenta, Titular, SaldoInicial);
        this.tasaInteresAnual = TasaInteresAnual;
    }
    //se le asignan valores
    private int retirosRealizadosMes=0;   
    private double comisionPorExceso=20.0;
    
    //este es un setter
    public void retirarConComision(double monto){
        if (retirosRealizadosMes>=3)
        {
            if(getSaldo()>=monto+comisionPorExceso){
                retirar(monto + comisionPorExceso);
                System.out.println("Se cobro comision por exceso: L. " + comisionPorExceso);
                retirosRealizadosMes += 1;
            }
        } 
        else {
            retirar(monto);
            retirosRealizadosMes += 1;
        }
    }
    //este es un setter
    public void aplicarInteresMensual(){
        double interes = (getSaldo() * (tasaInteresAnual/100))/12;
        depositar(interes);
    }
}
