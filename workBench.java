

import java.util.*;

public class workBench {

	public static void createList(HashMap<String, Employee> map) {
		map.put("X7F3", new Employee("X7F3", "JOHN DOE", "CEO", null));
		map.put("PORT4", new Employee("PORT4", "JANE SMITH", "CTO", "X7F3"));
		map.put("K2B9", new Employee("K2B9", "DAVIN LEE", "CFO", "X7F3"));
		map.put("LBM5", new Employee("LBM5", "Michael Brown", "VP ENG", "PORT4"));
	}

	// Trace upward: des → manager → CEO
	public static void getHierarchy(String des, HashMap<String, Employee> map, ArrayList<String> list) {
	 if (des == null ){
        return ;
	 }
		list.add(map.get(des).employeeId);
	 
		if(map.containsKey(des)) {
			des = map.get(des).managerEmployeeId;
		}
		getHierarchy(des, map, list);
	}

	public static void main(String[] args) {
		HashMap<String, Employee> map = new HashMap<>();
		createList(map);

		ArrayList<String> list = new ArrayList<>();
		getHierarchy("LBM5", map, list);
		StringBuilder sb= new StringBuilder();
		
		for(String id : list){
			 sb.append(map.get(id)).append(",");
		}

		System.out.println("Hierarchy Path (IDs): " + sb.toString());

		
	}
}
