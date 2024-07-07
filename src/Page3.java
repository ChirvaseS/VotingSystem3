import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;


public class Page3 extends JFrame implements ActionListener {

    JButton submit;
    JTextField textField;
    int persons;
    Page1 page1;

    Page3(Page1 page1){

        this.page1=page1;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        Font font= new Font("Serif",Font.BOLD, 24);
        Font font1= new Font("Serif",Font.BOLD, 18);

        setTitle("Voting System");
        ImageIcon icon = new ImageIcon("src/th.jpg");
        setIconImage(icon.getImage());



        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(161, 155, 111));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        add(panel1, BorderLayout.NORTH);


        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.setBackground(new Color(153, 153, 153));
        panel2.setSize(400,400);
        panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(panel2, BorderLayout.CENTER);

        JLabel title= new JLabel("How much people are voting?");
        title.setFont(font);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(title);

        submit= new JButton("Submit");
        submit.requestFocus();
        submit.addActionListener(this);
        panel2.add(submit);

        textField = new JTextField("Insert an integer", 20);
        textField.setFont(font1);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setMargin(new Insets(10, 10, 10, 10));
        panel2.add(textField);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Insert an integer")){
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()){
                    textField.setText("Insert an integer");
                }
            }
        });
        panel1.add(Box.createVerticalStrut(20));

        panel1.add(textField);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            try {
                persons = Integer.parseInt(textField.getText().trim());
                if (persons <=0){
                    JOptionPane.showMessageDialog(this,"Insert a positive Integer");

                }else {
                    ArrayList<Candidate> candidateList = page1.candidateList;
                    int candidateCount = page1.candidateCount;


                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new Page2(candidateList, candidateCount, persons);
                            dispose();

                        }

                    });
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }


    }
}

