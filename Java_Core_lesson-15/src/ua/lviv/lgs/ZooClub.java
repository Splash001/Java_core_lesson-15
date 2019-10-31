package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ZooClub {

	Map<Person, List<Pet>> map = new HashMap<>();

	public void addMember() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of member:");
		String name = scanner.nextLine();
		System.out.println("Enter age of member:");
		int age = scanner.nextInt();
		map.put(new Person(name, age), new ArrayList<Pet>());
	}

	public void addPet() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter members name:");
		String name = scanner.nextLine();
		System.out.println("Enter type of pet:");
		String type = scanner.nextLine();
		System.out.println("Enter name of pet");
		String namePet = scanner.nextLine();

		Iterator<java.util.Map.Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Pet>> next = iterator.next();
			if (next.getKey().getName().equalsIgnoreCase(name)) {
				List<Pet> value = next.getValue();
				value.add(new Pet(type, namePet));
				next.setValue(value);
			}
		}
	}

	public void deletePetFromEnteredMember() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter members name:");
		String name = scanner.nextLine();
		System.out.println("Enter type of pet");
		String type = scanner.nextLine();
		boolean isDeleted = false;

		Iterator<java.util.Map.Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Pet>> next = iterator.next();
			if (next.getKey().getName().equalsIgnoreCase(name)) {
				List<Pet> value = next.getValue();
				Iterator<Pet> iterator2 = value.iterator();
				while (iterator2.hasNext()) {
					Pet next2 = iterator2.next();
					if (next2.getType().equalsIgnoreCase(type)) {
						iterator2.remove();
						isDeleted = true;
					}
				}
			}
		}
		if (!isDeleted) {
			System.out.println("Sorry, but there is no such pet");
		} else {
			System.out.println("PEt is deleted");
		}
	}

	public void deleteMember() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter members name:");
		String name = scanner.nextLine();
		boolean isDeleted = false;

		Iterator<java.util.Map.Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Pet>> next = iterator.next();
			if (next.getKey().getName().equalsIgnoreCase(name)) {
				iterator.remove();
				isDeleted = true;
			}
		}
		if (!isDeleted) {
			System.out.println("Sorry, but there is no such member");
		} else {
			System.out.println("Club member is deleted");
		}

	}

	public void deletePetFromAllMember() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter pets type:");
		String type = scanner.nextLine();
		boolean isDeleted = false;

		Iterator<java.util.Map.Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Pet>> next = iterator.next();
			List<Pet> value = next.getValue();
			Iterator<Pet> iterator2 = value.iterator();
			while (iterator2.hasNext()) {
				Pet next2 = iterator2.next();
				if (next2.getType().equalsIgnoreCase(type)) {
					iterator2.remove();
					isDeleted = true;
				}
			}
		}
		if (!isDeleted) {
			System.out.println("There is no such type of pet");
		} else {
			System.out.println("Pet is deleted");
		}
	}

	public void printClub() {
		System.out.println(map);
	}

}