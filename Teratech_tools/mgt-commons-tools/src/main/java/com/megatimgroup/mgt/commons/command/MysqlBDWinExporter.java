/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.command;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BEKO
 */
public class MysqlBDWinExporter implements ICommand{

    public String CMDE ;
    
    private String batchfile ;    
    
    private String user ;
    
    private String password ;

    private String database;
    
    private String execpath ;
    /**
     * 
     * @param batchfile
     * @param user
     * @param password 
     * @param database 
     */
    public MysqlBDWinExporter(String batchfile, String user, String password,String database) {
        this.batchfile = batchfile;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    /**
     * 
     * @param CMDE = = "cmd.exe"
     * @param batchfile
     * @param user
     * @param password
     * @param database
     * @param execpath 
     */
    public MysqlBDWinExporter(String CMDE, String batchfile, String execpath, String user, String password, String database) {
        this.CMDE = CMDE;
        this.batchfile = batchfile;
        this.user = user;
        this.password = password;
        this.database = database;
        this.execpath = execpath;
    }

    
    
    
    
    @Override
    public boolean execute() throws IOException, InterruptedException {      
        
            //To change body of generated methods, choose Tools | Templates.
            //Creation du process
            ProcessBuilder pb = new ProcessBuilder(CMDE,"/C",batchfile);
            if(execpath!=null && !execpath.trim().isEmpty()){
                pb.directory(new File(execpath));
            }//end if(execpath!=null && !execpath.trim().isEmpty()){
            //Demarrage de la commande
            Process process = pb.start();
            //Attente des operatons
            process.waitFor();
            return true;       
       
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args){
        try {
            System.out.println(MysqlBDWinExporter.class.toString()+" ======= "+System.getProperty("user.dir"));
            MysqlBDWinExporter exporter = new MysqlBDWinExporter("export_db.cmd", "root", "megatim","d:\\keren_db");
            exporter.execute();
        } catch (IOException ex) {
            Logger.getLogger(MysqlBDWinExporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MysqlBDWinExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
