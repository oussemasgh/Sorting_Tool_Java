class Problem {
    public static void main(String[] args) {
        // Loop through the command-line arguments and check for "test"
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("test")) {
                // Output the index of the "test" argument and exit the program
                System.out.println(i);
                return;
            }
        }
        // If "test" was not found, output "-1"
        System.out.println("-1");
    }
}
