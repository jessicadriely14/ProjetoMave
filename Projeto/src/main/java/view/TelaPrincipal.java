package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JDesktopPane desktop = new JDesktopPane();
		desktop.setBackground(new Color(139, 69, 19));
		frame.getContentPane().add(desktop, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuCadastro = new JMenu("Cadastros");
		menuCadastro.setBackground(new Color(222, 184, 135));
		menuBar.add(menuCadastro);
		
		JMenuItem menuProfessor = new JMenuItem("Professor");
		menuProfessor.setBackground(new Color(222, 184, 135));
		menuProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		menuProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCRUDProfessor tela = new TelaCRUDProfessor();
				tela.setVisible(true);
				desktop.add(tela);
			}
			
		});
		menuCadastro.add(menuProfessor);
		
		JSeparator separator = new JSeparator();
		menuCadastro.add(separator);
		
		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.setBackground(new Color(222, 184, 135));
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuSair.setHorizontalAlignment(SwingConstants.CENTER);
		menuCadastro.add(menuSair);
		
		JMenu menuConsulta = new JMenu("Consulta");
		menuConsulta.setBackground(new Color(222, 184, 135));
		menuBar.add(menuConsulta);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.setBackground(new Color(222, 184, 135));
		menuBar.add(menuAjuda);
	}
}
