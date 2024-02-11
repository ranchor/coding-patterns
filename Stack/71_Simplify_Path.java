class Solution {
    public String simplifyPath(String path) {

        if (path == null || path.isEmpty())
            return "";

        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");
        for (String token : tokens) {
            // Handle Empty token check
            // Also handle empty stack when token is "..""
            if (token.isEmpty() || token.equals(".") || (stack.isEmpty() && token.equals(".."))) {
                continue;
            } else if (token.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(token);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        // if length equal to zero then we need to return some character
        return sb.length() == 0 ? "/" : sb.toString();

    }

}