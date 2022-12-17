package theTeamProject.View;

import javax.swing.*;
import main.java.theTeamProject.View.scoreView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.random.*;
import java.util.Scanner;

import theTeamProject.controllerInterface;
import theTeamProject.gameObserver;
import theTeamProject.gameInterface;

public class gameView implements ActionListener, gameObserver {

    // Main Menu here
    JPanel menuPanel = new JPanel();
    JButton human = new JButton(); // Play vs Human button
    JButton pc = new JButton(); // Play vs computer button
    JButton scoreBoard = new JButton(); // scoreButton
    JLabel scoreText = new JLabel();

    JFrame mainFrame = new JFrame("Jump Cross!");
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JButton[] buttons = new JButton[25];

    JLabel textField = new JLabel();

    boolean player = true; // If true, Red player goes, if False, blue player goes.

    boolean autoPlayer = false; // By default we will have no auto player.

    controllerInterface controller;
    gameInterface game;
    
    int counter = 0;
    scoreView sco = new scoreView();

    public gameView(controllerInterface controller, gameInterface game) {
        this.game = game;
        this.controller = controller;
        this.game.register(this);

        // frame settings

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 600);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

        // label settings

        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Monospaced", Font.BOLD, 20));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setOpaque(true);

        // menuPanel

        menuPanel.setSize(600, 600);
        menuPanel.setVisible(true);

        // buttons

        menuPanel.add(pc);
        menuPanel.add(human);
        menuPanel.add(scoreBoard);

        human.setText("Versus Human");
        human.setPreferredSize(new Dimension(200, 100));
        human.addActionListener(this);
        human.setVisible(true);

        pc.setText("Versus AutoPlayer");
        pc.setPreferredSize(new Dimension(200, 100));
        pc.addActionListener(this);
        pc.setVisible(true);

        sco.read();
        String theScore = sco.returnScore();

        scoreBoard.setText("Best score: " + theScore);
        scoreBoard.setPreferredSize(new Dimension(200, 100));
        scoreBoard.addActionListener(this);
        scoreBoard.setVisible(true);

        // panel settings

        titlePanel.setLayout(new BorderLayout());
        mainFrame.add(menuPanel);
        titlePanel.add(textField);
        mainFrame.add(titlePanel, BorderLayout.NORTH);
        mainFrame.add(buttonPanel);

        buttonPanel.setLayout(new GridLayout(5, 5));
        buttonPanel.setVisible(false);
        titlePanel.setVisible(false);

        for (int i = 0; i < 25; i++) {
            if (i == 21 || i == 22 || i == 23) {
                buttons[i] = new JButton("↑");
                buttonPanel.add(buttons[i]);
                buttons[i].setFont(new Font("Monospaced", Font.BOLD, 30));
                buttons[i].setForeground(Color.RED);
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);
            } else if (i == 9 || i == 14 || i == 19) {
                buttons[i] = new JButton("←");
                buttonPanel.add(buttons[i]);
                buttons[i].setFont(new Font("Monospaced", Font.BOLD, 30));
                buttons[i].setForeground(Color.BLUE);
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);
            } else if (i == 1 || i == 2 || i == 3) {
                buttons[i] = new JButton("");
                buttonPanel.add(buttons[i]);
                buttons[i].setFont(new Font("Monospaced", Font.BOLD, 30));
                buttons[i].setBackground(Color.PINK);
                buttons[i].setOpaque(true);
                buttons[i].setFocusable(false);
                buttons[i].setEnabled(false);
                buttons[i].addActionListener(this);
            } else if (i == 5 || i == 10 || i == 15) {
                buttons[i] = new JButton("");
                buttonPanel.add(buttons[i]);
                buttons[i].setFont(new Font("Monospaced", Font.BOLD, 30));
                buttons[i].setBackground(Color.CYAN);
                buttons[i].setOpaque(true);
                buttons[i].setFocusable(false);
                buttons[i].setEnabled(false);
                buttons[i].addActionListener(this);
            } else if (i == 0 || i == 4 || i == 20 || i == 24) {
                buttons[i] = new JButton("");
                buttonPanel.add(buttons[i]);
                buttons[i].setFont(new Font("Monospaced", Font.BOLD, 30));
                buttons[i].setEnabled(false);
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);
            } else {
                buttons[i] = new JButton("");
                buttonPanel.add(buttons[i]);
                buttons[i].setFont(new Font("Monospaced", Font.BOLD, 30));
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);
            }
        }
        checkTurns();
    }

    public void autoMove() {

        for (int i = 11; i < 15; i++) {
            if (buttons[i].getText() == "←") {
                if (controller.clicked(i)) {
                    return;
                }
            }
        }

        for (int i = 6; i < 10; i++) {
            if (buttons[i].getText() == "←") {
                if (controller.clicked(i)) {
                    return;
                }
            }
        }

        for (int i = 16; i < 20; i++) {
            if (buttons[i].getText() == "←") {
                if (controller.clicked(i)) {
                    return;
                }
            }
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == human) {
            menuPanel.setVisible(false);
            buttonPanel.setVisible(true);
            titlePanel.setVisible(true);
        } else if (e.getSource() == pc) {
            autoPlayer = true;
            menuPanel.setVisible(false);
            buttonPanel.setVisible(true);
            titlePanel.setVisible(true);
        }

        for (int i = 0; i < 25; i++) {
            if (autoPlayer == true) {
                if (e.getSource() == buttons[i]) {
                    if (Objects.equals(buttons[i].getText(), "↑")) {
                        controller.clicked(i);
                        autoMove();
                        counter += 1;
                    }
                }

            } // End of AutoPlayer is True

            else if (autoPlayer == false) {

                if (e.getSource() == buttons[i]) {
                    if (player) {
                        if (Objects.equals(buttons[i].getText(), "↑")) {
                            player = false;
                            controller.clicked(i);
                        }
                    } else {
                        if (Objects.equals(buttons[i].getText(), "←")) {
                            player = true;
                            controller.clicked(i);
                        }
                    }
                }
            } // End of autoPlayer == false

        } // End of for loop for 25
        repaint();
        checkTurns();
        checkWinner();
    }

    public void repaint() {
        for (int i = 0; i < 25; i++) {
            if (controller.getPiece(i) == 1) {
                buttons[i].setText("↑");
                buttons[i].setForeground(Color.RED);
            } else if (controller.getPiece(i) == 2) {
                buttons[i].setText("←");
                buttons[i].setForeground(Color.BLUE);
            } else {
                buttons[i].setText("");
            }
        }
    }

    public void checkTurns() {
        if (player) {
            textField.setText("Red player, move your piece");
        } else {
            textField.setText("Blue player, move your piece");
        }
    }

    public void checkWinner() {
        if (Objects.equals(buttons[1].getText(), "↑") && Objects.equals(buttons[2].getText(), "↑")
                && Objects.equals(buttons[3].getText(), "↑")) {
            winRed();

        } else if (Objects.equals(buttons[5].getText(), "←") && Objects.equals(buttons[10].getText(), "←")
                && Objects.equals(buttons[15].getText(), "←")) {
            winBlue();
        }
        
    }

    public void winBlue() {
        buttons[5].setBackground(Color.BLUE);
        buttons[10].setBackground(Color.BLUE);
        buttons[15].setBackground(Color.BLUE);
        for (int i = 0; i < 25; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("Blue player wins");
        textField.setForeground(Color.blue);
        if (autoPlayer == true) {
            sco.checkCount(counter);
        }

    }

    public void winRed() {
        buttons[1].setBackground(Color.RED);
        buttons[2].setBackground(Color.RED);
        buttons[3].setBackground(Color.RED);
        for (int i = 0; i < 25; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("Red player wins");
        textField.setForeground(Color.red);
        if (autoPlayer == true) {
            sco.checkCount(counter);
        }
    }

    public void update() {

    }

}
