import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.*;

//import sun.swing.table.DefaultTableCellHeaderRenderer;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class GUI_bag extends JFrame{
	protected JFrame frame;
	private final Color alphaZero = new Color(0, true);

    public GUI_bag() {
        pokemoninBag();
    }

    private void pokemoninBag(){

		Trainer pp = new Trainer();
		ArrayList<Pokemon> pok = new ArrayList<Pokemon>();
		//
		pok = Trainer.getBag();

        frame = new JFrame("Pokemon Game");
        frame.setResizable(false);
		frame.setBounds(0, 0, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("image/pokemonicon.png");
        frame.setIconImage(img.getImage());
        
        JButton btn_menu = new JButton("");
		btn_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_MainMenu mn = new GUI_MainMenu();
        		mn.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_menu.setIcon(new ImageIcon("image/b_menu.png"));
		btn_menu.setBounds(10, 10, 85, 40);
		frame.getContentPane().add(btn_menu);

		// Table
		JTable table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// ScrollPane for Table
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 150, 800, 350);
		scrollPane.setViewportView(table);
		frame.getContentPane().add(scrollPane);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());

		//pp.printPokemon(Trainer.getBag());
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addRow(new Object[0]);
		model.addRow(new Object[0]);
		
		

		int number = 0;
        for(Pokemon p: Trainer.getBag()){
			System.out.println(number + " " + p.getName()); // print pokemon in pokemons ArrayList
			model.addColumn("HP : " + p.getHP());
			model.setValueAt("" + p.getName(), 0, number);
			table.getColumnModel().getColumn(number).setPreferredWidth(200); 
			number++;
        }
		
		//table.getTableHeader().setOpaque(false);
		table.getTableHeader().setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		table.getTableHeader().setForeground(Color.blue);
		table.getTableHeader().setBackground(alphaZero);
		table.getTableHeader().setResizingAllowed(false);
		//table.getTableHeader().setBorder(BorderFactory.createEmptyBorder());
		table.setForeground(Color.black);
		table.setCellSelectionEnabled(false);
		table.setFocusable(false);
		table.setOpaque(false);
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.setShowGrid(false);
		table.setRowHeight(0, 50);
		table.setRowHeight(1, 200); 
		table.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		table.setEnabled(false);
		UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));


		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		centerRenderer.setOpaque(false);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
	
        JLabel Lab_pokbag = new JLabel(" ");
		Lab_pokbag.setIcon(new ImageIcon("image/pokemoninbag.png"));
		Lab_pokbag.setBounds(200, 30, 400, 80);
		frame.getContentPane().add(Lab_pokbag);

        JLabel Lab_bagbg = new JLabel(" ");
		Lab_bagbg.setIcon(new ImageIcon("image/bg_bag.gif"));
		Lab_bagbg.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(Lab_bagbg);
    }
}

