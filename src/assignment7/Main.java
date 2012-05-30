package assignment7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment7.EpidemicSystem;
import assignment7.EpidemicSystem.Node;


public class Main {
	final static List<Patient> list = new ArrayList<Patient>();
	
	public static void main( String[] args ) {
		printStartUpMessage();
		list.add(new Patient(160, 72.7));
		list.add(new Patient(178, 82.7));
		list.add(new Patient(167, 76.9));
		list.add(new Patient(177, 82.0));
		list.add(new Patient(156, 79.3));
		list.add(new Patient(180, 76.4));
		list.add(new Patient(176, 78.9));
		list.add(new Patient(187, 73.1));
		list.add(new Patient(155, 76.7));
		list.add(new Patient(190, 78.8));
		
		EpidemicSystem es = new EpidemicSystem();
		while( true ) {
			sendListToTree(list, es);
			es.printInOrder(es.root);
		}
	}
	
	private static void printStartUpMessage() {
		System.out.printf("Doctor we need your help!!\nThe situation is very grave!!\nA mass number of patients have been admitted to the hospital;\n");
		System.out.printf("however, all the patients have amnesia!!\nSo we have no medical data or history to go off of besides their height and weight.\n");
		System.out.printf("We would like you to make the executive desicsion on how we should organize the patients.\n");
		
	}
	
	public static void sendListToTree( List<Patient> list, EpidemicSystem es ) {
		String temp;
		Scanner in = new Scanner(System.in);
		int option;

		while ( true ){
			System.out.println("To sort by weight, enter 0");
			System.out.println("To sort by Height, enter 1");
			temp = in.nextLine();
			if(!isNumber(temp)) continue;
			option = Integer.parseInt(temp);
			if(option != 0 && option != 1) continue;
			break;
		}
		
		if ( option == 0 ) {
			Node root = new Node(list.get(0).getWeight());
			es.root = root;
			for( Patient current : list ) {
				es.insert(root, current.getWeight());
			}
		}
		
		else {
			Node root = new Node(list.get(0).getHeight());
			es.root = root;
			for( Patient current : list ) {
				es.insert(root, current.getHeight());
			}
		}
		
	}
	
	public static boolean isNumber(String temp) {
		try{
			@SuppressWarnings("unused")
			double d = Double.parseDouble(temp);
		} catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	public int readval(int check2) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int check1 = 0;
        boolean uix = true;
        int status = -1;
        while (uix){
        	try{				// Reads the user input. If input is not between the values, then it re-prompts the user for input
        		status = Integer.parseInt(input.readLine());
                uix = false;
                if (status < check1 || status > check2){
                    uix = true;
                    System.out.println("_Incorrect value: please input a double (between " + check1 + " and " + check2 + ")");
                    System.out.println("");
                    continue;
                }
        	}catch (NumberFormatException nos){
                    System.out.println("_Incorrect value: please input an integer");
                    uix = true;
                    System.out.println("");
                }
                
        }
        if (status == -1){
        	throw new Error("##########ERROR IN READVAL1 METHOD, QUITTING PROGRAM##########");
        }
        return status;
	}
}
