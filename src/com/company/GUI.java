package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI  {
    JTextField textField;
    SieveOfAtkin candidatePool = new SieveOfAtkin();
    private int[] primes;
    int counter = 0;
    public GUI() {
        JFrame frame = new JFrame("Frame Demo");
        JLabel label1 = new JLabel("Bitte eine Zahl eingeben", JLabel.CENTER);
        this.textField = new JTextField(20);
        textField.addActionListener(this::actionPerformed);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(label1, BorderLayout.CENTER);
        frame.getContentPane().add(textField, BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        int candidate = Integer.parseInt(text);
        if(isPrimeNumber(candidate))
            System.out.print(candidate + "is a prime.");
        else
            System.out.print(candidate + "is not a prime");

    }

    public boolean isPrimeNumber(int candidate)
    {
        fibonacciSearch searcher = new fibonacciSearch();
        int arr[] = buildArray(candidatePool.sieve);
        int n = 11;
        int x = candidate;
        return searcher.fibMonaccianSearch(arr, x, n);
    }
    public int[] buildArray(boolean[] candidatePool)
    {
        for (int i = 0; i < candidatePool.length-1; i++) {
            if(candidatePool[i]== true)
                primes[counter] = i;
            counter++;
        }
        return primes;
    }
}
