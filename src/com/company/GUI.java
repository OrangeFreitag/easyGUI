package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GUI {
    JTextField textField;

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
        JFrame messageFrame = new JFrame("Meldung");
        int candidate = Integer.parseInt(text);
        if (-1 != isPrimeNumber(candidate)) {
            JOptionPane.showMessageDialog(messageFrame,
                    candidate +" is a prime.");
        }
        else {
            JOptionPane.showMessageDialog(messageFrame,
                    candidate + " is not a prime.");
        }
        messageFrame.setVisible(true);
    }

    public int isPrimeNumber(int candidate) {
        SieveOfAtkin candidatePool = new SieveOfAtkin();
        candidatePool.determineCandiatePool();
        BinarySearch searcher = new BinarySearch();
        int arr[] = convertIntegers(buildArrayList(candidatePool.sieve));
        int n = arr.length;
        int x = candidate;
        return searcher.binarySearch(arr,0,n-1,x);
    }

    public ArrayList buildArrayList(boolean[] candidatePool) {
        ArrayList primes = new ArrayList<Integer>();
        int counter = 0;
        for (int i = 0; i < candidatePool.length - 1; i++) {
            if (candidatePool[i] == true)
                primes.add(counter);
            counter++;
        }
        return primes;
    }
    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
