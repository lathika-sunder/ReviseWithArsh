class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        // Create a map to store access times for each employee
        Map<String, List<Integer>> employeeAccessMap = new HashMap<>();

        // Iterate through the list of access times
        for (List<String> access : access_times) {
            // Extract employee name and access time from the current entry
            String employeeName = access.get(0);
            int time = Integer.parseInt(access.get(1));

            // If the employee is not already in the map, create a new entry
            if (!employeeAccessMap.containsKey(employeeName)) {
                employeeAccessMap.put(employeeName, new ArrayList<>());
            }

            // Add the access time to the list of access times for the employee
            employeeAccessMap.get(employeeName).add(time);
        }

        // List to store the names of high access employees
        List<String> highAccessEmployees = new ArrayList<>();

        // Iterate through the entries in the employeeAccessMap
        for (var entry : employeeAccessMap.entrySet()) {
            // Retrieve the sorted list of access times for the current employee
            List<Integer> times = entry.getValue();
            Collections.sort(times);

            // Iterate through the sorted access times to check for high access
            for (int i = 0; i < times.size() - 2; i++) {
                // If the time difference between consecutive accesses is less than 100, consider it high access
                if (times.get(i + 2) - times.get(i) < 100) {
                    // Add the employee to the list of high access employees and break out of the loop
                    highAccessEmployees.add(entry.getKey());
                    break;
                }
            }
        }

        // Return the list of high access employees
        return highAccessEmployees;
    }
}
