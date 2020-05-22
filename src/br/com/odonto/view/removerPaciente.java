package br.com.odonto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.odondo.dao.PacienteDao;
import br.com.odonto.models.Paciente;
import javax.swing.JComboBox;

public class removerPaciente extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtcelular;
	private JTextField txtendereco;
	private JTextField txtemail;
	private JTextField txtdatanascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					removerPaciente frame = new removerPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	PacienteDao pacienteDao;
	
	private MaskFormatter mascaraDataNascimento;
	private MaskFormatter mascaraTel;
	
	public removerPaciente() {
		setTitle("Remover Paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(novoPaciente.class.getResource("/images/fav.png")));
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
			mascaraDataNascimento = new MaskFormatter("####-##-##");
			//mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraTel = new MaskFormatter("(##)####-####");
		}
		catch(Exception ex)
		{
			System.out.println("Erro: " + ex.getMessage());
		}
		
		JLabel lblNewLabel = new JLabel("Remover Paciente");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(63, 11, 217, 45);
		lblNewLabel.setForeground(new Color(42, 157, 143));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(removerPaciente.class.getResource("/images/removepaciente.png")));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(21, 11, 32, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(42, 157, 143));
		lblNome.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNome.setBounds(21, 67, 57, 35);
		contentPane.add(lblNome);
		
		txtnome = new JTextField();
		txtnome.setEditable(false);
		txtnome.setFont(new Font("Arial", Font.PLAIN, 15));
		txtnome.setBounds(21, 102, 290, 35);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtcelular = new JFormattedTextField(mascaraTel);
		txtcelular.setEditable(false);
		txtcelular.setFont(new Font("Arial", Font.PLAIN, 15));
		txtcelular.setColumns(10);
		txtcelular.setBounds(21, 193, 290, 35);
		contentPane.add(txtcelular);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setForeground(new Color(42, 157, 143));
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCelular.setBounds(21, 158, 57, 35);
		contentPane.add(lblCelular);
		
		txtendereco = new JTextField();
		txtendereco.setEditable(false);
		txtendereco.setFont(new Font("Arial", Font.PLAIN, 15));
		txtendereco.setColumns(10);
		txtendereco.setBounds(21, 290, 290, 35);
		contentPane.add(txtendereco);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setForeground(new Color(42, 157, 143));
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEndereo.setBounds(21, 255, 129, 35);
		contentPane.add(lblEndereo);
		
		txtemail = new JTextField();
		txtemail.setEditable(false);
		txtemail.setFont(new Font("Arial", Font.PLAIN, 15));
		txtemail.setColumns(10);
		txtemail.setBounds(345, 102, 290, 35);
		contentPane.add(txtemail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(42, 157, 143));
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEmail.setBounds(345, 67, 57, 35);
		contentPane.add(lblEmail);
		
		txtdatanascimento = new JFormattedTextField(mascaraDataNascimento);
		txtdatanascimento.setEditable(false);
		txtdatanascimento.setFont(new Font("Arial", Font.PLAIN, 15));
		txtdatanascimento.setColumns(10);
		txtdatanascimento.setBounds(345, 193, 152, 35);
		contentPane.add(txtdatanascimento);
		
		JLabel lblData = new JLabel("Data de Nascimento");
		lblData.setForeground(new Color(42, 157, 143));
		lblData.setFont(new Font("Arial", Font.PLAIN, 17));
		lblData.setBounds(345, 158, 152, 35);
		contentPane.add(lblData);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(42, 157, 143));
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSexo.setBounds(345, 255, 57, 35);
		contentPane.add(lblSexo);
		
		JRadioButton rdmasculino = new JRadioButton("M");
		rdmasculino.setEnabled(false);
		rdmasculino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdmasculino.setBounds(345, 297, 43, 28);
		rdmasculino.setBackground(null);
		contentPane.add(rdmasculino);
		
		JRadioButton rdfeminino = new JRadioButton("F");
		rdfeminino.setEnabled(false);
		rdfeminino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdfeminino.setBounds(405, 297, 48, 28);
		rdfeminino.setBackground(null);
		contentPane.add(rdfeminino);
		
	    ButtonGroup group = new ButtonGroup();
	    group.add(rdmasculino);
	    group.add(rdfeminino);
		
		JButton btnNewButton_1_3_2_2 = new JButton("Remover");
		btnNewButton_1_3_2_2.setForeground(Color.WHITE);
		btnNewButton_1_3_2_2.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1_3_2_2.setFocusPainted(false);
		btnNewButton_1_3_2_2.setBorder(null);
		btnNewButton_1_3_2_2.setBackground(new Color(38, 70, 83));
		btnNewButton_1_3_2_2.setBounds(379, 389, 256, 54);
		contentPane.add(btnNewButton_1_3_2_2);
		
		JComboBox<String> cbpacientes = new JComboBox<String>();
		cbpacientes.setBounds(217, 17, 421, 35);
		contentPane.add(cbpacientes);
		cbpacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try {
            			pacienteDao = new PacienteDao();
	        			
	        			var p = pacienteDao.GetporNome((String)cbpacientes.getSelectedItem());

	        			txtnome.setText(p.getNome());
	        			txtcelular.setText(p.getCelular());
	        			txtemail.setText(p.getEmail());
	        			txtendereco.setText(p.getEndereco());
	        			txtdatanascimento.setText(p.getDataNascimento());
	        			
	        			if(p.getSexo().contentEquals("M")) {
	        				rdmasculino.setSelected(true);
	        			}else {
	        				rdfeminino.setSelected(true);
	        			}

					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
            }
        });
		
		btnNewButton_1_3_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {          	
            	 String[] options = {"Sim, tenho certeza", "Não, quero voltar"}; 
 	            int result = JOptionPane.showOptionDialog(
 	               frame,
 	               "Você tem certeza que deseja apagar todos os registro do " + cbpacientes.getSelectedItem() + "?", 
 	               "Excluir",            
 	               JOptionPane.YES_NO_OPTION,
 	               JOptionPane.WARNING_MESSAGE,
 	               null,
 	               options,
 	               options[0]
 	            );
 	            if(result == JOptionPane.YES_OPTION){
 	            	try {
 	        			pacienteDao = new PacienteDao();
 	        			
 	        			pacienteDao.Remover((String)cbpacientes.getSelectedItem());
 						JOptionPane.showMessageDialog(frame,
 							    "Paciente excluido com sucesso");
 						txtnome.setText(null);
	        			txtcelular.setText(null);
	        			txtemail.setText(null);
	        			txtendereco.setText(null);
	        			txtdatanascimento.setText(null);
	        			rdmasculino.setSelected(false);
	        			rdfeminino.setSelected(false);
 					}
 					catch(Exception ex) {
 						ex.printStackTrace();
 					}

 	            }
			}
		});

		
		try
		{
			pacienteDao = new PacienteDao();
			var pacientes = pacienteDao.Listar();
			
			for(var item : pacientes) {
				cbpacientes.addItem(item.getNome());
			}
			System.out.println(cbpacientes.getSelectedItem());
			
		}
		catch (Exception ex)
		{
			ex.getMessage();
		}
	}
}
