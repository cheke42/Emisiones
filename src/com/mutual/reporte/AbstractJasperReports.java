package com.mutual.reporte;

import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public abstract class AbstractJasperReports {
    private static JasperReport report;
    private static JasperPrint reportFilled;
    private static JasperViewer viewer;

    public static void createReport(Connection conn, String pathReporte,
	    Map<String, Object> parametros) {
	try {
	    report = (JasperReport) JRLoader.loadObjectFromFile(pathReporte);
	    System.out.println("Leyó el path bien");
	    reportFilled = JasperFillManager.fillReport(report, parametros,
		    conn);
	} catch (JRException ex) {
	    System.out.println("Entró en excepcion al crear el reporte");
	    ex.printStackTrace();
	}
    }

    public static void showViewer(String titulo) {
	viewer = new JasperViewer(reportFilled, false);
	viewer.setTitle(titulo);
	viewer.setVisible(true);
    }

    public static void exportToPDF(String destination, String extension) {
	try {

	    switch (extension) {
	    case "pdf":
		JasperExportManager.exportReportToPdfFile(reportFilled,
			destination + "." + extension);

		break;

	    }

	} catch (JRException ex) {
	    ex.printStackTrace();
	}
    }
}
