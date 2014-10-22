/*
 * <p>Copyright: Copyright (c) 2012</p>
 *
 * @author Tanaka Kensuke
 * @version 1.0
 */
package ch01;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Ex05_MinesweeperPropertyDialog_Lamda extends JDialog implements
		ActionListener {

	JSpinner widthSpinner;
	JSpinner heightSpinner;
	JSpinner bomCountSpinner;
	//MinesweeperJPanel owner;

	Ex05_MinesweeperPropertyDialog_Lamda(JPanel owner, boolean modal) {
		super();
		GridBagLayout gridbag = new GridBagLayout();
		// gridbag.columnWidths = new int[]{138, 0};
		gridbag.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 };
		gridbag.columnWeights = new double[] { 1.0, 1.0 };

		getContentPane().setLayout(gridbag);
		//this.owner = owner;

		setSize(400, 400);
		setResizable(false);
		createWidthSetting();
		createHeightSetting();
		createBomSetting();

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		gridbag.setConstraints(panel, gbc_panel);
		getContentPane().add(panel);

		JButton b1 = new JButton("OK");
		panel.add(b1);
		// b1.setBounds(500, 240, 80, 30);

		JButton btnCancel = new JButton("Cancel");
		// Lambda式で修正。5行から1行
		btnCancel.addActionListener(ea ->setVisible(false));

		panel.add(btnCancel);
		b1.addActionListener(this);

		// ウィンドウを閉じる時
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Colse");
				setVisible(false);
			}
		});
	}

	private void createWidthSetting() {
		JLabel label_1 = new JLabel("Width");
		// label_1.setBounds(180, 20, 50, 30);

		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		((GridBagLayout) getContentPane().getLayout()).setConstraints(label_1,
				gbc_label_1);
		getContentPane().add(label_1);

		SpinnerNumberModel model = new SpinnerNumberModel(30, 5, 100, 1);
		widthSpinner = new JSpinner(model);

		GridBagConstraints gbc_fontSize = new GridBagConstraints();
		gbc_fontSize.anchor = GridBagConstraints.WEST;
		gbc_fontSize.insets = new Insets(0, 0, 5, 5);
		gbc_fontSize.gridx = 1;
		gbc_fontSize.gridy = 0;
		((GridBagLayout) getContentPane().getLayout()).setConstraints(
				widthSpinner, gbc_fontSize);
		getContentPane().add(widthSpinner);

	}

	private void createHeightSetting() {
		JLabel label_1 = new JLabel("Height");
		// label_1.setBounds(180, 20, 50, 30);

		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		((GridBagLayout) getContentPane().getLayout()).setConstraints(label_1,
				gbc_label_1);
		getContentPane().add(label_1);

		SpinnerNumberModel model = new SpinnerNumberModel(16, 5, 100, 1);
		heightSpinner = new JSpinner(model);

		GridBagConstraints gbc_fontSize = new GridBagConstraints();
		gbc_fontSize.anchor = GridBagConstraints.WEST;
		gbc_fontSize.insets = new Insets(0, 0, 5, 5);
		gbc_fontSize.gridx = 1;
		gbc_fontSize.gridy = 1;
		((GridBagLayout) getContentPane().getLayout()).setConstraints(
				heightSpinner, gbc_fontSize);
		getContentPane().add(heightSpinner);
	}

	private void createBomSetting() {
		JLabel label_1 = new JLabel("Bom");
		// label_1.setBounds(180, 20, 50, 30);

		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		((GridBagLayout) getContentPane().getLayout()).setConstraints(label_1,
				gbc_label_1);
		getContentPane().add(label_1);

		SpinnerNumberModel model = new SpinnerNumberModel(16, 5, 100, 1);
		bomCountSpinner = new JSpinner(model);

		GridBagConstraints gbc_fontSize = new GridBagConstraints();
		gbc_fontSize.anchor = GridBagConstraints.WEST;
		gbc_fontSize.insets = new Insets(0, 0, 5, 5);
		gbc_fontSize.gridx = 1;
		gbc_fontSize.gridy = 2;
		((GridBagLayout) getContentPane().getLayout()).setConstraints(
				bomCountSpinner, gbc_fontSize);
		getContentPane().add(bomCountSpinner);
	}

	public void actionPerformed(ActionEvent e) {
//		this.owner.setPropertie((Integer) widthSpinner.getValue(),
//				(Integer) heightSpinner.getValue(), (Integer) bomCountSpinner
//						.getValue());
//		this.owner.initFrame();
		setVisible(false);
	}
}