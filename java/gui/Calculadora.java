import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class Calculadora extends JFrame {
    private final GridLayout gridBotoes = new GridLayout(5,7,4,4);
    private final GridLayout gridPainel = new GridLayout(2,1);
    private final Panel visorPainel = new Panel();
    private final Panel botoesPainel = new Panel();
    private final JTextField visor = new JTextField("");
    private final Font fonteVisor = new Font("Arial", Font.PLAIN, 20);


    public Calculadora()
    {
        super("Calculadora");
        this.setLayout(gridPainel);        
        visor.setColumns(35);
        visor.setFont(fonteVisor);        
        visorPainel.setLayout(new FlowLayout());
        visorPainel.add(visor);
        this.add(visorPainel);
        this.adicionarBotoes(botoesPainel);
        botoesPainel.setLayout(gridBotoes);
        this.add(botoesPainel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);
    }

    private void adicionarBotoes(Panel botoesPainel)
    {
        // primeira linha
        botoesPainel.add(new JButton("?"));
        botoesPainel.add(new JButton("BIN"));
        botoesPainel.add(new JButton("x!"));
        botoesPainel.add(new JButton("("));
        botoesPainel.add(new JButton(")"));
        botoesPainel.add(new JButton("%"));
        botoesPainel.add(new JButton("AC"));

        // segunda linha
        botoesPainel.add(new JButton("HEX"));
        botoesPainel.add(new JButton("sin"));
        botoesPainel.add(new JButton("ln"));
        botoesPainel.add(new JButton("7"));
        botoesPainel.add(new JButton("8"));
        botoesPainel.add(new JButton("9"));
        botoesPainel.add(new JButton("/"));

        // terceira linha
        botoesPainel.add(new JButton("PI"));
        botoesPainel.add(new JButton("cos"));
        botoesPainel.add(new JButton("log"));
        botoesPainel.add(new JButton("4"));
        botoesPainel.add(new JButton("5"));
        botoesPainel.add(new JButton("6"));
        botoesPainel.add(new JButton("X"));

        // quarta linha
        botoesPainel.add(new JButton("e"));
        botoesPainel.add(new JButton("tan"));
        botoesPainel.add(new JButton("V"));
        botoesPainel.add(new JButton("1"));
        botoesPainel.add(new JButton("2"));
        botoesPainel.add(new JButton("3"));
        botoesPainel.add(new JButton("-"));

        // quinta linha
        botoesPainel.add(new JButton("ANS"));
        botoesPainel.add(new JButton("EXP"));
        botoesPainel.add(new JButton("x^y"));
        botoesPainel.add(new JButton("0"));
        botoesPainel.add(new JButton("."));
        botoesPainel.add(new JButton("="));
        botoesPainel.add(new JButton("+"));

    }









    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
    }
}
