package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.UIManager;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5589772179571471473L;
	private JPanel contentPane;
	private RoomOrder rm = new RoomOrder();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Gui() throws IOException {
		setTitle("Room Organizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnPlaceStudents = new JButton("Place Students");
		btnPlaceStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rm.placeStudents();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPlaceStudents.setForeground(new Color(102, 0, 0));
		contentPane.add(btnPlaceStudents, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(153, 0, 0)), null));
		panel.setForeground(new Color(153, 0, 0));
		panel.setBackground(UIManager.getColor("Panel.background"));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblRequester = new JLabel("Requester");
		panel.add(lblRequester);
		
		String [] alpha = new String [40];
		rm.openDatabase("Students Names.xml");
		for(int i = 0; i<rm.students.size(); i++){
			alpha[i] = rm.students.get(i).getName();
		}
		Arrays.sort(alpha);
		
		final JComboBox<String> comboBox1 = new JComboBox<String>(alpha);
		comboBox1.setModel(new DefaultComboBoxModel<String>(alpha));
		comboBox1.setMaximumRowCount(41);
		panel.add(comboBox1);
		
		final JComboBox<String> comboBox2 = new JComboBox<String>(alpha);
		comboBox2.setMaximumRowCount(41);
		
		JButton btnRequest = new JButton("Request");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comboBox1.getSelectedItem().equals("") && !comboBox2.getSelectedItem().equals("")){
					try {
						rm.requestStudent(comboBox1.getSelectedItem().toString(), comboBox2.getSelectedItem().toString());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
					
				
			}
		});
		panel.add(btnRequest);
		
		panel.add(comboBox2);
		
		JLabel lblRequested = new JLabel("Requested");
		panel.add(lblRequested);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 0, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		String path = "three_color.png";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
		lblNewLabel.setIcon(new ImageIcon(image));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

}
