package com.company.minutesForPhoneCharging;

public class Main {
    public static void main(String[] args) {
        System.out.println(chargingSmartPhone(0,5)); // Toma 1 minuto
        System.out.println(chargingSmartPhone(831, 3500)); // Toma 7 horas
        System.out.println(chargingSmartPhone(39, 75)); // Toma 8 minutos ¿Es realista?
        System.out.println(chargingSmartPhone(10, 750)); // Toma 3 horas
        System.out.println(chargingSmartPhone(60, 75)); // Toma 3 minutos
        System.out.println(chargingSmartPhone(9000, 10000)); // Toma 2 horas
    }

    public static int chargingSmartPhone(int initialCharge, int finalCharge){
//        int start = initialCharge; // 🟠 Verificar si hay un caso donde start sea realmente necesarie
        double count = 0;
        int[] v = {10, 230, 559, 1009, 5000, 10000, 1000000000};
        int[] r = {10, 5, 8, 2, 7, 8, 3};

        for (int i = 0; i < v.length; i++) {
            while (initialCharge > v[i]) // 🟠 Creo que sin este loop corro el riesgo de sumar minutos a un velocidad que no corresponde; si mi batería inicial es 11, comenzaría cargando a 10 unidades por minuto
                i++;

            if (finalCharge < v[i]) {
                count += Math.ceil((double)(finalCharge - initialCharge) / (r[i])); // Pasado otro minuto el teléfono se puede cargar de más,
                break; // pero no vamos a pasar al siguiente minuto
            } else {
                count += Math.ceil((double)(v[i] - initialCharge) / (r[i]));
                initialCharge +=  Math.ceil((double)(v[i] - initialCharge) / (r[i])) * r[i];
            }

            if (initialCharge == v[i]) { // Si arranco con 10 de batería, en 1 minuto sumo otres 10 de batería
                count += 1;
                initialCharge += r[i];

                if (initialCharge > finalCharge)
                    break;
            }
        }

        return (int)count;
    }
}
