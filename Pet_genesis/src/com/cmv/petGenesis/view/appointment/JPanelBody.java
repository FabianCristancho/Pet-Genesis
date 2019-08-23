package com.cmv.petGenesis.view.appointment;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.cmv.petGenesis.connection.SQLExam;
import com.cmv.petGenesis.connection.SQLHistory;
import com.cmv.petGenesis.model.ExamBody;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelBody extends JPanel{
	
	private JPanel jPAuxPanel, jPOralCavid, jPNose, jPEyes, jPEars, jPTorax, jPAbs, jPLinfatics, jPGenitals, jPTegument, jPExtrems, jPSNC;
	private CustomLabel lblDientes, lblMucosa, lblLengua, lblTonsilas, lblFAringe, lblLaringe, addOral;
	private CustomLabel lblTrufa, lblFlujoNasal, lblRespiracion, addNose;
	private CustomLabel lblConjuntiva, lblEsclerotica, lblCornea, lblIris, lblCristalino, lblParpados, addEyes;
	private CustomLabel lblOreja, lblCondAudExt, lblTimpano, addEars;
	private CustomLabel lblTraquea, lblSonidosPulmonares, lblRuidosCardiacos, addTorax;
	private CustomLabel lblEstomago, lblIntestinos, lblHigado, lblBazo, lblRiniones, lblVejiga, addAbs;
	private CustomLabel lblSubmaxilares, lblPreescapulares, lblPopliteos, lblMesentericos, addLinfatics;
	private CustomLabel lblTesticulos, lblPrepucioPene, lblProstata, lblVulva, lblVagina, lblUtero, addGenitals;
	private CustomLabel lblTumoraciones, lblHeridas, lblParasitosExternos, lblPelaje, lblGlandulasAnales, lblGlandulasMamarias, lblDeshidratacion, addTengument;
	private CustomLabel lblClaudicacion, lblArticulaciones, lblHuesos, lblTejidosBlandos, addExtrems;
	private CustomLabel lblActitud, lblReflejos, lblCerebro, lblMedulaEspinal, addSNC;
	
	private CustomTxtField jtfDientes, jtfMucosa, jtfLengua, jtfTonsilas, jtfFAringe, jtfLaringe, jtfAddOral;
	private CustomTxtField jtfTrufa, jtfFlujoNasal, jtfRespiracion, jtfAddNose;
	private CustomTxtField jtfConjuntiva, jtfEsclerotica, jtfCornea, jtfIris, jtfCristalino, jtfParpados, jtfAddEyes;
	private CustomTxtField jtfOreja, jtfCondAudExt, jtfTimpano, jtfAddEars;
	private CustomTxtField jtfTraquea, jtfSonidosPulmonares, jtfRuidosCardiacos, jtfAddTorax;
	private CustomTxtField jtfEstomago, jtfIntestinos, jtfHigado, jtfBazo, jtfRiniones, jtfVejiga, jtfAddAbs;
	private CustomTxtField jtfSubmaxilares, jtfPreescapulares, jtfPopliteos, jtfMesentericos, jtfAddLinfatics;
	private CustomTxtField jtfTesticulos, jtfPrepucioPene, jtfProstata, jtfVulva, jtfVagina, jtfUtero, jtfAddGenitals;
	private CustomTxtField jtfTumoraciones, jtfHeridas, jtfParasitosExternos, jtfPelaje, jtfGlandulasAnales, jtfGlandulasMamarias, jtfDeshidratacion, jtfAddTengument;
	private CustomTxtField jtfClaudicacion, jtfArticulaciones, jtfHuesos, jtfTejidosBlandos, jtfAddExtrems;
	private CustomTxtField jtfActitud, jtfReflejos, jtfCerebro, jtfMedulaEspinal, jtfAddSNC;
	
	private JScrollPane jScrollPane;
	
	protected int idExamBody;
	
	public JPanelBody() {
		super();
		jPOralCavid = new JPanel(new GridBagLayout());
		jPNose = new JPanel(new GridBagLayout());
		jPEyes = new JPanel(new GridBagLayout());
		jPEars = new JPanel(new GridBagLayout());
		jPTorax = new JPanel(new GridBagLayout());
		jPAbs = new JPanel(new GridBagLayout());
		jPLinfatics = new JPanel(new GridBagLayout());
		jPGenitals = new JPanel(new GridBagLayout());
		jPTegument = new JPanel(new GridBagLayout());
		jPExtrems = new JPanel(new GridBagLayout());
		jPSNC = new JPanel(new GridBagLayout());
		jPAuxPanel = new JPanel(new GridLayout(6, 2, 5, 5));
		jScrollPane = new JScrollPane();
		
		SQLExam sqlExam = new SQLExam();
		idExamBody = sqlExam.getLastBody()+1;
		
		init();
	}

	private void init() {
		initAreaOralCavid();
		initAreaNose();
		initAreaEyes();
		initAreaEars();
		initAreaTorax();
		initAreaAbs();
		initAreaLinfatics();
		initAreaGenitals();
		initAreaTegument();
		initAreaExtrems();
		initAreaSNC();
		
		jScrollPane.setPreferredSize(new Dimension(850, 500));
		jScrollPane.setViewportView(jPAuxPanel);
		this.add(jPAuxPanel);
	}
	
	
	private void initAreaOralCavid() {
		jPOralCavid.setBorder(BorderFactory.createTitledBorder("CAVIDAD ORAL"));
		lblDientes = new CustomLabel("Dientes", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblMucosa = new CustomLabel("Mucosa", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblLengua = new CustomLabel("Lengua", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblTonsilas = new CustomLabel("Tonsilas", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblFAringe = new CustomLabel("Faringe", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblLaringe = new CustomLabel("Laringe", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addOral  = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfDientes = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfMucosa = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfLengua = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfTonsilas = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfFAringe = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfLaringe = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddOral = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPOralCavid.add(lblDientes, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPOralCavid.add(jtfDientes, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPOralCavid.add(lblMucosa, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPOralCavid.add(jtfMucosa, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPOralCavid.add(lblLengua, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPOralCavid.add(jtfLengua, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPOralCavid.add(lblTonsilas, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPOralCavid.add(jtfTonsilas, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPOralCavid.add(lblFAringe, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPOralCavid.add(jtfFAringe, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPOralCavid.add(lblLaringe, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPOralCavid.add(jtfLaringe, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		jPOralCavid.add(addOral, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		jPOralCavid.add(jtfAddOral, gbc);
		
		jPAuxPanel.add(jPOralCavid);
	}
	
	private void initAreaNose() {
		jPNose.setBorder(BorderFactory.createTitledBorder("NARIZ"));
		lblTrufa = new CustomLabel("Trufa", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblFlujoNasal = new CustomLabel("Flujo Nasal", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblRespiracion = new CustomLabel("Respiración", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addNose = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfTrufa = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfFlujoNasal = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfRespiracion = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddNose = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPNose.add(lblTrufa, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPNose.add(jtfTrufa, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPNose.add(lblFlujoNasal, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPNose.add(jtfFlujoNasal, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPNose.add(lblRespiracion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPNose.add(jtfRespiracion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPNose.add(addNose, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPNose.add(jtfAddNose, gbc);
		
		jPAuxPanel.add(jPNose);
	}
	
	private void initAreaEyes() {
		jPEyes.setBorder(BorderFactory.createTitledBorder("OJOS"));
		lblConjuntiva = new CustomLabel("Conjuntiva", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblEsclerotica = new CustomLabel("Esclerótica", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblCornea = new CustomLabel("Córnea", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblIris = new CustomLabel("Iris", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblCristalino = new CustomLabel("Cristalino", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblParpados = new CustomLabel("Párpados", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addEyes = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfConjuntiva = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfEsclerotica = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfCornea = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfIris = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfCristalino = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfParpados = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddEyes = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPEyes.add(lblConjuntiva, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPEyes.add(jtfConjuntiva, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPEyes.add(lblEsclerotica, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPEyes.add(jtfEsclerotica, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPEyes.add(lblCornea, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPEyes.add(jtfCornea, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPEyes.add(lblIris, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPEyes.add(jtfIris, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPEyes.add(lblCristalino, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPEyes.add(jtfCristalino, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPEyes.add(lblParpados, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPEyes.add(jtfParpados, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		jPEyes.add(addEyes, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		jPEyes.add(jtfAddEyes, gbc);
		
		jPAuxPanel.add(jPEyes);
	}
	
	private void initAreaEars() {
		jPEars.setBorder(BorderFactory.createTitledBorder("OÍDOS"));
		lblOreja = new CustomLabel("Oreja", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblCondAudExt = new CustomLabel("Cond. Aud. Ext.", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblTimpano = new CustomLabel("Tímpano", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addEars = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfOreja = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfCondAudExt = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfTimpano = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddEars = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPEars.add(lblOreja, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPEars.add(jtfOreja, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPEars.add(lblCondAudExt, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPEars.add(jtfCondAudExt, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPEars.add(lblTimpano, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPEars.add(jtfTimpano, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPEars.add(addEars, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPEars.add(jtfAddEars, gbc);
		
		jPAuxPanel.add(jPEars);
	}
	
	private void initAreaTorax() {
		jPTorax.setBorder(BorderFactory.createTitledBorder("TÓRAX"));
		lblTraquea = new CustomLabel("Tráquea", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblSonidosPulmonares = new CustomLabel("Sonidos Pulmonares", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblRuidosCardiacos = new CustomLabel("Ruidos Cardiacos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addTorax = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfTraquea = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfSonidosPulmonares = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfRuidosCardiacos = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddTorax = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPTorax.add(lblTraquea, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPTorax.add(jtfTraquea, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPTorax.add(lblSonidosPulmonares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPTorax.add(jtfSonidosPulmonares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPTorax.add(lblRuidosCardiacos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPTorax.add(jtfRuidosCardiacos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPTorax.add(addTorax, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPTorax.add(jtfAddTorax, gbc);
		
		jPAuxPanel.add(jPTorax);
	}
	
	private void initAreaAbs() {
		jPAbs.setBorder(BorderFactory.createTitledBorder("ABDOMEN"));
		lblEstomago = new CustomLabel("Estómago", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblIntestinos = new CustomLabel("Intestinos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblHigado = new CustomLabel("Hígado", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblBazo = new CustomLabel("Bazo", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblRiniones = new CustomLabel("Riñones", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblVejiga = new CustomLabel("Vejiga", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addAbs = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfEstomago = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfIntestinos = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfHigado = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfBazo = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfRiniones = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfVejiga = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddAbs = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPAbs.add(lblEstomago, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPAbs.add(jtfEstomago, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPAbs.add(lblIntestinos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPAbs.add(jtfIntestinos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPAbs.add(lblHigado, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPAbs.add(jtfHigado, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPAbs.add(lblBazo, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPAbs.add(jtfBazo, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPAbs.add(lblRiniones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPAbs.add(jtfRiniones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPAbs.add(lblVejiga, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPAbs.add(jtfVejiga, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		jPAbs.add(addAbs, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		jPAbs.add(jtfAddAbs, gbc);
		
		jPAuxPanel.add(jPAbs);
	}
	
	private void initAreaLinfatics() {
		jPLinfatics.setBorder(BorderFactory.createTitledBorder("GANGLIOS LINFÁTICOS"));
		lblSubmaxilares = new CustomLabel("Submaxilares", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblPreescapulares = new CustomLabel("Preescapulares", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblPopliteos = new CustomLabel("Poplíteos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblMesentericos = new CustomLabel("Mesentéricos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addLinfatics = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfSubmaxilares = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfPreescapulares = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfPopliteos = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfMesentericos = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddLinfatics = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPLinfatics.add(lblSubmaxilares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPLinfatics.add(jtfSubmaxilares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPLinfatics.add(lblPreescapulares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPLinfatics.add(jtfPreescapulares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPLinfatics.add(lblPopliteos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPLinfatics.add(jtfPopliteos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPLinfatics.add(lblMesentericos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPLinfatics.add(jtfMesentericos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPLinfatics.add(addLinfatics, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPLinfatics.add(jtfAddLinfatics, gbc);
		
		jPAuxPanel.add(jPLinfatics);
	}
	
	private void initAreaGenitals() {
		jPGenitals.setBorder(BorderFactory.createTitledBorder("GENITALES"));
		lblTesticulos = new CustomLabel("Testículos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblPrepucioPene = new CustomLabel("Prepucio y Pene", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblProstata = new CustomLabel("Próstata", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblVulva = new CustomLabel("Vulva", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblVagina = new CustomLabel("Vagina", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblUtero = new CustomLabel("Útero", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addGenitals = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfTesticulos = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfPrepucioPene = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfProstata = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfVulva = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfVagina = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfUtero = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddGenitals = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPGenitals.add(lblTesticulos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPGenitals.add(jtfTesticulos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPGenitals.add(lblPrepucioPene, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPGenitals.add(jtfPrepucioPene, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPGenitals.add(lblProstata, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPGenitals.add(jtfProstata, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPGenitals.add(lblVulva, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPGenitals.add(jtfVulva, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPGenitals.add(lblVagina, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPGenitals.add(jtfVagina, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPGenitals.add(lblUtero, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPGenitals.add(jtfUtero, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		jPGenitals.add(addGenitals, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		jPGenitals.add(jtfAddGenitals, gbc);
		
		jPAuxPanel.add(jPGenitals);
	}
	
	private void initAreaTegument() {
		jPTegument.setBorder(BorderFactory.createTitledBorder("TEGUMENTO"));
		lblTumoraciones = new CustomLabel("Tumoraciones", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblHeridas = new CustomLabel("Heridas", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblParasitosExternos = new CustomLabel("Parásitos Externos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblPelaje = new CustomLabel("Pelaje", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblGlandulasAnales = new CustomLabel("Glándulas Anales", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblGlandulasMamarias = new CustomLabel("Glándulas Mamarias", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblDeshidratacion = new CustomLabel("Deshidratación", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addTengument = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfTumoraciones = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfHeridas = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfParasitosExternos = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfPelaje = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfGlandulasAnales = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfGlandulasMamarias = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfDeshidratacion = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddTengument = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPTegument.add(lblTumoraciones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPTegument.add(jtfTumoraciones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPTegument.add(lblHeridas, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPTegument.add(jtfHeridas, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPTegument.add(lblParasitosExternos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPTegument.add(jtfParasitosExternos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPTegument.add(lblPelaje, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPTegument.add(jtfPelaje, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPTegument.add(lblGlandulasAnales, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPTegument.add(jtfGlandulasAnales, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPTegument.add(lblGlandulasMamarias, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPTegument.add(jtfGlandulasMamarias, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		jPTegument.add(lblDeshidratacion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		jPTegument.add(jtfDeshidratacion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 7);
		jPTegument.add(addTengument, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 7);
		jPTegument.add(jtfAddTengument, gbc);
		
		jPAuxPanel.add(jPTegument);
	}
	
	private void initAreaExtrems() {
		jPExtrems.setBorder(BorderFactory.createTitledBorder("EXTREMIDADES"));
		lblClaudicacion = new CustomLabel("Claudicación", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblArticulaciones = new CustomLabel("Articulaciones", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblHuesos = new CustomLabel("Huesos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblTejidosBlandos = new CustomLabel("Tejidos Blandos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addExtrems = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfClaudicacion = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfArticulaciones = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfHuesos = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfTejidosBlandos = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddExtrems = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPExtrems.add(lblClaudicacion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPExtrems.add(jtfClaudicacion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPExtrems.add(lblArticulaciones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPExtrems.add(jtfArticulaciones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPExtrems.add(lblHuesos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPExtrems.add(jtfHuesos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPExtrems.add(lblTejidosBlandos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPExtrems.add(jtfTejidosBlandos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPExtrems.add(addExtrems, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPExtrems.add(jtfAddExtrems, gbc);
		
		jPAuxPanel.add(jPExtrems);
	}
	
	private void initAreaSNC() {
		jPSNC.setBorder(BorderFactory.createTitledBorder("SISTEMA NERVIOSO CENTRAL"));
		lblActitud = new CustomLabel("Actitud", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblReflejos = new CustomLabel("Reflejos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblCerebro = new CustomLabel("Cerebro", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblMedulaEspinal = new CustomLabel("Médula Espinal", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addSNC = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		jtfActitud = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfReflejos = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfCerebro = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfMedulaEspinal = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
		jtfAddSNC = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM);
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPSNC.add(lblActitud, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPSNC.add(jtfActitud, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPSNC.add(lblReflejos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPSNC.add(jtfReflejos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPSNC.add(lblCerebro, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPSNC.add(jtfCerebro, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPSNC.add(lblMedulaEspinal, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPSNC.add(jtfMedulaEspinal, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPSNC.add(addSNC, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPSNC.add(jtfAddSNC, gbc);
		
		jPAuxPanel.add(jPSNC);
	}
	
	public ExamBody getResultExamBody() {
		ExamBody examBody = new ExamBody();
		
		examBody.setIdExamBody(idExamBody);
		examBody.setDientes(jtfDientes.getText());
		examBody.setMucosa(jtfMucosa.getText());
		examBody.setLengua(jtfLengua.getText());
		examBody.setTonsillas(jtfTonsilas.getText());
		examBody.setFaringe(jtfFAringe.getText());
		examBody.setLaringe(jtfLaringe.getText());
		examBody.setOralAdd(jtfAddOral.getText());
		examBody.setTrufa(jtfTrufa.getText());
		examBody.setFlujoNasal(jtfFlujoNasal.getText());
		examBody.setRespiracion(jtfRespiracion.getText());
		examBody.setNarizAdd(jtfAddNose.getText());
		examBody.setConjuntiva(jtfConjuntiva.getText());
		examBody.setEsclerotica(jtfEsclerotica.getText());
		examBody.setCornea(jtfCornea.getText());
		examBody.setIris(jtfIris.getText());
		examBody.setCristalino(jtfCristalino.getText());
		examBody.setParpados(jtfParpados.getText());
		examBody.setOjosAdd(jtfAddEyes.getText());
		examBody.setOreja(jtfOreja.getText());
		examBody.setCondAudExt(jtfCondAudExt.getText());
		examBody.setTimpano(jtfTimpano.getText());
		examBody.setOidosAdd(jtfAddEars.getText());
		examBody.setTraquea(jtfTraquea.getText());
		examBody.setSonidosPulmonares(jtfSonidosPulmonares.getText());
		examBody.setRuidosCardiacos(jtfRuidosCardiacos.getText());
		examBody.setToraxAdd(jtfAddTorax.getText());
		examBody.setEstomago(jtfEstomago.getText());
		examBody.setIntestinos(jtfIntestinos.getText());
		examBody.setHigado(jtfHigado.getText());
		examBody.setBazo(jtfBazo.getText());
		examBody.setRiniones(jtfRiniones.getText());
		examBody.setVejiga(jtfVejiga.getText());
		examBody.setAbdomenAdd(jtfAddAbs.getText());
		examBody.setSubmaxilares(jtfSubmaxilares.getText());
		examBody.setPreescapulares(jtfPreescapulares.getText());
		examBody.setPopliteos(jtfPopliteos.getText());
		examBody.setMesentericos(jtfMesentericos.getText());
		examBody.setGangliosAdd(jtfAddLinfatics.getText());
		examBody.setTesticulos(jtfTesticulos.getText());
		examBody.setPrepuecio(jtfPrepucioPene.getText());
		examBody.setProstata(jtfProstata.getText());
		examBody.setVulva(jtfVulva.getText());
		examBody.setVagina(jtfVagina.getText());
		examBody.setUtero(jtfUtero.getText());
		examBody.setGenitalesAdd(jtfAddGenitals.getText());
		examBody.setTumoraciones(jtfTumoraciones.getText());
		examBody.setHeridas(jtfHeridas.getText());
		examBody.setParasitos(jtfParasitosExternos.getText());
		examBody.setPelaje(jtfPelaje.getText());
		examBody.setgAnales(jtfGlandulasAnales.getText());
		examBody.setgMamarias(jtfGlandulasMamarias.getText());
		examBody.setDeshidratacion(jtfDeshidratacion.getText());
		examBody.setTegumentoAdd(jtfAddTengument.getText());
		examBody.setClaudicacion(jtfClaudicacion.getText());
		examBody.setArticulaciones(jtfArticulaciones.getText());
		examBody.setHuesos(jtfHuesos.getText());
		examBody.setTejidosBlandos(jtfTejidosBlandos.getText());
		examBody.setExtremidadesAdd(jtfAddExtrems.getText());
		examBody.setActitud(jtfActitud.getText());
		examBody.setReflejos(jtfReflejos.getText());
		examBody.setCerebro(jtfCerebro.getText());
		examBody.setMedulaEspinal(jtfMedulaEspinal.getText());
		examBody.setSncAdd(jtfAddSNC.getText());
		
		return examBody;
	}

	public int getIdExamBody() {
		return idExamBody;
	}
}
