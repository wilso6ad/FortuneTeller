import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;


public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {

        super("Ultimate Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);


        fortunes = new ArrayList<>();
        fortunes.add("You will become a millionaire in two years.");
        fortunes.add("You will meet your soulmate in a month.");
        fortunes.add("You will be famous one day.");
        fortunes.add("You will travel to an exotic location in asia soon.");
        fortunes.add("You will live a long and prosperous life.");
        fortunes.add("You will be promoted as manager at work next month.");
        fortunes.add("You will win the lottery in for days.");
        fortunes.add("You will make a great discovery soon.");
        fortunes.add("You will find diamonds in your yard.");
        fortunes.add("You will have a very successful career.");
        fortunes.add("You will find true happiness in love.");
        fortunes.add("You will have everything you have ever wanted.");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());



        titleLabel = new JLabel("Ultimate Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
        ImageIcon icon = new ImageIcon("crystal.jpg");
        setVisible(true);
        titleLabel.setIcon(icon);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        readButton = new JButton("Read My Fortune!");
        readButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
        readButton.addActionListener((ActionEvent e) -> {
            String fortune = getRandomFortune();
            fortuneArea.append(fortune + "\n");
        });

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });


        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String getRandomFortune() {
        int index = lastFortuneIndex;
        while (index == lastFortuneIndex) {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }
}