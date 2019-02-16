import java.util.Scanner;

/* @author: Públio Buiatti Guirelli
 * 
 * @version: 1.0
 * 
 * @since: 02/2019
 */
public class Solution {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String textTypeTestCases = "Type the number of test cases (1 to 10): ";
	private static final String textTypeSequencesDNA = "Type two sequences DNA (minium 1 character, maximum 100000 characteres): \n";

	public static void main(String[] args) {
		System.out.print(textTypeTestCases);
		int numberTestCases = Integer.parseInt(scanner.nextLine().trim());

		// Check constraint (1 <= t <= 10)
		while (numberTestCases < 1 || numberTestCases > 10) {
			System.out.print(textTypeTestCases);
			numberTestCases = Integer.parseInt(scanner.nextLine().trim());
		}

		for (int indexTestCase = 0; indexTestCase < numberTestCases; indexTestCase++) {
			System.out.print(textTypeSequencesDNA);
			String[] sequencesDNA = scanner.nextLine().split(" ");
			String patientDNA = sequencesDNA[0].toLowerCase();
			String virusDNA = sequencesDNA[1].toLowerCase();

			// Check constraint (1 <= |p| <= 100000)
			if (patientDNA.length() > 100000) {
				patientDNA = patientDNA.substring(0, 99999);
			}

			// Check constraint (1 <= |v| <= 100000)
			if (virusDNA.length() > 100000) {
				virusDNA = virusDNA.substring(0, 99999);
			}

			virusIndices(patientDNA, virusDNA);
		}
	}

	/*
	 * Compare the DNA sequences and print a list of space-separated integers that
	 * represent the starting indices of matching substrings in increasing order, or
	 * No match!.
	 * 
	 * @param patientDNA: string that represents sequence patient DNA.
	 * 
	 * @param virusDNA: string that represents sequence virus DNA.
	 */
	static void virusIndices(String patientDNA, String virusDNA) {

		int beginIndexVirus = 0;
		int endIndexVirus = beginIndexVirus + virusDNA.length();
		boolean match = false;

		while (endIndexVirus <= patientDNA.length()) {
			if (checkMatching(beginIndexVirus, endIndexVirus, patientDNA, virusDNA)) {
				System.out.print(beginIndexVirus + " ");
				match = true;
			}
			beginIndexVirus++;
			endIndexVirus++;
		}

		if (!match) {
			System.out.println("No Match!");
		} else {
			System.out.println("");
		}

	}

	/*
	 * Verify all substrings in the patient DNA that either exactly match the virus
	 * DNA or have at most one mismatch, i.e., a difference in at most one location.
	 * 
	 * @param beginIndexVirus: index that represents the begin of sequence virus DNA.
	 * 
	 * @param endIndexVirus: index that represents the end of sequence virus DNA.
	 * 
	 * @param patientDNA: string that represents sequence patient DNA.
	 * 
	 * @param virusDNA: string that represents sequence virus DNA.
	 * 
	 * @return boolean: true if has match or false if no match.
	 */
	static boolean checkMatching(int beginIndexVirus, int endIndexVirus, String patientDNA, String virusDNA) {
		int oneMismatch = 0, indexCharVirus = 0;

		for (int indexCharPatient = beginIndexVirus; indexCharPatient < endIndexVirus; indexCharPatient++) {
			if (patientDNA.charAt(indexCharPatient) != virusDNA.charAt(indexCharVirus)) {
				if (oneMismatch != 0) {
					return false;
				}
				oneMismatch++;
			}
			indexCharVirus++;
		}
		return true;
	}
}
