package combinations;

public class GenerateCombinations {

	public static final String delim = ",";
	
	public static void sec01_buildmgmt_CI() {
		int[][] qNa = { { 2, 1 }, { 2, 0 }, { 3, 0 }, { 3, 0 }, { 4, 0 }, { 0, 5, 4 }, { 5, 4, 2, 0 }, { 5, 0 } };

		int comb = 0;
		String key = "";
		System.out.println("Total Questions: " + qNa.length);

		for (int i = 0; i < qNa[0].length; i++) {
			for (int j = 0; j < qNa[1].length; j++) {
				for (int k = 0; k < qNa[2].length; k++) {
					for (int l = 0; l < qNa[3].length; l++) {
						for (int m = 0; m < qNa[4].length; m++) {
							for (int n = 0; n < qNa[5].length; n++) {
								for (int o = 0; o < qNa[6].length; o++) {
									for (int p = 0; p < qNa[7].length; p++) {
										key = qNa[0][i] + delim + qNa[1][j] + delim + qNa[2][k] + delim + qNa[3][l]
												+ delim + qNa[4][m] + delim + qNa[5][n] + delim + qNa[6][o] + delim
												+ qNa[7][p] + delim;
										System.out.println(key);
										comb++;
									}

								}

							}

						}

					}

				}

			}
		}

		System.out.println("total combinations: " + comb);

	}

	public static void sec02_env_deployment() {
		int[][] qNa = { { 3, 1, 2 }, { 3, 2, 2 }, { 3, 0 }, { 4, 0 }, { 5, 0 }, };

		int comb = 0;
		String key = "";
		System.out.println("Total Questions: " + qNa.length);

		for (int i = 0; i < qNa[0].length; i++) {
			for (int j = 0; j < qNa[1].length; j++) {
				for (int k = 0; k < qNa[2].length; k++) {
					for (int l = 0; l < qNa[3].length; l++) {
						for (int m = 0; m < qNa[4].length; m++) {
							key = qNa[0][i] + delim + qNa[1][j] + delim + qNa[2][k] + delim + qNa[3][l] + delim
									+ qNa[4][m] + delim;
							System.out.println(key);
							comb++;

						}

					}

				}

			}
		}

		System.out.println("total combinations: " + comb);

	}

	public static void sec03_releasemgmt_complicane() {
		int[][] qNa = { { 2, 1 }, { 2, 1 }, { 3, 0 }, { 4, 0 }, { 5, 0 } };

		int comb = 0;
		String key = "";
		System.out.println("Total Questions: " + qNa.length);

		for (int i = 0; i < qNa[0].length; i++) {
			for (int j = 0; j < qNa[1].length; j++) {
				for (int k = 0; k < qNa[2].length; k++) {
					for (int l = 0; l < qNa[3].length; l++) {
						for (int m = 0; m < qNa[4].length; m++) {
										key = qNa[0][i] + delim + qNa[1][j] + delim + qNa[2][k] + delim + qNa[3][l]
												+ delim + qNa[4][m] + delim;
										System.out.println(key);
										comb++;

						}

					}

				}

			}
		}

		System.out.println("total combinations: " + comb);

	}

	public static void sec04_testing() {
		int[][] qNa = { { 1, 2 }, { 3, 2 }, { 3, 1 }, { 3, 0 }, { 4, 0 }, { 5, 0 }};

		int comb = 0;
		String key = "";
		System.out.println("Total Questions: " + qNa.length);

		for (int i = 0; i < qNa[0].length; i++) {
			for (int j = 0; j < qNa[1].length; j++) {
				for (int k = 0; k < qNa[2].length; k++) {
					for (int l = 0; l < qNa[3].length; l++) {
						for (int m = 0; m < qNa[4].length; m++) {
							for (int n = 0; n < qNa[5].length; n++) {
										key = qNa[0][i] + delim + qNa[1][j] + delim + qNa[2][k] + delim + qNa[3][l]
												+ delim + qNa[4][m] + delim + qNa[5][n] + delim;
										System.out.println(key);
										comb++;

							}

						}

					}

				}

			}
		}

		System.out.println("total combinations: " + comb);

	}

	public static void main(String[] args) {
		//sec01_buildmgmt_CI();
		//sec02_env_deployment();
		//sec03_releasemgmt_complicane();
		//sec04_testing();
		
	}

}
