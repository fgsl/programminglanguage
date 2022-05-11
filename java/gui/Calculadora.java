import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Panel;

public class Calculadora extends JFrame {
    private final GridLayout gridBotoes = new GridLayout(4,6,4,4);
    private final GridLayout gridPainel = new GridLayout(2,1);
    private final Panel visorPainel = new Panel();
    private final Panel botoesPainel = new Panel();


    public Calculadora()
    {
        super("Calculadora");
        this.setLayout(gridPainel);
        this.add(visorPainel);
        this.add(botoesPainel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);
    }



    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
    }
}
