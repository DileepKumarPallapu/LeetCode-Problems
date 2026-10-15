class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String email : emails) {
            int at = email.indexOf('@');

            String local = email.substring(0, at);
            String domain = email.substring(at);

            local = local.split("\\+", 2)[0];
            local = local.replace(".", "");

            unique.add(local + domain);
        }

        return unique.size();
    }
}