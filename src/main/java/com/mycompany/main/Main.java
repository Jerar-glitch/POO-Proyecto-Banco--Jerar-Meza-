/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author jerar
 */
public class Main {


    public static void main(String[] args) {

        //1: Encapsulamiento
        System.out.println("=====1: Encapsulamiento =====");
        CuentaBancaria miCuenta = new CuentaBancaria("001-123", "Juan Alvarenga", 10000.0);
        System.out.println("Saldo protegido, solo se consulta con getSaldo(): L. " + miCuenta.getSaldo());

        //2: Acceso directo a atributos publicos
        System.out.println("\n=====2: Atributos publicos =====");
        System.out.println("Titular: " + miCuenta.titular);
        System.out.println("Numero de cuenta: " + miCuenta.numeroCuenta);

        //3: CuentaAhorro (comision a partir del 4to retiro) 
        System.out.println("\n=====3: CuentaAhorro =====");
        CuentaAhorro ahorro = new CuentaAhorro("002-456", "Maria Yanez", 3000.0, 5.0);
        System.out.println("Saldo inicial: L. " + ahorro.getSaldo());

        for (int i = 1; i <= 4; i++) {
            System.out.println("Retiro #" + i + " de L. 100");
            ahorro.retirarConComision(100);
            System.out.println(" Saldo despues del retiro: L. " + ahorro.getSaldo());
        }
        System.out.println("(El 4to retiro descuenta 100 + 20 de comision por exceso)");

        //4: Rendimiento de ahorro
        System.out.println("\n=====4: Interes mensual =====");
        System.out.println("Saldo antes del interes: L. " + ahorro.getSaldo());
        ahorro.aplicarInteresMensual();
        System.out.println("Saldo despues del interes: L. " + ahorro.getSaldo());

        //5: CuentaCorriente (sobregiro)
        System.out.println("\n=====5: CuentaCorriente =====");
        CuentaCorriente corriente = new CuentaCorriente("003-789", "Carlos Mejia",
                1000.0, "Inversiones Mejia S.A.", 5000.0);
        System.out.println("Empresa: " + corriente.nombreEmpresa);
        System.out.println("Saldo inicial: L. " + corriente.getSaldo());
        System.out.println("Limite de sobregiro: L. " + corriente.getLimiteSobregiro());

        System.out.println("Intentando retirar L. 3500...");
        boolean exito = corriente.retirarConSobregiro(3500);
        System.out.println("Retiro exitoso: " + exito);
        System.out.println("Saldo actual: L. " + corriente.getSaldo());
        System.out.println("Sobregiro utilizado (2500 + 3%): L. " + corriente.getSobregiroUtilizado());

        //6: Amortizacion de deuda
        System.out.println("\n=====6: Pago de sobregiro =====");
        corriente.pagarSobregiro(3000);
        System.out.println("Estado final -> Saldo: L. " + corriente.getSaldo()
                + " | Sobregiro pendiente: L. " + corriente.getSobregiroUtilizado());

        // Datos generales de las cuentas
        System.out.println("\n===== DATOS FINALES =====");
        ahorro.mostrarDatos();
        System.out.println();
        corriente.mostrarDatos();
    
    }
}
