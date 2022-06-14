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

public class Calculadora extends JFrame {
    private final String raizquadrada = "\u221A";
    private final GridLayout gridBotoes = new GridLayout(5,7,4,4);
    private final GridLayout gridPainel = new GridLayout(2,1);
    private final Panel visorPainel = new Panel();
    private final Panel botoesPainel = new Panel();
    private final JTextField visor = new JTextField("");
    private final Font fonteVisor = new Font("Arial", Font.PLAIN, 20);
    private final JLabel memoria = new JLabel("");
    private Double acumulador;
    private Boolean usouVirgula = false;
    private Boolean limpar = false;
    private String operacao;

    public Calculadora()
    {
        super("Calculadora");
        this.setLayout(gridPainel);        
        visor.setColumns(35);
        visor.setFont(fonteVisor);
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        visorPainel.setLayout(new BorderLayout());
        visorPainel.add(visor,BorderLayout.NORTH);
        memoria.setFont(fonteVisor);
        memoria.setHorizontalAlignment(SwingConstants.RIGHT);;
        visorPainel.add(memoria,BorderLayout.SOUTH);
        this.add(visorPainel);
        this.adicionarBotoes(botoesPainel);
        botoesPainel.setLayout(gridBotoes);
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

    private void adicionarBotoesDaPrimeiraLinha(Panel botoesPainel)
    {
        // primeira linha
        botoesPainel.add(this.fabricarBotao("?"));
        botoesPainel.add(this.fabricarBotao("BIN"));
        botoesPainel.add(this.fabricarBotao("x!"));
        botoesPainel.add(this.fabricarBotao("-n"));
        botoesPainel.add(this.fabricarBotao("1/x"));
        botoesPainel.add(this.fabricarBotao("%"));
        botoesPainel.add(this.fabricarBotao("AC"));
    }

    private void adicionarBotoesDaSegundaLinha(Panel botoesPainel)
    {
        // segunda linha
        botoesPainel.add(this.fabricarBotao("HEX"));
        botoesPainel.add(this.fabricarBotao("sin"));
        botoesPainel.add(this.fabricarBotao("ln"));
        botoesPainel.add(this.fabricarBotao("7"));
        botoesPainel.add(this.fabricarBotao("8"));
        botoesPainel.add(this.fabricarBotao("9"));
        botoesPainel.add(this.fabricarBotao("/"));
    }    

    private void adicionarBotoesDaTerceiraLinha(Panel botoesPainel)
    {
        // terceira linha
        botoesPainel.add(this.fabricarBotao("PI"));
        botoesPainel.add(this.fabricarBotao("cos"));
        botoesPainel.add(this.fabricarBotao("log"));
        botoesPainel.add(this.fabricarBotao("4"));
        botoesPainel.add(this.fabricarBotao("5"));
        botoesPainel.add(this.fabricarBotao("6"));
        botoesPainel.add(this.fabricarBotao("X"));
    }    

    private void adicionarBotoesDaQuartaLinha(Panel botoesPainel)
    {
        // quarta linha
        botoesPainel.add(this.fabricarBotao("e"));
        botoesPainel.add(this.fabricarBotao("tan"));
        botoesPainel.add(this.fabricarBotao(Calculadora.this.raizquadrada));
        botoesPainel.add(this.fabricarBotao("1"));
        botoesPainel.add(this.fabricarBotao("2"));
        botoesPainel.add(this.fabricarBotao("3"));
        botoesPainel.add(this.fabricarBotao("-"));
    }    

    private void adicionarBotoesDaQuintaLinha(Panel botoesPainel)
    {
        // quinta linha
        botoesPainel.add(this.fabricarBotao("ANS"));
        botoesPainel.add(this.fabricarBotao("EXP"));
        botoesPainel.add(this.fabricarBotao("x^y"));
        botoesPainel.add(this.fabricarBotao("0"));
        botoesPainel.add(this.fabricarBotao(","));
        botoesPainel.add(this.fabricarBotao("="));
        botoesPainel.add(this.fabricarBotao("+"));
    }

    private JButton fabricarBotao(String texto)
    {
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

            if (textoDoBotao.equals("AC")){
                visor.setText("");
                Calculadora.this.usouVirgula = false;
                Calculadora.this.memoria.setText("");
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
                if (Calculadora.this.limpar){
                    visor.setText("");
                    Calculadora.this.limpar = false;
                    Calculadora.this.usouVirgula = false;
                } 
                
                String textoDoVisor = visor.getText();
                textoDoVisor = textoDoVisor + textoDoBotao;
                visor.setText(textoDoVisor);
                return;
            }

            if(textoDoBotao.equals("?")) {
                String sobre = "Adrian Torquetti";
                JOptionPane.showMessageDialog(null, sobre);
            }

            if (textoDoBotao.equals("PI")){
                visor.setText(String.valueOf(Math.PI));
                return;
            }
            if (textoDoBotao.equals("e")){
                visor.setText(String.valueOf(2.71828182846));
                return;
            }

            if (textoDoBotao.equals("cos")){
                acumulador = Double.parseDouble(visor.getText());
                visor.setText(String.valueOf(Math.cos(acumulador)));
                return;
            }
            
            if (textoDoBotao.equals("sin")){
                acumulador = Double.parseDouble(visor.getText());
                visor.setText(String.valueOf(Math.sin(acumulador)));
                return;
            }
            
            if (textoDoBotao.equals("tan")){
                acumulador = Double.parseDouble(visor.getText());
                visor.setText(String.valueOf(Math.tan(acumulador)));
                return;
            }            
            
            if (textoDoBotao.equals(Calculadora.this.raizquadrada)){
                acumulador = Double.parseDouble(visor.getText());
                visor.setText(String.valueOf(Math.sqrt(acumulador)));
                return;
            }

            if (textoDoBotao.equals("HEX")){
                acumulador = Double.parseDouble(visor.getText());
                visor.setText(Integer.toHexString(acumulador.intValue()));
                return;
            }

            if (textoDoBotao.equals("BIN")){
                acumulador = Double.parseDouble(visor.getText());
                visor.setText(Integer.toBinaryString(acumulador.intValue()));
                return;
            }


            if (textoDoBotao.equals(",") &&
                !visor.getText().equals("") &&
                !Calculadora.this.usouVirgula){
                visor.setText(visor.getText() + ",");
                Calculadora.this.usouVirgula = true;
            }

            if (textoDoBotao.equals("-n")){
                acumulador = Double.parseDouble(visor.getText());
                visor.setText(String.valueOf(acumulador * (-1)));
            }

            if (textoDoBotao.equals("1/x")){
                acumulador = Double.parseDouble(visor.getText());
                visor.setText(String.valueOf(1/acumulador));
            }

            if (textoDoBotao.equals("?")){
                visor.setText(String.valueOf(acumulador));
                return;
            }

           
                        
            JLabel memoria = Calculadora.this.memoria;

            if (textoDoBotao.equals("+") ||
                textoDoBotao.equals("-") ||
                textoDoBotao.equals("/") ||
                textoDoBotao.equals("X") ||
                textoDoBotao.equals("?") ||
                textoDoBotao.equals("BIN") ||
                textoDoBotao.equals("x!") ||
                textoDoBotao.equals("HEX") ||
                textoDoBotao.equals("sin") ||
                textoDoBotao.equals("ln") ||
                textoDoBotao.equals("PI") ||
                textoDoBotao.equals("cos") ||
                textoDoBotao.equals("log") ||
                textoDoBotao.equals("e") ||
                textoDoBotao.equals("tan") ||
                textoDoBotao.equals("√") ||
                textoDoBotao.equals("ANS") ||
                textoDoBotao.equals("EXP") ||
                textoDoBotao.equals("x^y") ||
                textoDoBotao.equals(".")   ||
                textoDoBotao.equals("-n") ||
                textoDoBotao.equals("1/x") ||
                textoDoBotao.equals("%")) {
                Calculadora.this.operacao = textoDoBotao;
                Calculadora.this.acumulador = Double.parseDouble(visor.getText());
                memoria.setText(visor.getText() + textoDoBotao); 
                visor.setText("");
                return;
            }

            if (textoDoBotao.equals("=")){
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
                    case "tan":
                        resultado = Math.tan(acumulador);
                        break;
                    case "cos":
                        resultado = Math.cos(acumulador);
                        break;
                    case "ln":
                        resultado = Math.log(acumulador);
                        break;
                    case "√":
                        resultado = Math.sqrt(acumulador);
                        break;
                    case "sin":
                        resultado = Math.sin(acumulador); 
                        break;        
                    case "ANS":
                        acumulador = resultado;
                        break;
                    case "-n":
                        resultado = valorAtual * - 1;
                        break;
                    case "1/n": 
                        resultado = 1 / valorAtual;
                        break;
                    
                        
                        
                        

                    default:
                        break;
                }
                
                
                
                memoria.setText(memoria.getText() + visor.getText() + "=" + String.valueOf(resultado));
                visor.setText(String.valueOf(resultado));
                Calculadora.this.limpar = true;
            }            
        }        
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculadora.setSize(600,600);
        calculadora.setVisible(true);
    }
}