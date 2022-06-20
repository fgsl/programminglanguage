// Demonstrando JPopupMenus.
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ButtonGroup;

public class PopupFrame extends JFrame {
	private final JRadioButtonMenuItem[] items; // contém itens para cores
	private final Color[] colorValues = { Color.BLUE, Color.YELLOW, Color.RED }; // cores a serem utilizadas
	private final JPopupMenu popupMenu; // permite que o usuário selecione a cor

	// construtor sem argumento configure a GUI
	public PopupFrame() {
		super("Using JPopupMenus");
		ItemHandler handler = new ItemHandler(); // rotina de tratamento para itens de menu
		String[] colors = { "Blue", "Yellow", "Red" };
		ButtonGroup colorGroup = new ButtonGroup(); // gerencia itens de cor
		popupMenu = new JPopupMenu(); // cria menu pop-up
		items = new JRadioButtonMenuItem[colors.length];

		// cria item de menu, adiciona-o ao menu pop-up, permite tratamento de eventos
		for (int count = 0; count < items.length; count++) {
			items[count] = new JRadioButtonMenuItem(colors[count]);
			popupMenu.add(items[count]); // adiciona o item ao menu pop-up
			colorGroup.add(items[count]); // adiciona o item ao grupo de botões
			items[count].addActionListener(handler); // adiciona handler
		}

		setBackground(Color.WHITE);
		// declara um MouseListener para a janela a fim de exibir o menu pop-up
		addMouseListener(new MouseAdapter() // classe interna anônima
		{
			// trata eventos de pressionamento do mouse
			@Override
			public void mousePressed(MouseEvent event) {
				checkForTriggerEvent(event);
			}

			// trata eventos de liberação de botão do mouse
			@Override
			public void mouseReleased(MouseEvent event) {
				checkForTriggerEvent(event);
			}

			// determina se o evento deve acionar o menu pop-up
			private void checkForTriggerEvent(MouseEvent event) {
				if (event.isPopupTrigger())
					popupMenu.show(event.getComponent(), event.getX(), event.getY());
			}

		});
	} // fim do construtor PopupFrame
		// classe interna privada para tratar eventos de item de menu

	private class ItemHandler implements ActionListener {
		// processa seleções de itens de menu
		@Override
		public void actionPerformed(ActionEvent event) {
			// determina qual item de menu foi selecionado
			for (int i = 0; i < items.length; i++) {
				if (event.getSource() == items[i]) {
					getContentPane().setBackground(colorValues[i]);
					return;
				}
			}
		}
	} // fim da classe interna privada ItemHandler
} // fim da classe PopupFrame
