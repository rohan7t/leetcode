package leetcode;

import java.util.HashSet;

public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
	if (emails == null || emails.length == 0) {
	    return 0;
	}
	HashSet<String> hs = new HashSet<String>();
	for (String email : emails) {
	    String processedEmail = processEmail(email);
	    hs.add(processedEmail);
	}
	return hs.size();
    }

    private String processEmail(String email) {
	String[] split = email.split("@");
	String localName = split[0];
	int plusIndex = localName.indexOf("+");
	if (plusIndex != -1) {
	    localName = localName.substring(0, plusIndex);
	}
	localName = localName.replace(".", "");
	return localName + split[1];
    }
}
