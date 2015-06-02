package com.mutual.reporte;

import java.sql.Connection;

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

	public static void createReport(Connection conn, String pathReporte) {
		try {
			report = (JasperReport) JRLoader.loadObjectFromFile(pathReporte);
			reportFilled = JasperFillManager.fillReport(report, null, conn);
		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

	public static void showViewer() {
		viewer = new JasperViewer(reportFilled, false);
		viewer.setVisible(true);
	}

	public static void exportToPDF(String destination, String extension) {
		try {

			switch (extension) {
			case "pdf":
				JasperExportManager.exportReportToPdfFile(reportFilled, destination + "." + extension);
				
				break;

			}

		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}
}
