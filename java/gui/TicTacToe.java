import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Random;

class TicTacToe extends JFrame
{
    private final JTextField[] cells = new JTextField[9];
    private final GridLayout gridLayout = new GridLayout(3,3, 4, 4);

    public TicTacToe()
    {        
        super("Tic Tac Toe");
        setLayout(gridLayout);
        Font font = new Font("Arial",Font.BOLD,120);
        for(int i=0;i<9;i++){
            cells[i] = new JTextField(" ");
            cells[i].setFont(font);
            cells[i].setHorizontalAlignment(SwingConstants.CENTER);
            cells[i].setEditable(false);
            cells[i].addMouseListener(new ClickListener());
            add(cells[i]);
        }
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setSize(600, 600);
        ticTacToe.setVisible(true);
    }

    private class ClickListener extends MouseAdapter
    {
        private boolean gameOver = false;

        public void mouseClicked(MouseEvent e)
        {
            if (this.endGame()){
                JOptionPane.showMessageDialog(TicTacToe.this, "Acabou o jogo!");
                return;
            }    

            JTextField clickedCell = (JTextField) e.getSource();            
            String symbol;
            symbol = clickedCell.getText();
            if (this.isFilled(symbol)){
                JOptionPane.showMessageDialog(TicTacToe.this, "Célula preenchida. Clique em outra");
                return;
            }
            clickedCell.setText("0");
            Random random = new Random();
            int attempts = 0;
            int i = 0;
            JTextField oponentCell;
            while(attempts < 9){                
                i = random.nextInt(8);
                oponentCell = TicTacToe.this.cells[i];
                symbol = oponentCell.getText();
                if (!this.isFilled(symbol))
                {
                    oponentCell.setText("1");
                    break;
                }
                attempts++;                
            }
            if (this.endGame()){
                JOptionPane.showMessageDialog(TicTacToe.this, "Acabou o jogo!");
                return;
            }
        }

        private boolean isFilled(String symbol){
            return symbol.equals("0") || symbol.equals("1");
        }

        private boolean endGame()
        {
            if (this.gameOver){
                return true;
            }

            if (this.someoneWon()){
                this.gameOver = true;
                return true;
            }

            boolean endGame = true;            

            JTextField[] cells = TicTacToe.this.cells; 

            for(int i=0;i<9;i++){
                if (cells[i].getText().equals(" ")){
                    endGame = false;
                    break;
                }
            }
            this.gameOver = endGame;
            return endGame;
        }

        private boolean someoneWon()
        {
            boolean someoneWon = false;
            JTextField[] cells = TicTacToe.this.cells;
            int i;
            // horizontais
            for(i=0;i<3;i++){
                if (this.isCellsEquals(i, i+1, i+2)){
                    if (cells[0].getText().equals("0")){
                        JOptionPane.showMessageDialog(TicTacToe.this, "Você ganhou!");
                    } else {
                        JOptionPane.showMessageDialog(TicTacToe.this, "Você perdeu!");
                    }
                    return true;
                }
            }
            // verticais
            for(i=0;i<3;i++){
                if (this.isCellsEquals(i, i+3, i+6)){
                    if (cells[0].getText().equals("0")){
                        JOptionPane.showMessageDialog(TicTacToe.this, "Você ganhou!");
                    } else {
                        JOptionPane.showMessageDialog(TicTacToe.this, "Você perdeu!");
                    }
                    return true;
                }
            }
            // diagonais
            if (this.isCellsEquals(0, 4, 8) || this.isCellsEquals(2, 4, 6)){
                if (cells[0].getText().equals("0")){
                    JOptionPane.showMessageDialog(TicTacToe.this, "Você ganhou!");
                } else {
                    JOptionPane.showMessageDialog(TicTacToe.this, "Você perdeu!");
                }
                return true;
            }
            
            return someoneWon;
        }
    
        private boolean isCellsEquals(int first, int second, int third)
        {
            JTextField[] cells = TicTacToe.this.cells;       
            return !cells[first].getText().equals(" ") && 
                cells[first].getText().equals(cells[second].getText()) &&
                cells[second].getText().equals(cells[third].getText());
        }    
    }
}