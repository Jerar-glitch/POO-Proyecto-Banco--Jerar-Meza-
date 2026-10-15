/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author jerar
 */
public class CuentaBancaria {
    public String numeroCuenta;
    public String titular;
    private double Saldo;
    private int totalTransacciones;
     
    //esto es un constructor
    public CuentaBancaria(String NumeroCuenta,String Titular,double saldoInicial) {
        this.numeroCuenta=NumeroCuenta;
        this.titular = Titular;
        this.totalTransacciones=0;
        if(saldoInicial<0)
        {
           Saldo=0.0; 
        } else {
            this.Saldo=saldoInicial;
        }
        
    }
    //estos son getters
    public double getSaldo(){
        return Saldo;
    }
    
    public int getTotalTransacciones(){
        return totalTransacciones;
    }
    //este es un setter, ya que  devuelve lo que se pida
    public void depositar(double monto){
        if(monto > 0) {
            Saldo += monto;
            totalTransacciones += 1;
        } else {
            throw new Error("el monto no puede ser menor o igual a cero");
        }
    }
    //este tambien es en setter ya que actualizan valores
    public boolean retirar(double monto){
        if(monto>0 && Saldo>=monto){
           Saldo-= monto;
           totalTransacciones += 1;
           return true;
        } else {
          throw new Error("el monto no puede ser mayor que el saldo"); 
        }
    }
    //funcion para mostrar datos en el main
    public void mostrarDatos() {
        System.out.println("\t Bac Credomatic");
        System.out.println("Nombre del titular:" + titular);
        System.out.println("Numero de cuenta:" + numeroCuenta);
        System.out.println("Saldo actual:" + Saldo);
        System.out.println("Total de transacciones:"+totalTransacciones);
    }
    
}   
