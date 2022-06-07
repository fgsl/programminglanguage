import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import javafx.scene.control.Button;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class Calculadora extends JFrame{

    private final GridLayout gridBottons = new GridLayout(5,7,4,4);
    private final GridLayout gridPainel = new GridLayout(2,1);
    private final Panel visorPainel = new Panel();
    private final Panel botoesPainel = new Panel();
    private final JTextField visor = new JTextField("");
    private final Font fontevisor = new Font("Arial", Font.PLAIN, 20);
    private Double acumulador;
    private Boolean usouVirgula = false;
    private String operacao;
    private final JLabel memoria = new JLabel("");

    public Calculadora()
    {
        super("Calculadora");
        this.setLayout(gridPainel);
        visor.setColumns(35);
        visor.setFont(fontevisor);
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        visorPainel.setLayout(new FlowLayout());
        visorPainel.add(visor);
        this.add(visorPainel);
        this.adicionarBotoes(botoesPainel);
        botoesPainel.setLayout(gridBottons);
        this.add(botoesPainel);
        
    }

    private void adicionarBotoes(Panel botoesPainel)
    {
        this.adicionarBotoesDaPrimeiraLinha(botoesPainel);
        this.adicionarBotoesDaSegundaLinha(botoesPainel);
        this.adicionarBotoesDaTerceiraLinha(botoesPainel);
        this.adicionarBotoesDaQuartaLinha(botoesPainel);
        this.adicionarBotoesDaQuintaLinha(botoesPainel);

    }

    private void adicionarBotoesDaPrimeiraLinha(Panel botoePanel){
        //Primeira linha
        botoesPainel.add(this.fabricarBotao("?"));
        botoesPainel.add(this.fabricarBotao("BIN"));
        botoesPainel.add(this.fabricarBotao("x!"));
        botoesPainel.add(this.fabricarBotao("("));
        botoesPainel.add(this.fabricarBotao(")"));
        botoesPainel.add(this.fabricarBotao("%"));
        botoesPainel.add(this.fabricarBotao("AC"));

    }

    private void adicionarBotoesDaSegundaLinha(Panel botoePanel){
        //segunda linha
        botoesPainel.add(this.fabricarBotao("HEX"));
        botoesPainel.add(this.fabricarBotao("SIN"));
        botoesPainel.add(this.fabricarBotao("IN"));
        botoesPainel.add(this.fabricarBotao("7"));
        botoesPainel.add(this.fabricarBotao("8"));
        botoesPainel.add(this.fabricarBotao("9"));
        botoesPainel.add(this.fabricarBotao("/"));
    }

    private void adicionarBotoesDaTerceiraLinha(Panel botoePanel){

         //terceira linha
         botoesPainel.add(this.fabricarBotao("PI"));
         botoesPainel.add(this.fabricarBotao("cos"));
         botoesPainel.add(this.fabricarBotao("log"));
         botoesPainel.add(this.fabricarBotao("4"));
         botoesPainel.add(this.fabricarBotao("5"));
         botoesPainel.add(this.fabricarBotao("6"));
         botoesPainel.add(this.fabricarBotao("x"));
    }

    private void adicionarBotoesDaQuartaLinha(Panel botoePanel){

        //quarta linha
        botoesPainel.add(this.fabricarBotao("e"));
        botoesPainel.add(this.fabricarBotao("tan"));
        botoesPainel.add(this.fabricarBotao("v"));
        botoesPainel.add(this.fabricarBotao("1"));
        botoesPainel.add(this.fabricarBotao("2"));
        botoesPainel.add(this.fabricarBotao("3"));
        botoesPainel.add(this.fabricarBotao("-"));
    }

    private void adicionarBotoesDaQuintaLinha(Panel botoePanel){
        
        //quinta linha
        botoesPainel.add(this.fabricarBotao("ANS"));
        botoesPainel.add(this.fabricarBotao("EXP"));
        botoesPainel.add(this.fabricarBotao("x^y"));
        botoesPainel.add(this.fabricarBotao("0"));
        botoesPainel.add(this.fabricarBotao(","));
        botoesPainel.add(this.fabricarBotao("="));
        botoesPainel.add(this.fabricarBotao("+"));
        

    }

    private JButton fabricarBotao(String texto){

        JButton botao = new JButton(texto);
        botao.addActionListener(new ControladorDaCalculadora());
        return botao;
    }

    private class ControladorDaCalculadora implements ActionListener{
        public void actionPerformed(ActionEvent evento){

            JButton botao = (JButton) evento.getSource();

            String textoDoBotao = botao.getText();

            JTextField visor = Calculadora.this.visor;

            if(textoDoBotao.equals( "AC")){
                visor.setText("");
                return;
            }

            if(textoDoBotao.equals( "?")){
                JOptionPane.showMessageDialog(null, "Jesuel Alves Gonçalves de Lima");
                return;
            }

            Integer numero = 0;

            Boolean botaoNumerico = true;
            
            try {
                numero = Integer.parseInt(textoDoBotao);
            } catch (NumberFormatException nfe) {
                botaoNumerico = false;
            }
            
            if (botaoNumerico){
                String textoDoVisor = Calculadora.this.visor.getText();
                textoDoVisor = textoDoVisor + textoDoBotao;
                visor.setText(textoDoVisor);
                return;
            }

            if (textoDoBotao.equals(",") &&
            !visor.getText().equals("") &&
            !Calculadora.this.usouVirgula){
            visor.setText(visor.getText() + ",");
            Calculadora.this.usouVirgula = true;
            }
                    
            JLabel memoria = Calculadora.this.memoria;

            if(textoDoBotao.equals("+")||
                textoDoBotao.equals("-") ||
                textoDoBotao.equals("/") ||
                textoDoBotao.equals("X") ||
                textoDoBotao.equals("EXP") ||
                textoDoBotao.equals("log") ||
                textoDoBotao.equals("%") ){
                    Calculadora.this.operacao = textoDoBotao;
                    Calculadora.this.acumulador = Double.parseDouble(visor.getText());
                    visor.setText("");
                return;
            }

            if(textoDoBotao.equals("=")){
                String operacao = Calculadora.this.operacao;
                Double acumulador = Calculadora.this.acumulador;
                Double resultado = 0.0;
                Double valorAtual = Double.parseDouble(visor.getText());

                switch(operacao){
                    case "+":
                        resultado = acumulador + valorAtual;
                        break;
                        
                    case "-":
                        resultado = acumulador - valorAtual;
                        break;

                    case "X":
                        resultado = acumulador * valorAtual;
                        break;

                    case "/":
                        resultado = acumulador / valorAtual;
                        
                        break;
                    
                    case "EXP": 
                        resultado =  (10 * 10) * valorAtual; 

                        break;

                    case "log":
                        resultado = 10 * valorAtual; 

                        break;

                    case "%":
                        valorAtual = 100.0;
                        resultado = acumulador / valorAtual; 

                        break;    

                    default:
                        break;
                }
                visor.setText(String.valueOf(resultado));
            }
        }
    }
    public static void main (String[] args){
        Calculadora calculadora = new Calculadora();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculadora.setSize(600,600);
        calculadora.setVisible(true);

    }
    
}