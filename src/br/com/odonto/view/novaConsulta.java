package br.com.odonto.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.odondo.dao.ConsultaDao;
import br.com.odondo.dao.DentistaDao;
import br.com.odondo.dao.PacienteDao;
import br.com.odondo.dao.ProcedimentoDao;
import br.com.odonto.models.Consulta;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class novaConsulta extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtvalor;
	private JTextField txtdata;
	private JTextField txthora;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					novaConsulta frame = new novaConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private PacienteDao pacienteDao;
	private ConsultaDao consultaDao;
	private ProcedimentoDao procDao;
	private DentistaDao dentistaDao;
	
	private MaskFormatter mascarahora;
	private MaskFormatter mascaradata;
	
	public novaConsulta() {
		setTitle("Marcar Consulta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(novaConsulta.class.getResource("/images/fav.png")));
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
		
		JLabel lblNewLabel = new JLabel("Nova Consulta");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(63, 11, 113, 45);
		lblNewLabel.setForeground(new Color(42, 157, 143));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(novoPaciente.class.getResource("/images/plus.png")));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(21, 11, 32, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblpaciente = new JLabel("Paciente");
		lblpaciente.setForeground(new Color(42, 157, 143));
		lblpaciente.setFont(new Font("Arial", Font.PLAIN, 17));
		lblpaciente.setBounds(21, 67, 82, 35);
		contentPane.add(lblpaciente);
		
		JLabel lbldentista = new JLabel("Dentista");
		lbldentista.setForeground(new Color(42, 157, 143));
		lbldentista.setFont(new Font("Arial", Font.PLAIN, 17));
		lbldentista.setBounds(21, 158, 82, 35);
		contentPane.add(lbldentista);
		
		txtvalor = new JTextField();
		txtvalor.setFont(new Font("Arial", Font.PLAIN, 15));
		txtvalor.setColumns(10);
		txtvalor.setBounds(345, 295, 290, 35);
		contentPane.add(txtvalor);
		
		JLabel lblobs = new JLabel("Observa\u00E7\u00E3o");
		lblobs.setForeground(new Color(42, 157, 143));
		lblobs.setFont(new Font("Arial", Font.PLAIN, 17));
		lblobs.setBounds(21, 255, 162, 35);
		contentPane.add(lblobs);
		
		txtdata =  new JFormattedTextField(mascaradata);
		txtdata.setFont(new Font("Arial", Font.PLAIN, 15));
		txtdata.setColumns(10);
		txtdata.setBounds(345, 102, 113, 35);
		contentPane.add(txtdata);
		
		JLabel lbldata = new JLabel("Data");
		lbldata.setForeground(new Color(42, 157, 143));
		lbldata.setFont(new Font("Arial", Font.PLAIN, 17));
		lbldata.setBounds(345, 67, 57, 35);
		contentPane.add(lbldata);
		
		txthora = new JFormattedTextField(mascarahora);
		txthora.setFont(new Font("Arial", Font.PLAIN, 15));
		txthora.setColumns(10);
		txthora.setBounds(483, 102, 124, 35);
		contentPane.add(txthora);
		
		JLabel lblhora = new JLabel("Hora");
		lblhora.setForeground(new Color(42, 157, 143));
		lblhora.setFont(new Font("Arial", Font.PLAIN, 17));
		lblhora.setBounds(483, 67, 152, 35);
		contentPane.add(lblhora);
		
		JLabel lblvalor = new JLabel("Valor");
		lblvalor.setForeground(new Color(42, 157, 143));
		lblvalor.setFont(new Font("Arial", Font.PLAIN, 17));
		lblvalor.setBounds(345, 255, 57, 35);
		contentPane.add(lblvalor);
		
		JButton btnMarcar = new JButton("Marcar Consulta");
		btnMarcar.setForeground(Color.WHITE);
		btnMarcar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnMarcar.setFocusPainted(false);
		btnMarcar.setBorder(null);
		btnMarcar.setBackground(new Color(38, 70, 83));
		btnMarcar.setBounds(379, 389, 256, 54);
		contentPane.add(btnMarcar);
		
		JComboBox<String> cbpaciente = new JComboBox<String>();
		cbpaciente.setBounds(23, 102, 288, 35);
		contentPane.add(cbpaciente);
		
		JComboBox<String> cbdentista = new JComboBox<String>();
		cbdentista.setBounds(21, 193, 288, 35);
		contentPane.add(cbdentista);
		
		JTextArea txtobs = new JTextArea();
		txtobs.setBounds(21, 295, 290, 91);
		contentPane.add(txtobs);
		
		JLabel lblProc = new JLabel("Procedimento");
		lblProc.setForeground(new Color(42, 157, 143));
		lblProc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblProc.setBounds(345, 158, 82, 35);
		contentPane.add(lblProc);
		
		JComboBox<String> cbproc = new JComboBox<String>();
		cbproc.setBounds(347, 199, 288, 35);
		contentPane.add(cbproc);
		
		btnMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					pacienteDao = new PacienteDao();
					dentistaDao = new DentistaDao();
					consultaDao = new ConsultaDao();
					procDao = new ProcedimentoDao();
					
					var paciente = pacienteDao.GetporNome((String)cbpaciente.getSelectedItem());
					var dentista = dentistaDao.GetporNome((String)cbdentista.getSelectedItem());

					var consulta = new Consulta();
					consulta.setPacienteId(paciente.getId());
					consulta.setDentistaId(dentista.getId());
					consulta.setDataConsulta(txtdata.getText());
					consulta.setHoraConsulta(txthora.getText());
					consulta.setValor(Double.parseDouble(txtvalor.getText()));
					consulta.setObservacao(txtobs.getText());

					var procedimento = procDao.GetporNome((String)cbproc.getSelectedItem());

					consultaDao.MarcarConsulta(consulta, procedimento.getId());

					JOptionPane.showMessageDialog(frame,"Consulta Marcada");
				}
				catch (Exception ex)
				{
					ex.getMessage();
				}
			}
		});
		
		try 
		{
			pacienteDao = new PacienteDao();
			dentistaDao = new DentistaDao();
			procDao = new ProcedimentoDao();
			
			var pacientes = pacienteDao.Listar();
			for(var item : pacientes) {
				cbpaciente.addItem(item.getNome());
			}
			
			var dentistas = dentistaDao.Listar();
			for(var item : dentistas) {
				cbdentista.addItem(item.getNome());
			}
			
			var procedimentos = procDao.Listar();
			for(var item : procedimentos) {
				cbproc.addItem(item.getDescricao());
			}
			

		}
		catch (Exception ex)
		{
			ex.getMessage();
		}
		
	}
}
