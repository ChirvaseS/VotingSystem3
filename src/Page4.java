import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Page4 extends JFrame {

    Page4(ArrayList<Candidate> candidateList) {


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
        panel2.setLayout(new GridLayout(candidateList.size() +1, 2));
        JLabel candidateLabel = new JLabel("Candidate");
        candidateLabel.setFont(font1);
        JLabel votesLabel = new JLabel("Votes");
        votesLabel.setFont(font1);
        panel2.add(candidateLabel);
        panel2.add(votesLabel);

        for (Candidate candidate : candidateList) {
            String candidateName = candidate.getName();
            int votes = candidate.getNumberOfVotes();

            JLabel nameLabel = new JLabel(candidateName);
            nameLabel.setFont(font1);
            panel2.add(nameLabel);

            JLabel votesValueLabel = new JLabel(String.valueOf(votes));
            votesValueLabel.setFont(font1);
            panel2.add(votesValueLabel);
        }





        panel2.setBackground(new Color(153, 153, 153));
        panel2.setSize(400,400);
        panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(panel2, BorderLayout.CENTER);

        JLabel title= new JLabel("Result of the vote");
        title.setFont(font);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(title);

        setVisible(true);



    }


}
