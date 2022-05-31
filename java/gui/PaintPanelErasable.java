// Classe de adaptadores utilizada para implementar rotinas de tratamento de evento.
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaintPanelErasable extends JPanel
{
    // lista das referências Point
    private final ArrayList<Point> points = new ArrayList<>();
    private final BorderLayout layout = new BorderLayout();
    private final JButton limpar = new JButton("limpar");
    private boolean limpeza = false;

    // configura GUI e registra rotinas de tratamento de evento de mouse
    public PaintPanelErasable()
    {
        setLayout(layout);

        limpar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event)
            {
                PaintPanelErasable.this.limpeza = true;
                repaint();        
            }

        });

        this.add(this.limpar,BorderLayout.SOUTH);    

        // trata evento de movimento de mouse do frame
        addMouseMotionListener(
            new MouseMotionAdapter() // classe interna anônima
            {
                // armazena coordenadas da ação de arrastar e repinta
                @Override
                public void mouseDragged(MouseEvent event)
                {
                    points.add( event.getPoint() );
                    PaintPanelErasable.this.limpeza = false;
                    repaint(); // repinta JFrame
                }
            }
        );
    }
    // desenha ovais em um quadro delimitador de 4 x 4 nas localizações especificadas na janela
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // limpa a área de desenho
        if (PaintPanelErasable.this.limpeza){
            points.clear();
            return;
        }
        // desenha todos os pontos
        int i = 0;
        for (Point point : points) {
            if (i % 2 == 0){
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.RED);
            }
            //g.fillOval(point.x, point.y , 8, 8);
            g.fillRect(point.x, point.y , 20, 20);
            i++;            
        }
        //int size = points.size();  
        //g.fillOval(points.get(size-1).x,points.get(size-1).y,20,20);
   }
} // fim da classe PaintPanel
