package ua.lviv.lgs;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		ZooClub club = new ZooClub();
		Scanner sc = new Scanner(System.in);

		while (true) {
			menu();

			switch (sc.next()) {
			case "1": {
				club.addMember();
				break;
			}
			case "2": {
				club.addPet();
				break;
			}
			case "3": {
				club.deletePetFromEnteredMember();
				break;
			}
			case "4": {
				club.deleteMember();
				break;
			}
			case "5": {
				club.deletePetFromAllMember();
				break;
			}
			case "6": {
				club.printClub();
				break;
			}
			case "7": {
				System.exit(0);
				break;
			}
			}
		}
	}

	public static void menu() {
		System.out.println("Press 1 to add club-member:");
		System.out.println("Press 2 to add members pet:");
		System.out.println("Press 3 to delete pet from member:");
		System.out.println("Press 4 to delete club-member:");
		System.out.println("Press 5 to delete the pet-type:");
		System.out.println("Press 6 to show the club on screen:");
		System.out.println("Press 7 to exit");
	}
}
