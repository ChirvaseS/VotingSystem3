import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class Page1 extends JFrame implements ActionListener {
    //introduc Numele candidatilor
    //cate persoane voteaza

    JButton submit;
    JTextField statment1;
    int candidateCount =0;
    JButton finish;
    ArrayList<Candidate> candidateList= new ArrayList<>();


    Page1(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);

        setTitle("Voting System");
        ImageIcon icon = new ImageIcon("src/th.jpg");
        setIconImage( icon.getImage());

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(161, 155, 111));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        add(panel1);


        JLabel title = new JLabel("Welcome to my vote System" );
        Font font= new Font("Serif",Font.BOLD, 24);
        Font font1= new Font("Serif",Font.BOLD, 18);
        title.setFont(font);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.requestFocus();
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(title);

        statment1 = new JTextField("Enter candidate name");
        statment1.setFont(font1);
        statment1.setAlignmentX(Component.CENTER_ALIGNMENT);
        statment1.setMargin(new Insets(0,300,0,0));
        statment1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (statment1.getText().equals("Enter candidate name")){
                    statment1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (statment1.getText().isEmpty()){
                    statment1.setText("Enter candidate name");
                }


            }
        });
        panel1.add(Box.createVerticalStrut(20));

        panel1.add(statment1);



        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.requestFocus();
        panel1.add(submit);

        finish = new JButton("Finish");
        finish.addActionListener(this);
        finish.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(finish);



        setLocationRelativeTo(null);

        setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                submit.requestFocus();

            }
        });
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()== submit && !statment1.getText().isEmpty()){
            String name = statment1.getText();
            Candidate newCandidate = new Candidate(name);
            newCandidate.setName(name);
            System.out.println("Candidate: "+name);
            candidateCount++;
            candidateList.add(newCandidate);
            statment1.setText("Enter candidate name");
        }
        if (e.getSource()== finish){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Page3(Page1.this);
                    dispose();
                }
            });

        }


    }
}
