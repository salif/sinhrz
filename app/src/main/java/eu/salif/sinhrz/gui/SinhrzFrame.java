/*
 * Copyright 2021 Salif Mehmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.salif.sinhrz.gui;

import eu.salif.sinhrz.interfaces.Args;
import eu.salif.sinhrz.interfaces.Localisation;
import eu.salif.sinhrz.interfaces.Sinhrz;
import eu.salif.sinhrz.errors.SinhrzException;
import eu.salif.sinhrz.implementations.ArgsImpl;
import eu.salif.sinhrz.implementations.SinhrzImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;

public class SinhrzFrame extends JFrame implements ActionListener {
	private final Localisation localisation;
	private JTextField inputSinhrzFileName;
	private JTextField inputSinhrzLockFileName;
	private JTextField inputLocalLabel;
	private JTextField inputLocalPath;
	private JTextField inputRemoteLabel;
	private JTextField inputRemotePath;
	private JCheckBox inputDoInit;
	private JCheckBox inputDoVerbose;
	private PrintStream errStream;
	private PrintStream outStream;

	public SinhrzFrame(Localisation localisation) {
		this.localisation = localisation;
		setTitle(String.format("%s | %s", this.localisation.NAME(), this.localisation.LOC_NAME()));
		setSize(500, 500);
		setLayout(null);
		addElements();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void addElements() {
		Container c = this;

		JLabel labelSinhrzFileName = new JLabel(this.localisation.GUI_SINHRZ_FILENAME());
		labelSinhrzFileName.setHorizontalAlignment(SwingConstants.LEFT);
		labelSinhrzFileName.setBounds(20, 50, 200, 30);
		c.add(labelSinhrzFileName);

		inputSinhrzFileName = new JTextField();
		inputSinhrzFileName.setBounds(230, 50, 250, 30);
		inputSinhrzFileName.setText(ArgsImpl.getEnv(this.localisation.ENV_SINHRZ_FILENAME(),
			this.localisation.DEFAULT_SINHRZ_FILENAME()));
		c.add(inputSinhrzFileName);

		labelSinhrzFileName.setLabelFor(inputSinhrzFileName);

		JLabel labelSinhrzLockFileName = new JLabel(this.localisation.GUI_SINHRZ_LOCK_FILENAME());
		labelSinhrzLockFileName.setHorizontalAlignment(SwingConstants.LEFT);
		labelSinhrzLockFileName.setBounds(20, 100, 200, 30);
		c.add(labelSinhrzLockFileName);

		inputSinhrzLockFileName = new JTextField();
		inputSinhrzLockFileName.setBounds(230, 100, 250, 30);
		inputSinhrzLockFileName.setText(ArgsImpl.getEnv(this.localisation.ENV_SINHRZ_LOCK_FILENAME(),
			this.localisation.DEFAULT_SINHRZ_LOCK_FILENAME()));
		c.add(inputSinhrzLockFileName);

		labelSinhrzLockFileName.setLabelFor(inputSinhrzLockFileName);

		JLabel labelLocalLabel = new JLabel(this.localisation.GUI_LOCAL_LABEL());
		labelLocalLabel.setHorizontalAlignment(SwingConstants.LEFT);
		labelLocalLabel.setBounds(20, 150, 200, 30);
		c.add(labelLocalLabel);

		inputLocalLabel = new JTextField();
		inputLocalLabel.setBounds(230, 150, 250, 30);
		inputLocalLabel.setText(ArgsImpl.getEnv(this.localisation.ENV_LOCAL_LABEL(),
			this.localisation.DEFAULT_LOCAL_LABEL()));
		c.add(inputLocalLabel);

		labelLocalLabel.setLabelFor(inputLocalLabel);

		JLabel labelLocalPath = new JLabel(this.localisation.GUI_LOCAL_PATH());
		labelLocalPath.setHorizontalAlignment(SwingConstants.LEFT);
		labelLocalPath.setBounds(20, 200, 200, 30);
		c.add(labelLocalPath);

		inputLocalPath = new JTextField();
		inputLocalPath.setBounds(230, 200, 250, 30);
		inputLocalPath.setText(ArgsImpl.getEnv(this.localisation.ENV_LOCAL_PATH(), ""));
		c.add(inputLocalPath);

		labelLocalPath.setLabelFor(inputLocalPath);

		JLabel labelRemoteLabel = new JLabel(this.localisation.GUI_REMOTE_LABEL());
		labelRemoteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		labelRemoteLabel.setBounds(20, 250, 200, 30);
		c.add(labelRemoteLabel);

		inputRemoteLabel = new JTextField();
		inputRemoteLabel.setBounds(230, 250, 250, 30);
		inputRemoteLabel.setText(ArgsImpl.getEnv(this.localisation.ENV_REMOTE_LABEL(),
			this.localisation.DEFAULT_REMOTE_LABEL()));
		c.add(inputRemoteLabel);

		labelRemoteLabel.setLabelFor(inputRemoteLabel);

		JLabel labelRemotePath = new JLabel(this.localisation.GUI_REMOTE_PATH());
		labelRemotePath.setHorizontalAlignment(SwingConstants.LEFT);
		labelRemotePath.setBounds(20, 300, 200, 30);
		c.add(labelRemotePath);

		inputRemotePath = new JTextField();
		inputRemotePath.setBounds(230, 300, 250, 30);
		inputRemotePath.setText(ArgsImpl.getEnv(this.localisation.ENV_REMOTE_PATH(), ""));
		c.add(inputRemotePath);

		labelRemotePath.setLabelFor(inputRemotePath);

		inputDoInit = new JCheckBox(this.localisation.GUI_DO_INIT());
		inputDoInit.setBounds(20, 350, 200, 30);
		inputDoInit.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		if (System.getenv(this.localisation.ENV_DO_INIT()) != null) {
			inputDoInit.doClick();
		}
		c.add(inputDoInit);

		inputDoVerbose = new JCheckBox(this.localisation.GUI_DO_VERBOSE());
		inputDoVerbose.setBounds(230, 350, 250, 30);
		inputDoVerbose.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		if (System.getenv(this.localisation.ENV_DO_VERBOSE()) != null) {
			inputDoVerbose.doClick();
		}
		c.add(inputDoVerbose);

		JButton btn = new JButton(this.localisation.SYNC_MESSAGE());
		btn.setBounds(150, 400, 200, 30);
		btn.addActionListener(this);
		c.add(btn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ByteArrayOutputStream errOutputStream = new ByteArrayOutputStream();
		this.errStream = new PrintStream(errOutputStream);
		ByteArrayOutputStream outOutputStream = new ByteArrayOutputStream();
		this.outStream = new PrintStream(outOutputStream);
		try {
			Sinhrz sinhrz = new SinhrzImpl();
			sinhrz.setArgs(new Args() {
				@Override
				public Localisation getLocalisation() {
					return localisation;
				}

				@Override
				public PrintStream getErrStream() {
					return errStream;
				}

				@Override
				public PrintStream getOutStream() {
					return outStream;
				}

				@Override
				public String getSinhrzFileName() {
					return inputSinhrzFileName.getText();
				}

				@Override
				public String getSinhrzLockFileName() {
					return inputSinhrzLockFileName.getText();
				}

				@Override
				public String getLocalLabel() {
					return inputLocalLabel.getText();
				}

				@Override
				public Path getLocalPath() {
					return Path.of(inputLocalPath.getText()).normalize();
				}

				@Override
				public String getRemoteLabel() {
					return inputRemoteLabel.getText();
				}

				@Override
				public Path getRemotePath() {
					return Path.of(inputRemotePath.getText()).normalize();
				}

				@Override
				public boolean getDoInit() {
					return inputDoInit.isSelected();
				}

				@Override
				public boolean getDoVerbose() {
					return inputDoVerbose.isSelected();
				}
			});
			boolean success = sinhrz.sync();
			if (success) {
				JTextArea textArea = new JTextArea(outOutputStream.toString());
				JScrollPane scrollPane = new JScrollPane(textArea);
				textArea.setEditable(false);
				scrollPane.setPreferredSize(new Dimension(400, 200));
				JOptionPane.showMessageDialog(this, scrollPane);
			}
		} catch (SinhrzException sinhrzException) {
			sinhrzException.print(localisation, errStream);
			JOptionPane.showMessageDialog(this, errOutputStream.toString(),
				this.localisation.ERROR_MESSAGE(), JOptionPane.ERROR_MESSAGE);
		}
	}
}
