package com.cmv.petGenesis.view.historyManagement;


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
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelResultExamBody extends JPanel{
	
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
	
	private CustomLabel lblRDientes, lblRMucosa, lblRLengua, lblRTonsilas, lblRFAringe, lblRLaringe, rAddOral;
	private CustomLabel lblRTrufa, lblRFlujoNasal, lblRRespiracion, rAddNose;
	private CustomLabel lblRConjuntiva, lblREsclerotica, lblRCornea, lblRIris, lblRCristalino, lblRParpados, rAddEyes;
	private CustomLabel lblROreja, lblRCondAudExt, lblRTimpano, rAddEars;
	private CustomLabel lblRTraquea, lblRSonidosPulmonares, lblRRuidosCardiacos, rAddTorax;
	private CustomLabel lblREstomago, lblRIntestinos, lblRHigado, lblRBazo, lblRRiniones, lblRVejiga, rAddAbs;
	private CustomLabel lblRSubmaxilares, lblRPreescapulares, lblRPopliteos, lblRMesentericos, rAddLinfatics;
	private CustomLabel lblRTesticulos, lblRPrepucioPene, lblRProstata, lblRVulva, lblRVagina, lblRUtero, rAddGenitals;
	private CustomLabel lblRTumoraciones, lblRHeridas, lblRParasitosExternos, lblRPelaje, lblRGlandulasAnales, lblRGlandulasMamarias, lblRDeshidratacion, rAddTengument;
	private CustomLabel lblRClaudicacion, lblRArticulaciones, lblRHuesos, lblRTejidosBlandos, rAddExtrems;
	private CustomLabel lblRActitud, lblRReflejos, lblRCerebro, lblRMedulaEspinal, rAddSNC;

	
	private JScrollPane jScrollPane;
	
	protected int idExamBody;
	
	public JPanelResultExamBody() {
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
		
		lblRDientes = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRMucosa = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRLengua = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRTonsilas = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRFAringe = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRLaringe = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddOral  = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPOralCavid.add(lblDientes, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPOralCavid.add(lblRDientes, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPOralCavid.add(lblMucosa, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPOralCavid.add(lblRMucosa, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPOralCavid.add(lblLengua, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPOralCavid.add(lblRLengua, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPOralCavid.add(lblTonsilas, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPOralCavid.add(lblRTonsilas, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPOralCavid.add(lblFAringe, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPOralCavid.add(lblRFAringe, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPOralCavid.add(lblLaringe, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPOralCavid.add(lblRLaringe, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		jPOralCavid.add(addOral, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		jPOralCavid.add(rAddOral, gbc);
		
		jPAuxPanel.add(jPOralCavid);
	}
	
	private void initAreaNose() {
		jPNose.setBorder(BorderFactory.createTitledBorder("NARIZ"));
		lblTrufa = new CustomLabel("Trufa", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblFlujoNasal = new CustomLabel("Flujo Nasal", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblRespiracion = new CustomLabel("Respiración", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addNose = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
	
		lblRTrufa = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRFlujoNasal = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRRespiracion = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddNose = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPNose.add(lblTrufa, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPNose.add(lblRTrufa, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPNose.add(lblFlujoNasal, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPNose.add(lblRFlujoNasal, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPNose.add(lblRespiracion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPNose.add(lblRRespiracion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPNose.add(addNose, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPNose.add(rAddNose, gbc);
		
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
		
		lblRConjuntiva = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblREsclerotica = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRCornea = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRIris = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRCristalino = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRParpados = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddEyes = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPEyes.add(lblConjuntiva, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPEyes.add(lblRConjuntiva, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPEyes.add(lblEsclerotica, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPEyes.add(lblREsclerotica, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPEyes.add(lblCornea, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPEyes.add(lblRCornea, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPEyes.add(lblIris, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPEyes.add(lblRIris, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPEyes.add(lblCristalino, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPEyes.add(lblRCristalino, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPEyes.add(lblParpados, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPEyes.add(lblRParpados, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		jPEyes.add(addEyes, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		jPEyes.add(rAddEyes, gbc);
		
		jPAuxPanel.add(jPEyes);
	}
	
	private void initAreaEars() {
		jPEars.setBorder(BorderFactory.createTitledBorder("OÍDOS"));
		lblOreja = new CustomLabel("Oreja", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblCondAudExt = new CustomLabel("Cond. Aud. Ext.", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblTimpano = new CustomLabel("Tímpano", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addEars = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		
		lblROreja = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRCondAudExt = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRTimpano = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddEars = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPEars.add(lblOreja, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPEars.add(lblROreja, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPEars.add(lblCondAudExt, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPEars.add(lblRCondAudExt, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPEars.add(lblTimpano, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPEars.add(lblRTimpano, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPEars.add(addEars, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPEars.add(rAddEars, gbc);
		
		jPAuxPanel.add(jPEars);
	}
	
	private void initAreaTorax() {
		jPTorax.setBorder(BorderFactory.createTitledBorder("TÓRAX"));
		lblTraquea = new CustomLabel("Tráquea", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblSonidosPulmonares = new CustomLabel("Sonidos Pulmonares", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblRuidosCardiacos = new CustomLabel("Ruidos Cardiacos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addTorax = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		
		lblRTraquea = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRSonidosPulmonares = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRRuidosCardiacos = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddTorax = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPTorax.add(lblTraquea, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPTorax.add(lblRTraquea, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPTorax.add(lblSonidosPulmonares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPTorax.add(lblRSonidosPulmonares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPTorax.add(lblRuidosCardiacos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPTorax.add(lblRRuidosCardiacos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPTorax.add(addTorax, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPTorax.add(rAddTorax, gbc);
		
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
		
		lblREstomago = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRIntestinos = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRHigado = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRBazo = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRRiniones = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRVejiga = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddAbs = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPAbs.add(lblEstomago, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPAbs.add(lblREstomago, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPAbs.add(lblIntestinos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPAbs.add(lblRIntestinos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPAbs.add(lblHigado, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPAbs.add(lblRHigado, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPAbs.add(lblBazo, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPAbs.add(lblRBazo, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPAbs.add(lblRiniones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPAbs.add(lblRRiniones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPAbs.add(lblVejiga, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPAbs.add(lblRVejiga, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		jPAbs.add(addAbs, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		jPAbs.add(rAddAbs, gbc);
		
		jPAuxPanel.add(jPAbs);
	}
	
	private void initAreaLinfatics() {
		jPLinfatics.setBorder(BorderFactory.createTitledBorder("GANGLIOS LINFÁTICOS"));
		lblSubmaxilares = new CustomLabel("Submaxilares", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblPreescapulares = new CustomLabel("Preescapulares", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblPopliteos = new CustomLabel("Poplíteos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblMesentericos = new CustomLabel("Mesentéricos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addLinfatics = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		
		lblRSubmaxilares = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRPreescapulares = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRPopliteos = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRMesentericos = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddLinfatics = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPLinfatics.add(lblSubmaxilares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPLinfatics.add(lblRSubmaxilares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPLinfatics.add(lblPreescapulares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPLinfatics.add(lblRPreescapulares, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPLinfatics.add(lblPopliteos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPLinfatics.add(lblRPopliteos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPLinfatics.add(lblMesentericos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPLinfatics.add(lblRMesentericos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPLinfatics.add(addLinfatics, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPLinfatics.add(rAddLinfatics, gbc);
		
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
		
		lblRTesticulos = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRPrepucioPene = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRProstata = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRVulva = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRVagina = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRUtero = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddGenitals = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPGenitals.add(lblTesticulos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPGenitals.add(lblRTesticulos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPGenitals.add(lblPrepucioPene, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPGenitals.add(lblRPrepucioPene, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPGenitals.add(lblProstata, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPGenitals.add(lblRProstata, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPGenitals.add(lblVulva, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPGenitals.add(lblRVulva, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPGenitals.add(lblVagina, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPGenitals.add(lblRVagina, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPGenitals.add(lblUtero, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPGenitals.add(lblRUtero, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		jPGenitals.add(addGenitals, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		jPGenitals.add(rAddGenitals, gbc);
		
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
		
		lblRTumoraciones = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRHeridas = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRParasitosExternos = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRPelaje = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRGlandulasAnales = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRGlandulasMamarias = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRDeshidratacion = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddTengument = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPTegument.add(lblTumoraciones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPTegument.add(lblRTumoraciones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPTegument.add(lblHeridas, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPTegument.add(lblRHeridas, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPTegument.add(lblParasitosExternos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPTegument.add(lblRParasitosExternos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPTegument.add(lblPelaje, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPTegument.add(lblRPelaje, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPTegument.add(lblGlandulasAnales, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPTegument.add(lblRGlandulasAnales, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPTegument.add(lblGlandulasMamarias, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPTegument.add(lblRGlandulasMamarias, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		jPTegument.add(lblDeshidratacion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		jPTegument.add(lblRDeshidratacion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 7);
		jPTegument.add(addTengument, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 7);
		jPTegument.add(rAddTengument, gbc);
		
		jPAuxPanel.add(jPTegument);
	}
	
	private void initAreaExtrems() {
		jPExtrems.setBorder(BorderFactory.createTitledBorder("EXTREMIDADES"));
		lblClaudicacion = new CustomLabel("Claudicación", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblArticulaciones = new CustomLabel("Articulaciones", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblHuesos = new CustomLabel("Huesos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblTejidosBlandos = new CustomLabel("Tejidos Blandos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addExtrems = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		
		lblRClaudicacion = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRArticulaciones = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRHuesos = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRTejidosBlandos = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddExtrems = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPExtrems.add(lblClaudicacion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPExtrems.add(lblRClaudicacion, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPExtrems.add(lblArticulaciones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPExtrems.add(lblRArticulaciones, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPExtrems.add(lblHuesos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPExtrems.add(lblRHuesos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPExtrems.add(lblTejidosBlandos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPExtrems.add(lblRTejidosBlandos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPExtrems.add(addExtrems, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPExtrems.add(rAddExtrems, gbc);
		
		jPAuxPanel.add(jPExtrems);
	}
	
	private void initAreaSNC() {
		jPSNC.setBorder(BorderFactory.createTitledBorder("SISTEMA NERVIOSO CENTRAL"));
		lblActitud = new CustomLabel("Actitud", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblReflejos = new CustomLabel("Reflejos", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblCerebro = new CustomLabel("Cerebro", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		lblMedulaEspinal = new CustomLabel("Médula Espinal", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		addSNC = new CustomLabel("Adicional", ConstantView.FONT_LABELS_BODY, Color.BLACK);
		
		lblRActitud = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRReflejos = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRCerebro = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		lblRMedulaEspinal = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		rAddSNC = new CustomLabel("", ConstantView.FONT_LABELS_BODY_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPSNC.add(lblActitud, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPSNC.add(lblRActitud, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPSNC.add(lblReflejos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPSNC.add(lblRReflejos, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPSNC.add(lblCerebro, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPSNC.add(lblRCerebro, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPSNC.add(lblMedulaEspinal, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPSNC.add(lblRMedulaEspinal, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPSNC.add(addSNC, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jPSNC.add(rAddSNC, gbc);
		
		jPAuxPanel.add(jPSNC);
	}
	
	public void setDataExamBody() {
		
	}
}
