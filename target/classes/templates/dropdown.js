// dropdown.js

function handleDropdownChange(dropdown) {
    const selectedValue = dropdown.value;
    const nestedDropdownContainer = document.getElementById("nested-dropdown-container");

    if (selectedValue === "/master" || selectedValue === "/reports" || selectedValue === "/transactions") {
        // Show nested dropdown container
        nestedDropdownContainer.style.display = "block";

        // Populate nested dropdown content based on selected option
        const nestedDropdown = document.createElement("select");
        nestedDropdown.onchange = function() {
            window.location.href = this.value;
        };

        if (selectedValue === "/master") {
            // Add options for Master dropdown
            nestedDropdown.add(new Option("Employees", "/master/employees"));
            // Add more Master options as needed
        } else if (selectedValue === "/reports") {
            // Add options for Reports dropdown
            nestedDropdown.add(new Option("Salary Report", "/reports/salary"));
            // Add more Reports options as needed
        } else {
            // Add options for Transactions dropdown
            nestedDropdown.add(new Option("Add Salary", "/transactions/add-salary"));
            // Add more Transactions options as needed
        }

        nestedDropdownContainer.innerHTML = ""; // Clear any existing content
        nestedDropdownContainer.appendChild(nestedDropdown);
    } else {
        // Hide nested dropdown container
        nestedDropdownContainer.style.display = "none";
    }
}
