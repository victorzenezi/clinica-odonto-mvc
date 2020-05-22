package br.com.odonto.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.odondo.dao.ConsultaDao;
import br.com.odondo.dao.DentistaDao;
import br.com.odondo.dao.PacienteDao;

import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class home {

	private JFrame frmClinicaOdontolgica;
	private JTable table_1 = new JTable();
	private JTable tabelaAgenda = new JTable();
	
	private PacienteDao pacienteDao;
	private DentistaDao dentistaDao;
	private ConsultaDao consultaDao;
	private JTextField txtnome;
	private JTextField txtespecialidade;
	
	JComboBox<String> cbdentistas = new JComboBox<String>();

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
		tela_dentistas.setBackground(new Color(241, 250, 238));
		tela_dentistas.setLayout(null);
		tabelaAgenda.setCellSelectionEnabled(true);
		tabelaAgenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO", "DATA", "HORA", "OBSERVA\u00C7\u00C3O", "PROCEDIMENTO", "DENTISTA", "PACIENTE"
			}
		));
		tabelaAgenda.getColumnModel().getColumn(3).setPreferredWidth(109);
		tabelaAgenda.getColumnModel().getColumn(4).setPreferredWidth(116);
		tabelaAgenda.getColumnModel().getColumn(6).setPreferredWidth(85);
		
		tabelaAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaAgenda.setRowSelectionAllowed(false);
		tabelaAgenda.setEnabled(false);
		tabelaAgenda.setColumnSelectionAllowed(true);
		tabelaAgenda.setBounds(35, 332, 740, 172);
		
		var header = tabelaAgenda.getTableHeader();
		header.setBounds(35, 305, 137, 35);
		header.setSize(740, 25);
		tela_dentistas.add(header,BorderLayout.NORTH);
		tela_dentistas.add(tabelaAgenda);
		
		JLabel lblNewLabel_3 = new JLabel("\u00C1rea do Dentista");
		lblNewLabel_3.setForeground(new Color(42, 157, 143));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(32, 25, 172, 35);
		tela_dentistas.add(lblNewLabel_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(32, 66, 743, 9);
		tela_dentistas.add(separator_1);
		

		cbdentistas.setBounds(532, 25, 243, 35);
		tela_dentistas.add(cbdentistas);
		
		JLabel lblNewLabel_3_1 = new JLabel("Dentista");
		lblNewLabel_3_1.setForeground(new Color(42, 157, 143));
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_3_1.setBounds(443, 25, 79, 35);
		tela_dentistas.add(lblNewLabel_3_1);
		
		txtnome = new JTextField();
		txtnome.setEditable(false);
		txtnome.setFont(new Font("Arial", Font.PLAIN, 15));
		txtnome.setColumns(10);
		txtnome.setBounds(100, 86, 243, 35);
		tela_dentistas.add(txtnome);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nome");
		lblNewLabel_3_1_1.setForeground(new Color(42, 157, 143));
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_3_1_1.setBounds(35, 84, 79, 35);
		tela_dentistas.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Especialidade");
		lblNewLabel_3_1_2.setForeground(new Color(42, 157, 143));
		lblNewLabel_3_1_2.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_3_1_2.setBounds(353, 86, 137, 35);
		tela_dentistas.add(lblNewLabel_3_1_2);
		
		txtespecialidade = new JTextField();
		txtespecialidade.setEditable(false);
		txtespecialidade.setFont(new Font("Arial", Font.PLAIN, 15));
		txtespecialidade.setColumns(10);
		txtespecialidade.setBounds(500, 86, 275, 35);
		tela_dentistas.add(txtespecialidade);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel(" Agenda");
		lblNewLabel_3_1_1_1.setIcon(new ImageIcon(home.class.getResource("/images/agenda-verde.png")));
		lblNewLabel_3_1_1_1.setForeground(new Color(42, 157, 143));
		lblNewLabel_3_1_1_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_3_1_1_1.setBounds(335, 236, 137, 35);
		tela_dentistas.add(lblNewLabel_3_1_1_1);
		
		JButton btnattconsulta = new JButton(" Atualizar Consulta");
		btnattconsulta.setIcon(new ImageIcon(home.class.getResource("/images/check-2.png")));
		btnattconsulta.setForeground(new Color(42, 157, 143));
		btnattconsulta.setFont(new Font("Arial", Font.PLAIN, 20));
		btnattconsulta.setFocusPainted(false);
		btnattconsulta.setBorder(null);
		btnattconsulta.setBackground(new Color(241, 250, 238));
		btnattconsulta.setBounds(87, 165, 223, 66);
		tela_dentistas.add(btnattconsulta);
		
		JButton btnhistorico = new JButton(" Hist\u00F3rico");
		btnhistorico.setIcon(new ImageIcon(home.class.getResource("/images/historico.png")));
		btnhistorico.setForeground(new Color(42, 157, 143));
		btnhistorico.setFont(new Font("Arial", Font.PLAIN, 20));
		btnhistorico.setFocusPainted(false);
		btnhistorico.setBorder(null);
		btnhistorico.setBackground(new Color(241, 250, 238));
		btnhistorico.setBounds(493, 165, 223, 66);
		tela_dentistas.add(btnhistorico);
		
		JButton btnatt_1 = new JButton("Atualizar");
		btnatt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTabelaAgenda();
				AtualizarTabelaAgenda();
			}
		});
		btnatt_1.setForeground(Color.WHITE);
		btnatt_1.setFont(new Font("Century", Font.PLAIN, 20));
		btnatt_1.setFocusPainted(false);
		btnatt_1.setBorder(null);
		btnatt_1.setBackground(new Color(38, 70, 83));
		btnatt_1.setBounds(35, 515, 164, 33);
		tela_dentistas.add(btnatt_1);
		
		JPanel tela_pacientes = new JPanel();
		layeredPane.add(tela_pacientes, "name_72381383160800");
		tela_pacientes.setBackground(new Color(241, 250, 238));
		tela_pacientes.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pacientes");
		lblNewLabel.setForeground(new Color(42, 157, 143));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setBounds(32, 25, 107, 35);
		tela_pacientes.add(lblNewLabel);
		table_1.setColumnSelectionAllowed(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setEnabled(false);
		table_1.setRowSelectionAllowed(false);
		
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Data de Nascimento", "Email", "Endere\u00E7o", "Celular", "Sexo"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(134);
		table_1.setBounds(35, 163, 740, 346);
		tela_pacientes.add(table_1);

		
		
		
		JButton btnNewButton_1_3_2_2_1 = new JButton(" Novo Paciente");
		btnNewButton_1_3_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var cadastrar = new novoPaciente();
				cadastrar.setVisible(true);
			}
		});
		btnNewButton_1_3_2_2_1.setIcon(new ImageIcon(home.class.getResource("/images/addpaciente.png")));
		btnNewButton_1_3_2_2_1.setForeground(new Color(42, 157, 143));
		btnNewButton_1_3_2_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1_3_2_2_1.setFocusPainted(false);
		btnNewButton_1_3_2_2_1.setBorder(null);
		btnNewButton_1_3_2_2_1.setBackground(new Color(241, 250, 238));
		btnNewButton_1_3_2_2_1.setBounds(552, 86, 223, 66);
		tela_pacientes.add(btnNewButton_1_3_2_2_1);
		
		JButton btnNewButton_1_3_2_2_1_1 = new JButton(" Alterar");
		btnNewButton_1_3_2_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var alterar = new alterarPaciente();
				alterar.setVisible(true);
			}
		});
		btnNewButton_1_3_2_2_1_1.setIcon(new ImageIcon(home.class.getResource("/images/edit.png")));
		btnNewButton_1_3_2_2_1_1.setForeground(new Color(42, 157, 143));
		btnNewButton_1_3_2_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1_3_2_2_1_1.setFocusPainted(false);
		btnNewButton_1_3_2_2_1_1.setBorder(null);
		btnNewButton_1_3_2_2_1_1.setBackground(new Color(241, 250, 238));
		btnNewButton_1_3_2_2_1_1.setBounds(32, 86, 223, 66);
		tela_pacientes.add(btnNewButton_1_3_2_2_1_1);
		
		JButton btnNewButton_1_3_2_2_1_2 = new JButton(" Remover");
		btnNewButton_1_3_2_2_1_2.setIcon(new ImageIcon(home.class.getResource("/images/removepaciente.png")));
		btnNewButton_1_3_2_2_1_2.setForeground(new Color(42, 157, 143));
		btnNewButton_1_3_2_2_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1_3_2_2_1_2.setFocusPainted(false);
		btnNewButton_1_3_2_2_1_2.setBorder(null);
		btnNewButton_1_3_2_2_1_2.setBackground(new Color(241, 250, 238));
		btnNewButton_1_3_2_2_1_2.setBounds(285, 86, 223, 66);
		btnNewButton_1_3_2_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var remover = new removerPaciente();
				remover.setVisible(true);
			}
		});
		tela_pacientes.add(btnNewButton_1_3_2_2_1_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(32, 66, 743, 9);
		tela_pacientes.add(separator);
		
		JButton btnatt = new JButton("Atualizar");
		btnatt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTabelaPaciente();
				AtualizarTabelaPaciente();
			}
		});
		btnatt.setForeground(Color.WHITE);
		btnatt.setFont(new Font("Century", Font.PLAIN, 20));
		btnatt.setFocusPainted(false);
		btnatt.setBorder(null);
		btnatt.setBackground(new Color(38, 70, 83));
		btnatt.setBounds(32, 520, 164, 33);
		tela_pacientes.add(btnatt);
		
		JPanel tela_consultas = new JPanel();
		layeredPane.add(tela_consultas, "name_72439954133900");
		tela_consultas.setBackground(new Color(241, 250, 238));
		tela_consultas.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Consultas");
		lblNewLabel_1.setForeground(new Color(42, 157, 143));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(32, 25, 107, 35);
		tela_consultas.add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(32, 66, 743, 9);
		tela_consultas.add(separator_2);
		
		JButton btnMarcarConsulta = new JButton(" Marcar Consulta");
		btnMarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var novaConculsta = new novaConsulta();
				novaConculsta.setVisible(true);
			}
		});
		btnMarcarConsulta.setIcon(new ImageIcon(home.class.getResource("/images/plus.png")));
		btnMarcarConsulta.setForeground(new Color(42, 157, 143));
		btnMarcarConsulta.setFont(new Font("Arial", Font.PLAIN, 20));
		btnMarcarConsulta.setFocusPainted(false);
		btnMarcarConsulta.setBorder(null);
		btnMarcarConsulta.setBackground(new Color(241, 250, 238));
		btnMarcarConsulta.setBounds(32, 109, 223, 66);
		tela_consultas.add(btnMarcarConsulta);
		
		JButton btnDesmarcarConsulta = new JButton(" Desmarcar Consulta");
		btnDesmarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var removerConsulta = new removerConsulta();
				removerConsulta.setVisible(true);
			}
		});
		btnDesmarcarConsulta.setIcon(new ImageIcon(home.class.getResource("/images/del.png")));
		btnDesmarcarConsulta.setForeground(new Color(42, 157, 143));
		btnDesmarcarConsulta.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDesmarcarConsulta.setFocusPainted(false);
		btnDesmarcarConsulta.setBorder(null);
		btnDesmarcarConsulta.setBackground(new Color(241, 250, 238));
		btnDesmarcarConsulta.setBounds(290, 109, 234, 66);
		tela_consultas.add(btnDesmarcarConsulta);
		
		JButton btnProcedimento = new JButton("Novo Procedimento");
		btnProcedimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var proc = new novoProcedimento();
				proc.setVisible(true);
			}
		});
		btnProcedimento.setIcon(new ImageIcon(home.class.getResource("/images/dente.png")));
		btnProcedimento.setForeground(new Color(42, 157, 143));
		btnProcedimento.setFont(new Font("Arial", Font.PLAIN, 20));
		btnProcedimento.setFocusPainted(false);
		btnProcedimento.setBorder(null);
		btnProcedimento.setBackground(new Color(241, 250, 238));
		btnProcedimento.setBounds(552, 109, 223, 66);
		tela_consultas.add(btnProcedimento);

		
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
				tela_consultas.setVisible(true);
			}
		});
		btnNewButton_1_3.setIcon(new ImageIcon(home.class.getResource("/images/check.png")));
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setFont(new Font("Century", Font.PLAIN, 20));
		btnNewButton_1_3.setFocusPainted(false);
		btnNewButton_1_3.setBorder(null);
		btnNewButton_1_3.setBackground(new Color(38, 70, 83));
		btnNewButton_1_3.setBounds(0, 311, 245, 66);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_3_2 = new JButton(" Pacientes");
		btnNewButton_1_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela_dentistas.setVisible(false);
				tela_pacientes.setVisible(true);
				tela_consultas.setVisible(false);
			}
		});
		btnNewButton_1_3_2.setIcon(new ImageIcon(home.class.getResource("/images/paciente.png")));
		btnNewButton_1_3_2.setForeground(Color.WHITE);
		btnNewButton_1_3_2.setFont(new Font("Century", Font.PLAIN, 20));
		btnNewButton_1_3_2.setFocusPainted(false);
		btnNewButton_1_3_2.setBorder(null);
		btnNewButton_1_3_2.setBackground(new Color(38, 70, 83));
		btnNewButton_1_3_2.setBounds(0, 228, 245, 66);
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
		btnNewButton_1_3_2_1.setBounds(0, 482, 245, 53);
		panel.add(btnNewButton_1_3_2_1);
		
		JButton btnNewButton_1_3_2_2 = new JButton("Home");
		btnNewButton_1_3_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela_dentistas.setVisible(true);
				tela_pacientes.setVisible(false);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("versao 1.0");
		lblNewLabel_1_1.setForeground(new Color(42, 157, 143));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(162, 538, 83, 27);
		panel.add(lblNewLabel_1_1);

		
		//Area do Dentistas
		cbdentistas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try {
            			pacienteDao = new PacienteDao();
	        			
	        			var d = dentistaDao.GetporNome((String)cbdentistas.getSelectedItem());

	        			txtnome.setText(d.getNome());
	        			txtespecialidade.setText(d.getEspecialidade());

					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
            }
        });
		
		btnattconsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
				var attConsulta = new atualizarConsulta((String)cbdentistas.getSelectedItem());
				attConsulta.setVisible(true);
        }});
		
		btnhistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var historico = new historicoConsulta((String)cbdentistas.getSelectedItem());
				historico.setVisible(true);
			}
		});
		
    	try {
			dentistaDao = new DentistaDao();
			
			var dentistas = dentistaDao.Listar();
			
			for(var item : dentistas) {
				cbdentistas.addItem((String)item.getNome());
			}

		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
    	AtualizarTabelaPaciente();
    	AtualizarTabelaAgenda();
	}
	
	public void LimparTabelaPaciente() {
		DefaultTableModel model =(DefaultTableModel) table_1.getModel();
		model.setRowCount(0);
	}
	
	public void AtualizarTabelaPaciente() {
		try 
		{
			pacienteDao = new PacienteDao();
			
			table_1.createDefaultColumnsFromModel();
			DefaultTableModel model =(DefaultTableModel) table_1.getModel();
			
			var pacientes = pacienteDao.Listar();
			
			var row = new Object[6];
			
			for(var item : pacientes) {
				row[0] = item.getNome();
				row[1] = item.getDataNascimento();
				row[2] = item.getEmail();
				row[3] = item.getEndereco();
				row[4] = item.getCelular();
				row[5] = item.getSexo();
				model.addRow(row);
			}
			
			model.fireTableDataChanged();
		}
		catch(Exception ex)
		{
			System.out.println("Erro: " + ex.getMessage());
		}
	}

	
	public void LimparTabelaAgenda() {
		DefaultTableModel model =(DefaultTableModel) tabelaAgenda.getModel();
		model.setRowCount(0);
	}
	
	public void AtualizarTabelaAgenda() {
		try 
		{
			consultaDao = new ConsultaDao();
			
			tabelaAgenda.createDefaultColumnsFromModel();
			DefaultTableModel model =(DefaultTableModel) tabelaAgenda.getModel();
			
			var agenda = consultaDao.GetAgenda((String)cbdentistas.getSelectedItem());
			
			var row = new Object[7];
			
			for(var item : agenda) {
				row[0] = item.getId();
				row[1] = item.getData();
				row[2] = item.getHora();
				row[3] = item.getObs();
				row[4] = item.getProcedimento();
				row[5] = item.getDentista();
				row[6] = item.getPaciente();
				model.addRow(row);
			}
			
			model.fireTableDataChanged();
		}
		catch(Exception ex)
		{
			System.out.println("Erro: " + ex.getMessage());
		}
	}
}
