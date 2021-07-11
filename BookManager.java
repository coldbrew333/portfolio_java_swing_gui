package com.example.app;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import com.example.domain.BookVO;
import com.example.repository.BookDAO;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;

public class BookManager extends JFrame {
	
	private BookDAO bookDAO = new BookDAO();
	private ImageIcon books = new ImageIcon("C:\\Users\\user\\eclipse-workspace\\java-swing-gui\\images\\books.jpg");
	
	private BufferedImage img =null;
	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel5;
	private JSplitPane splitPane;
	private JPanel panel2;
	private JLabel lblName;
	private JLabel lblWriter;
	private JLabel lblPublisher;
	private JLabel lblCount;
	private JLabel lblRegDate;
	private JTextField tfName;
	private JTextField tfWriter;
	private JTextField tfPublisher;
	private JTextField tfCount;
	private JTextField tfRegDate;
	private JButton btnRegister;
	private JPanel panel3;
	private JSplitPane splitPane_1;
	private JTextArea textArea;
	private JPanel panel4;
	private JComboBox comboBox;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JLabel lblKategorie;
	private JTextField tfKategorie;
	private JLabel lblTotal;
	private JPanel panelBottom;
	private JButton btnTotal;
	private JButton btnModify;
	private JButton btnRemove;
	private JPanel panelWest;
	private JPanel panel_1;
	private JLabel lblName1;
	private JTextField tfName1;
	private JPanel panel_2;
	private JLabel lblWriter1;
	private JTextField tfWriter1;
	private JPanel panel;
	private JLabel lblPublisher1;
	private JTextField tfPublisher1;
	private JPanel panel_3;
	private JLabel lblKategorie1;
	private JTextField tfKategorie1;
	private JPanel panel_4;
	private JLabel lblCount1;
	private JTextField tfCount1;
	private JScrollPane scrollPane;
	private JPanel panel_5;
	private JTextField tfNum;
	private JLabel lblNum;
	private JPanel panel_6;
	private JLabel lblBackImage;
	private JLabel lblStorage;
	

	public static void main(String[] args) {
		new BookManager();

	}//main
	
	public BookManager() {
		super("책관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(435,700);
		setLocationByPlatform(true);
		
		Container c=getContentPane();
		
		c.add(getTabbedPane(), BorderLayout.CENTER);
		
		
	
		
		
		setVisible(true);
	}//public BookManager

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("메인", null, getPanel_6_1(), null);
			tabbedPane.addTab("기록", null, getPanel1(), null);
			tabbedPane.addTab("전체보기", null, getPanel5(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setLayout(new BorderLayout(0, 0));
			panel1.add(getSplitPane_1(), BorderLayout.CENTER);
		}
		return panel1;
	}
	private JPanel getPanel5() {
		if (panel5 == null) {
			panel5 = new JPanel();
			panel5.setForeground(new Color(51, 51, 51));
			panel5.setLayout(new BorderLayout(0, 0));
			panel5.add(getLblTotal(), BorderLayout.NORTH);
			panel5.add(getPanelBottom(), BorderLayout.SOUTH);
			panel5.add(getPanelWest(), BorderLayout.WEST);
			panel5.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel5;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setBackground(new Color(102, 102, 102));
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setLeftComponent(getPanel2());
			splitPane.setRightComponent(getPanel3());
			splitPane.setDividerLocation(180);
		}
		return splitPane;
	}
	private JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.setForeground(new Color(255, 204, 153));
			panel2.setLayout(null);
			panel2.add(getLblName());
			panel2.add(getLblWriter());
			panel2.add(getLblPublisher());
			panel2.add(getLblCount());
			panel2.add(getLblRegDate());
			panel2.add(getTfName());
			panel2.add(getTfWriter());
			panel2.add(getTfPublisher());
			panel2.add(getTfCount());
			panel2.add(getTfRegDate());
			panel2.add(getBtnRegister());
			panel2.add(getLblKategorie());
			panel2.add(getTfKategorie());
		}
		return panel2;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("책제목");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(0, 12, 55, 18);
		}
		return lblName;
	}
	private JLabel getLblWriter() {
		if (lblWriter == null) {
			lblWriter = new JLabel("작가");
			lblWriter.setHorizontalAlignment(SwingConstants.LEFT);
			lblWriter.setBounds(10, 43, 55, 18);
		}
		return lblWriter;
	}
	private JLabel getLblPublisher() {
		if (lblPublisher == null) {
			lblPublisher = new JLabel("출판사");
			lblPublisher.setHorizontalAlignment(SwingConstants.CENTER);
			lblPublisher.setBounds(0, 73, 55, 18);
		}
		return lblPublisher;
	}
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("가격");
			lblCount.setHorizontalAlignment(SwingConstants.LEFT);
			lblCount.setBounds(182, 43, 55, 18);
		}
		return lblCount;
	}
	private JLabel getLblRegDate() {
		if (lblRegDate == null) {
			lblRegDate = new JLabel("구입한 날짜");
			lblRegDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegDate.setBounds(180, 73, 72, 18);
		}
		return lblRegDate;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(48, 10, 114, 22);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfWriter() {
		if (tfWriter == null) {
			tfWriter = new JTextField();
			tfWriter.setBounds(48, 42, 114, 22);
			tfWriter.setColumns(10);
		}
		return tfWriter;
	}
	private JTextField getTfPublisher() {
		if (tfPublisher == null) {
			tfPublisher = new JTextField();
			tfPublisher.setBounds(48, 71, 114, 22);
			tfPublisher.setColumns(10);
		}
		return tfPublisher;
	}
	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setBounds(251, 41, 114, 22);
			tfCount.setColumns(10);
		}
		return tfCount;
	}
	private JTextField getTfRegDate() {
		if (tfRegDate == null) {
			tfRegDate = new JTextField();
			tfRegDate.setBounds(251, 71, 114, 22);
			tfRegDate.setColumns(10);
		}
		return tfRegDate;
	}
	private JButton getBtnRegister() {//등록이 되지 않는다... 왤까?
		if (btnRegister == null) {
			btnRegister = new JButton("등록하기");
			btnRegister.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
	
					String name = tfName.getName();
					if(name.isEmpty()) {
						JOptionPane.showInternalMessageDialog(BookManager.this, "입력해주세요", "error",
								JOptionPane.ERROR_MESSAGE);
						tfName.requestFocus();
						return;
					}//IF
					
					BookVO bookVO = new BookVO();
					bookVO.setName(tfName.getText());
					bookVO.setWriter(tfWriter.getText());
					bookVO.setPublisher(tfPublisher.getText());
					bookVO.setKategorie(tfKategorie.getText());
					bookVO.setCount(tfCount.getText());
					bookVO.setRegdate(new Timestamp(System.currentTimeMillis()));
					
					bookDAO.insertBook(bookVO);//DB INSERT
					
					JOptionPane.showMessageDialog(BookManager.this,"등록완료되었습니다", "등록완료", 
							JOptionPane.INFORMATION_MESSAGE);
					
					
					//비우기
					tfName.setText("");
					tfWriter.setText("");
					tfPublisher.setText("");
					tfKategorie.setText("");
					tfCount.setText("");
				
				}//action
			});
			btnRegister.setFont(new Font("HY목각파임B", Font.BOLD, 15));
			btnRegister.setForeground(new Color(102, 102, 102));
			btnRegister.setBackground(new Color(204, 204, 204));
			btnRegister.setBounds(139, 121, 98, 28);
		}
		return btnRegister;
	}
	private JPanel getPanel3() {
		if (panel3 == null) {
			panel3 = new JPanel();
			panel3.setLayout(new BorderLayout(0, 0));
			panel3.add(getSplitPane_1_1(), BorderLayout.CENTER);
		}
		return panel3;
	}
	private JSplitPane getSplitPane_1_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setLeftComponent(getTextArea());
			splitPane_1.setRightComponent(getPanel4());
			splitPane_1.setDividerLocation(180);
		}
		return splitPane_1;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false); // 편집 안되게 설정하기
		}
		return textArea;
	}
	private JPanel getPanel4() {
		if (panel4 == null) {
			panel4 = new JPanel();
			panel4.setLayout(null);
			panel4.add(getComboBox());
			panel4.add(getTfSearch());
			panel4.add(getBtnSearch());
		}
		return panel4;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"선택..", "제목", "출판사", "작가", "카테고리"}));
			comboBox.setBounds(12, 26, 65, 27);
		}
		return comboBox;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(12, 72, 162, 27);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색하기");
			btnSearch.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int selectedIndex = comboBox.getSelectedIndex();
					if (selectedIndex == 0) {
						JOptionPane.showMessageDialog(BookManager.this,
								"검색항목을 선택해주세요", "error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}//if
					String word = tfSearch.getText();
					if (word.isEmpty()) {
						JOptionPane.showMessageDialog(BookManager.this,
								"검색어 입력해주세요", "error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}//if
					
					String field ="";
					switch (selectedIndex) {
					case 1: field="name";break;
					case 2: field="publisher";break;
					case 3: field="writer";break;
					case 4: field="kategorie";break;
					}
					List<BookVO>list=bookDAO.search(word,field);
					textArea.setText("");
					
					if(list.size()>0) {
						for(BookVO book : list){
							textArea.append(book.getName());
							textArea.append(book.getPublisher());
							textArea.append(book.getWriter());
							textArea.append(book.getKategorie());
						}
						
					}else {//size()=0
						textArea.append("결과가 존재하지 않습니다");
						
					}
					
					
			
			
			}//action
			});
			btnSearch.setFont(new Font("HY목각파임B", Font.BOLD, 15));
			btnSearch.setBackground(new Color(204, 204, 204));
			btnSearch.setBounds(50, 153, 98, 28);
		}
		return btnSearch;
	}
	private JLabel getLblKategorie() {
		if (lblKategorie == null) {
			lblKategorie = new JLabel("카테고리");
			lblKategorie.setBounds(182, 12, 55, 18);
		}
		return lblKategorie;
	}
	private JTextField getTfKategorie() {
		if (tfKategorie == null) {
			tfKategorie = new JTextField();
			tfKategorie.setBounds(251, 10, 114, 22);
			tfKategorie.setColumns(10);
		}
		return tfKategorie;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("전체기록");
			lblTotal.setFont(new Font("HY목각파임B", Font.BOLD, 15));
			lblTotal.setForeground(new Color(0, 0, 0));
			lblTotal.setOpaque(true);
			lblTotal.setBackground(new Color(51, 102, 255));
			lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTotal;
	}
	private JPanel getPanelBottom() {
		if (panelBottom == null) {
			panelBottom = new JPanel();
			panelBottom.add(getBtnTotal());
			panelBottom.add(getBtnModify());
			panelBottom.add(getBtnRemove());
		}
		return panelBottom;
	}
	private JButton getBtnTotal() {
		if (btnTotal == null) {
			btnTotal = new JButton("톺아보기");
			btnTotal.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					textArea.setText("");
					
					List<BookVO> list = bookDAO.getBooks();
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
					
					for(BookVO book : list) {
						textArea.append(String.format("번호:%d\n", book.getNum()));
						textArea.append(String.format("책제목:%s\n")+book.getName());
						textArea.append(String.format("작가:%s\n")+book.getWriter());
						textArea.append(String.format("출판사:%s\n")+book.getPublisher());
						textArea.append(String.format("카테고리:%s\n")+book.getKategorie());
						textArea.append(String.format("가격:%s\n")+book.getCount());
						String strRegDate = sdf.format(book.getRegdate());
						textArea.append(String.format("등록날짜 : %s\n\n", strRegDate));
						
						
						
					}//for
					
				}
			});
		}
		return btnTotal;
	}
	private JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정하기");
			btnModify.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				
				BookVO bookVO = new BookVO();
				bookVO.setNum(Integer.parseInt(tfNum.getText()));
				bookVO.setName(tfName1.getText());
				bookVO.setWriter(tfWriter1.getText());
				bookVO.setPublisher(tfPublisher1.getText());
				bookVO.setKategorie(tfKategorie1.getText());
				bookVO.setCount(tfCount1.getText());
				bookVO.setRegdate(new Timestamp(System.currentTimeMillis()));
				
				bookDAO.updateBooks(bookVO);
				
				btnTotal.doClick();//전체보기
				
				
				
				
				
				
				}
			});
		}
		return btnModify;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("삭제하기");
			btnRemove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				int num	=Integer.parseInt(tfNum.getText());
				
				bookDAO.removeByNum(num);
				
				btnTotal.doClick();//전체보기
				}
			});
		}
		return btnRemove;
	}
	private JPanel getPanelWest() {
		if (panelWest == null) {
			panelWest = new JPanel();
			panelWest.setLayout(new GridLayout(0, 1, 0, 0));
			panelWest.add(getPanel_1());
			panelWest.add(getPanel_2());
			panelWest.add(getPanel());
			panelWest.add(getPanel_3());
			panelWest.add(getPanel_4());
			panelWest.add(getPanel_5());
		}
		return panelWest;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblName1());
			panel_1.add(getTextField_2());
		}
		return panel_1;
	}
	private JLabel getLblName1() {
		if (lblName1 == null) {
			lblName1 = new JLabel("책제목");
		}
		return lblName1;
	}
	private JTextField getTextField_2() {
		if (tfName1 == null) {
			tfName1 = new JTextField();
			tfName1.setColumns(10);
		}
		return tfName1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getLblWriter1());
			panel_2.add(getTextField_1_1());
		}
		return panel_2;
	}
	private JLabel getLblWriter1() {
		if (lblWriter1 == null) {
			lblWriter1 = new JLabel("작가");
		}
		return lblWriter1;
	}
	private JTextField getTextField_1_1() {
		if (tfWriter1 == null) {
			tfWriter1 = new JTextField();
			tfWriter1.setColumns(10);
		}
		return tfWriter1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblPublisher1());
			panel.add(getTextField_2_1());
		}
		return panel;
	}
	private JLabel getLblPublisher1() {
		if (lblPublisher1 == null) {
			lblPublisher1 = new JLabel("출판사");
		}
		return lblPublisher1;
	}
	private JTextField getTextField_2_1() {
		if (tfPublisher1 == null) {
			tfPublisher1 = new JTextField();
			tfPublisher1.setColumns(10);
		}
		return tfPublisher1;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getLblKategorie1());
			panel_3.add(getTfKategorie1());
		}
		return panel_3;
	}
	private JLabel getLblKategorie1() {
		if (lblKategorie1 == null) {
			lblKategorie1 = new JLabel("카테고리");
		}
		return lblKategorie1;
	}
	private JTextField getTfKategorie1() {
		if (tfKategorie1 == null) {
			tfKategorie1 = new JTextField();
			tfKategorie1.setColumns(10);
		}
		return tfKategorie1;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.add(getLblCount1());
			panel_4.add(getTfCount1());
		}
		return panel_4;
	}
	private JLabel getLblCount1() {
		if (lblCount1 == null) {
			lblCount1 = new JLabel("가격");
		}
		return lblCount1;
	}
	private JTextField getTfCount1() {
		if (tfCount1 == null) {
			tfCount1 = new JTextField();
			tfCount1.setColumns(10);
		}
		return tfCount1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
		}
		return scrollPane;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.add(getLblNum());
			panel_5.add(getTfNum());
		}
		return panel_5;
	}
	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setColumns(10);
		}
		return tfNum;
	}
	private JLabel getLblNum() {
		if (lblNum == null) {
			lblNum = new JLabel("번호");
		}
		return lblNum;
	}
	private JPanel getPanel_6_1() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(new BorderLayout(0, 0));
			panel_6.add(getLblBackImage(), BorderLayout.CENTER);
			panel_6.add(getLblStorage(), BorderLayout.NORTH);
		}
		return panel_6;
	}
	private JLabel getLblBackImage() {
		if (lblBackImage == null) {
			lblBackImage = new JLabel("",books,SwingConstants.CENTER);
		}
		return lblBackImage;
	}
	private JLabel getLblStorage() {
		if (lblStorage == null) {
			lblStorage = new JLabel("책수납");
			lblStorage.setBackground(new Color(255, 248, 220));
			lblStorage.setFont(new Font("한컴산뜻돋움", Font.BOLD, 16));
			lblStorage.setHorizontalAlignment(SwingConstants.CENTER);
			lblStorage.setOpaque(true);//불투명
		}
		return lblStorage;
	}
}//class
