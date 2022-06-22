import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.util.Random;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class TicTacToeDavi extends JFrame {
    private static final long serialVersionUID = 1L;// burocracia do Java
    private final JTextField[] cells = new JTextField[9];
    private final BorderLayout gridPaineis = new BorderLayout();
    private final GridLayout gridCelulas = new GridLayout(3,3, 4, 4);
    
    private final JPanel painelBotoes = new JPanel();
    private final JPanel painelCelulas= new JPanel();
    private final JPanel painelRotulos = new JPanel();

    private final JButton botaoSobre;
    private final JButton botaoNovaPartida;

    private final JLabel jogadorO; // jogador O
    private final JLabel jogadorX; // jogador X

    Integer placarJogador0 = 0, placarJogadorX = 0;
    String placar;

    private boolean gameOver = false;

    public TicTacToeDavi() {

        super("Tic Tac Toe");
        setLayout(gridPaineis);

        // painel de botões
        painelBotoes.setLayout(new GridLayout(1,2));
        botaoSobre = new JButton("Sobre");
        Sobre handler = new Sobre();
        botaoSobre.addActionListener(handler);
        painelBotoes.add(botaoSobre);
        
        botaoNovaPartida = new JButton("Nova partida");
        NovaPartida novapartida = new NovaPartida();
        botaoNovaPartida.addActionListener(novapartida);
        painelBotoes.add(botaoNovaPartida);

        add(painelBotoes, BorderLayout.NORTH);

        // painel de células
        painelCelulas.setLayout(gridCelulas);
        Font font = new Font("Arial", Font.BOLD,120);

        for(int i = 0; i < 9; i++) {
            cells[i] = new JTextField(" ");
            cells[i].setFont(font);
            
            cells[i].setHorizontalAlignment(SwingConstants.CENTER);
            cells[i].setEditable(false);
            
            cells[i].addMouseListener(new ClickListener());
            painelCelulas.add(cells[i]);
        }

        add(painelCelulas,BorderLayout.CENTER);
        
        // painel de rótulos
        painelRotulos.setLayout(new GridLayout(1,2));
        jogadorO = new JLabel("Jogador O: 0");
        jogadorO.setHorizontalAlignment(SwingConstants.CENTER);
        painelRotulos.add(jogadorO);

        jogadorX = new JLabel("Jogador X: 0");
        jogadorX.setHorizontalAlignment(SwingConstants.CENTER);
        painelRotulos.add(jogadorX);
        add(painelRotulos,BorderLayout.SOUTH);   
    }

    private class ClickListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) { 
            if (TicTacToeDavi.this.gameOver){
                JOptionPane.showMessageDialog(null, "O jogo acabou, inicie uma nova partida!");
                return;
            }

            JTextField clickedCell = (JTextField) e.getSource();            
            clickedCell.setText("0");
            
            String symbol;
            symbol = clickedCell.getText();

            Random random = new Random();
            int attempts = 0, i = 0;
            JTextField oponentCell;

            while(attempts < 9) {                
                i = random.nextInt(8);
                oponentCell = TicTacToeDavi.this.cells[i];
                symbol = oponentCell.getText();
                
                if (!this.isFilled(symbol)) {
                    oponentCell.setText("X");
                    break;
                }

                attempts++;                
            }
            
            if (this.isFilled(symbol)) {
                JOptionPane.showMessageDialog(TicTacToeDavi.this, "Célula preenchida. Clique em outra");
                return;
            }
            
            if (this.endGame()) {
                JOptionPane.showMessageDialog(TicTacToeDavi.this, "Acabou o jogo!");
                return;
            }
        }

        private boolean isFilled(String symbol) {
            return symbol.equals("0") || symbol.equals("X");
        }

        private boolean someoneWon() {

            boolean someoneWon = false;
            JTextField[] cells = TicTacToeDavi.this.cells;
            int i;
            
            // horizontais
            for(i = 0; i < 3; i++) {
                if (this.isCellsEquals(i, i + 1, i + 2)) {
                    if (cells[0].getText().equals("0")) {
                        placarJogador0++;
                        placar = "Jogador O: " + placarJogador0;
                        jogadorO.setText(placar);

                        JOptionPane.showMessageDialog(TicTacToeDavi.this, "Você ganhou!");
                    } else {
                        placarJogadorX++;
                        placar = "Jogador X: " + placarJogadorX;
                        jogadorX.setText(placar);

                        JOptionPane.showMessageDialog(TicTacToeDavi.this, "Você perdeu!");
                    }
                    return true;
                }
            }

            // verticais
            for(i = 0; i < 3; i++) {
                if (this.isCellsEquals(i, i + 3, i + 6)) {
                    if (cells[0].getText().equals("0")) {
                        placarJogador0 ++;
                        placar = "Jogador O: " + placarJogador0;
                        jogadorO.setText(placar);

                        JOptionPane.showMessageDialog(TicTacToeDavi.this, "Você ganhou!");
                    } else {
                        placarJogadorX++;
                        placar = "Jogador X: " + placarJogadorX;
                        jogadorX.setText(placar);

                        JOptionPane.showMessageDialog(TicTacToeDavi.this, "Você perdeu!");
                    }
                    return true;
                }
            }
            
            // diagonais
            if (this.isCellsEquals(0, 4, 8)) {
                if (cells[0].getText().equals("0")) {
                    placarJogador0 ++;
                    placar = "Jogador O: " + placarJogador0;
                    jogadorO.setText(placar);

                    JOptionPane.showMessageDialog(TicTacToeDavi.this, "Você ganhou!");
                } else {
                    placarJogadorX ++;
                    placar = "Jogador X: " + placarJogadorX;
                    jogadorX.setText(placar);

                    JOptionPane.showMessageDialog(TicTacToeDavi.this, "Você perdeu!");
                }
                return true;
            }
            if (this.isCellsEquals(2, 4, 6)) {
                if (cells[2].getText().equals("0")) {
                    placarJogador0 ++;
                    placar = "Jogador O: " + placarJogador0;
                    jogadorO.setText(placar);

                    JOptionPane.showMessageDialog(TicTacToeDavi.this, "Você ganhou!");
                } else {
                    placarJogadorX ++;
                    placar = "Jogador X: " + placarJogadorX;
                    jogadorX.setText(placar);

                    JOptionPane.showMessageDialog(TicTacToeDavi.this, "Você perdeu!");
                }
                return true;
            }
            
            return someoneWon;
        }
        
        private boolean endGame() {

            if (TicTacToeDavi.this.gameOver) {
                return true;
            }

            if (this.someoneWon()){
                TicTacToeDavi.this.gameOver = true;
                return true;
            }

            boolean endGame = true;            

            JTextField[] cells = TicTacToeDavi.this.cells; 

            for(int i = 0; i < 9; i++) {
                if (cells[i].getText().equals(" ")) {
                    endGame = false;
                    break;
                }
            }

            TicTacToeDavi.this.gameOver = endGame;
            return endGame;
        }
    
        private boolean isCellsEquals(int first, int second, int third) 
        {
            JTextField[] cells = TicTacToeDavi.this.cells;       
            return !cells[first].getText().equals(" ") && 
                cells[first].getText().equals(cells[second].getText()) &&
                cells[second].getText().equals(cells[third].getText());
        }    
    }

    private class NovaPartida implements ActionListener
    {
        // processa eventos de campo de texto
        @Override
        public void actionPerformed(ActionEvent event)
        {
            for (int i = 0; i < 9; i++) {
                TicTacToeDavi.this.cells[i].setText(" ");
            }
            TicTacToeDavi.this.gameOver = false;            
            return;
        }
    }

    private class Sobre implements ActionListener
    {
        // processa eventos de campo de texto
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String string = "Davi Fabiano";
            JOptionPane.showMessageDialog(null, string);
            return;
        }
    }

    public static void main(String[] args) {

        TicTacToeDavi ticTacToe = new TicTacToeDavi();
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setSize(600, 600);
        ticTacToe.setVisible(true);
    }
}