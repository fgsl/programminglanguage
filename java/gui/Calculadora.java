import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Math;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Calculadora extends JFrame {
    private final String raizquadrada = "\u221A";
    private final GridLayout gridBotoes = new GridLayout(5, 7, 4, 4);
    private final GridLayout gridPainel = new GridLayout(2, 1);
    private final Panel visorPainel = new Panel();
    private final Panel botoesPainel = new Panel();
    private final JTextField visor = new JTextField("");
    private final Font fonteVisor = new Font("Arial", Font.PLAIN, 20);
    private final JLabel memoria = new JLabel("");
    private Double acumulador;
    private Boolean usouVirgula = false;
    private Boolean limpar = false;
    private String operacao;

    public Calculadora() {
        super("Calculadora");
        this.setLayout(gridPainel);
        visor.setColumns(35);
        visor.setFont(fonteVisor);
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        visorPainel.setLayout(new BorderLayout());
        visorPainel.add(visor, BorderLayout.NORTH);
        memoria.setFont(fonteVisor);
        memoria.setHorizontalAlignment(SwingConstants.RIGHT);
        ;
        visorPainel.add(memoria, BorderLayout.SOUTH);
        this.add(visorPainel);
        this.adicionarBotoes(botoesPainel);
        botoesPainel.setLayout(gridBotoes);
        this.add(botoesPainel);
    }

    private void adicionarBotoes(Panel botoesPainel) {
        List<List<String>> listas = new ArrayList<List<String>>();
        listas.add(Arrays.asList("?", "BIN", "x!", "-n", "1/x", "%", "AC"));
        listas.add(Arrays.asList("HEX", "sin", "ln", "7", "8", "9", "/"));
        listas.add(Arrays.asList("PI", "cos", "log", "4", "5", "6", "X"));
        listas.add(Arrays.asList("e", "tan", Calculadora.this.raizquadrada, "1", "2", "3", "-"));
        listas.add(Arrays.asList("ANS", "EXP", "x^y", "0", ",", "=", "+"));
        for (List<String> lista : listas) {
            for (String texto : lista) {
                botoesPainel.add(this.fabricarBotao(texto));
            }
        }

    }

    private JButton fabricarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.addActionListener(new ControladorDaCalculadora());

        return botao;
    }

    private class ControladorDaCalculadora implements ActionListener {
        public void actionPerformed(ActionEvent evento)
        {
            JButton botao = (JButton) evento.getSource();

            String textoDoBotao = botao.getText();

            JTextField visor = Calculadora.this.visor;

            if (this.botaoAC(textoDoBotao)){
                return;
            }

            if (this.botaoNumerico(textoDoBotao)){
                return;
            }

            if (this.botaoSobre(textoDoBotao)){
                return;
            }

            if (this.botaoConstante(textoDoBotao)){
                return;
            }

            if (this.botaoTrigonometrico(textoDoBotao)){
                return;
            }
            
            if (textoDoBotao.equals(Calculadora.this.raizquadrada)){
                acumulador = Double.parseDouble(visor.getText());
                visor.setText(String.valueOf(Math.sqrt(acumulador)));
                return;
            }

            if (this.botoesDeConversao(textoDoBotao)){
                return;
            }

            if (textoDoBotao.equals(",") &&
                !visor.getText().equals("") &&
                !Calculadora.this.usouVirgula){
                visor.setText(visor.getText() + ".");
                Calculadora.this.usouVirgula = true;
            }

            if (this.botaoReversoOuInverso(textoDoBotao))
            {
                return;
            }
                        
            JLabel memoria = Calculadora.this.memoria;

            if (this.botaoDeOperacao(textoDoBotao)) {
                return;
            }

            if (this.botaoIgual(textoDoBotao)){
                return;
            }
        }

        private boolean botaoAC(String textoDoBotao)
        {
            if (textoDoBotao.equals("AC")){
                visor.setText("");
                Calculadora.this.usouVirgula = false;
                Calculadora.this.memoria.setText("");
                return true;
            }
            return false;
        }
        
        private boolean botaoDeOperacao(String textoDoBotao) {
            List<String> textos = Arrays.asList("+","-","/","X","?","BIN","x!","HEX","sin","ln","PI","cos","log","e","tan","√","ANS","EXP","x^y",".","-n","1/x","%");
            for(String texto: textos){
                if (textoDoBotao.equals(texto)){
                    Calculadora.this.operacao = textoDoBotao;
                    Calculadora.this.acumulador = Double.parseDouble(visor.getText());
                    memoria.setText(visor.getText() + textoDoBotao); 
                    visor.setText("");    
                    return true;
                }
            }
            
            return false;
        } 

        private boolean botaoNumerico(String textoDoBotao) {
            Integer numero = 0;
            Boolean botaoNumerico = true;

            try {
                numero = Integer.parseInt(textoDoBotao);
            } catch (NumberFormatException nfe) {
                botaoNumerico = false;
            }

            if (botaoNumerico){
                if (Calculadora.this.limpar){
                    visor.setText("");
                    Calculadora.this.limpar = false;
                    Calculadora.this.usouVirgula = false;
                } 
                
                String textoDoVisor = visor.getText();
                textoDoVisor = textoDoVisor + textoDoBotao;
                visor.setText(textoDoVisor);
                return true;
            }
            return false;
        }

        private boolean botaoSobre(String textoDoBotao){
            if(textoDoBotao.equals("?")) {
                String sobre = "Adrian Torquetti";
                JOptionPane.showMessageDialog(null, sobre);
                return true;
            }
            return false;
        }

        private boolean botaoConstante(String textoDoBotao){
            if (textoDoBotao.equals("PI") ||
                textoDoBotao.equals("e")){
                Double valor = textoDoBotao.equals("PI") ? Math.PI : Math.E;
                visor.setText(String.valueOf(valor));
                return true;
            }
            return false;
        }

        private boolean botaoTrigonometrico(String textoDoBotao)
        {
            if (textoDoBotao.equals("cos") ||
                textoDoBotao.equals("sin") ||
                textoDoBotao.equals("tan")){
                acumulador = Double.parseDouble(visor.getText());
                Double valor = textoDoBotao.equals("cos") ? Math.cos(acumulador) : (textoDoBotao.equals("sin") ? Math.sin(acumulador) : Math.tan(acumulador));
                visor.setText(String.valueOf(valor));
                return true;
            }
            return false;
        }

        private boolean botoesDeConversao(String textoDoBotao){
            if (textoDoBotao.equals("HEX") ||
                textoDoBotao.equals("BIN")
            ){
                acumulador = Double.parseDouble(visor.getText());
                String valor = textoDoBotao.equals("HEX") ? Integer.toHexString(acumulador.intValue()) : Integer.toBinaryString(acumulador.intValue());
                visor.setText(valor);
                return true;
            }
            return false;
        }

        private boolean botaoReversoOuInverso(String textoDoBotao){
            if (textoDoBotao.equals("-n") ||
                textoDoBotao.equals("1/x")){
                acumulador = Double.parseDouble(visor.getText());
                Double valor = textoDoBotao.equals("-n") ? acumulador * (-1) : 1/acumulador;
                visor.setText(String.valueOf(valor));
                return true;
            }
            return false;
        }

        private boolean botaoIgual(String textoDoBotao){
            if (!textoDoBotao.equals("=")){
                return false;
            }

            Double resultado = 0.0;
            String valorVisor = visor.getText();
	    Double valorAtual = 0.0;
	    try { // O visor pode estar vazio
                valorAtual = Double.parseDouble(valorVisor);
	    } catch (Exception e) { // %
	        valorVisor = memoria.getText();
                valorVisor = valorVisor.replace("%","");
                valorVisor = valorVisor.replace("x!","");
                valorVisor = valorVisor.replace("PI","");
                valorVisor = valorVisor.replace("log","");
                valorVisor = valorVisor.replace("cos","");
                valorVisor = valorVisor.replace("tan","");
                valorVisor = valorVisor.replace("√","");		
     	        valorAtual = Double.parseDouble(valorVisor);	
	    }
            Double acumulador = Calculadora.this.acumulador;
            switch (Calculadora.this.operacao) {
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
                case "%":
                    resultado = acumulador / 100;
                    break;
                case "x^y":
                    resultado = Math.pow(acumulador, valorAtual);
                    break;
                case "EXP":
                    resultado = acumulador * (Math.pow(10, valorAtual));
                    break;
                case "x!": 
                    int i = 1;
                    resultado = 1.0;

                    while(i <= acumulador) {
                        resultado = resultado * i;
                        i++;
                    } 
                    break;
                case "log":
                    resultado = Math.log10(acumulador);
                    break;
                case "ln":
                    resultado = Math.log(acumulador);
                    break;
                case "ANS":
                    acumulador = resultado;
                    break;
                default:
                    break;
            }
                
            memoria.setText(memoria.getText() + visor.getText() + "=" + String.valueOf(resultado));
            visor.setText(String.valueOf(resultado));
            Calculadora.this.limpar = true;
            return true;            
        }
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculadora.setSize(600,600);
        calculadora.setVisible(true);
    }
}
