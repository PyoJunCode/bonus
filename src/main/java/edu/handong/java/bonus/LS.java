package edu.handong.java.bonus;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;


public class LS {
	
	boolean c_opt;
	boolean m_opt;
	boolean F_opt;
	boolean s_opt;
	boolean na_opt;
	
	
	boolean help;
	
	String Path;

	
	public void run(String[] args) {
		
		Options options = createOptions();
		
		parseOptions(options, args);
			
		if (help || args.length == 0) printHelp(options);
		else
		this.lsRun();
		
		
		
	}
	
	private Options createOptions() {
		Options options = new Options();


		// add options by using OptionBuilder
		options.addOption(Option.builder("m").longOpt("modified")
				.desc("print modified date of file.")
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("F").longOpt("F")
				.desc("appends a character revealing the nature of a file")
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("s").longOpt("size")
				.desc("size of the file")
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("help").longOpt("help")
				.desc("show help.")
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("c").longOpt("custom")
				.desc("Set user's custom path")
				.hasArg()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("na").longOpt("not all")
				.desc("hide hidden file information")
				.build());



		return options;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "bonus-ls";
		String footer ="";
		formatter.printHelp("bonus-ls", header, options, footer, true);
	}
	
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		
		
		try {

			CommandLine cmd = parser.parse(options , args);
			
			c_opt = cmd.hasOption("c");
			Path = cmd.getOptionValue("c");
			m_opt = cmd.hasOption("m");
			F_opt = cmd.hasOption("F");
			s_opt = cmd.hasOption("s");
			na_opt = cmd.hasOption("na");
			help = cmd.hasOption("help");
			
			
			
			

				
				
				
			}
	
			catch (Exception e) {
			printHelp(options);
			System.exit(-1);
			}
		
		return true;
	}
	
	public void lsRun() {
		
		ArrayList<String> filesName = new ArrayList<String>();
		
		if(!c_opt) Path = System.getProperty("user.dir");

		System.out.println("ls command in path : " + Path);
		System.out.println("------------------List-----------------");
		
		File lsFile = new File(Path);
		File[] list = lsFile.listFiles();
		
		
		
		
		for(File files : list) {
			
			if(s_opt) {
				
				if(files.isDirectory())
					filesName.add(files.getName() + "\tFile Size : is Directory.");
			
				else
					filesName.add(files.getName() + "\tFile Size : " + files.length() + " byte.");
			}
			
			else if(F_opt) {
				
				if(files.isDirectory())
					filesName.add(files.getName()+"/");
				else if(files.canExecute())
					filesName.add(files.getName()+"*");
				else
					filesName.add(files.getName());
			}
			
			else if(m_opt) {
				SimpleDateFormat day = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				
				filesName.add(files.getName() + "\tmodified date : " + day.format(files.lastModified()));
			}
			
			else {
				filesName.add(files.getName());
			}
			
			
		}//for
		
		
		for(String print : filesName) {
			
			if(na_opt) {
				if(!print.startsWith("."))
					System.out.println(print);
			}
				
			
		else
			System.out.println(print);
		}
		
		
		
	}
	
	
}

