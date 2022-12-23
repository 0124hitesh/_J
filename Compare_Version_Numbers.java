class Solution {
	int compareVersion(String version1, String version2) {
		String subVersion1 = "", subVersion2 = "";
		int i = 0, j = 0;

		while (i < version1.length() || j < version2.length()) {
			while (i < version1.length() && version1.charAt(i) == '0') {
				i++;
			}
			while (i < version1.length() && version1.charAt(i) != '.') {
				subVersion1 += version1.charAt(i);
				i++;
			}

			while (j < version2.length() && version2.charAt(j) == '0') {
				j++;
			}
			while (j < version2.length() && version2.charAt(j) != '.') {
				subVersion2 += version2.charAt(j);
				j++;
			}

			if (subVersion1.length() > subVersion2.length()) {
				return 1;
			} else if (subVersion1.length() < subVersion2.length()) {
				return -1;
			}

			for (int k = 0; k < subVersion1.length(); k++) {
				if (subVersion1.charAt(k) > subVersion2.charAt(k)) {
					return 1;
				} else if (subVersion1.charAt(k) < subVersion2.charAt(k)) {
					return -1;
				}
			}
			
			subVersion1 = "";
			subVersion2 = "";
			i++;
			j++;
		}
		return 0;
	}
}