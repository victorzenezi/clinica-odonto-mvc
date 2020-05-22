package br.com.odonto.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.odondo.dao.ConsultaDao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class historicoConsulta extends JFrame {

	private JPanel contentPane;
	private JTable tabelahistorico = new JTable();
	
	private ConsultaDao consultaDao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					historicoConsulta frame = new historicoConsulta(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public historicoConsulta(String nomeDentista) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(historicoConsulta.class.getResource("/images/fav.png")));
		setTitle("Histórico de consultas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(241, 250, 238));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabelahistorico.setCellSelectionEnabled(true);
		tabelahistorico.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO", "DATA", "HORA", "OBSERVA\u00C7\u00C3O", "PROCEDIMENTO", "DENTISTA", "PACIENTE"
			}
		));
		tabelahistorico.getColumnModel().getColumn(3).setPreferredWidth(109);
		tabelahistorico.getColumnModel().getColumn(4).setPreferredWidth(116);
		tabelahistorico.getColumnModel().getColumn(6).setPreferredWidth(85);
		
		tabelahistorico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelahistorico.setRowSelectionAllowed(false);
		tabelahistorico.setEnabled(false);
		tabelahistorico.setColumnSelectionAllowed(true);
		tabelahistorico.setBounds(20, 72, 600, 380);
		
		contentPane.add(tabelahistorico);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel(" Hist\u00F3rico de Consultas");
		lblNewLabel_3_1_1_1.setIcon(new ImageIcon(historicoConsulta.class.getResource("/images/historico.png")));
		lblNewLabel_3_1_1_1.setForeground(new Color(42, 157, 143));
		lblNewLabel_3_1_1_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_3_1_1_1.setBounds(187, 26, 284, 35);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JButton btnsair = new JButton("Voltar");
		btnsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnsair.setForeground(Color.WHITE);
		btnsair.setFont(new Font("Century", Font.PLAIN, 20));
		btnsair.setFocusPainted(false);
		btnsair.setBorder(null);
		btnsair.setBackground(new Color(38, 70, 83));
		btnsair.setBounds(241, 476, 164, 35);
		contentPane.add(btnsair);
		
		try 
		{
			consultaDao = new ConsultaDao();
			
			tabelahistorico.createDefaultColumnsFromModel();
			DefaultTableModel model =(DefaultTableModel) tabelahistorico.getModel();
			
			var agenda = consultaDao.GetAgendaHistorico(nomeDentista);
			
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
