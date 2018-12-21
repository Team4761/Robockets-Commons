package org.robockets.commons.modauto;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class reads autonomous configurations from a file and creates command groups based on the configs
 *
 * USAGE:
 * - Extend AutoCommand instead of Command in your commands
 * - Implement the getNew method
 * - Use @link{#addElement} to add commandNames and commands to the lookup table
 * - Run the desktop program, create a config, and run
 */
public class AutoReader {


	public BidiMap<String, AutoCommand> lookupTable = new DualHashBidiMap<>();

	public AutoReader() {
		/*lookupTable.put("DriveStraight", new DriveStraight(0));
		lookupTable.put("DriveHorizontal", new DriveHorizontal(0));
		lookupTable.put("TurnAngle", new TurnAngle(0));*/
	}

	public void addElement(String commandName, AutoCommand command) {
		lookupTable.put(commandName, command);
	}

	public String[] getAvailableFiles() {
		File dir = new File("/home/lvuser/autoModes/");

		return dir.list();
	}

	public CommandGroup read(String name) {
		String json = "";
		try {
			json = new String(Files.readAllBytes(Paths.get("/home/lvuser/autoModes/" + name)));
		} catch (IOException e) {
			System.out.println("Error Reading File");
			return null;
		}

		ArrayList<ArrayList<ArrayList<ArrayList<String>>>> autoData = new Gson().fromJson(json, new TypeToken<ArrayList<ArrayList<ArrayList<ArrayList<String>>>>>(){}.getType());
		CommandGroup command = new CommandGroup();

		boolean wasPreviousSeq = false;

		for (ArrayList<ArrayList<ArrayList<String>>> a : autoData) { // Does this support args properly?
			String type = a.get(0).get(0).get(0);

			if (type.equals("SEQ")) {
				wasPreviousSeq = true;
				for (ArrayList<String> s : a.get(1)) {
					String comm = s.get(0);
					List<String> stringParams =  s.subList(1, s.size());
					double[] params = new double[stringParams.size()];

					for (int i=0; i<stringParams.size();i++) {
						params[i] = Double.parseDouble(stringParams.get(i));
					}

					System.out.println("Seq: " + comm + Arrays.toString(params));
					command.addSequential(lookupTable.get(comm).getNew(params));

				}
			} else if (type.equals("PAR")) {

				for (ArrayList<String> s : a.get(1)) {
					String comm = s.get(0);
					List<String> stringParams = s.subList(1, s.size());
					double[] params = new double[stringParams.size()];

					for (int i=0; i<stringParams.size();i++) {
						params[i] = Double.parseDouble(stringParams.get(i));
					}

					if (wasPreviousSeq) {
						System.out.println("Seq: " + comm + Arrays.toString(params));
						command.addSequential(lookupTable.get(comm).getNew(params));
						wasPreviousSeq = false;
					} else {
						System.out.println("Par: " + comm + Arrays.toString(params));
						command.addParallel(lookupTable.get(comm).getNew(params));
					}

				}

				wasPreviousSeq = false;
			}
		}

		return command;
	}
}
