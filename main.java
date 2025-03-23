import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class f extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

		String[]  str={"Farmer ID", "Farmer Name", "Farm Size"};
			

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farmer frame = new Farmer();
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
	public f() {
		
JLabel lblNewLabel = new JLabel("");
//lblNewLabel.setBounds(0, 0, , 16);

lblNewLabel.setIcon(new ImageIcon("F:\\fpic.png"));
lblNewLabel.setBounds(0, 0, 1400, 700);
//contentPane.add(lblNewLabel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Farmer ID");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(56, 57, 169, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Farmer Name");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2.setBounds(52, 113, 117, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Farm Size");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_3.setBounds(56, 156, 113, 30);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(213, 64, 74, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 160, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(213, 117, 169, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("Agricultural Management");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel_4.setBounds(81, 13, 376, 31);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(420, 97, 377, 205);
		contentPane.add(scrollPane);
                //table = new JTable();

       // frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(str);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

		table.setFont(new Font("Times New Roman", Font.BOLD, 20));
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
			}
		));*/
		table.getColumnModel().getColumn(1).setPreferredWidth(198);
		scrollPane.setViewportView(table);

		

				
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					String query="select * from farmer where f_name LIKE '"+textField_2.getText()+"'";
					
			
	
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
										//table.setModel(DbUtils.resultSetToTableModel(rs));
										}

				catch(Exception e) {
					System.out.println(e);
				                  }
			}

			
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSearch.setBounds(438, 61, 97, 25);
		contentPane.add(btnSearch);
		
		JButton Insert = new JButton("Insert");
		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String fid=textField.getText();
					//String fname=.getText();
					String fname=textField_2.getText();
					String fsize=textField_1.getText();
					
					
	 String sql="insert into farmer(f_id,f_name,farm_size) values ("+ fid +  ",'"  + fname +"',"+fsize+")";
                   System.out.println(sql);
						System.out.println(sql);
	                     Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
						Statement stmt=con.createStatement();
						stmt.executeUpdate(sql); 
						System.out.println("values Inserted Successfully");
						stmt.close();
						con.close();
					   // UserInfo u=	new UserInfo();
					//	UserInfo.main(null);
					}
						catch(Exception e1) {
							System.out.println(e1);
						}

			}
		});
		Insert.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Insert.setBounds(561, 61, 97, 25);
		contentPane.add(Insert);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
String q="delete from farmer where f_name LIKE '"+textField_2.getText()+"'";
//		+ "+and f_id LIKE"+textField.getText()+"and farm_size LIKE"+textField_1.getText()""
		System.out.println(q);
					
			
	
					PreparedStatement pst=con.prepareStatement(q);
				//	ResultSet rs=
							pst.executeUpdate( q);
							System.out.println("record deleted successfully");
							
										//table.setModel(DbUtils.resultSetToTableModel(rs));
										}

				catch(Exception e1) {
					System.out.println(e1);
				}
			

			}
		});
		Delete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Delete.setBounds(685, 61, 97, 25);
		contentPane.add(Delete);
		
		JButton Login = new JButton("Login");
		Login.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Login.setBounds(12, 218, 97, 25);
		contentPane.add(Login);
		
		JButton Clear = new JButton("Clear");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			
			}
			
		});
		Clear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Clear.setBounds(121, 218, 97, 25);
		contentPane.add(Clear);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Cancel.setBounds(243, 218, 97, 25);
		contentPane.add(Cancel);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
String f_id = "";

        String f_name = "";
        
        String farm_size = "";
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					//String query="select *  from farmer";
	
					//PreparedStatement pst=con.prepareStatement(query);
					//ResultSet rs=pst.executeQuery();

            Statement stmt= con.createStatement();

            ResultSet rs = stmt.executeQuery("Select * from Farmer");

            Statement stmt1=con.createStatement();
            //ResultSet rs1=stmt1.executeQuery("select sum(amount) from dbe1");

           while(rs.next()) {
                f_id = rs.getString("f_id");

                f_name = rs.getString("f_name");
         
                farm_size = rs.getString("farm_size");
                
                model.addRow(new Object[] {f_id, f_name,farm_size});
            }
           

					
					}
				catch(Exception ae) {
					System.out.println(ae);
				}
			

			}
		});
		btnShowAll.setBounds(438, 17, 117, 25);
		contentPane.add(btnShowAll);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  try {
						
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	//String q="delete from farmer where f_name LIKE '"+textField_2.getText()+"'";
				//	String sq = "update farmer set f_name='"+textField_2.getText()+"'where"+textField.getText()+"'";
				//	String sql="UPDATE User set SupplierName='"+value1+"' ,MarbleType='"+value2+"' ,InStock='"+value3+"'";

						int sid=Integer.parseInt(textField.getText());
						int size=Integer.parseInt(textField_1.getText());
		//String sq = "update farmer set f_name = ? where f_id = ?,farm_size= ?";
String sq="UPDATE farmer SET f_name='"+textField_2.getText()+"',farm_size="+textField_1.getText()+"where f_id='"+textField.getText()+"'";
					     // PreparedStatement preparedStmt = conn.prepareStatement(query);
					      

			         System.out.println(sq);
						PreparedStatement pst=con.prepareStatement(sq);
						//pst.setInt(1, sid);
					      //pst.setString(2,textField_2.getText());
					      //pst.setInt(3, size);
					      
					//	ResultSet rs=
								pst.executeUpdate( sq);
								System.out.println("record updated successfully");
								
											//table.setModel(DbUtils.resultSetToTableModel(rs));
											}

					catch(Exception e1) {
						System.out.println(e1);
					}
				

				

								 
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(685, 19, 97, 25);
		contentPane.add(btnNewButton);
		
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				 	String fid=textField.getText();
						String fname= textField_2.getText();
						int id=Integer.parseInt(textField.getText());
						int fsize= Integer.parseInt(textField_1.getText());
						
						
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
						
						String sql="select * from farmer";
						//where u_name='"+user+"and u_pass="+psd+"'";
						Statement  st =con.createStatement();
						ResultSet rs=st.executeQuery(sql);
						while(rs.next())
					    {  
							if( (fname.equals(rs.getString(2))) && id ==(rs.getInt(1)) && fsize == (rs.getLong(3)) ) 
							{
							
								JOptionPane.showMessageDialog(null,"Login successful");
							}
									
					
					    }
					/*	else
						{
							JOptionPane.showMessageDialog(null,"Invalid Login");
						}*/

			}
			
									catch(Exception e)
									{
										System.out.println(e);
										
									}
			
		}
		});
		
		
	
		

		}	
}
