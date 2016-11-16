package com.acer.nina.test;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class GridLayoutFrame extends JFrame // 建構子
{

	private static final long serialVersionUID = 1L;

	private JTextArea jName;
	private JTextArea email;
	private JTextArea mobilephone;
	// private JTextArea userage;

	private JLabel errEmail;
	private JLabel errPhone;

	// private JLabel errAge;

	// private Model model3 = new Model();
	// private JComboBox combo3 = new JComboBox(model3.getCitys().toArray());

	GridLayoutFrame() {
		super("GridLayout");

		Model model = new Model();

		Container c = this.getContentPane();
		c.setLayout(new GridLayout(10, 5, 15, 15));

		c.add(new JLabel("1"));
		c.add(new JLabel("2"));
		c.add(new JLabel("3"));

		JLabel name = new JLabel("*姓名：", SwingConstants.CENTER);
		name.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		c.add(name);
		c.add(jName = new JTextArea());
		c.add(new JLabel("不可為數字"));

		JLabel age = new JLabel("*年齡：", SwingConstants.CENTER);
		age.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		c.add(age);
		c.add( new JTextArea());
		c.add( new JLabel("只可為數字"));

		JLabel sex = new JLabel("*性別：", SwingConstants.CENTER);
		sex.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		c.add(sex);
		JRadioButton rbutton1 = new JRadioButton("男");
		JRadioButton rbutton2 = new JRadioButton("女");
		c.add(rbutton1);
		c.add(rbutton2);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rbutton1);
		buttonGroup.add(rbutton2);

		JLabel add = new JLabel("*地址：", SwingConstants.CENTER);
		add.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		c.add(add);
		JComboBox combo1 = new JComboBox(model.getCitys().toArray());
		JComboBox combo2 = new JComboBox(model.getTowns(model.getCitys().get(0)).toArray());

		c.add(combo1);
		c.add(combo2);

		JLabel mail = new JLabel("*E-Mail：", SwingConstants.CENTER);
		mail.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		c.add(mail);
		c.add(email = new JTextArea());
		c.add(errEmail = new JLabel(""));

		JLabel phone = new JLabel("*手機號碼：", SwingConstants.CENTER);
		phone.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		c.add(phone);
		c.add(mobilephone = new JTextArea());
		c.add(errPhone = new JLabel(""));

		c.add(new JLabel(""));
		c.add(new JLabel(""));
		JLabel empty = new JLabel("*為必填欄位!!", SwingConstants.CENTER);
		empty.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		c.add(empty);

		JButton sumbit = new JButton("Submit");
		sumbit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Yes:0, NO:1, cancel:-1
				int chekcValue = JOptionPane.showConfirmDialog(null, "是否送出", "送出確認",JOptionPane.YES_NO_OPTION);
				
				System.out.println("chekcValue = " + chekcValue);
						
				Controller controller = new Controller();

				UserVo vo = new UserVo();
				vo.setName(jName.toString());
				// vo.setAge(age);
				// vo.setCity(city);
				// vo.setTown(town);
				// vo.setSex(sex);
				vo.setPhone(mobilephone.toString());
				vo.setEmail(email.getText());

				System.out.println(">> email.getText() = " + email.getText());

				Map map = controller.doSubmit(vo);
				if (!map.isEmpty()) {
					errEmail.setText((String) map.get("email"));
				}
				if (!map.isEmpty()) {
					errPhone.setText((String) map.get("phone"));
				}
			}
		});

		c.add(new JLabel(""));
		c.add(new JLabel(""));

		c.add(sumbit);

		Controller controller = new Controller(model, combo2);
		combo1.addActionListener(controller);
	}

	// new Controller(this);

	// public JComboBox getCombo3() {
	// return combo3;
	// }
	//
	//
	//
	// public void setCombo3(JComboBox combo3) {
	// this.combo3 = combo3;
	// }

	public class Item {
		private String id;
		private String description;
		
		public Item(String id, String description) {
			this.id = id;
			this.description = description;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		public String toString() {
			return description;
		}
	}
}
