import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class NoobieCalculator extends JFrame implements ActionListener {

    static JFrame frame;

    static JTextField textField;

    String s0, s1, s2;

    NoobieCalculator() {
        s0 = s1 = s2 = "";
    }

    public static void main(String[] args) {
        frame = new JFrame("NoobieCalculator");            //Defines the frame of the calculator.
        frame.setSize(200, 220);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }

        frame.setLocation(200, 200); // ??

        JPanel panel = new JPanel();

        NoobieCalculator nb = new NoobieCalculator();

        textField = new JTextField(20);

        JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, beq, badd, bsub, bmul, bdiv, bclr, bdot;

        //        final JTextArea textArea = new JTextArea(40, 40);
        //        frame.getContentPane().add(BorderLayout.CENTER, textArea);

        //Buttons for numbers
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        //Button for equals
        beq = new JButton("=");

        //Buttons for operations
        badd = new JButton("+");
        bsub = new JButton("-");
        bmul = new JButton("*");
        bdiv = new JButton("/");

        //Clear Button
        bclr = new JButton("C");
        //Decimal point button
        bdot = new JButton(".");
        frame.add(panel);
        //Adding Buttons to the layout
        panel.add(textField);
        panel.add(bclr);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(badd);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bsub);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bmul);
        panel.add(bdot);
        panel.add(b0);
        panel.add(beq);
        panel.add(bdiv);



        //Defining Action Listeners
        b0.addActionListener(nb);
        b1.addActionListener(nb);
        b2.addActionListener(nb);
        b3.addActionListener(nb);
        b4.addActionListener(nb);
        b5.addActionListener(nb);
        b6.addActionListener(nb);
        b7.addActionListener(nb);
        b8.addActionListener(nb);
        b9.addActionListener(nb);
        badd.addActionListener(nb);
        bsub.addActionListener(nb);
        bmul.addActionListener(nb);
        bdiv.addActionListener(nb);
        beq.addActionListener(nb);
        bclr.addActionListener(nb);
        bdot.addActionListener(nb);

//        final JButton b2 = new JButton("2");
//        frame.getContentPane().add(BorderLayout.SOUTH, b2);
//
//        final JButton b3 = new JButton("3");
//        frame.getContentPane().add(BorderLayout.EAST, b3);
//
//        final JButton b4 = new JButton("4");
//        frame.getContentPane().add(BorderLayout.WEST, b4);

//        final JButton b5 = new JButton("5");
//        frame.getContentPane().add(BorderLayout.SOUTH, b5);
//
//        final JButton b6 = new JButton("6");
//        frame.getContentPane().add(BorderLayout.SOUTH, b6);


//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                textArea.append("Button was clicked\n");
//            }
//        });


        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String s = e.getActionCommand();

        if(s.charAt(0) >= '0' && s.charAt(0) <='9' || s.charAt(0) == '.') {
            if(s1.equals("")) {
                s0 = s0 + s;
            }
            else {
                s2 = s2 + s;
            }
            textField.setText(s0 + s1 + s2);
        }

        else if(s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";

            textField.setText(s0 + s1 + s2);
        }
        else if(s.charAt(0) == '=') {
            double res = 0;

            if(s1.equals("+")) {
                res = Double.parseDouble(s0) + Double.parseDouble(s2);
            }
            else if(s1.equals("-")) {
                res = Double.parseDouble(s0) - Double.parseDouble(s2);
            }
            else if(s1.equals("*")) {
                res = Double.parseDouble(s0) * Double.parseDouble(s2);
            }
            else if(s1.equals("/") && Double.parseDouble(s2) != 0) {
                res = Double.parseDouble(s0) / Double.parseDouble(s2);
            }
            else {

            }
            textField.setText(s0 + s1 + s2 + "=" + res);

            s0 = Double.toString(res);

            s1 = s2 = "";
        }
        else {
            if(s1.equals("") || s2.equals("")) {
                s1 = s;
            }
            else {
                double res = 0;

                if(s1.equals("+")) {
                    res = Double.parseDouble(s0) + Double.parseDouble(s2);
                }
                else if(s1.equals("-")) {
                    res = Double.parseDouble(s0) - Double.parseDouble(s2);
                }
                else if(s1.equals("*")) {
                    res = Double.parseDouble(s0) * Double.parseDouble(s2);
                }
                else if(s1.equals("/") && Double.parseDouble(s2) != 0) {
                    res = Double.parseDouble(s0) / Double.parseDouble(s2);
                }
                else {

                }
                s0 = Double.toString(res);

                s1 = s;

                s2 = "";
            }

            textField.setText(s0 + s1 + s2);
        }

    }
}
