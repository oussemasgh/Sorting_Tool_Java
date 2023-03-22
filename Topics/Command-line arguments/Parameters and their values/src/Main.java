class Problem {
    public static void main(String[] args) {
        // Loop through the command-line arguments two by two
        for (int i = 0; i < args.length; i += 2) {
            // Get the parameter and value
            String parameter = args[i];
            String value = args[i + 1];
            // Output the parameter and value in the desired format
            System.out.println(parameter + "=" + value);
        }
    }
}
