package com.company.cyclingFastest40km;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static double faster40km(final int lapDistanceInKm,
                                    final List<Double> avgSpeedByLap) {
        Double faster40km = 0.0;
        double sumOfSpeed = 0.0;
        double additionalSumOfSpeed = 0.0;
        int avgsOfSpeed = 0;
        int additionalAvgsOfSpeed = 0;

        if (lapDistanceInKm * avgSpeedByLap.size() >= 40) {
            avgSpeedByLap.sort(Comparator.reverseOrder());
            System.out.println(avgSpeedByLap);
            int remainingKms = 40;
            for (int i = 0; i < avgSpeedByLap.size(); i++) {
                if (remainingKms >= lapDistanceInKm) {
                    sumOfSpeed += avgSpeedByLap.get(i);
//                    faster40km += avgSpeedByLap.get(i) / lapDistanceInKm;
                    remainingKms = remainingKms - lapDistanceInKm;
                    avgsOfSpeed++;

                } else if (remainingKms > 0) {
                    // more complicated logic
                    // an aproximation?
                    //System.out.println("remainin kilometers: " + remainingKms);
                    additionalSumOfSpeed += avgSpeedByLap.get(i);
                    additionalAvgsOfSpeed++;
                    //System.out.println("El resultado será un aproximación, a menos que completes la vuelta de " + lapDistanceInKm + "kms\n🚩 Aún te quedan " + remainingKms + "kms para un resultado exacto");
                    remainingKms = 0;
//                    faster40km += avgSpeedByLap.get(i) / remainingKms;
                }
            }
        } else
            throw new RuntimeException("El tramo recorrido es demasiado corto para calcular la velocidad");

        if (additionalSumOfSpeed > 0.0) {
            avgsOfSpeed += additionalAvgsOfSpeed;
            sumOfSpeed += additionalSumOfSpeed;
//            additionalSumOfSpeed /= additionalAvgsOfSpeed;
//            faster40km += additionalSumOfSpeed;
        }
        faster40km = sumOfSpeed / avgsOfSpeed;
        return faster40km;
    }

    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#.##");

        List<Double> avgSpeedByLap = Arrays.asList(25.7, 28.1, 29.1, 36.3, 42.4, 34.4);
        //avgSpeedByLap.add();

        System.out.println(formatter.format(faster40km(10, avgSpeedByLap)) + "\n");
        System.out.println(formatter.format(faster40km(9, avgSpeedByLap)) + "\n");
        System.out.println(formatter.format(faster40km(11, avgSpeedByLap)) + "\n"); // If resultadoAproximado == resultadoExacto; return "Increíble! El resultado es el mismo"
        System.out.println(formatter.format(faster40km(7, avgSpeedByLap)));
    }
}
