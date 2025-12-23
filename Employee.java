
public class Employee {
	String employeeId;
	String employeeName;
	String employeeDesignation;
	String managerEmployeeId;

	public Employee(String empId, String empName, String empDes, String managerId) {
		this.employeeId = empId;
		this.employeeName = empName;
		this.employeeDesignation = empDes;
		this.managerEmployeeId = managerId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getManagerEmployeeId() {
		return managerEmployeeId;
	}

	public void setManagerEmployeeId(String managerEmployeeId) {
		this.managerEmployeeId = managerEmployeeId;
	}

	public String toString() {
		return employeeName + "(" + employeeDesignation + " - " + employeeId + ")";
	}
}
