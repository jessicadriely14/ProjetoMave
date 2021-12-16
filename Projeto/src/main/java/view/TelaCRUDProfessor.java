package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import control.ProfessorControle;
import model.Professor;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCRUDProfessor extends JInternalFrame {
	private Professor objeto;
	private ProfessorControle controle = new ProfessorControle();
	
	
	private JTextField textID;
	private JTextField textNome;
	private JTextField textSituacao;
	private JTextField textDtNasc;
	private JTextField textCPF;
	private JTextField textEmail;
	private JTextField textSexo;
	private JButton btnFechar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCRUDProfessor frame = new TelaCRUDProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCRUDProfessor() {
		setBounds(100, 100, 538, 298);
		
		JLabel lblTitulo = new JLabel("Cadastro de Professores");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitulo, BorderLayout.NORTH);
		
		JPanel painelCampos = new JPanel();
		painelCampos.setBackground(new Color(245, 222, 179));
		getContentPane().add(painelCampos, BorderLayout.CENTER);
		
		JLabel lblD = new JLabel("ID :");
		lblD.setHorizontalAlignment(SwingConstants.LEFT);
		
		textID = new JTextField();
		textID.setBackground(new Color(255, 255, 255));
		textID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome :");
		
		JLabel lblSituacao = new JLabel("Situa\u00E7\u00E3o :");
		
		JLabel lblDtNasc = new JLabel("Data de Nascimento :");
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		JLabel lblCPF = new JLabel("CPF :");
		
		JLabel lblEmail = new JLabel("E-mail :");
		
		JLabel lblSexo = new JLabel("Sexo :");
		
		textNome = new JTextField();
		textNome.setBackground(new Color(255, 255, 255));
		textNome.setColumns(10);
		
		textSituacao = new JTextField();
		textSituacao.setBackground(new Color(255, 255, 255));
		textSituacao.setColumns(10);
		
		textDtNasc = new JTextField();
		textDtNasc.setBackground(new Color(255, 255, 255));
		textDtNasc.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setBackground(new Color(255, 255, 255));
		textCPF.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBackground(new Color(255, 255, 255));
		textEmail.setColumns(10);
		
		textSexo = new JTextField();
		textSexo.setBackground(new Color(255, 255, 255));
		textSexo.setColumns(10);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBackground(new Color(222, 184, 135));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objeto = new Professor(null, textNome.getText(), textSituacao.getText(),
						textDtNasc.getText(), textCPF.getText(), textEmail.getText(),
						textSexo.getText());
				controle.inserir(objeto);
				JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso.");
				textID.setText(String.valueOf(objeto.getId()));
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(new Color(222, 184, 135));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(objeto != null) {
					objeto.setNome(textNome.getText());
					objeto.setSituacao(textSituacao.getText());
					objeto.setDtnasc(textDtNasc.getText());
					objeto.setCpf(textCPF.getText());
					objeto.setEmail(textEmail.getText());
					objeto.setSexo(textSexo.getText());
					controle.alterar(objeto);
					JOptionPane.showMessageDialog(null, "Professor alterado com sucesso.");
				}else {
					JOptionPane.showConfirmDialog(null, "Não há professor para ser modificado.");
					limparTela();
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(222, 184, 135));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(objeto != null) {
					controle.excluir(objeto);
					limparTela();
					JOptionPane.showMessageDialog(null, "Professor excluído com sucesso");
				}else {
					JOptionPane.showMessageDialog(null,"Não há professor para ser excluído.");
				}
				limparTela();
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(222, 184, 135));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer valor = Integer.parseInt(textID.getText());
				objeto = controle.buscarPorId(valor);
				if(objeto != null) {
					textID.setText(String.valueOf(objeto.getId()));
					textNome.setText(objeto.getNome());
					textSituacao.setText(objeto.getSituacao());
					textDtNasc.setText(objeto.getDtnasc());
					textCPF.setText(objeto.getCpf());
					textEmail.setText(objeto.getEmail());
					textSexo.setText(objeto.getSexo());
				}else {
					JOptionPane.showMessageDialog(null, "Não existe professor com o código digitado.");
					textID.setText("");
				}
			}
		});
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBackground(new Color(222, 184, 135));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color(222, 184, 135));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		GroupLayout gl_painelCampos = new GroupLayout(painelCampos);
		gl_painelCampos.setHorizontalGroup(
			gl_painelCampos.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painelCampos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelCampos.createSequentialGroup()
							.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelCampos.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDtNasc)
										.addComponent(lblCPF)
										.addComponent(lblEmail)
										.addComponent(lblNewLabel)
										.addComponent(lblD, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSituacao))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
										.addComponent(textSituacao, 179, 187, Short.MAX_VALUE)
										.addComponent(textEmail, Alignment.TRAILING, 179, 187, Short.MAX_VALUE)
										.addComponent(textSexo, Alignment.TRAILING, 179, 187, Short.MAX_VALUE)
										.addComponent(textID, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addComponent(textNome, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addComponent(textDtNasc, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addComponent(textCPF, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
								.addComponent(lblNewLabel_3))
							.addGap(54))
						.addGroup(gl_painelCampos.createSequentialGroup()
							.addGap(10)
							.addComponent(lblSexo)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAlterar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(btnInserir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(btnExcluir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(btnFechar, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_painelCampos.setVerticalGroup(
			gl_painelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCampos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblD)
						.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSituacao)
						.addComponent(textSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDtNasc)
						.addComponent(textDtNasc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_painelCampos.createSequentialGroup()
							.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCPF)
								.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel_3))
					.addGap(6)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSexo)
						.addComponent(textSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57))
				.addGroup(gl_painelCampos.createSequentialGroup()
					.addGap(51)
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConsultar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFechar)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		painelCampos.setLayout(gl_painelCampos);

	}

	public void limparTela() {
		objeto = null;
		textID.setText("");
		textNome.setText("");
		textSituacao.setText("");
		textDtNasc.setText("");
		textCPF.setText("");
		textEmail.setText("");
		textSexo.setText("");
	}
}

	
	
	
