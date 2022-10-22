import java.util.ArrayList;
import java.util.Arrays;

public class GameMechanics {
	static boolean BattleTester(ArrayList<? extends Character> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(0).getClass() != list.get(i).getClass()) {
				return false;
			}
		}
		return true;
	}
	
	static String basicWinChances(Hero tempHero, Villain tempVillain) {
		int heroHearts = tempHero.getHearts();
		int villainHearts = tempVillain.getHearts();
		int winnerHearts = 0;
		
		if (heroHearts > villainHearts) {
			winnerHearts = heroHearts/villainHearts;
			return "Hero " + tempHero.getName() + " " + heroHearts + " to " + villainHearts;
		}
		else if (villainHearts > heroHearts) {
			winnerHearts = villainHearts/heroHearts;
			return "Villain " + tempVillain.getName() + " " + villainHearts + " to " + heroHearts;
		}
		else {
			return "Even match.";
		}
	}
	
	static String advancedWinChances(Character char1, Character char2) {
		double char1Hearts = char1.getHearts();
		double char2Hearts = char2.getHearts();
		double winnerHearts = 0;
		double heartsWithArmor = 0;
		double armorHealth;
		if (char1.getClass().getName() == "Hero") {
			armorHealth = char1.getArmour() / 100;
			char1Hearts = (double) char1Hearts * armorHealth;
		}
		if (char2.getClass().getName() == "Hero") {
			armorHealth = char2.getArmour() / 100;
			char2Hearts = (double) char2Hearts * armorHealth;
		}
		
		
		if (char1Hearts > char2Hearts) {
			winnerHearts = char1Hearts/char2Hearts;
			return "Character 1 " + char1.getName() + " " + char1Hearts + " to " + char2Hearts;
		}
		else if (char2Hearts > char1Hearts) {
			winnerHearts = char2Hearts/char1Hearts;
			return "Character 2 " + char2.getName() + " " + char2Hearts + " to " + char1Hearts;
		}
		else {
			return "Even match.";
		}
	}
	
	static sortedBattlefieldCharacters(ArrayList<Character> BattleRoyale) {
		//ArrayList<Character> BattleRoyale = new ArrayList<Character>();
		for (int i = 0; i < BattleRoyale.size(); i++) {
			System.out.println(BattleRoyale.get(i).getName());
		}
		
		// Sorting code to sort battle royale list
		for (int i = 0; i < BattleRoyale.size(); i++) {
			System.out.println(BattleRoyale.get(i).getName());
		}
	}
	
	
	public static void main(String[] args) {
		/*ArrayList<Character> villainList = new ArrayList<Character>();
		Villain testVillain1 = new Villain("Creeper", new Location(0, 1, 0), false, "axe", 6);
		Villain testVillain2 = new Villain("Zombie", new Location(0, 1, 0), false, "shovel", 6);
		villainList.add(testVillain1);
		villainList.add(testVillain2);
		BattleTester(villainList);
		
		Block testBlock = new Block("copper", new Location(0, 0, 0), 5);
		villainList.add(villainList);
		BattleTester(villainList);*/
		
		Villain testVillain = new Villain("Creeper", new Location(0, 1, 0), false, "axe", 6);
		System.out.println(testVillain);

		
		Hero testHero = new Hero("Bowen", new Location(0, 0, 40), Arrays.asList("iron sword", "beef", "flare"), 5, 100) ;
		System.out.println(testHero);
		
		System.out.println(advancedWinChances(testHero, testVillain));
		
		Villain testVillain1 = new Villain("Creeper", new Location(0, 2, 0), false, "shovel", 3);
		System.out.println(testVillain1);

		
		Hero testHero1 = new Hero("Bowen", new Location(0, 0, 42), Arrays.asList("diamond sword", "pork", "ice"), 7, 50) ;
		System.out.println(testHero1);
		
		System.out.println(advancedWinChances(testHero1, testVillain1));
	}
}
