package br.com.odonto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.odondo.dao.ConsultaDao;
import br.com.odonto.models.Consulta;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class atualizarConsulta extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atualizarConsulta frame = new atualizarConsulta(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ConsultaDao consultaDao;

	public atualizarConsulta(String nomeDentista) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(atualizarConsulta.class.getResource("/images/fav.png")));
		setResizable(false);
		setTitle("Atualizar Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(241, 250, 238));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<Integer> cbconsultas = new JComboBox<Integer>();
		cbconsultas.setBounds(34, 81, 407, 48);
		contentPane.add(cbconsultas);
		
		JTextArea txtobs = new JTextArea();
		txtobs.setBounds(34, 221, 407, 163);
		contentPane.add(txtobs);
		
		JButton btnattconsulta = new JButton("Consulta Finalizada");
		btnattconsulta.setForeground(Color.WHITE);
		btnattconsulta.setFont(new Font("Century", Font.PLAIN, 20));
		btnattconsulta.setFocusPainted(false);
		btnattconsulta.setBorder(null);
		btnattconsulta.setBackground(new Color(38, 70, 83));
		btnattconsulta.setBounds(34, 428, 407, 66);
		contentPane.add(btnattconsulta);
		
		JLabel lblNewLabel_3 = new JLabel(" Atualizar Consulta");
		lblNewLabel_3.setIcon(new ImageIcon(atualizarConsulta.class.getResource("/images/check-2.png")));
		lblNewLabel_3.setForeground(new Color(42, 157, 143));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(134, 35, 230, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Observa\u00E7\u00F5es:");
		lblNewLabel_3_1.setForeground(new Color(42, 157, 143));
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_3_1.setBounds(34, 175, 172, 35);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("escolha a consulta pelo seu c\u00F3digo.");
		lblNewLabel_3_2.setForeground(new Color(42, 157, 143));
		lblNewLabel_3_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(34, 129, 241, 35);
		contentPane.add(lblNewLabel_3_2);
		
		//combo
		cbconsultas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try {
            			consultaDao = new ConsultaDao();

	        			var consulta = consultaDao.GetbyId((int)cbconsultas.getSelectedItem());

	        			txtobs.setText(consulta.getObservacao());
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
            }
        });
		
		//botao
		btnattconsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	try {
        			consultaDao = new ConsultaDao();

        			consultaDao.AtualizarConsulta((int)cbconsultas.getSelectedItem(), txtobs.getText());
        			
        			dispose();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		//onInit
    	try {
			consultaDao = new ConsultaDao();
			
			var consultas = consultaDao.GetAllporDentista(nomeDentista);

			for(var item : consultas) {
				cbconsultas.addItem(item.getId());

			}

		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
