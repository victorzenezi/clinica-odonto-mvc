package br.com.odonto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.odondo.dao.ConsultaDao;
import br.com.odondo.dao.DentistaDao;
import br.com.odondo.dao.PacienteDao;
import br.com.odondo.dao.ProcedimentoDao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class removerConsulta extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					removerConsulta frame = new removerConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private MaskFormatter mascarahora;
	private MaskFormatter mascaradata;
	private JTextField textField;
	private JTextField txtpaciente;
	private JTextField txtdentista;
	
	private ConsultaDao consultaDao;
	private PacienteDao pacienteDao;
	private ProcedimentoDao procDao;
	private DentistaDao dentistaDao;

	public removerConsulta() {
		setTitle("Desmarcar Consulta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(removerConsulta.class.getResource("/images/fav.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(241, 250, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// MASCARAS
		try 
		{
			mascarahora = new MaskFormatter("##:##");
			mascaradata = new MaskFormatter("####-##-##");
		}
		catch(Exception ex)
		{
			System.out.println("Erro: " + ex.getMessage());
		}
		
		JLabel lblDesmarcarConsulta = new JLabel("Desmarcar Consulta");
		lblDesmarcarConsulta.setForeground(new Color(42, 157, 143));
		lblDesmarcarConsulta.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDesmarcarConsulta.setBounds(64, 22, 169, 45);
		contentPane.add(lblDesmarcarConsulta);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(removerConsulta.class.getResource("/images/del.png")));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(22, 22, 32, 45);
		contentPane.add(lblNewLabel_1);
		
		JButton btnDesmarcarConsulta = new JButton("Desmarcar Consulta");
		btnDesmarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDesmarcarConsulta.setForeground(Color.WHITE);
		btnDesmarcarConsulta.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDesmarcarConsulta.setFocusPainted(false);
		btnDesmarcarConsulta.setBorder(null);
		btnDesmarcarConsulta.setBackground(new Color(38, 70, 83));
		btnDesmarcarConsulta.setBounds(388, 392, 256, 54);
		contentPane.add(btnDesmarcarConsulta);
		
		JLabel lbldentista_1 = new JLabel("Consulta");
		lbldentista_1.setForeground(new Color(42, 157, 143));
		lbldentista_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lbldentista_1.setBounds(275, 27, 75, 35);
		contentPane.add(lbldentista_1);
		
		JComboBox cbconsulta = new JComboBox();
		cbconsulta.setBounds(346, 29, 298, 35);
		contentPane.add(cbconsulta);
		
		JLabel lblpaciente = new JLabel("Paciente");
		lblpaciente.setForeground(new Color(42, 157, 143));
		lblpaciente.setFont(new Font("Arial", Font.PLAIN, 17));
		lblpaciente.setBounds(22, 79, 82, 35);
		contentPane.add(lblpaciente);
		
		JLabel lbldata = new JLabel("Data");
		lbldata.setForeground(new Color(42, 157, 143));
		lbldata.setFont(new Font("Arial", Font.PLAIN, 17));
		lbldata.setBounds(346, 79, 57, 35);
		contentPane.add(lbldata);
		
		JLabel lblhora = new JLabel("Hora");
		lblhora.setForeground(new Color(42, 157, 143));
		lblhora.setFont(new Font("Arial", Font.PLAIN, 17));
		lblhora.setBounds(484, 79, 57, 35);
		contentPane.add(lblhora);
		
		JFormattedTextField txtdata = new JFormattedTextField(mascaradata);
		txtdata.setEditable(false);
		txtdata.setFont(new Font("Arial", Font.PLAIN, 15));
		txtdata.setColumns(10);
		txtdata.setBounds(346, 114, 113, 35);
		contentPane.add(txtdata);
		
		JFormattedTextField txthora = new JFormattedTextField(mascarahora);
		txthora.setEditable(false);
		txthora.setFont(new Font("Arial", Font.PLAIN, 15));
		txthora.setColumns(10);
		txthora.setBounds(484, 114, 152, 35);
		contentPane.add(txthora);
		
		JLabel lbldentista = new JLabel("Dentista");
		lbldentista.setForeground(new Color(42, 157, 143));
		lbldentista.setFont(new Font("Arial", Font.PLAIN, 17));
		lbldentista.setBounds(22, 170, 82, 35);
		contentPane.add(lbldentista);
		
		JLabel lblobs = new JLabel("Observa\u00E7\u00E3o");
		lblobs.setForeground(new Color(42, 157, 143));
		lblobs.setFont(new Font("Arial", Font.PLAIN, 17));
		lblobs.setBounds(22, 267, 162, 35);
		contentPane.add(lblobs);
		
		JTextArea txtobs = new JTextArea();
		txtobs.setBounds(22, 307, 290, 91);
		contentPane.add(txtobs);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(346, 221, 298, 35);
		contentPane.add(textField);
		
		JLabel lblvalor = new JLabel("Valor");
		lblvalor.setForeground(new Color(42, 157, 143));
		lblvalor.setFont(new Font("Arial", Font.PLAIN, 17));
		lblvalor.setBounds(346, 170, 57, 35);
		contentPane.add(lblvalor);
		
		txtpaciente = new JTextField();
		txtpaciente.setEditable(false);
		txtpaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		txtpaciente.setColumns(10);
		txtpaciente.setBounds(22, 114, 290, 35);
		contentPane.add(txtpaciente);
		
		txtdentista = new JTextField();
		txtdentista.setEditable(false);
		txtdentista.setFont(new Font("Arial", Font.PLAIN, 15));
		txtdentista.setColumns(10);
		txtdentista.setBounds(22, 221, 290, 35);
		contentPane.add(txtdentista);
		
		btnDesmarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					consultaDao = new ConsultaDao();

					
					consultaDao.Remover((int)cbconsulta.getSelectedItem());
					
					txtdata.setText(null);
					txthora.setText(null);
					textField.setText(null);
					txtobs.setText(null);
					txtpaciente.setText(null);
					txtdentista.setText(null);
					
					cbconsulta.removeAllItems();
					
					var consultas = consultaDao.ListarAtivos();
					
					for(var item : consultas) {
						cbconsulta.addItem(item.getId());
					}
				}
				catch(Exception ex)
				{
					ex.getMessage();
				}
			}
		});
		
		cbconsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					consultaDao = new ConsultaDao();
					procDao = new ProcedimentoDao();
					dentistaDao = new DentistaDao();
					pacienteDao = new PacienteDao();
					
					var c = consultaDao.GetbyId((int)cbconsulta.getSelectedItem());
					
					txtdata.setText(c.getDataConsulta());
					txthora.setText(c.getHoraConsulta());
					textField.setText(Double.toString(c.getValor()));
					txtobs.setText(c.getObservacao());
					
					var paciente = pacienteDao.GetById(c.getPacienteId());
					var dentista = dentistaDao.GetById(c.getDentistaId());
					
					txtpaciente.setText(paciente.getNome());
					txtdentista.setText(dentista.getNome());
					
				}
				catch(Exception ex)
				{
					ex.getMessage();
				}
			}
		});
		
		try 
		{
			consultaDao = new ConsultaDao();
			var consultas = consultaDao.ListarAtivos();
			
			for(var item : consultas) {
				cbconsulta.addItem(item.getId());
			}
			
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
}
