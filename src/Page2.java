import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Page2 extends JFrame implements ActionListener {

    ImageIcon buttonImage0 = new ImageIcon("src/nonpressed buton.jpg");
    Image img = buttonImage0.getImage();
    Image scalling = img.getScaledInstance(200, 100, Image.SCALE_DEFAULT);
    ImageIcon buttonImage = new ImageIcon(scalling);

    ImageIcon buttonImage1 = new ImageIcon("src/pressed button.jpg");
    Image img1 = buttonImage1.getImage();
    Image scalling1 = img1.getScaledInstance(200, 100, Image.SCALE_DEFAULT);
    ImageIcon buttonImage2 = new ImageIcon(scalling1);

    JButton submit;
    Integer voteRemaining;
    private Candidate selectedCandidate = null;
    private final Map<JButton, Candidate> buttonCandidateMap = new HashMap<>();
    private ArrayList<Candidate> candidateList;


    Page2(ArrayList<Candidate> candidateList, int candidateCount, int persons) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        voteRemaining = persons;

        setTitle("Voting System");
        ImageIcon icon = new ImageIcon("src/th.jpg");
        setIconImage(icon.getImage());

        this.candidateList = candidateList;


        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(161, 155, 111));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        add(panel1, BorderLayout.NORTH);


        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.setBackground(new Color(153, 153, 153));
        panel2.setSize(400, 400);
        panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(panel2, BorderLayout.CENTER);

        JLabel title = new JLabel("Vote only one candidate and press submit");
        Font font = new Font("Serif", Font.BOLD, 24);
        Font font1 = new Font("Serif", Font.BOLD, 18);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(font);
        panel1.add(title);


        submit = new JButton("Submit Vote");
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.addActionListener(this);
        panel2.add(submit);

        for (Candidate candidate : candidateList) {
            JButton candidateButton = new JButton(candidate.getName(), buttonImage);
            candidateButton.setIcon(buttonImage);
            candidateButton.setHorizontalTextPosition(JButton.CENTER);
            candidateButton.setVerticalTextPosition(SwingConstants.CENTER);
            candidateButton.setToolTipText(candidate.getName());
            candidateButton.setContentAreaFilled(false);
            candidateButton.setBorderPainted(false);
            candidateButton.setFocusPainted(false);
            candidateButton.addActionListener(this);
            candidateButton.setFont(font1);
            panel2.add(candidateButton);

            candidateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    candidateButton.setIcon(buttonImage2);
                }
            });

            buttonCandidateMap.put(candidateButton, candidate);
        }


        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (buttonCandidateMap.containsKey(e.getSource())) {
            JButton clickedButton = (JButton) e.getSource();
            Candidate candidate = buttonCandidateMap.get(clickedButton);
            if (candidate == selectedCandidate) {

                clickedButton.setIcon(buttonImage);
                selectedCandidate = null;
            } else {

                if (selectedCandidate != null) {
                    // Deselect previous candidate
                    for (Map.Entry<JButton, Candidate> entry : buttonCandidateMap.entrySet()) {
                        if (entry.getValue() == selectedCandidate) {
                            entry.getKey().setIcon(buttonImage);
                            break;
                        }
                    }
                }
                clickedButton.setIcon(buttonImage2);
                selectedCandidate = candidate;
            }
        }
        if (e.getSource() == submit) {
            if (selectedCandidate != null) {
                selectedCandidate.incrmentVote();
                voteRemaining--;
                System.out.println("Thank you for voting \n" + " Number of votes remained:" + voteRemaining);
                selectedCandidate = null;
            } else {
                System.out.println("Select a candidate");
            }
            for (JButton button : buttonCandidateMap.keySet()) {
                button.setIcon(buttonImage);

                if (voteRemaining == 0) {
                    for (Candidate candidate : candidateList) {
                        candidate.setNumberOfVotes(candidate.getNumberOfVotes());
                    }
                    new Page4(candidateList);
                    dispose();
                }
            }


        }

    }
}
