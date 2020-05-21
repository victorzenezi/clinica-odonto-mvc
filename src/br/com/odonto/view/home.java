package br.com.odonto.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;

import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class home {

	private JFrame frmClinicaOdontolgica;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frmClinicaOdontolgica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public home() {
		initialize();
	}

	private void initialize(){
		frmClinicaOdontolgica = new JFrame();
		frmClinicaOdontolgica.setIconImage(Toolkit.getDefaultToolkit().getImage(home.class.getResource("/images/fav.png")));
		frmClinicaOdontolgica.setTitle("Clinica Odontol\u00F3gica");
		frmClinicaOdontolgica.setResizable(false);
		frmClinicaOdontolgica.setBounds(100, 100, 1066, 603);
		frmClinicaOdontolgica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClinicaOdontolgica.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(38, 70, 83));
		panel.setBounds(0, 0, 245, 564);
		frmClinicaOdontolgica.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(244, 0, 806, 564);
		frmClinicaOdontolgica.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel tela_dentistas = new JPanel();
		layeredPane.add(tela_dentistas, "name_72381362201800");
		tela_dentistas.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Especialidade"
			}
		));
		table.setBounds(238, 245, 344, 265);
		tela_dentistas.add(table);
		
		JPanel tela_pacientes = new JPanel();
		layeredPane.add(tela_pacientes, "name_72381383160800");
		tela_pacientes.setLayout(null);
		
		JLabel lblEstouEmPacientes = new JLabel("ESTOU EM PACIENTES");
		lblEstouEmPacientes.setBounds(323, 207, 227, 14);
		tela_pacientes.add(lblEstouEmPacientes);
		
		JPanel tela_agenda = new JPanel();
		layeredPane.add(tela_agenda, "name_72416477775900");
		tela_agenda.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ESTOU EM AGENDA");
		lblNewLabel_1.setBounds(251, 177, 266, 115);
		tela_agenda.add(lblNewLabel_1);
		
		JPanel tela_consultas = new JPanel();
		layeredPane.add(tela_consultas, "name_72439954133900");
		tela_consultas.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ESTOU EM CONSULTAS");
		lblNewLabel_2.setBounds(283, 188, 338, 181);
		tela_consultas.add(lblNewLabel_2);

		
		JButton btnNewButton_1 = new JButton("Clinica Odontol\u00F3gica");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Century", Font.PLAIN, 23));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(new Color(38, 70, 83));
		btnNewButton_1.setBounds(0, 11, 245, 66);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_3 = new JButton(" Consultas");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela_dentistas.setVisible(false);
				tela_pacientes.setVisible(false);
				tela_agenda.setVisible(false);
				tela_consultas.setVisible(true);
			}
		});
		btnNewButton_1_3.setIcon(new ImageIcon(home.class.getResource("/images/check.png")));
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setFont(new Font("Century", Font.PLAIN, 20));
		btnNewButton_1_3.setFocusPainted(false);
		btnNewButton_1_3.setBorder(null);
		btnNewButton_1_3.setBackground(new Color(38, 70, 83));
		btnNewButton_1_3.setBounds(0, 363, 245, 66);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_3_1 = new JButton("    Agenda");
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela_dentistas.setVisible(false);
				tela_pacientes.setVisible(false);
				tela_agenda.setVisible(true);
				tela_consultas.setVisible(false);
			}
		});
		btnNewButton_1_3_1.setIcon(new ImageIcon(home.class.getResource("/images/agenda.png")));
		btnNewButton_1_3_1.setForeground(Color.WHITE);
		btnNewButton_1_3_1.setFont(new Font("Century", Font.PLAIN, 20));
		btnNewButton_1_3_1.setFocusPainted(false);
		btnNewButton_1_3_1.setBorder(null);
		btnNewButton_1_3_1.setBackground(new Color(38, 70, 83));
		btnNewButton_1_3_1.setBounds(0, 286, 245, 66);
		panel.add(btnNewButton_1_3_1);
		
		JButton btnNewButton_1_3_2 = new JButton(" Pacientes");
		btnNewButton_1_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela_dentistas.setVisible(false);
				tela_pacientes.setVisible(true);
				tela_agenda.setVisible(false);
				tela_consultas.setVisible(false);
			}
		});
		btnNewButton_1_3_2.setIcon(new ImageIcon(home.class.getResource("/images/paciente.png")));
		btnNewButton_1_3_2.setForeground(Color.WHITE);
		btnNewButton_1_3_2.setFont(new Font("Century", Font.PLAIN, 20));
		btnNewButton_1_3_2.setFocusPainted(false);
		btnNewButton_1_3_2.setBorder(null);
		btnNewButton_1_3_2.setBackground(new Color(38, 70, 83));
		btnNewButton_1_3_2.setBounds(0, 209, 245, 66);
		panel.add(btnNewButton_1_3_2);
		
		JButton btnNewButton_1_3_2_1 = new JButton("Sair");
		btnNewButton_1_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_3_2_1.setForeground(Color.WHITE);
		btnNewButton_1_3_2_1.setFont(new Font("Century", Font.PLAIN, 20));
		btnNewButton_1_3_2_1.setFocusPainted(false);
		btnNewButton_1_3_2_1.setBorder(null);
		btnNewButton_1_3_2_1.setBackground(new Color(38, 70, 83));
		btnNewButton_1_3_2_1.setBounds(0, 511, 245, 53);
		panel.add(btnNewButton_1_3_2_1);
		
		JButton btnNewButton_1_3_2_2 = new JButton(" Dentistas");
		btnNewButton_1_3_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela_dentistas.setVisible(true);
				tela_pacientes.setVisible(false);
				tela_agenda.setVisible(false);
				tela_consultas.setVisible(false);
			}
		});
		btnNewButton_1_3_2_2.setIcon(new ImageIcon(home.class.getResource("/images/dentista.png")));
		btnNewButton_1_3_2_2.setForeground(Color.WHITE);
		btnNewButton_1_3_2_2.setFont(new Font("Century", Font.PLAIN, 20));
		btnNewButton_1_3_2_2.setFocusPainted(false);
		btnNewButton_1_3_2_2.setBorder(null);
		btnNewButton_1_3_2_2.setBackground(new Color(38, 70, 83));
		btnNewButton_1_3_2_2.setBounds(0, 140, 245, 66);
		panel.add(btnNewButton_1_3_2_2);

	

	}
}
