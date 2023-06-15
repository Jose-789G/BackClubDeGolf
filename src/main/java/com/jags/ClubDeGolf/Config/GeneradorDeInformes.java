package com.jags.ClubDeGolf.Config;

import com.jags.ClubDeGolf.Modelo.Socio;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

import java.util.HashMap;
import java.util.List;

public class GeneradorDeInformes {
    public static void informe_socio(List<Socio> lista){
        JasperPrint print;
        HashMap param = new HashMap<>();
        param.put("---","---");

        try {
            JRDataSource datasource = new JRBeanArrayDataSource(lista.toArray());
            String report = "src/main/java/com/jags/ClubDeGolf/Config/Informes/Blank_A4.jasper";
            print = JasperFillManager.fillReport(report,param,datasource);
            JasperExportManager.exportReportToPdfFile(print,"SociosClub.pdf");
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
